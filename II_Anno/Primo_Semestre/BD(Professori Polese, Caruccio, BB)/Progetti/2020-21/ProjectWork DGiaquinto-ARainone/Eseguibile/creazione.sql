DROP SCHEMA del2;
CREATE SCHEMA del2;
USE del2;

create table clienti
(
	email varchar(50) primary key,
	nome varchar(50) not null,
	cognome varchar(50) not null,
	telefono varchar(20) not null,
	data_reg date not null,
    CHECK ( email LIKE '%_@_%._%' )
);

create table indirizzi
(
    via varchar(50),
	civico varchar(20),
	cap varchar(5),
	citta varchar(50),
	provincia varchar(2), #sigla della provincia
	cliente_email varchar(50),
	#se viene eliminato il cliente, anche i suoi indirizzi vengono cancellati
	foreign key (cliente_email) references clienti(email) on update cascade on delete cascade,
	#ogni indirizzo e associato ad un solo cliente
	primary key (via, civico, cap, citta ,provincia ,cliente_email)
);

create table ristoranti
(
    #il ristorante viene identificato tramite id per permettere piu occorrenze della stessa catena
	id int auto_increment primary key,
	piva varchar(16) not null,
	denominazione varchar(50) not null,
	ragione_sociale varchar(50) not null,
	tipologia varchar(50) not null,
	ordini_coda smallint not null,
	coda_max smallint not null,
	telefono varchar(20) not null,
	email varchar(50) not null,
	via varchar(50) not null,
	civico varchar(20) not null,
	cap varchar(5) not null,
	citta varchar(50) not null,
	provincia varchar(2) not null
);

create table orari_apertura(
    giorno tinyint unsigned,
    ora varchar(11),
    ristorante_id int,
    #se viene eliminato il ristorante, anche i suoi orari di apertura vengono cancellati
    foreign key (ristorante_id) references ristoranti(id) on update cascade on delete cascade,
    #es. formato (1, '09:00-13:00', 32)
    primary key (giorno, ora, ristorante_id),
    #giorno puo assumere valore da 1 a 7, dove 1=lunedi e 7=domenica
    #ora deve essere del tipo HH:MM-HH:MM e indica orario di apertura e chiusura
    CHECK ( giorno >= 1 AND giorno <= 7 AND ora REGEXP '[0-2][0-9]:[0-5][0-9]-[0-2][0-9]:[0-5][0-9]')
);

create table deliveries
(
  codice int auto_increment primary key,
  ristorante_id int,
  tipologia varchar(50) not null,
  descrizione varchar(50) not null,
  data_inizio date not null,
  cadenza varchar(20) not null,
  #se viene eliminato il ristorante, anche i suoi servizi di delivery vengono eliminati
  foreign key (ristorante_id) references ristoranti(id) on update cascade on delete cascade
);

create table societa
(
    piva varchar(16) primary key,
    cf varchar(16) not null,
    email varchar(50) not null,
    denominazione varchar(50) not null,
    amministratore varchar(50) not null,
    via varchar(50) not null,
	civico varchar(20) not null,
	cap varchar(5) not null,
	citta varchar(50) not null,
    provincia varchar(2) not null
);

create table affidi
(
    delivery_codice int,
    societa_piva varchar(16),
    #se viene eliminato un servizio di delivery, anche il collegamento ai servizi a cui si affidava viene rimosso
    foreign key (delivery_codice) references deliveries(codice) on update cascade on delete cascade,
    foreign key (societa_piva) references societa(piva) on update cascade on delete cascade,
    primary key (delivery_codice, societa_piva)
);

create table persone
(
    cf varchar(16) primary key,
    nome varchar(50) not null,
    cognome varchar(50) not null,
    telefono varchar(20) not null,
    email varchar(50) not null,
    CHECK ( cf REGEXP '[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]')
);

create table riders
(
    persona_cf varchar(16),
    disponibilita boolean not null,
    score_medio decimal(4,2),
    num_valutazioni int not null,
    num_impiego smallint not null,
    data_primo_impiego date not null,
    automunito boolean not null,
    targa varchar(10),
    tipo_veicolo varchar(50),
    #se viene eliminata la persona associata, anche il rider, essendo entita debole, viene eliminato.
    foreign key (persona_cf) references persone(cf) on update cascade on delete cascade,
    primary key(persona_cf)
);

create table impieghi
(
    societa_piva varchar(16),
    rider_persona_cf varchar(16),
    quota_oraria decimal(10,2) not null,
    data_impiego date not null,
    #se vengono eliminati o societa o rider, anche la loro collaborazione viene eliminata.
    foreign key (societa_piva) references societa(piva) on update cascade on delete cascade,
    foreign key (rider_persona_cf) references riders(persona_cf) on update cascade on delete cascade,
    primary key (societa_piva, rider_persona_cf)
);

create table valutazioni
(
    rider_cf varchar(16),
    cliente_email varchar(50),
    data_valutazione date not null,
    valutazione tinyint unsigned not null,
    #non si possono eliminare rider?
    foreign key (rider_cf) references riders(persona_cf) on update cascade on delete restrict,
    foreign key (cliente_email) references clienti(email) on update cascade on delete restrict,
    primary key (cliente_email, rider_cf),
    CHECK ( valutazione >= 1 AND valutazione <= 5 )
);

create table dipendenti
(
    persona_cf varchar(16),
    stato varchar(20) not null,
    anni_esperienza tinyint unsigned,
    curriculum text not null,
    delivery_codice int,
    #se viene eliminata la persona, essendo un entita debole, viene eliminato anche dipendente
    foreign key (persona_cf) references persone(cf) on update cascade on delete cascade,
    #se viene eliminato il servizio di delivery associato, viene settato a null
    foreign key (delivery_codice) references deliveries(codice) on update cascade on delete set null,
    primary key (persona_cf)
);

create table ordini
(
    num_ordine smallint unsigned,
    data_ordine datetime,
    ristorante_id int,
    cliente_email varchar(50) not null default '',
    destinazione varchar(200) not null,
    tipo varchar(50) not null,
    descrizione varchar(50) not null,
    stato varchar(20) not null,
    stima_orario datetime,
    persona_cf varchar(16),
    orario_consegna datetime,
    nominativo_consegna varchar(50),
    #se viene eliminato il ristorante l azione viene annullata se sono presenti ordini, bisogna decidere
    #cosa farsene degli ordini di quel ristorante prima di poter procedere all eliminazione
    foreign key (ristorante_id) references ristoranti(id) on update cascade on delete restrict,
    #come prima per il ristorante
    foreign key (cliente_email) references clienti(email) on update cascade on delete restrict,
    #se viene eliminata la persona che l ha consegnato, l ordine rimarra nel db
    foreign key (persona_cf) references persone(cf) on update cascade on delete set null,
    primary key (num_ordine, data_ordine, ristorante_id),
    CHECK (orario_consegna >= data_ordine)
);