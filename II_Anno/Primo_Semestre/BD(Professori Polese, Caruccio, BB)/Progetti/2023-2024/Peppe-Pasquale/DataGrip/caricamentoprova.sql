-- INSERIMENTO DATI
use Campionato;

-- inserimento dati nella tabella Circuito
INSERT INTO Circuito (Nome, Paese, Lunghezza, nCurve) VALUES
('Monza', 'Italia', 5.793, 11),
('Monte Carlo', 'Monaco', 3.337, 19),
('Silverstone', 'Gran Bretagna', 5.891, 18),
('Suzuka', 'Giappone', 5.807, 18);

-- inserimento dati nella tabella Costruttore
INSERT INTO Costruttore (Ragione_sociale, Nome, Sede, nComponenti_forniti) VALUES
('RacingTech Components Ltd.', 'RacingTech', '123 Main Street, Londra W1A 1AA, Gran Bretagna', 3),
('Precision Motorsport Parts Inc.', 'Precision Motorsport', '456 Oak Avenue, Los Angeles, CA 90001, Stati Uniti', 3),
('EuroTech Racing Supplies GmbH', 'EuroTech', '789 Main Strasse, Francoforte 60311, Germania', 3),
('SpeedCraft Engineering Co. Ltd.', 'SpeedCraft', '101 Sakura Avenue, Tokyo 100-0001, Giappone', 3);

-- inserimento dati nella tabella Scuderia
INSERT INTO Scuderia (Nome, Paese) VALUES
('Scuderia Ferrari', 'Italia'),
('Mercedes-AMG Petronas Formula One Team', 'Gran Bretagna'),
('Red Bull Racing', 'Gran Bretagna'),
('McLaren F1 Team', 'Gran Bretagna');

-- inserimento nella tabella Gara
INSERT INTO Gara (Nome, Data, DurataH, Tipo, Nome_Circuito) VALUES
-- Italia
('GP Italia', '2023-05-15', 2, 'asciutta', 'Monza'),
('Q1 Italia', '2023-05-14', 1, 'asciutta', 'Monza'),
('Q2 Italia', '2023-05-14', 0.5, 'asciutta', 'Monza'),
('Q3 Italia', '2023-05-15', 0.5, 'asciutta', 'Monza'),
('FP1 Italia', '2023-05-12', 1, 'asciutta', 'Monza'),
('FP2 Italia', '2023-05-12', 1, 'asciutta', 'Monza'),
('FP3 Italia', '2023-05-13', 1, 'asciutta', 'Monza'),

-- Monaco
('GP Monaco', '2023-05-29', 1.5, 'bagnata', 'Monte Carlo'),
('Q1 Monaco', '2023-05-28', 1, 'bagnata', 'Monte Carlo'),
('Q2 Monaco', '2023-05-28', 0.5, 'bagnata', 'Monte Carlo'),
('Q3 Monaco', '2023-05-29', 0.5, 'bagnata', 'Monte Carlo'),
('FP1 Monaco', '2023-05-26', 1, 'bagnata', 'Monte Carlo'),
('FP2 Monaco', '2023-05-26', 1, 'bagnata', 'Monte Carlo'),
('FP3 Monaco', '2023-05-27', 1, 'bagnata', 'Monte Carlo'),

-- Gran Bretagna
('GP Gran Bretagna', '2023-07-10', 2.5, 'asciutta', 'Silverstone'),
('Q1 Gran Bretagna', '2023-07-09', 1, 'asciutta', 'Silverstone'),
('Q2 Gran Bretagna', '2023-07-09', 0.5, 'asciutta', 'Silverstone'),
('Q3 Gran Bretagna', '2023-07-10', 0.5, 'asciutta', 'Silverstone'),
('FP1 Gran Bretagna', '2023-07-07', 1, 'asciutta', 'Silverstone'),
('FP2 Gran Bretagna', '2023-07-07', 1, 'asciutta', 'Silverstone'),
('FP3 Gran Bretagna', '2023-07-08', 1, 'asciutta', 'Silverstone'),

-- Giappone
('GP Giappone', '2023-09-25', 2, 'asciutta', 'Suzuka'),
('Q1 Giappone', '2023-09-24', 1, 'asciutta', 'Suzuka'),
('Q2 Giappone', '2023-09-24', 0.5, 'asciutta', 'Suzuka'),
('Q3 Giappone', '2023-09-25', 0.5, 'asciutta', 'Suzuka'),
('FP1 Giappone', '2023-09-22', 1, 'asciutta', 'Suzuka'),
('FP2 Giappone', '2023-09-22', 1, 'asciutta', 'Suzuka'),
('FP3 Giappone', '2023-09-23', 1, 'asciutta', 'Suzuka');


-- inserimento dati nella tabella Vettura
INSERT INTO Vettura (nGara, Modello, Data_acquisto, Prezzo, Nome_Scuderia) VALUES
-- Scuderia Ferrari
(16, 'SF21', '2023-03-01', 1200000.00, 'Scuderia Ferrari'),
(55, 'SF21', '2023-03-15', 1250000.00, 'Scuderia Ferrari'),

