-- Script per la creazione del database Campionato

DROP DATABASE IF EXISTS Campionato; -- cleanup

CREATE DATABASE IF NOT EXISTS Campionato;
USE Campionato;

-- Circuito
-- Nome PK, Paese, Lunghezza, nCurve
CREATE TABLE IF NOT EXISTS Circuito (
    Nome VARCHAR(50) NOT NULL,
    Paese VARCHAR(50) NOT NULL,
    Lunghezza FLOAT NOT NULL,
    nCurve INT NOT NULL,
    PRIMARY KEY (Nome)
);

-- Costruttore
-- Ragione_sociale PK, Nome, Sede, nComponenti_forniti
CREATE TABLE IF NOT EXISTS Costruttore (
    Ragione_sociale VARCHAR(50) NOT NULL,
    Nome VARCHAR(50) NOT NULL,
    Sede VARCHAR(50) NOT NULL,
    nComponenti_forniti INT NOT NULL,
    PRIMARY KEY (Ragione_sociale)
);

-- Scuderia
-- Nome PK, Paese
CREATE TABLE IF NOT EXISTS Scuderia (
    Nome VARCHAR(50) NOT NULL,
    Paese VARCHAR(50) NOT NULL,
    PRIMARY KEY (Nome)
);

-- Gara
-- Nome PK, Data, DurataH, Tipo (asciutta/bagnata), Nome_Circuito FK
CREATE TABLE IF NOT EXISTS Gara (
    Nome VARCHAR(50) NOT NULL,
    Data DATE NOT NULL,
    DurataH FLOAT NOT NULL,
    Tipo ENUM('asciutta', 'bagnata') NOT NULL,
    Nome_Circuito VARCHAR(50) NOT NULL,
    PRIMARY KEY (Nome),
    FOREIGN KEY (Nome_Circuito) REFERENCES Circuito(Nome)
);

-- Vettura
-- nGara PK, Modello, Data_acquisto, Prezzo, Nome_Scuderia FK
CREATE TABLE IF NOT EXISTS Vettura (
    nGara INT NOT NULL,
    Modello VARCHAR(50) NOT NULL,
    Data_acquisto DATE NOT NULL,
    Prezzo DECIMAL NOT NULL,
    Nome_Scuderia VARCHAR(50) NOT NULL,
    PRIMARY KEY (nGara),
    FOREIGN KEY (Nome_Scuderia) REFERENCES Scuderia(Nome)
);

-- Componente
-- Codice PK, Costo, Tipo (Motore, Cambio, Telaio), Cilindrata_motore*, nCilindri_motore*, Tipo_motore*, Materiale_telaio*, Peso_telaio*,
-- nMarce_cambio*, Ragione_sociale_Costruttore FK, nGara_Vettura FK
CREATE TABLE IF NOT EXISTS Componente (
    Codice INT NOT NULL AUTO_INCREMENT,
    Costo DECIMAL NOT NULL,
    Tipo ENUM('Motore', 'Cambio', 'Telaio') NOT NULL,
    Cilindrata_motore INT DEFAULT NULL,
    nCilindri_motore INT DEFAULT NULL,
    Tipo_motore VARCHAR(50) DEFAULT NULL,
    Materiale_telaio VARCHAR(50) DEFAULT NULL,
    Peso_telaio FLOAT DEFAULT NULL,
    nMarce_cambio INT DEFAULT NULL,
    Ragione_sociale_Costruttore VARCHAR(50) NOT NULL,
    nGara_Vettura INT NOT NULL,
    PRIMARY KEY (Codice),
    FOREIGN KEY (Ragione_sociale_Costruttore) REFERENCES Costruttore(Ragione_sociale),
    FOREIGN KEY (nGara_Vettura) REFERENCES Vettura(nGara)
);

-- Pilota
-- SSID PK, Nome, Cognome, DDN, Nazionalita, Tipo, Quota*, nLicenze*, Data_prima_licenza*, nGara_Vettura FK
CREATE TABLE IF NOT EXISTS Pilota (
    SSID VARCHAR(50) NOT NULL,
    Nome VARCHAR(50) NOT NULL,
    Cognome VARCHAR(50) NOT NULL,
    DDN DATE NOT NULL,
    Nazionalita VARCHAR(50) NOT NULL,
    Tipo ENUM('PRO', 'AM', 'GD') NOT NULL,
    Quota DECIMAL,
    nLicenze INT,
    Data_prima_licenza DATE,
    nGara_Vettura INT NOT NULL,
    PRIMARY KEY (SSID),
    FOREIGN KEY (nGara_Vettura) REFERENCES Vettura(nGara)
);

-- Partecipazione
-- Nome_Gara PK FK, nGara_Vettura PK FK, Punti, Posizione, Motivo_ritiro*,
CREATE TABLE IF NOT EXISTS Partecipazione (
    Nome_Gara VARCHAR(50) NOT NULL,
    nGara_Vettura INT NOT NULL,
    Punti INT NOT NULL,
    posizione INT,
    Motivo_ritiro VARCHAR(50),
    PRIMARY KEY (Nome_Gara, nGara_Vettura),
    FOREIGN KEY (Nome_Gara) REFERENCES Gara(Nome),
    FOREIGN KEY (nGara_Vettura) REFERENCES Vettura(nGara)
);
