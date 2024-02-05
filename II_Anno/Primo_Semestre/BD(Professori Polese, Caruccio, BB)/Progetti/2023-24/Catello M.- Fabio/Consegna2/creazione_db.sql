CREATE DATABASE IF NOT EXISTS Campionato;
USE Campionato;

CREATE TABLE IF NOT EXISTS Circuito(
nome_circuito VARCHAR(45) NOT NULL,
paese_residenza VARCHAR(45) NOT NULL,
ncurve INT NOT NULL,
lunghezza FLOAT NOT NULL,
PRIMARY KEY (nome_circuito)
);

CREATE TABLE IF NOT EXISTS Gara (
codice_gara INT AUTO_INCREMENT PRIMARY KEY,
nome_gara varchar(45) NOT NULL,
stagione YEAR NOT NULL,
data_gara DATE NOT NULL,
duratah TIME NOT NULL,
tipo ENUM('asciutta','bagnata') NOT NULL,
Circuito varchar(45) NOT NULL,
FOREIGN KEY (Circuito) REFERENCES Circuito(nome_circuito)
ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Scuderia (
nome_scuderia varchar(45) PRIMARY KEY,
nazione_sede varchar(56) NOT NULL
);

CREATE TABLE IF NOT EXISTS Costruttore(
ragione_sociale varchar(80) PRIMARY KEY,
nome varchar(45) NOT NULL,
sede_fabbrica varchar(56) NOT NULL,
ncomponenti INT NOT NULL CHECK (ncomponenti >= 0)
);

CREATE TABLE IF NOT EXISTS Vettura (
id_gara INT auto_increment PRIMARY KEY,
modello VARCHAR(45) NOT NULL,
totale_punti INT NOT NULL,
rif_scuderia varchar(45),
FOREIGN KEY (rif_scuderia) REFERENCES Scuderia(nome_scuderia)  
);

CREATE TABLE IF NOT EXISTS Componente_Motore (
codice_motore INT NOT NULL AUTO_INCREMENT,
vettura INT NOT NULL,
costo FLOAT NOT NULL CHECK (costo >= 0),
cilindrata INT NOT NULL CHECK (cilindrata >= 0),
tipo_motore ENUM("turbo","aspirato") NOT NULL,
ncilindri INT NOT NULL CHECK (ncilindri >= 1),
data_installazione DATE NOT NULL,
rif_costruttore varchar(80) NOT NULL,
rif_vettura INT NOT NULL,
FOREIGN KEY (rif_costruttore) REFERENCES Costruttore(ragione_sociale) ON DELETE CASCADE, 
FOREIGN KEY (rif_vettura) REFERENCES Vettura(id_gara) ON DELETE CASCADE,
CONSTRAINT PRIMARY KEY(codice_motore, vettura)
);

CREATE TABLE IF NOT EXISTS Componente_Telaio (
codice_telaio INT NOT NULL AUTO_INCREMENT,
vettura INT NOT NULL,
costo FLOAT NOT NULL CHECK (costo >= 0),
peso FLOAT NOT NULL CHECK (peso >= 0),
materiale varchar(45) NOT NULL,
data_installazione DATE NOT NULL,
rif_costruttore varchar(80) NOT NULL,
rif_vettura INT NOT NULL,
FOREIGN KEY (rif_costruttore) REFERENCES Costruttore(ragione_sociale) ON DELETE CASCADE, 
FOREIGN KEY (rif_vettura) REFERENCES Vettura(id_gara) ON DELETE CASCADE,
CONSTRAINT PRIMARY KEY(codice_telaio, vettura)
);

CREATE TABLE IF NOT EXISTS Componente_Cambio (
codice_cambio INT NOT NULL AUTO_INCREMENT,
vettura INT NOT NULL,
costo FLOAT NOT NULL CHECK (costo >= 0),
marce INT NOT NULL CHECK (marce >= 7 AND marce <= 8),
data_installazione DATE NOT NULL,
rif_costruttore varchar(80) NOT NULL,
rif_vettura INT NOT NULL,
FOREIGN KEY (rif_costruttore) REFERENCES Costruttore(ragione_sociale) ON DELETE CASCADE, 
FOREIGN KEY (rif_vettura) REFERENCES Vettura(id_gara) ON DELETE CASCADE,
CONSTRAINT PRIMARY KEY(codice_cambio, vettura)
);

CREATE TABLE IF NOT EXISTS Equipaggio (
ID_EQUIPAGGIO INT AUTO_INCREMENT PRIMARY KEY,
rif_vettura INT,
FOREIGN KEY (rif_vettura) REFERENCES Vettura(id_gara) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS PILOTA_AM (
nome varchar(45) NOT NULL,
cognome varchar(45) NOT NULL,
data_nascita DATE NOT NULL,
nazionalità  VARCHAR(56) NOT NULL,
punteggio INT NOT NULL DEFAULT 0,
data_prima_licenza DATE NOT NULL,
quota INT DEFAULT 0 CHECK (quota >= 0),
nfinanziamenti INT DEFAULT 0 CHECK (nfinanziamenti >= 0),
gm BOOLEAN NOT NULL DEFAULT 0,
CONSTRAINT gm_check CHECK ((nfinanziamenti <=> 0 AND NOT gm) OR (gm AND nfinanziamenti >= 1)),
rif_equipaggio INT,
FOREIGN KEY (rif_equipaggio) REFERENCES Equipaggio(ID_EQUIPAGGIO) ON DELETE SET NULL,
CONSTRAINT uk_PILOTA_PRO
UNIQUE(nome, cognome, data_nascita),
CONSTRAINT pk_PILOTA_AM 
PRIMARY KEY(nome, cognome, data_nascita)
);

CREATE TABLE IF NOT EXISTS PILOTA_PRO (
nome varchar(45) NOT NULL,
cognome varchar(45) NOT NULL,
data_nascita DATE NOT NULL,
nazionalità  VARCHAR(56) NOT NULL,
punteggio INT NOT NULL DEFAULT 0,
nlicenze INT NOT NULL CHECK (nlicenze >= 2),
rif_equipaggio INT,
FOREIGN KEY (rif_equipaggio) REFERENCES Equipaggio(ID_EQUIPAGGIO) ON DELETE SET NULL,
CONSTRAINT uk_PILOTA_PRO UNIQUE(nome, cognome, data_nascita),
CONSTRAINT pk_PILOTA_PRO PRIMARY KEY(nome, cognome, data_nascita)
);

CREATE TABLE IF NOT EXISTS Finanzia(
ID_FIN INT AUTO_INCREMENT PRIMARY KEY,
importo FLOAT NOT NULL CHECK (importo >= 0),
data_fin DATE NOT NULL,
rif_scuderia varchar(80) NOT NULL,
rif_gm_nome varchar(45) NOT NULL,
rif_gm_cognome varchar(45) NOT NULL,
rif_gm_data_nascita DATE NOT NULL,
CONSTRAINT fk_scuderia FOREIGN KEY (rif_scuderia) REFERENCES Scuderia(nome_scuderia) ON DELETE CASCADE,
CONSTRAINT fk_pilota_gm FOREIGN KEY (rif_gm_nome,rif_gm_cognome,rif_gm_data_nascita) REFERENCES PILOTA_AM(nome,cognome,data_nascita) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Partecipazione (
 rif_gara INT NOT NULL,
 rif_vettura INT NOT NULL,
 punti INT,
 posizione INT DEFAULT 0,
 motivo_ritiro ENUM ("squalifica","incidente","guasto_meccanico") DEFAULT NULL,
 FOREIGN KEY (rif_gara) REFERENCES Gara(codice_gara) ON DELETE CASCADE,
 FOREIGN KEY (rif_vettura) REFERENCES Vettura(id_gara) ON DELETE CASCADE,
 PRIMARY KEY(rif_gara, rif_vettura)
);

