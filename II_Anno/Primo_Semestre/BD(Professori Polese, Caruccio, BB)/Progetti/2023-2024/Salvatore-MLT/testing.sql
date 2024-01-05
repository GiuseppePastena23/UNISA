USE campionato;

-- SELECT Pilota.Nome, Pilota.Cognome, Pilota.SSID, Pilota.Nazionalita, Gareggiare.Posizione FROM Pilota
-- INNER JOIN Circuito ON Circuito.Paese = Pilota.Nazionalita  -- Garantisce che sia "in casa"
-- INNER JOIN Gara ON Gara.IDCircuito = Circuito.ID
-- INNER JOIN Gareggiare ON Gareggiare.NomeGara = Gara.Nome
-- WHERE Gareggiare.Posizione = 1;
-- GROUP BY Gareggiare.Posizione;

-- SELECT Squadra.Nome, Squadra.PunteggioFinale, Componenti.TipoMotore FROM Squadra
-- INNER JOIN Vettura ON Vettura.ID = Squadra.NomeVeicolo
-- INNER JOIN Componenti ON Componenti.NomeVettura = Vettura.ID
-- WHERE Componenti.Tipo = 'motore';

-- SELECT Squadra.Nome, Squadra.NomeVeicolo, Squadra.PunteggioFinale, Componenti.TipoMotore FROM Squadra
-- INNER JOIN Vettura ON Vettura.ID = Squadra.NomeVeicolo
-- INNER JOIN Componenti ON Componenti.NomeVettura = Vettura.ID
-- WHERE Componenti.Tipo = 'motore';

-- Voglio tutti i costruttori associati ad una squadra
-- per cui
-- Squadra --> Vettura --> Scuderia

-- AGGIORNAMENTO serve durata da Gara

-- Calcolo il rapporto del punteggio al tempo e poi lo sommo e faccio la media (Stampa soltanto le scuderie che partecipano) (altrimenti bisognava metter IFNULL, left join e comunque sembrava inutile)
-- SELECT Scuderia.Nome, SUM(Squadra.PunteggioFinale/Gara.Durata)/COUNT(Squadra.Nome) AS PunteggioFinaleMediaTempo FROM Squadra
-- INNER JOIN Vettura ON Vettura.ID = Squadra.NomeVeicolo
-- INNER JOIN Scuderia ON Scuderia.Nome = Vettura.NomeScuderia
-- INNER JOIN Gareggiare ON Gareggiare.NomeSquadra = Squadra.Nome
-- INNER JOIN Gara ON Gara.Nome = Gareggiare.NomeGara
-- GROUP BY Scuderia.Nome;

-- WHEN SUM(CASE WHEN Pilota.NFinanziamenti IS NULL THEN 1 ELSE 0 END) > 0

-- SELECT Pilota.NFinanziamenti FROM Squadra
-- INNER JOIN Pilota ON Pilota.NomeSquadra = Squadra.Nome
-- WHERE Squadra.Nome = 'TEST1' AND Pilota.NFinanziamenti IS NULL;




-- SELECT Squadra.Nome ,COUNT(Pilota.SommaFinanziamenti)/COUNT(Pilota.SSID) * 100 AS PercentualeGD FROM Squadra
-- INNER JOIN Pilota ON Squadra.Nome = Pilota.NomeSquadra
-- GROUP BY Squadra.Nome;


INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, TipoMotore, Numerocilindri)
VALUES
('TEST4', 'motore', 10000, '2023-10-04', 'Ferrari', '1', 'Ferrari S.p.A.', 'alluminio', 60, 8, 1600, 'tipo1', 8),
('TEST5', 'motore', 20000, '2022-09-20', 'Ferrari', '2', 'Ferrari S.p.A.', 'carbonio', 750, 7, 1600, 'tipo1', 10);

INSERT INTO Circuito (ID, Nome,  Paese)
VALUES
('1', 'Autodromo Nazionale Monza', 'Italia'),
('2', 'Bahrain International Circuit', 'Bahrain'),
('3', 'Yas Marina Circuit', 'Emirati Arabi Uniti'),
('4', 'Circuit de Spa-Francorchamps', 'Belgio'),
('5', 'Silverstone Circuit', 'Regno Unito');

INSERT INTO Scuderia (Nome, Sedecentrale)
VALUES
('Ferrari', 'Maranello, Italia'),
('Mercedes-AMG Petronas', 'Woking, Regno Unito'),
('Red Bull Racing', 'Milton Keynes, Regno Unito'),
('McLaren', 'Woking, Regno Unito'),
('AlphaTauri', 'Faenza, Italia');

