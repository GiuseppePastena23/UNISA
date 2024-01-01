USE campionato;

INSERT INTO Circuito (ID, Nome, Paese)
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

INSERT INTO Gara (Giorno, NomeCircuito, Durata, Tipo, Nome)
VALUES
('2023-03-19', '1', 240, 'asciutta', 'Gran Premio dItalia'),
('2023-03-26', '2', 280, 'bagnata', 'Gran Premio del Bahrain'),
('2023-03-30', '3', 260, 'asciutta', 'Gran Premio degli Emirati Arabi Uniti'),
('2023-04-07', '4', 270, 'bagnata', 'Gran Premio del Belgio'),
('2023-04-14', '5', 250, 'asciutta', 'Gran Premio di Gran Bretagna');

INSERT INTO Vettura (ID, NomeScuderia, NGara, Modello)
VALUES
('1', 'Ferrari', 71, 'F1-75'),
('2', 'Mercedes-AMG Petronas', 67, 'MCL36'),
('3', 'Red Bull Racing', 70, 'RB18'),
('4', 'McLaren', 69, 'AMR22'),
('5', 'AlphaTauri', 68, 'AT03');

INSERT INTO Squadra (Nome, PunteggioFinale, NomeVeicolo)
VALUES
('Ferrari', 224, '1'),
('Red Bull Racing', 201, '3'),
('Mercedes-AMG Petronas', 197, '2'),
('McLaren', 167, '2'),
('AlphaTauri', 129, '5');

INSERT INTO Gareggiare (DataGara, NomeSquadra, Punteggio, Squalifica)
VALUES
('2023-03-19', 'Ferrari', 37, NULL),
('2023-03-26', 'Red Bull Racing', 45, NULL),
('2023-03-30', 'Mercedes-AMG Petronas', 28, NULL),
('2023-04-07', 'McLaren', 20, NULL),
('2023-04-14', 'AlphaTauri', 12, NULL);

INSERT INTO Pilota (Nome, Cognome, SSID, Datnas, Nazionalita, NomeSquadra, PrimaLicenza, NLicenze)
VALUES
('Carlos', 'Sainz Jr', '1', '1994-09-01', 'Spagnolo', 'Ferrari', null, 10),
('Charles', 'Leclerc', '2', '1997-10-16', 'Monegasco', 'Ferrari', null, 20),
('Max', 'Verstappen', '3', '1997-09-30', 'Olandese', 'Red Bull Racing', null, 30),
('Sergio', 'Perez', '4', '1990-01-26', 'Messicano', 'Red Bull Racing', null, 20),
('Lando', 'Norris', '5', '1999-01-13', 'Britannico', 'McLaren', null, 20);

INSERT INTO Componenti (ID, Tipo, Costo, Datainstallazione, NomeScuderia, NomeVettura, NomeCostruttore, Materiale, Peso, Nmarce, Cilindrata, Tipocilindrata, Numerocilindri)
VALUES
('1', 'cambio', 10000, '2023-10-04', 'Ferrari', '1', 'Ferrari S.p.A.', 'alluminio', 60, 8, 1600, 'tipo1', 8),
('2', 'telaio', 20000, '2022-09-20', 'Ferrari', '2', 'Ferrari S.p.A.', 'carbonio', 750, 7, 1600, 'tipo1', 10),
('3', 'motore', 30000, '2023-09-10', 'Red Bull Racing', '3', 'Ferrari S.p.A.', 'alluminio', 300, 10, 1600, 'tipo1', 6),
('4', 'cambio', 15000, '2023-09-20', 'McLaren', '4', 'Ferrari S.p.A.', 'carbonio', 50, 8, 1600, 'tipo1', 8),
('5', 'telaio', 25000, '2022-09-13', 'Ferrari', '5', 'Ferrari S.p.A.', 'carbonio', 650, 7, 1600, 'tipo2', 12);