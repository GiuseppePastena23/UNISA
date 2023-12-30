DROP SCHEMA condomini;
CREATE SCHEMA condomini;
USE condomini;

CREATE TABLE `condomini`.`condominio` (
  `nome` VARCHAR(45) NOT NULL,
  `via` VARCHAR(45) NOT NULL,
  `cap` VARCHAR(45) NOT NULL,
  `città` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nome`));
  
INSERT INTO `condomini`.`condominio` (`nome`, `via`, `cap`, `città`) VALUES ('Alighieri','via Roma','84084','Fisciano');
INSERT INTO `condomini`.`condominio` (`nome`, `via`, `cap`, `città`) VALUES ('Bianchi','via Della Liberazione','84084','Fisciano');
  
CREATE TABLE `condomini`.`proprietario` (
  `nome` VARCHAR(45) NOT NULL,
  `cognome` VARCHAR(45) NOT NULL,
  `codiceFiscale` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codiceFiscale`));
  
-- Query di insert su proprietario
INSERT INTO `condomini`.`proprietario` (`nome`, `cognome`, `codiceFiscale`) VALUES ('Mario', 'Rossi', 'RSSMRA75A20H501A');
INSERT INTO `condomini`.`proprietario` (`nome`, `cognome`, `codiceFiscale`) VALUES ('Giovanni', 'Esposito', 'SPSGNN76E01F205D');

