CREATE DATABASE campionato;
USE campionato;

CREATE USER 'pacman34'@'localhost' IDENTIFIED BY 'Sasa1212x';
SELECT * FROM mysql.user WHERE user='pacman34';
GRANT ALL PRIVILEGES ON `campionato`.* TO 'pacman34'@'localhost';
FLUSH PRIVILEGES;


CREATE TABLE Circuito
(
  ID VARCHAR(50) NOT NULL,
  Nome VARCHAR(50) NOT NULL,
  Paese VARCHAR(50) NOT NULL,
  PRIMARY KEY (ID)
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

CREATE TABLE Gara
(
  Giorno DATE NOT NULL,
  NomeCircuito VARCHAR(50) NOT NULL,
  Durata INT NOT NULL,
  Tipo ENUM('asciutta', 'bagnata') NOT NULL,
  Nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(Giorno),
  FOREIGN KEY (NomeCircuito) REFERENCES Circuito(ID)
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

CREATE TABLE Squadra
(
  Nome VARCHAR(50) NOT NULL,
  PunteggioFinale INT NOT NULL,
  NomeVeicolo VARCHAR(50) NOT NULL,
  PRIMARY KEY (Nome),
  FOREIGN KEY (NomeVeicolo) REFERENCES Vettura(ID)
);

CREATE TABLE Gareggiare
(
  DataGara DATE NOT NULL,
  NomeSquadra VARCHAR(50) NOT NULL,
  Punteggio INT NOT NULL,
  Squalifica VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (DataGara, NomeSquadra),
  FOREIGN KEY (DataGara) REFERENCES Gara(Giorno),
  FOREIGN KEY (NomeSquadra) REFERENCES Squadra(Nome)
);

CREATE TABLE Pilota
(
  Nome VARCHAR(50) NOT NULL,
  Cognome VARCHAR(50) NOT NULL,
  SSID VARCHAR(50) NOT NULL,
  Datnas DATE NOT NULL,
  Nazionalita VARCHAR(50) NOT NULL,
  NomeSquadra VARCHAR(50) NOT NULL,
  PRIMARY KEY (SSID),
  FOREIGN KEY (NomeSquadra) REFERENCES Squadra(Nome)
);

CREATE TABLE Componenti
(
  ID VARCHAR(50) NOT NULL,
  Tipo ENUM('cambio', 'telaio', 'motore') NOT NULL,
  Costo DECIMAL NOT NULL,
  Datainstallazione DATE NOT NULL,
  NomeScuderia VARCHAR(50) NOT NULL,
  NomeVettura VARCHAR(50) NOT NULL,
  NomeCostruttore VARCHAR(50) NOT NULL,
  FOREIGN KEY (NomeScuderia) REFERENCES Scuderia(Nome),
  FOREIGN KEY (NomeVettura) REFERENCES Vettura(ID),
  FOREIGN KEY (NomeCostruttore) REFERENCES Costruttore(Ragionesociale),
  PRIMARY KEY (ID),
  Materiale VARCHAR(50),
  Peso INT DEFAULT NULL,
  Nmarce INT DEFAULT NULL,
  Cilindrata INT DEFAULT NULL,
  Tipocilindrata ENUM ('tipo1', 'tipo2') DEFAULT NULL,
  Numerocilindri INT DEFAULT NULL
);