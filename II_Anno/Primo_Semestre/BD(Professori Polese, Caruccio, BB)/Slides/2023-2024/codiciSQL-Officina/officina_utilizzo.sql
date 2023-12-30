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
-- Table structure for table `utilizzo`
--

DROP TABLE IF EXISTS `utilizzo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizzo` (
  `codiceRicambio` varchar(15) NOT NULL,
  `progressivoIntervento` int NOT NULL,
  `nomeOfficina` varchar(50) NOT NULL,
  `quantità` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`codiceRicambio`,`progressivoIntervento`,`nomeOfficina`),
  KEY `numIntervento_idx` (`progressivoIntervento`),
  KEY `officina_idx` (`nomeOfficina`),
  CONSTRAINT `codiceRicambio` FOREIGN KEY (`codiceRicambio`) REFERENCES `ricambio` (`codice`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `numIntervento` FOREIGN KEY (`progressivoIntervento`) REFERENCES `intervento` (`numProgressivo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `officina` FOREIGN KEY (`nomeOfficina`) REFERENCES `intervento` (`nomeOfficina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizzo`
--

LOCK TABLES `utilizzo` WRITE;
/*!40000 ALTER TABLE `utilizzo` DISABLE KEYS */;
INSERT INTO `utilizzo` VALUES ('0451103351',2,'Meccanica Ferraro A. & Figli',1),('598382',1,'Meccanica Ferraro A. & Figli',2),('CT704',1,'Meccanica Ferraro A. & Figli',1),('CT704',1,'Officina Ferraro Giuseppe',1);
/*!40000 ALTER TABLE `utilizzo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-12 14:07:32