CREATE TABLE `condomini`.`scala` (
  `codice` VARCHAR(2) NOT NULL,
  `condominio` VARCHAR(45) NOT NULL,
  `quotaScala` INT NOT NULL,
  PRIMARY KEY (`codice`, `condominio`),
    FOREIGN KEY (`condominio`)
    REFERENCES `condomini`.`condominio` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
-- Query di insert che funzionano su scala
INSERT INTO `condomini`.`scala` (`codice`, `condominio`, `quotascala`) VALUES ('A', 'Alighieri', '20');
INSERT INTO `condomini`.`scala` (`codice`, `condominio`, `quotascala`) VALUES ('A', 'Bianchi', '30');
INSERT INTO `condomini`.`scala` (`codice`, `condominio`, `quotascala`) VALUES ('B', 'Bianchi', '10');

-- Query di insert che falliscono su scala
INSERT INTO `condomini`.`scala` (`codice`, `condominio`, `quotascala`) VALUES ('B', 'Verdi', '10'); -- Non esiste il condominio Verdi

CREATE TABLE `condomini`.`appartamento` (
  `interno` VARCHAR(10) NOT NULL,
  `scala` VARCHAR(45) NOT NULL,
  `condominio` VARCHAR(45) NOT NULL,
  `millesimi` INT NOT NULL,
   `via` VARCHAR(45),
  `cap` VARCHAR(45),
  `città` VARCHAR(45),
  `proprietario` VARCHAR(45),
  PRIMARY KEY (`interno`, `scala`, `condominio`),
	FOREIGN KEY (`scala`, `condominio`)
	REFERENCES `condomini`.`scala` (`codice`, `condominio`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,
    FOREIGN KEY (`proprietario`)
	REFERENCES `condomini`.`proprietario` (`codiceFiscale`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);

-- Query di insert che funzionano su appartamento
INSERT INTO `condomini`.`appartamento` (`interno`, `scala`, `condominio`, `millesimi`) VALUES ('1', 'A', 'Alighieri', '104');
INSERT INTO `condomini`.`appartamento` (`interno`, `scala`, `condominio`, `millesimi`) VALUES ('2', 'A', 'Alighieri', '210');
INSERT INTO `condomini`.`appartamento` (`interno`, `scala`, `condominio`, `millesimi`) VALUES ('1', 'A', 'Bianchi', '10');
INSERT INTO `condomini`.`appartamento` (`interno`, `scala`, `condominio`, `millesimi`) VALUES ('1', 'B', 'Bianchi', '34');

-- Query di insert che falliscono su appartamento
INSERT INTO `condomini`.`appartamento` (`interno`, `scala`, `condominio`, `millesimi`) VALUES ('1', 'B', 'Alighieri', '34'); -- Non esiste la scala B nel condominio Alighieri
INSERT INTO `condomini`.`appartamento` (`interno`, `scala`, `condominio`, `millesimi`) VALUES ('1', 'A', 'Verdi', '34'); -- Non esiste il condominio Verdi

CREATE TABLE `condomini`.`spesa` (
  `codice` VARCHAR(10) NOT NULL,
  `rif_condominio` VARCHAR(45),
  `tipo` VARCHAR(45) NOT NULL,
  `importo` DOUBLE NOT NULL,
  `fattura` VARCHAR(45),
  `rif_scala_s` VARCHAR(2),
  `rif_scala_c` VARCHAR(45),
  PRIMARY KEY (`codice`),
    FOREIGN KEY (`rif_condominio`)
    REFERENCES `condomini`.`condominio` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,     
	FOREIGN KEY (`rif_scala_s`, `rif_scala_c`)
    REFERENCES `condomini`.`scala` (`codice`, `condominio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    );
    
-- Query di insert che funzionano su spesa
INSERT INTO `condomini`.`spesa` (`codice`, `tipo`, `importo`, `fattura`) VALUES ('1', 'appartamento', '150', '');
INSERT INTO `condomini`.`spesa` (`codice`, `rif_condominio`, `tipo`, `importo`, `fattura`) VALUES ('2', 'Alighieri', 'condominio', '15000', 'sì');
INSERT INTO `condomini`.`spesa` (`codice`, `tipo`, `importo`, `fattura`, `rif_scala_s`, `rif_scala_c`) VALUES ('3', 'scala', '2500', 'sì', 'B', 'Bianchi');

-- Query di insert che falliscono su spesa
INSERT INTO `condomini`.`spesa` (`codice`, `rif_condominio`, `tipo`, `importo`, `fattura`) VALUES ('4', 'Verdi', 'condominio', '15000', 'sì'); -- Non esiste il condominio Verdi
INSERT INTO `condomini`.`spesa` (`codice`, `tipo`, `importo`, `fattura`, `rif_scala_s`, `rif_scala_c`) VALUES ('4', 'scala', '2500', 'sì', 'B', 'Alighieri'); -- Non esiste la scala B del condominio Alighieri


CREATE TABLE `condomini`.`rif_appartamento` (
  `spesa` VARCHAR(10) NOT NULL,
  `interno` VARCHAR(10) NOT NULL,
  `scala` VARCHAR(45) NOT NULL,
  `condominio` VARCHAR(45) NOT NULL,  
  PRIMARY KEY (`interno`, `scala`, `condominio`, `spesa`),
  FOREIGN KEY (`spesa`)
	REFERENCES `condomini`.`spesa` (`codice`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,
	FOREIGN KEY (`interno`, `scala`, `condominio`)
	REFERENCES `condomini`.`appartamento` (`interno`, `scala`, `condominio`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION
);

-- Query di insert che funzionano su rif_appartamento
INSERT INTO `condomini`.`rif_appartamento` (`spesa`, `interno`, `scala`, `condominio`) VALUES ('1', '1', 'A', 'Alighieri');

-- Query di insert che falliscono su rif_appartamento
INSERT INTO `condomini`.`rif_appartamento` (`spesa`, `interno`, `scala`, `condominio`) VALUES ('4', '1', 'A', 'Alighieri'); -- Non esiste alcuna spesa con ID=4
INSERT INTO `condomini`.`rif_appartamento` (`spesa`, `interno`, `scala`, `condominio`) VALUES ('1', '1', 'B', 'Alighieri'); -- Non esiste la scala B del condominio Alighieri


CREATE TABLE `condomini`.`pagamento` (
  `spesa` VARCHAR(10) NOT NULL,
  `interno` VARCHAR(10) NOT NULL,
  `scala` VARCHAR(45) NOT NULL,
  `condominio` VARCHAR(45) NOT NULL,  
  `data` DATE NOT NULL,
  `percentuale` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`interno`, `scala`, `condominio`, `spesa`),
  FOREIGN KEY (`spesa`)
	REFERENCES `condomini`.`spesa` (`codice`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,
	FOREIGN KEY (`interno`, `scala`, `condominio`)
	REFERENCES `condomini`.`appartamento` (`interno`, `scala`, `condominio`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION);
    
-- Query di insert che funzionano su pagamento
INSERT INTO `condomini`.`pagamento` (`spesa`, `interno`, `scala`, `condominio`, `data`, `percentuale`, `tipo`) VALUES ('1', '1', 'A', 'Alighieri', curdate(), '45', 'appartamento');
INSERT INTO `condomini`.`pagamento` (`spesa`, `interno`, `scala`, `condominio`, `data`, `percentuale`, `tipo`) VALUES ('2', '1', 'A', 'Alighieri', curdate(), '20', 'condominio');
INSERT INTO `condomini`.`pagamento` (`spesa`, `interno`, `scala`, `condominio`, `data`, `percentuale`, `tipo`) VALUES ('2', '2', 'A', 'Alighieri', curdate(), '40', 'condominio');
INSERT INTO `condomini`.`pagamento` (`spesa`, `interno`, `scala`, `condominio`, `data`, `percentuale`, `tipo`) VALUES ('3', '1', 'B', 'Bianchi', curdate(), '100', 'scala');

-- Query di insert che falliscono su pagamento
INSERT INTO `condomini`.`pagamento` (`spesa`, `interno`, `scala`, `condominio`, `data`, `percentuale`, `tipo`) VALUES ('1', '2', 'B', 'Alighieri', curdate(), '45', 'appartamento'); -- Non esiste la scala B del condominio Alighieri
INSERT INTO `condomini`.`pagamento` (`spesa`, `interno`, `scala`, `condominio`, `data`, `percentuale`, `tipo`) VALUES ('4', '1', 'A', 'Alighieri', curdate(), '20', 'condominio'); -- Non esiste la spesa con ID 4
INSERT INTO `condomini`.`pagamento` (`spesa`, `interno`, `scala`, `condominio`, `data`, `percentuale`, `tipo`) VALUES ('2', '2', 'B', 'Bianchi', curdate(), '40', 'condominio'); -- Non esiste l'appartamento 2B nel condominio Bianchi
INSERT INTO `condomini`.`pagamento` (`spesa`, `interno`, `scala`, `condominio`, `data`, `percentuale`, `tipo`) VALUES ('3', '2', 'A', 'Bianchi', curdate(), '100', 'scala'); --  Non esiste l'appartamento 2A nel condominio Bianchi (solo in Alighieri)
    

ALTER TABLE appartamento
ADD COLUMN `proprietario` VARCHAR(45)
AFTER `città`,
ADD CONSTRAINT 
FOREIGN KEY(`proprietario`) 
REFERENCES `condomini`.`proprietario`(`codiceFiscale`)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
  

  
