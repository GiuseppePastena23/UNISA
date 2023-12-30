INSERT INTO Circuito (ID, Nome, Paese)
VALUES ('Monza', 'Monza Circuit', 'Italy');

INSERT INTO Circuito (ID, Nome, Paese)
VALUES ('Nürburgring', 'Nürburgring Nordschleife', 'Germany');

INSERT INTO Circuito (ID, Nome, Paese)
VALUES ('Silverstone', 'Silverstone Circuit', 'United Kingdom');

INSERT INTO Circuito (ID, Nome, Paese)
VALUES ('Circuit de Monaco', 'Circuit de Monaco', 'Monaco');

INSERT INTO Circuito (ID, Nome, Paese)
VALUES ('Interlagos', 'Interlagos', 'Brazil');

-- Insert statements for the Gara table

INSERT INTO Gara (Data, Circuito, Durata, Tipo, Nome)
VALUES ('2023-03-12', 'Monza', 250, 'asciutta', 'Monza Grand Prix');

INSERT INTO Gara (Data, Circuito, Durata, Tipo, Nome)
VALUES ('2023-06-26', 'Nürburgring', 300, 'bagnata', 'Nürburgring Grand Prix');

INSERT INTO Gara (Data, Circuito, Durata, Tipo, Nome)
VALUES ('2023-08-13', 'Silverstone', 240, 'asciutta', 'British Grand Prix');

INSERT INTO Gara (Data, Circuito, Durata, Tipo, Nome)
VALUES ('2023-09-30', 'Circuit de Monaco', 150, 'asciutta', 'Monaco Grand Prix');

INSERT INTO Gara (Data, Circuito, Durata, Tipo, Nome)
VALUES ('2023-11-18', 'Interlagos', 330, 'asciutta', 'Brazilian Grand Prix');

-- Insert statements for the Gareggiare table

INSERT INTO Gareggiare (NomeGara, NomeSquadra, Punteggio, Squalifica)
VALUES ('Monza Grand Prix', 'Ferrari', 250, 'No');

INSERT INTO Gareggiare (NomeGara, NomeSquadra, Punteggio, Squalifica)
VALUES ('Nürburgring Grand Prix', 'Red Bull', 180, 'Yes');

INSERT INTO Gareggiare (NomeGara, NomeSquadra, Punteggio, Squalifica)
VALUES ('British Grand Prix', 'Mercedes', 210, 'No');

INSERT INTO Gareggiare (NomeGara, NomeSquadra, Punteggio, Squalifica)
VALUES ('Monaco Grand Prix', 'McLaren', 165, 'No');

INSERT INTO Gareggiare (NomeGara, NomeSquadra, Punteggio, Squalifica)
VALUES ('Brazilian Grand Prix', 'Ferrari', 270, 'No');

-- Insert statements for the Squadra table

INSERT INTO Squadra (Nome, PunteggioFinale, Veicolo)
VALUES ('Ferrari', 1025, 'F1-75');

INSERT INTO Squadra (Nome, PunteggioFinale, Veicolo)
VALUES ('Red Bull', 978, 'RB18');

INSERT INTO Squadra (Nome, PunteggioFinale, Veicolo)
VALUES ('Mercedes', 942, 'W13');

INSERT INTO Squadra (Nome, PunteggioFinale, Veicolo)
VALUES ('McLaren', 817, 'MCL36');

INSERT INTO Squadra (Nome, PunteggioFinale, Veicolo)
VALUES ('Aston Martin', 732, 'AMR23');

-- Insert statements for the Vettura table

INSERT INTO Vettura (ID, NomeScuderia, NGara, Modello)
VALUES ('F175', 'Ferrari', 5, 'F1-75');

INSERT INTO Vettura (ID, NomeScuderia, NGara, Modello)
VALUES ('RB18', 'Red Bull', 31, 'F1-75');