INSERT INTO Costruttore (Ragionesociale, Nome, Sedefabbrica)
VALUES
('Ferrari S.p.A.', 'Ferrari', 'Maranello, Italia'),
('Mercedes-Benz AG', 'Mercedes-AMG Petronas', 'Stoccarda, Germania'),
('Red Bull Technology Ltd.', 'Red Bull Racing', 'Milton Keynes, Regno Unito'),
('McLaren Group Limited', 'McLaren', 'Woking, Regno Unito'),
('Red Bull Technology GmbH', 'AlphaTauri', 'Faenza, Italia');

INSERT INTO Gara (Giorno, IDCircuito, Durata, Tipo, Nome)
VALUES
('2023-03-19', '1', 240, 'asciutta', 'Gran Premio dItalia'),
('2023-03-26', '2', 280, 'bagnata', 'Grand Prix'),
('2023-03-30', '3', 260, 'asciutta', 'Gran Premio degli Emirati Arabi Uniti'),
('2023-04-07', '4', 270, 'bagnata', 'Gran Premio del Belgio'),
('2023-04-14', '5', 250, 'asciutta', 'Gran Premio di Gran Bretagna');

INSERT INTO Vettura (ID, NomeScuderia, NGara, Modello)
VALUES
('1', 'Ferrari', 71, 'F1-75'),
('2', 'Ferrari', 67, 'MCL36'),
('3', 'Red Bull Racing', 70, 'RB18'),
('4', 'Red Bull Racing', 69, 'AMR22'),
('5', 'AlphaTauri', 68, 'AT03');

INSERT INTO Squadra (Nome, PunteggioFinale, NomeVeicolo)
VALUES
('TEST1', 224, '1'),
('TEST2', 201, '3'),
('TEST3', 197, '4'),
('TEST4', 167, '2'),
('TEST5', 129, '5');

INSERT INTO Gareggiare (NomeGara, NomeSquadra, Posizione, Punteggio, Squalifica)
VALUES
 ('Gran Premio dItalia', 'TEST2', 1, 50, null),
 ('Grand Prix', 'TEST2', 2, 40, null),
 ('Grand Prix', 'TEST3', 3, 12, null),
 ('Gran Premio dItalia', 'TEST4', 4, 28, null),
('Gran Premio dItalia', 'TEST1', 5, 20, null),
('Gran Premio dItalia', 'TEST5', 6, 12, null),
('Gran Premio di Gran Bretagna', 'TEST1', 7, 60, null);
-- ('Gran Premio dItalia', '', 10, null),
-- ('Gran Premio dItalia', '', null, 'nonconoscosqualifiche');

INSERT INTO Pilota (Nome, Cognome, SSID, Datnas, Nazionalita, NomeSquadra, PrimaLicenza, NLicenze, NFinanziamenti, SommaFinanziamenti)
VALUES
-- ('Carlos', 'Sainz Jr', '1', '1994-09-01', 'Italia', 'Ferrari', null, 10, null, null),
-- ('Charles', 'Leclerc', '2', '1997-10-16', 'Belgio', 'Ferrari', null, 20, null, null),
 --  ('Max', 'Verstappen', '3', '1997-09-30', 'Italia', 'Red Bull Racing', null, 30, null, null),
 -- ('Sergio', 'Perez', '4', '1990-01-26', 'Regno Unito', 'Red Bull Racing', null, 20, null, null),
 ('Lando', 'Norris', '5', '1999-01-13', 'Italia', 'Red Bull Racing', null, 20, null, null),
 ('Landolfi', 'MacNorris', '6', '1999-01-14', 'Regno Unito', 'McLaren', null, 20, null, null), 
('Salvatore', 'Forclaz', '7', '1999-01-14', 'Italia', 'TEST1', null, 10, null, null);

INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, TipoMotore, Numerocilindri)
VALUES
('1', 'cambio', 10000, '2023-10-04', 'Ferrari', '1', 'Ferrari S.p.A.', 'alluminio', 60, 8, 1600, 'tipo1', 8),
('2', 'telaio', 20000, '2022-09-20', 'Ferrari', '2', 'Ferrari S.p.A.', 'carbonio', 750, 7, 1600, 'tipo1', 10),
('3', 'motore', 30000, '2023-09-10', 'Red Bull Racing', '3', 'Ferrari S.p.A.', 'alluminio', 300, 10, 1600, 'tipo1', 6),
('4', 'cambio', 15000, '2023-09-20', 'Ferrari', '4', 'Ferrari S.p.A.', 'carbonio', 50, 8, 1600, 'tipo1', 8),
('5', 'telaio', 25000, '2022-09-13', 'Ferrari', '5', 'Ferrari S.p.A.', 'carbonio', 650, 7, 1600, 'tipo2', 12);

INSERT INTO Circuito (ID, Nome, Paese) VALUES
('CIR1', 'Monza', 'Italy'),
('CIR2', 'Silverstone', 'United Kingdom'),
('CIR3', 'Spa-Francorchamps', 'Belgium');

