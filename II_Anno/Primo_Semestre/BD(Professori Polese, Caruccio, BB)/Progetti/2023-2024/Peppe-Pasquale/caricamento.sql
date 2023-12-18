-- Script di inserimento dati in Campionato

use Campionato;

INSERT INTO Circuito (Nome, Paese, Lunghezza, nCurve) VALUES
('Monza', 'Italia', 5.793, 11),
('Monte Carlo', 'Monaco', 3.337, 19),
('Silverstone', 'Gran Bretagna', 5.891, 18),
('Suzuka', 'Giappone', 5.807, 18);

INSERT INTO Costruttore (Ragione_sociale, Nome, Sede, nComponenti_forniti) VALUES
('RacingTech Components Ltd.', 'RacingTech', '123 Main Street, Londra W1A 1AA, Gran Bretagna', 3),
('Precision Motorsport Parts Inc.', 'Precision Motorsport', '456 Oak Avenue, Los Angeles, CA 90001, Stati Uniti', 3),
('EuroTech Racing Supplies GmbH', 'EuroTech', '789 Main Strasse, Francoforte 60311, Germania', 3),
('SpeedCraft Engineering Co. Ltd.', 'SpeedCraft', '101 Sakura Avenue, Tokyo 100-0001, Giappone', 3);


INSERT INTO Scuderia (Nome, Paese) VALUES
('Scuderia Ferrari', 'Italia'),
('Mercedes-AMG Petronas Formula One Team', 'Gran Bretagna'),
('Red Bull Racing', 'Gran Bretagna'),
('McLaren F1 Team', 'Gran Bretagna');


INSERT INTO Gara (Nome, Data, DurataH, Tipo, Nome_Circuito) VALUES
('GP Italia', '2023-05-15', 2, 'asciutta', 'Monza'),
('Q1 Italia', '2023-05-14', 1, 'asciutta', 'Monza'),
('Q2 Italia', '2023-05-14', 0.5, 'asciutta', 'Monza'),
('Q3 Italia', '2023-05-15', 0.5, 'asciutta', 'Monza'),
('FP1 Italia', '2023-05-12', 1, 'asciutta', 'Monza'),
('FP2 Italia', '2023-05-12', 1, 'asciutta', 'Monza'),
('FP3 Italia', '2023-05-13', 1, 'asciutta', 'Monza'),

('GP Monaco', '2023-05-29', 1.5, 'bagnata', 'Monte Carlo'),
('Q1 Monaco', '2023-05-28', 1, 'bagnata', 'Monte Carlo'),
('Q2 Monaco', '2023-05-28', 0.5, 'bagnata', 'Monte Carlo'),
('Q3 Monaco', '2023-05-29', 0.5, 'bagnata', 'Monte Carlo'),
('FP1 Monaco', '2023-05-26', 1, 'bagnata', 'Monte Carlo'),
('FP2 Monaco', '2023-05-26', 1, 'bagnata', 'Monte Carlo'),
('FP3 Monaco', '2023-05-27', 1, 'bagnata', 'Monte Carlo'),

('GP Gran Bretagna', '2023-07-10', 2.5, 'asciutta', 'Silverstone'),
('Q1 Gran Bretagna', '2023-07-09', 1, 'asciutta', 'Silverstone'),
('Q2 Gran Bretagna', '2023-07-09', 0.5, 'asciutta', 'Silverstone'),
('Q3 Gran Bretagna', '2023-07-10', 0.5, 'asciutta', 'Silverstone'),
('FP1 Gran Bretagna', '2023-07-07', 1, 'asciutta', 'Silverstone'),
('FP2 Gran Bretagna', '2023-07-07', 1, 'asciutta', 'Silverstone'),
('FP3 Gran Bretagna', '2023-07-08', 1, 'asciutta', 'Silverstone'),

('GP Giappone', '2023-09-25', 2, 'asciutta', 'Suzuka'),
('Q1 Giappone', '2023-09-24', 1, 'asciutta', 'Suzuka'),
('Q2 Giappone', '2023-09-24', 0.5, 'asciutta', 'Suzuka'),
('Q3 Giappone', '2023-09-25', 0.5, 'asciutta', 'Suzuka'),
('FP1 Giappone', '2023-09-22', 1, 'asciutta', 'Suzuka'),
('FP2 Giappone', '2023-09-22', 1, 'asciutta', 'Suzuka'),
('FP3 Giappone', '2023-09-23', 1, 'asciutta', 'Suzuka');


INSERT INTO Vettura (nGara, Modello, Data_acquisto, Prezzo, Nome_Scuderia) VALUES
(16, 'SF21', '2023-03-01', 1200000.00, 'Scuderia Ferrari'),
(55, 'SF21', '2023-03-15', 1250000.00, 'Scuderia Ferrari'),
(44, 'W13', '2023-02-15', 1500000.00, 'Mercedes-AMG Petronas Formula One Team'),
(77, 'W13', '2023-02-28', 1550000.00, 'Mercedes-AMG Petronas Formula One Team'),
(11, 'RB18', '2023-03-10', 1300000.00, 'Red Bull Racing'),
(33, 'RB18', '2023-03-20', 1350000.00, 'Red Bull Racing'),
(4, 'MCL36', '2023-01-20', 1100000.00, 'McLaren F1 Team'),
(26, 'MCL36', '2023-02-01', 1150000.00, 'McLaren F1 Team');


