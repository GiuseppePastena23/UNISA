use Campionato;
-- Inserimento dati nella tabella Circuito
INSERT INTO Circuito (nome_circuito, paese_residenza, ncurve, lunghezza)
VALUES 
('Monza', 'Italia', 11, 5.793),
('Silverstone', 'Regno Unito', 18, 5.891),
('Spa-Francorchamps', 'Belgio', 19, 7.004);

-- Inserimento dati nella tabella Gara
INSERT INTO Gara (nome_gara, stagione, data_gara, duratah, tipo, Circuito)
VALUES 
('Gran Premio Italia', 2023, '2023-09-10', '02:00:00', 'asciutta', 'Monza'),
('British Grand Prix', 2023, '2023-07-16', '01:45:00', 'asciutta', 'Silverstone'),
('Belgian Grand Prix', 2023, '2023-08-27', '01:50:00', 'bagnata', 'Spa-Francorchamps');

-- Inserimento dati nella tabella Scuderia
INSERT INTO Scuderia (nome_scuderia, nazione_sede)
VALUES 
('Ferrari', 'Italia'),
('Mercedes', 'Germania'),
('Red Bull Racing', 'Austria');

-- Inserimento dati nella tabella Costruttore
INSERT INTO Costruttore (ragione_sociale, nome, sede_fabbrica, ncomponenti)
VALUES 
('Ferrari Costruzioni', 'Ferrari', 'Maranello', 500),
('Mercedes Motors', 'Mercedes', 'Stoccarda', 450),
('Red Bull Engineering', 'Red Bull Racing', 'Milton Keynes', 400);

-- Inserimento dati nella tabella Vettura
INSERT INTO Vettura (modello, totale_punti, rif_scuderia)
VALUES 
('SF21', 100, 'Ferrari'),
('W12', 120, 'Mercedes'),
('RB16B', 90, 'Red Bull Racing');

-- Inserimento dati nella tabella Componente_Motore
INSERT INTO Componente_Motore (vettura, costo, cilindrata, tipo_motore, ncilindri, data_installazione, rif_costruttore, rif_vettura)
VALUES 
(1, 500000, 1600, 'turbo', 6, '2023-01-15', 'Ferrari Costruzioni', 1),
(2, 550000, 1600, 'turbo', 6, '2023-02-20', 'Mercedes Motors', 2),
(3, 480000, 1600, 'turbo', 6, '2023-01-30', 'Red Bull Engineering', 3);

-- Inserimento dati nella tabella Componente_Telaio
INSERT INTO Componente_Telaio (vettura, costo, peso, materiale, data_installazione, rif_costruttore, rif_vettura)
VALUES 
(1, 300000, 750, 'carbonio', '2023-01-18', 'Ferrari Costruzioni', 1),
(2, 280000, 720, 'carbonio', '2023-02-25', 'Mercedes Motors', 2),
(3, 320000, 780, 'carbonio', '2023-02-10', 'Red Bull Engineering', 3);

-- Inserimento dati nella tabella Componente_Cambio
INSERT INTO Componente_Cambio (vettura, costo, marce, data_installazione, rif_costruttore, rif_vettura)
VALUES 
(1, 200000, 8, '2023-01-20', 'Ferrari Costruzioni', 1),
(2, 180000, 7, '2023-03-01', 'Mercedes Motors', 2),
(3, 220000, 8, '2023-02-15', 'Red Bull Engineering', 3);

-- Inserimento dati nella tabella Equipaggio
INSERT INTO Equipaggio (rif_vettura) VALUES (1), (2), (3);

-- Inserimento dati nella tabella PILOTA_AM
INSERT INTO PILOTA_AM (nome, cognome, data_nascita, nazionalità, data_prima_licenza, rif_equipaggio)
VALUES 
('Sebastian', 'Vettel', '1987-07-03', 'Germania', '2005-01-10', 1),
('Lewis', 'Hamilton', '1985-01-07', 'Regno Unito', '2007-03-20', 2),
('Max', 'Verstappen', '1997-09-30', 'Paesi Bassi', '2015-05-15', 3);

-- Inserimento dati nella tabella PILOTA_PRO
INSERT INTO PILOTA_PRO (nome, cognome, data_nascita, nazionalità, nlicenze, rif_equipaggio)
VALUES 
('Sergio', 'Pérez', '1990-01-26', 'Messico', 3, 3);
('Charles', 'Leclerc', '1997-10-16', 'Monaco', 2, 1),
('Valtteri', 'Bottas', '1989-08-28', 'Finlandia', 3, 2),

-- Inserimento dati nella tabella Finanzia
INSERT INTO Finanzia (importo, data_fin, rif_scuderia, rif_gm_nome, rif_gm_cognome, rif_gm_data_nascita)
VALUES 
(500000, '2023-01-05', 'Ferrari', 'Sebastian', 'Vettel', '1987-07-03'),
(450000, '2023-02-10', 'Mercedes', 'Lewis', 'Hamilton', '1985-01-07'),
(400000, '2023-03-15', 'Red Bull Racing', 'Max', 'Verstappen', '1997-09-30');

-- Inserimento dati nella tabella Partecipazione
INSERT INTO Partecipazione (rif_gara, rif_vettura, punti, posizione, motivo_ritiro)
VALUES 
(1, 1, 25, 1, NULL),
(2, 2, 18, 2, 'guasto_meccanico'),
(3, 3, 15, 3, 'incidente');

INSERT INTO Finanzia (importo, data_fin, rif_scuderia, rif_gm_nome, rif_gm_cognome, rif_gm_data_nascita)
VALUES 
(50.23, '2023-01-12', 'Ferrari', 'Max', 'Verstappen', '1997-09-30');

INSERT INTO PILOTA_AM (nome, cognome, data_nascita, nazionalità, data_prima_licenza, rif_equipaggio, gm, nfinanziamenti)
VALUES
('Sebastiano', 'Vettel', '1987-07-03', 'Germania', '2005-01-10', 1, 1, 2);