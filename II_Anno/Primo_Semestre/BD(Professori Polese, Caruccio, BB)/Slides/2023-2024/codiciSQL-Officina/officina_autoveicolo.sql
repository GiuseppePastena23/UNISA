-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: officina
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autoveicolo`
--

DROP TABLE IF EXISTS `autoveicolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autoveicolo` (
  `targa` varchar(8) NOT NULL,
  `modello` varchar(30) NOT NULL,
  `tipoAlimentazione` varchar(30) NOT NULL,
  `tipo` int NOT NULL,
  `numAssi` varchar(10) DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `tipoCatalizzatore` varchar(10) DEFAULT NULL,
  `categoriaEmissione` varchar(20) DEFAULT NULL,
  `codiceFiscale` varchar(16) NOT NULL,
  PRIMARY KEY (`targa`),
  KEY `cliente_idx` (`codiceFiscale`),
  CONSTRAINT `cliente` FOREIGN KEY (`codiceFiscale`) REFERENCES `cliente` (`codiceFiscale`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autoveicolo`
--

LOCK TABLES `autoveicolo` WRITE;
/*!40000 ALTER TABLE `autoveicolo` DISABLE KEYS */;
INSERT INTO `autoveicolo` VALUES ('AB123','Fiat Punto','Benzina',2,NULL,NULL,'B','Euro 4','MRARSS60D63A717X'),('CA171','Eurocargo 190E30','Diesel',1,'4X2',9000,NULL,NULL,'LNEBCH05B41G230M'),('FF111','Opel Corsa','GPL',2,NULL,NULL,'A','Euro 6','LNEBCH05B41G230M');
/*!40000 ALTER TABLE `autoveicolo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-12 14:07:31
