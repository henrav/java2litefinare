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
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `User_ID` int NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(255) NOT NULL,
  `Passworden` varchar(255) NOT NULL,
  `First_Name` varchar(255) NOT NULL,
  `Last_Name` varchar(255) NOT NULL,
  `Phone_Num` varchar(255) NOT NULL,
  `Mail` varchar(255) NOT NULL,
  `Street_Num` int DEFAULT NULL,
  `Street_Name` varchar(255) DEFAULT NULL,
  `Town` varchar(255) DEFAULT NULL,
  `Zip_Code` varchar(255) DEFAULT NULL,
  `Date_Created` date DEFAULT NULL,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'henrav','lmao','henrik','ravnborg','123456789','henrik@ravnborg.se',87,'klintvägen','luelå','98234','2023-02-06'),(2,'rettan','xd','anders','ravnborg','987654321','anders@ravnborg.se',19,'toppmurklevägen','lidingö','18157','2023-02-06'),(3,'apa','lmaoxd','johan','ravnborg','123459876','johan@ravnborg.se',1234,'tjeckisgata','prag','123123','2023-02-06'),(4,'bibliotekarie','hejsan','biblis','karie','91823','biblis@karie.se',12312,'nåntinggatan','stockholm','123123','2023-01-01'),(5,'tjena','xddd','tjena','ravnborg','142134234','asdasd@asasd.se',423523,'klint','lule','645645','2023-01-01'),(6,'hänktatank','hejsan','henrikapan','ravnborg','002313423','nåntingnånting@gmail',NULL,NULL,NULL,NULL,NULL),(7,'hänktatank','hejsan','henrikapan','ravnborg','002313423','nåntingnånting@gmail',NULL,NULL,NULL,NULL,NULL),(8,'hänktatank','hejsan','henrikapan','ravnborg','002313423','nåntingnånting@gmail',NULL,NULL,NULL,NULL,NULL),(9,'hänktatank','hejsan','henrikapan','ravnborg','002313423','nåntingnånting@gmail',NULL,NULL,NULL,NULL,NULL),(10,'henrav','henke','ravenbårg','henke','34534','dsfgdf',34534,'dfgd','dhffg','4234',NULL),(12,'hej på dig jag gillar apor','asfas','dgdfh','dfhd','56456','hgfghf',456,'fghfgh','ghj','456',NULL),(13,'aporna älskar bananer','sdgs','sgs','asdas','345346','dfgdfh',556,'dfg','dfg','235',NULL),(14,'kasfkas','tjena apan','sfs','hgfh','345345','dfgdfg',346534,'dfhdf','sdgs','3423',NULL),(15,'aporna gillar bananer','sdg','s','sgsg','346346','hfgh',45645,'fghfg','dfgd','345',NULL),(16,'aenrik','senrik','benrik','denrik','fenrik','genrik',235235,'henrik','jenrik','kdenrik',NULL),(17,'jenrik','jenrkik','jenrki','jenrik','jenrik','jenrik',34534,'jenrik','jenrik','jenrik',NULL),(18,'adfksd','gsfhd','bdfgbdf','sdfsd','fsdfs','fsdfsd',546456,'fghf','gfhfgh','fghh',NULL),(19,'dfg','df','dfhd','fhd','hfdh','fdfh',453,'sdfs','sdf','sdf',NULL);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
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
