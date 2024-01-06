DROP DATABASE campionato;
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
  IDCircuito VARCHAR(50) NOT NULL,
  Durata INT NOT NULL,
  Tipo ENUM('asciutta', 'bagnata') NOT NULL,
  Nome VARCHAR(50) NOT NULL,
  PRIMARY KEY(Nome),
  FOREIGN KEY (IDCircuito) REFERENCES Circuito(ID)
);

CREATE TABLE Vettura
(
  ID VARCHAR(50) NOT NULL,
  NomeScuderia VARCHAR(50) UNIQUE NOT NULL, -- PER EVITARE CHE ABBIA PIÙ DI UNA SCUDERIA/CONFLITTI
  NGara INT NOT NULL,
  Modello VARCHAR(50) NOT NULL,
  PRIMARY KEY(ID),
  FOREIGN KEY (NomeScuderia) REFERENCES Scuderia(Nome)
);

CREATE TABLE Squadra
(
  Nome VARCHAR(50) NOT NULL,
  PunteggioFinale INT NOT NULL,
  NomeVeicolo VARCHAR(50) UNIQUE NOT NULL, -- AGGIUNTA UNIQUE PER EVITARE CHE UNA SQUADRA AVESSE PIÙ VETTURE
  PRIMARY KEY (Nome),
  FOREIGN KEY (NomeVeicolo) REFERENCES Vettura(ID)
);

CREATE TABLE Gareggiare
(
  NomeGara VARCHAR(50) NOT NULL,
  NomeSquadra VARCHAR(50) NOT NULL,
  Posizione INT DEFAULT NULL,
  Punteggio INT DEFAULT NULL,
  Squalifica VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (NomeGara, NomeSquadra),
  FOREIGN KEY (NomeGara) REFERENCES Gara(Nome),
  FOREIGN KEY (NomeSquadra) REFERENCES Squadra(Nome)
  -- UNIQUE È GARANTITA GIÀ DALLA PRESENZA DI 2 PRIMARY KEY
);

CREATE TABLE Pilota
(
  Nome VARCHAR(50) NOT NULL,
  Cognome VARCHAR(50) NOT NULL,
  SSID VARCHAR(50) NOT NULL,
  Datnas DATE NOT NULL,
  Nazionalita VARCHAR(50) NOT NULL,
  NomeSquadra VARCHAR(50) NOT NULL,
  PrimaLicenza DATE DEFAULT NULL,
  NLicenze INT DEFAULT NULL,
  NFinanziamenti INT DEFAULT NULL,
  SommaFinanziamenti FLOAT DEFAULT NULL,
  PRIMARY KEY (SSID),
  FOREIGN KEY (NomeSquadra) REFERENCES Squadra(Nome),
  -- INSERIMENTO COSTRAINT VINCOLO INTEGRITÀ
  CONSTRAINT AMPRO CHECK 
  (
        (NLicenze IS NULL AND NFinanziamenti IS NULL AND SommaFinanziamenti IS NULL AND PrimaLicenza IS NOT NULL) -- PRO 
        OR
        (PrimaLicenza IS NOT NULL AND NLicenze IS NULL)  -- AM/GD
   )
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
  TipoMotore VARCHAR(50) DEFAULT NULL,
  Numerocilindri INT DEFAULT NULL,
  CONSTRAINT TIPO CHECK
  (
		(Tipo = 'cambio' AND Nmarce IS NOT NULL AND Materiale IS NULL AND Peso IS NULL AND Cilindrata IS NULL AND TipoMotore IS NULL AND NumeroCilindri IS NULL)
        OR
        (Tipo = 'telaio' AND Nmarce IS NULL AND Materiale IS NOT NULL AND Peso IS NOT NULL AND Cilindrata IS NULL AND TipoMotore IS NULL AND NumeroCilindri IS NULL)
        OR
        (Tipo = 'motore' AND Nmarce IS NULL AND Materiale IS NULL AND Peso IS NULL AND Cilindrata IS NOT NULL AND TipoMotore IS NOT NULL AND NumeroCilindri IS NOT NULL)
  ),
  UNIQUE(NomeVettura, Tipo) -- ulteriore controllo per evitare che ci siano 2 tipi uguali di componenti associati alla stessa vettura
);