-- Mercedes-AMG Petronas Formula One Team
(44, 'W13', '2023-02-15', 1500000.00, 'Mercedes-AMG Petronas Formula One Team'),
(77, 'W13', '2023-02-28', 1550000.00, 'Mercedes-AMG Petronas Formula One Team'),

-- Red Bull Racing
(11, 'RB18', '2023-03-10', 1300000.00, 'Red Bull Racing'),
(33, 'RB18', '2023-03-20', 1350000.00, 'Red Bull Racing'),

-- McLaren F1 Team
(4, 'MCL36', '2023-01-20', 1100000.00, 'McLaren F1 Team'),
(55, 'MCL36', '2023-02-01', 1150000.00, 'McLaren F1 Team');


-- inserimento di componenti
INSERT INTO Componente (Costo, Tipo, Cilindrata_motore, nCilindri_motore, Tipo_motore, Materiale_telaio, Peso_telaio, nMarce_cambio, Ragione_sociale_Costruttore, nGara_Vettura) VALUES
-- RacingTech Components Ltd.
(5500.00, 'Motore', 2000, 8, 'V8', NULL, NULL, NULL, 'RacingTech Components Ltd.', 44),
(2200.00, 'Cambio', NULL, NULL, NULL, NULL, NULL, 7, 'RacingTech Components Ltd.', 77),
(3200.00, 'Telaio', NULL, NULL, NULL, 'Carbonio', 650, NULL, 'RacingTech Components Ltd.', 16),

-- Precision Motorsport Parts Inc.
(4800.00, 'Motore', 1800, 6, 'V6', NULL, NULL, NULL, 'Precision Motorsport Parts Inc.', 11),
(1900.00, 'Cambio', NULL, NULL, NULL, NULL, NULL, 8, 'Precision Motorsport Parts Inc.', 55),
(2700.00, 'Telaio', NULL, NULL, NULL, 'Alluminio', 600, NULL, 'Precision Motorsport Parts Inc.', 77),

-- EuroTech Racing Supplies GmbH
(4200.00, 'Motore', 2200, 10, 'V10', NULL, NULL, NULL, 'EuroTech Racing Supplies GmbH', 55),
(2300.00, 'Cambio', NULL, NULL, NULL, NULL, NULL, 6, 'EuroTech Racing Supplies GmbH', 33),
(3800.00, 'Telaio', NULL, NULL, NULL, 'Carbonio', 620, NULL, 'EuroTech Racing Supplies GmbH', 16),

-- SpeedCraft Engineering Co. Ltd.
(5000.00, 'Motore', 2100, 12, 'V12', NULL, NULL, NULL, 'SpeedCraft Engineering Co. Ltd.', 33),
(2100.00, 'Cambio', NULL, NULL, NULL, NULL, NULL, 6, 'SpeedCraft Engineering Co. Ltd.', 44),
(3000.00, 'Telaio', NULL, NULL, NULL, 'Titanio', 590, NULL, 'SpeedCraft Engineering Co. Ltd.', 77);


-- inserimento dati nella tabella Pilota
-- suddivisione in 3 tipoligie di piloti
-- 1) piloti PRO con solo il numero di licenze
-- 2) piloti AM solo con la data della prima licenza
-- 3) piloti GD che è un AM con anche la quota
-- Inserimento dati nella tabella Pilota con SSID formato codice fiscale
INSERT INTO Pilota (SSID, Nome, Cognome, DDN, Nazionalita, Tipo, Quota, nLicenze, Data_prima_licenza, nGara_Vettura) VALUES
-- Piloti PRO
('HMTLSN85A01H501Z', 'Lewis', 'Hamilton', '1985-01-07', 'Britannico', 'PRO', NULL, 5, NULL, 44),
('VRSTPM97P30H501E', 'Max', 'Verstappen', '1997-09-30', 'Olandese', 'PRO', NULL, 4, NULL, 33),

-- Piloti AM
('TRNAXL99T13H501B', 'Alex', 'Turner', '1999-11-13', 'Britannico', 'AM', NULL, NULL, '2022-03-01', 4),
('PKRCHL97P16H501M', 'Charlie', 'Parker', '1997-10-16', 'Monegasco', 'AM', NULL, NULL, '2022-02-28', 55),

-- Piloti GD
('SCHTFX87L03C205G', 'Felix', 'Schmidt', '1987-07-03', 'Tedesco', 'GD', 200000.00, NULL, '2022-03-10', 11),
('BRGNNA89M28C205F', 'Nina', 'Berg', '1989-08-28', 'Finlandese', 'GD', 180000.00, NULL, '2022-03-20', 77);


-- inserimento dati nella tabella Partecipazione
-- metti qualche ritiro per vedere se funziona
INSERT INTO Partecipazione (Nome_Gara, nGara_Vettura, Punti, Motivo_ritiro, posizione) VALUES
('GP Monza', 1, 0, 'cacarella pilota', 23),
('GP Monza', 2, 18, NULL, 2),
('GP Monza', 3, 15, NULL, 3),
('GP Montecarlo', 1, 25, NULL, 1),
('GP Montecarlo', 2, 18, NULL, 2),
('GP Montecarlo', 3, 15, NULL, 3),
('GP Silverstone', 1, 25, NULL, 1),
('GP Silverstone', 2, 18, NULL, 2),
('GP Silverstone', 3, 15, NULL, 3);
