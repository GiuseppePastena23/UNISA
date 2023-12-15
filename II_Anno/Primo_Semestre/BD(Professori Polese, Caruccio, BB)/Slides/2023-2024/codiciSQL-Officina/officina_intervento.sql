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
-- Table structure for table `intervento`
--

DROP TABLE IF EXISTS `intervento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `intervento` (
  `numProgressivo` int NOT NULL,
  `nomeOfficina` varchar(50) NOT NULL,
  `dataInizio` date NOT NULL,
  `dataFine` date DEFAULT NULL,
  `oreManodopera` int DEFAULT NULL,
  `targaAutoveicolo` varchar(8) NOT NULL,
  PRIMARY KEY (`numProgressivo`,`nomeOfficina`),
  KEY `nomeOfficina_idx` (`nomeOfficina`),
  KEY `targaAutoveicolo_idx` (`targaAutoveicolo`),
  CONSTRAINT `nomeOfficina` FOREIGN KEY (`nomeOfficina`) REFERENCES `officina` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `targaAutoveicolo` FOREIGN KEY (`targaAutoveicolo`) REFERENCES `autoveicolo` (`targa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intervento`
--

LOCK TABLES `intervento` WRITE;
/*!40000 ALTER TABLE `intervento` DISABLE KEYS */;
INSERT INTO `intervento` VALUES (1,'Meccanica Ferraro A. & Figli','2018-09-13','2018-09-14',5,'CA171'),(1,'Officina Ferraro Giuseppe','2018-10-22','2018-10-24',10,'FF111'),(2,'Meccanica Ferraro A. & Figli','2018-12-03','2018-12-03',2,'CA171'),(3,'Meccanica Ferraro A. & Figli','2023-12-03','2018-12-06',2,'CA171');
/*!40000 ALTER TABLE `intervento` ENABLE KEYS */;
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
