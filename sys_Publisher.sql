-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: localhost    Database: sys
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `Publisher`
--

DROP TABLE IF EXISTS `Publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Publisher` (
  `Publisher_ID` int NOT NULL AUTO_INCREMENT,
  `Publisher_Name` varchar(255) NOT NULL,
  `Street_Num` int DEFAULT NULL,
  `Street_Name` varchar(255) DEFAULT NULL,
  `Town` varchar(255) DEFAULT NULL,
  `Zip_Code` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `Phone_Num` varchar(255) DEFAULT NULL,
  `Mail` varchar(255) DEFAULT NULL,
  `Website` varchar(255) DEFAULT NULL,
  `Date_Founded` date DEFAULT NULL,
  `Description` text,
  PRIMARY KEY (`Publisher_ID`),
  UNIQUE KEY `Mail` (`Mail`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Publisher`
--

LOCK TABLES `Publisher` WRITE;
/*!40000 ALTER TABLE `Publisher` DISABLE KEYS */;
INSERT INTO `Publisher` VALUES (1,'Penguin Books',NULL,NULL,NULL,NULL,NULL,'555-555-5555','penguin@books.com',NULL,NULL,'An imprint of Penguin Random House'),(2,'Simon & Schuster',NULL,NULL,NULL,NULL,NULL,'555-555-5556','simon@schuster.com',NULL,NULL,'A major publisher of books'),(3,'HarperCollins',NULL,NULL,NULL,NULL,NULL,'555-555-5557','harper@collins.com',NULL,NULL,'A leading publisher of books'),(4,'Hachette Book Group',NULL,NULL,NULL,NULL,NULL,'555-555-5558','hachette@bookgroup.com',NULL,NULL,'A subsidiary of Hachette Livre'),(5,'Macmillan Publishers',NULL,NULL,NULL,NULL,NULL,'555-555-5559','macmillan@publishers.com',NULL,NULL,'A group of publishing companies');
/*!40000 ALTER TABLE `Publisher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-16 12:52:45