INSERT INTO Componente (Costo, Tipo, Cilindrata_motore, nCilindri_motore, Tipo_motore, Materiale_telaio, Peso_telaio, nMarce_cambio, Ragione_sociale_Costruttore, nGara_Vettura) VALUES
(5500.00, 'Motore', 2000, 8, 'V8', NULL, NULL, NULL, 'RacingTech Components Ltd.', 44),
(2200.00, 'Cambio', NULL, NULL, NULL, NULL, NULL, 7, 'RacingTech Components Ltd.', 77),
(3200.00, 'Telaio', NULL, NULL, NULL, 'Carbonio', 650, NULL, 'RacingTech Components Ltd.', 16),

(4800.00, 'Motore', 1800, 6, 'V6', NULL, NULL, NULL, 'Precision Motorsport Parts Inc.', 11),
(1900.00, 'Cambio', NULL, NULL, NULL, NULL, NULL, 8, 'Precision Motorsport Parts Inc.', 55),
(2700.00, 'Telaio', NULL, NULL, NULL, 'Alluminio', 600, NULL, 'Precision Motorsport Parts Inc.', 77),

(4200.00, 'Motore', 2200, 10, 'V10', NULL, NULL, NULL, 'EuroTech Racing Supplies GmbH', 55),
(2300.00, 'Cambio', NULL, NULL, NULL, NULL, NULL, 6, 'EuroTech Racing Supplies GmbH', 33),
(3800.00, 'Telaio', NULL, NULL, NULL, 'Carbonio', 620, NULL, 'EuroTech Racing Supplies GmbH', 16),

(5000.00, 'Motore', 2100, 12, 'V12', NULL, NULL, NULL, 'SpeedCraft Engineering Co. Ltd.', 33),
(2100.00, 'Cambio', NULL, NULL, NULL, NULL, NULL, 6, 'SpeedCraft Engineering Co. Ltd.', 44),
(3000.00, 'Telaio', NULL, NULL, NULL, 'Titanio', 590, NULL, 'SpeedCraft Engineering Co. Ltd.', 77);


INSERT INTO Pilota (SSID, Nome, Cognome, DDN, Nazionalita, Tipo, Quota, nLicenze, Data_prima_licenza, nGara_Vettura) VALUES
('54VGYIIGIUASC654', 'Lewis', 'Hamilton', '1985-01-07', 'Inglese', 'PRO', NULL, 5, NULL, 44),
('WVB8956VDS11SD2V', 'Max', 'Verstappen', '1997-09-30', 'Olandese', 'PRO', NULL, 4, NULL, 33),

('TRNAXL99T13H501B', 'Mario', 'Rossi', '1999-11-13', 'Italiano', 'AM', NULL, NULL, '2022-03-01', 4),
('PKRCHL97P16H501M', 'James', 'Brown', '1997-10-16', 'Inglese', 'AM', NULL, NULL, '2022-02-28', 55),

('SCHTFX87L03C205G', 'Carlos', 'Hombre', '1987-07-03', 'Spagnolo', 'GD', 200000.00, NULL, '2022-03-10', 11),
('BRGNNA89M28C205F', 'Luigi', 'Casati', '1989-08-28', 'Italiano', 'GD', 180000.00, NULL, '2022-03-20', 77);


INSERT INTO Partecipazione (Nome_Gara, nGara_Vettura, Punti, Motivo_ritiro, posizione) VALUES
('GP Italia', 44, 25, NULL, 1),
('GP Italia', 77, 18, NULL, 2),
('GP Italia', 55, 15, NULL, 3),
('GP Italia', 11, 12, NULL, 4),
('GP Italia', 33, 10, NULL, 5),
('GP Italia', 16, 8, NULL, 6),
('GP Italia', 4, 0, 'ritiro', NULL),
('Q1 Italia', 44, 0, 'ritiro', NULL),
('Q2 Italia', 77, 0, NULL, 3),
('Q3 Italia', 55, 0, 'squalifica', NULL),
('FP1 Italia', 11, 0, NULL, 8),
('FP2 Italia', 33, 0, NULL, 10),
('FP3 Italia', 16, 0, NULL, 6),
('GP Monaco', 44, 25, NULL, 1),
('GP Monaco', 77, 0, 'incidente', NULL),
('GP Monaco', 11, 12, NULL, 4),
('GP Monaco', 33, 10, NULL, 5),
('GP Monaco', 16, 8, NULL, 6),
('GP Monaco', 4, 0, 'ritiro', NULL),
('GP Monaco', 55, 0, 'squalifica', NULL),
('Q1 Monaco', 44, 0, NULL, 1),
('Q2 Monaco', 77, 0, NULL, 3),
('Q3 Monaco', 55, 0, 'squalifica', NULL),
('FP1 Monaco', 11, 0, NULL, 8),
('FP2 Monaco', 33, 0, NULL, 10),
('FP3 Monaco', 16, 0, NULL, 6);
