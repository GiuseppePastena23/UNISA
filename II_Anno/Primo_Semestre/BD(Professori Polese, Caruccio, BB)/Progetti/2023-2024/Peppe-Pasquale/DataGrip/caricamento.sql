-- INSERIMENTO DATI
use Campionato;
-- inserimento dati nella tabella Circuito
INSERT INTO Circuito (Nome, Paese, Lunghezza, nCurve) VALUES
('Monza', 'Italia', 5.793, 11),
('Montecarlo', 'Monaco', 3.337, 19),
('Silverstone', 'Gran Bretagna', 5.891, 18);

-- inserimento dati nella tabella Costruttore
INSERT INTO Costruttore (Ragione_sociale, Nome, Sede, nComponenti_forniti) VALUES
('Ferrari', 'Ferrari', 'Maranello', 3),
('Mercedes', 'Mercedes', 'Stoccarda', 3),
('Renault', 'Renault', 'Parigi', 3);

-- inserimento dati nella tabella Scuderia
INSERT INTO Scuderia (Nome, Paese) VALUES
('Ferrari', 'Italia'),
('Mercedes', 'Germania'),
('Alphatauri', 'Italia');

-- inserimento dati nella tabella Gara
INSERT INTO Gara (Nome, Data, DurataH, Tipo, Nome_Circuito) VALUES
('GP Monza', '2023-04-06', 2.5, 'Asciutta', 'Monza'),
('GP Montecarlo', '2023-01-13', 2.5, 'Bagnata', 'Montecarlo'),
('GP Silverstone', '2023-02-20', 2.5, 'Bagnata', 'Silverstone');

-- inserimento dati nella tabella Vettura
INSERT INTO Vettura (nGara, Modello, Data_acquisto, Prezzo, Nome_Scuderia) VALUES
(1, 'Ferrari SF21', '2023-01-01', 1000000, 'Ferrari'),
(2, 'Mercedes W12', '2023-01-01', 1000000, 'Mercedes'),
(3, 'Alphatauri AT03', '2023-01-01', 1000000, 'Alphatauri');

-- inserimento dati nella tabella Componente
INSERT INTO Componente (Costo, Tipo, Cilindrata_motore, nCilindri_motore, Tipo_motore, Materiale_telaio, Peso_telaio, nMarce_cambio, Ragione_sociale_Costruttore, nGara_Vettura) VALUES
(5000, 'Motore', 1600, 6, 'V6', NULL, NULL, NULL, 'Ferrari', 1),
(1000, 'Telaio', NULL, NULL, NULL, 'Carbonio', 100, NULL, 'Ferrari', 1),
(2000, 'Cambio', NULL, NULL, NULL, NULL, NULL, 8, 'Ferrari', 1),
(5000, 'Motore', 1600, 6, 'V6', NULL, NULL, NULL, 'Mercedes', 2),
(1000, 'Telaio', NULL, NULL, NULL, 'Carbonio', 100, NULL, 'Mercedes', 2),
(2000, 'Cambio', NULL, NULL, NULL, NULL, NULL, 8, 'Mercedes', 2),
(5000, 'Motore', 1600, 6, 'V6', NULL, NULL, NULL, 'Renault', 3),
(1000, 'Telaio', NULL, NULL, NULL, 'Carbonio', 100, NULL, 'Renault', 3),
(2000, 'Cambio', NULL, NULL, NULL, NULL, NULL, 8, 'Renault', 3);

-- inserimento dati nella tabella Pilota
-- suddivisione in 3 tipoligie di piloti
-- 1) piloti PRO con solo il numero di licenze
-- 2) piloti AM solo con la data della prima licenza
-- 3) piloti GD che è un AM con anche la quota
INSERT INTO Pilota (SSID, Nome, Cognome, DDN, Nazionalita, Tipo, Quota, nLicenze, Data_prima_licenza, nGara_Vettura) VALUES
('123456789', 'Mario', 'Rossi', '1990-01-01', 'Italia', 'PRO', NULL, 3, NULL, 1),
('987654321', 'Luigi', 'Verdi', '1990-01-01', 'Italia', 'AM', NULL, NULL, '2023-01-01', 1),
('111111111', 'Giovanni', 'Bianchi', '1990-01-01', 'Italia', 'GD', 1000, NULL, '2023-01-01', 1);

-- inserimento dati nella tabella Partecipa
-- metti qualche ritiro per vedere se funziona
INSERT INTO Partecipa (Nome_Gara, nGara_Vettura, Punti, Motivo_ritiro, posizione) VALUES
('GP Monza', 1, 0, 'cacarella pilota', 23),
('GP Monza', 2, 18, NULL, 2),
('GP Monza', 3, 15, NULL, 3),
('GP Montecarlo', 1, 25, NULL, 1),
('GP Montecarlo', 2, 18, NULL, 2),
('GP Montecarlo', 3, 15, NULL, 3),
('GP Silverstone', 1, 25, NULL, 1),
('GP Silverstone', 2, 18, NULL, 2),
('GP Silverstone', 3, 15, NULL, 3);
