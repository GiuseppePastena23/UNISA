-- INFORMAZIONI NAMING CONVENTION
-- Tabelle: nome singolare
-- numero: n
-- pascal case + snake case con reference maiuscole es "Nome_Circuito" (per le foreign key) oppure "nCilindri_motore"

-- creazione di un database per un campionato automobilistico
CREATE DATABASE IF NOT EXISTS Campionato;
USE Campionato;

-- creazione tabella Circuito
-- Nome PK, Paese, Lunghezza, nCurve
CREATE TABLE IF NOT EXISTS Circuito (
    Nome VARCHAR(20) NOT NULL,
    Paese VARCHAR(20) NOT NULL,
    Lunghezza FLOAT NOT NULL,
    nCurve INT NOT NULL,
    PRIMARY KEY (Nome)
);

-- creazione tabella Costruttore
-- Ragione_sociale PK, Nome, Sede (indirizzo), nComponenti_forniti
CREATE TABLE IF NOT EXISTS Costruttore (
    Ragione_sociale VARCHAR(20) NOT NULL,
    Nome VARCHAR(20) NOT NULL,
    Sede VARCHAR(20) NOT NULL,
    nComponenti_forniti INT NOT NULL,
    PRIMARY KEY (Ragione_sociale)
);

-- creazione tabella Scuderia
-- Nome PK, Paese
CREATE TABLE IF NOT EXISTS Scuderia (
    Nome VARCHAR(20) NOT NULL,
    Paese VARCHAR(20) NOT NULL,
    PRIMARY KEY (Nome)
);

-- creazione tabella Gara
-- Nome PK, Data, DurataH, Tipo (asciutta/bagnata), Nome_Circuito FK)
CREATE TABLE IF NOT EXISTS Gara (
    Nome VARCHAR(20) NOT NULL,
    Data DATE NOT NULL,
    DurataH FLOAT NOT NULL,
    Tipo BOOLEAN NOT NULL,
    Nome_Circuito VARCHAR(20) NOT NULL,
    PRIMARY KEY (Nome),
    FOREIGN KEY (Nome_Circuito) REFERENCES Circuito(Nome)
);

-- creazione tabella Vettura
-- nGara PK, Modello, Data_Acquisto, Prezzo, Nome_Scuderia FK
CREATE TABLE IF NOT EXISTS Vettura (
    nGara INT NOT NULL,
    Modello VARCHAR(20) NOT NULL,
    Data_acquisto DATE NOT NULL,
    Prezzo FLOAT NOT NULL,
    Nome_Scuderia VARCHAR(20) NOT NULL,
    PRIMARY KEY (nGara),
    FOREIGN KEY (Nome_Scuderia) REFERENCES Scuderia(Nome)
);

-- creazione tabella Componente
-- Codice PK, Costo, Tipo (Motore, Cambio, Telaio), Cilindrata_motore*, nCilindri_motore*, Tipo_motore*, Materiale_telaio*, Peso_telaio*,
-- nMarce_cambio*, Ragione_sociale_Costruttore FK, nGara_Vettura FK
CREATE TABLE IF NOT EXISTS Componente (
    Codice INT NOT NULL AUTO_INCREMENT,
    Costo FLOAT NOT NULL,
    Tipo VARCHAR(6) NOT NULL,
    Cilindrata_motore INT,
    nCilindri_motore INT,
    Tipo_motore VARCHAR(20),
    Materiale_telaio VARCHAR(20),
    Peso_telaio FLOAT,
    nMarce_cambio INT,
    Ragione_sociale_Costruttore VARCHAR(20) NOT NULL,
    nGara_Vettura INT NOT NULL,
    PRIMARY KEY (Codice),
    FOREIGN KEY (Ragione_sociale_Costruttore) REFERENCES Costruttore(Ragione_sociale),
    FOREIGN KEY (nGara_Vettura) REFERENCES Vettura(nGara)
);

-- creazione tabella Pilota
-- SSID PK, Nome, Cognome, DDN, Nazionalita, Quota*, nLicenze*, Data_prima_licenza*, Nome_Scuderia FK, nGara_Vettura FK
CREATE TABLE IF NOT EXISTS Pilota (
    SSID VARCHAR(20) NOT NULL,
    Nome VARCHAR(20) NOT NULL,
    Cognome VARCHAR(20) NOT NULL,
    DDN DATE NOT NULL,
    Nazionalita VARCHAR(20) NOT NULL,
    Quota FLOAT,
    nLicenze INT,
    Data_prima_licenza DATE,
    Nome_Scuderia VARCHAR(20) NOT NULL,
    nGara_Vettura INT NOT NULL,
    PRIMARY KEY (SSID),
    FOREIGN KEY (Nome_Scuderia) REFERENCES Scuderia(Nome),
    FOREIGN KEY (nGara_Vettura) REFERENCES Vettura(nGara)
);

-- creazione tabella Partecipa
-- Nome_Gara PK, nGara_Vettura PK, Punti, Motivo_ritiro*, posizione
CREATE TABLE IF NOT EXISTS Partecipa (
    Nome_Gara VARCHAR(20) NOT NULL,
    nGara_Vettura INT NOT NULL,
    Punti INT NOT NULL,
    Motivo_ritiro VARCHAR(20),
    posizione INT,
    PRIMARY KEY (Nome_Gara, nGara_Vettura),
    FOREIGN KEY (Nome_Gara) REFERENCES Gara(Nome),
    FOREIGN KEY (nGara_Vettura) REFERENCES Vettura(nGara)
);