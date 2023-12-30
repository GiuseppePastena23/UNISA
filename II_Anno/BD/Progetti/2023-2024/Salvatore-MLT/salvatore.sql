CREATE TABLE Circuito
(
  ID VARCHAR(50) NOT NULL,
  Nome VARCHAR(50) NOT NULL,
  Paese VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE Gara
(
  Data DATE NOT NULL,
  Circuito VARCHAR(50) NOT NULL,
  Durata INT NOT NULL,
  Tipo ENUM('asciutta', 'bagnata') NOT NULL,
  Nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(Data),
  FOREIGN KEY (Circuito) REFERENCES Circuito(ID)
);

CREATE TABLE Gareggiare
(
  DataGara DATE NOT NULL,
  NomeSquadra VARCHAR(50) NOT NULL,
  Punteggio INT NOT NULL,
  Squalifica VARCHAR(50),
  PRIMARY KEY (Gara, Squadra),
  FOREIGN KEY (DataGara) REFERENCES Gara(Data),
  FOREIGN KEY (NomeSquadra) REFERENCES Squadra(Nome)
);

CREATE TABLE Squadra
(
  Nome VARCHAR(50) NOT NULL,
  PunteggioFinale INT NOT NULL,
  Veicolo VARCHAR(50) NOT NULL,
  PRIMARY KEY (Nome),
  FOREIGN KEY (Veicolo) REFERENCES Vettura(ID)
);

CREATE TABLE Vettura
(
  ID VARCHAR(50) NOT NULL,
  NomeScuderia VARCHAR(50) NOT NULL,
  NGara INT NOT NULL,
  Modello VARCHAR(50) NOT NULL,
  PRIMARY KEY(ID),
  FOREIGN KEY (NomeScuderia) REFERENCES Scuderia(Nome)
);

CREATE TABLE Pilota
(
  Nome VARCHAR(50) NOT NULL,
  Cognome VARCHAR(50) NOT NULL,
  SSID VARCHAR(50) NOT NULL,
  Datnas DATE NOT NULL,
  Nazionalita VARCHAR(50) NOT NULL,
  Squadra VARCHAR(50) NOT NULL,
  PRIMARY KEY (SSID),
  FOREIGN KEY (Squadra) REFERENCES Squadra(Nome)
);

CREATE TABLE Scuderia
(
  Nome VARCHAR(50) NOT NULL,
  Sedecentrale VARCHAR(50) NOT NULL,
  PRIMARY KEY (Nome)
);

CREATE TABLE Costruttore
(
  Ragionesociale VARCHAR(50) NOT NULL,
  Nome VARCHAR(50) NOT NULL,
  Sedefabbrica VARCHAR(50) NOT NULL,
  PRIMARY KEY (Ragionesociale)
);

CREATE TABLE Componenti
(
  ID VARCHAR(50) NOT NULL,
  Tipo ENUM('cambio', 'telaio', 'motore') NOT NULL,
  Costo DECIMAL NOT NULL,
  Datainstallazione DATE NOT NULL,
  Scuderia VARCHAR(50) NOT NULL,
  Vettura VARCHAR(50) NOT NULL,
  Costruttore VARCHAR(50) NOT NULL,
  FOREIGN KEY (Scuderia) REFERENCES Scuderia(Nome),
  FOREIGN KEY (Vettura) REFERENCES Vettura(ID),
  FOREIGN KEY (Costruttore) REFERENCES Costruttore(Ragionesociale),
  PRIMARY KEY (ID),
  Materiale VARCHAR(50),
  Peso INT DEFAULT NULL,
  Nmarce INT DEFAULT NULL,
  Cilindrata INT DEFAULT NULL,
  Tipocilindrata ENUM ('tipo1', 'tipo2') DEFAULT NULL,
  Numerocilindri INT DEFAULT NULL
);