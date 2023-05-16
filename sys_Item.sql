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
-- Table structure for table `Item`
--

DROP TABLE IF EXISTS `Item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Item` (
  `Item_ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `ISBN` varchar(13) NOT NULL,
  `Barcode` varchar(255) NOT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `Description` text,
  `Item_Type` enum('Standard Literature','Course Literature','Reference Literature','DVD') NOT NULL,
  `Rent_Time_Weeks` int NOT NULL,
  `Item_Status` enum('Available','Reserved','Checked Out','Overdue') NOT NULL,
  PRIMARY KEY (`Item_ID`),
  UNIQUE KEY `Barcode` (`Barcode`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Item`
--

LOCK TABLES `Item` WRITE;
/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
INSERT INTO `Item` VALUES (1,'The Great Gatsby','10000000001','20000000001','Shelf A1','A classic novel by F. Scott Fitzgerald.','Standard Literature',8,'Available'),(2,'The Great Gatsby','10000000001','20000000002','Shelf A1','A classic novel by F. Scott Fitzgerald.','Standard Literature',8,'Available'),(3,'The Great Gatsby','10000000001','20000000003','Shelf A1','A classic novel by F. Scott Fitzgerald.','Standard Literature',8,'Available'),(4,'The Great Gatsby','10000000001','20000000004','Shelf A1','A classic novel by F. Scott Fitzgerald.','Standard Literature',8,'Available'),(5,'The Great Gatsby','10000000001','20000000005','Shelf A1','A classic novel by F. Scott Fitzgerald.','Reference Literature',0,'Available'),(6,'Introduction to Algorithms','10000000002','30000000001','Shelf B2','A textbook for algorithms and data structures.','Course Literature',4,'Available'),(7,'Introduction to Algorithms','10000000002','30000000002','Shelf B2','A textbook for algorithms and data structures.','Course Literature',4,'Available'),(8,'Introduction to Algorithms','10000000002','30000000003','Shelf B2','A textbook for algorithms and data structures.','Course Literature',4,'Available'),(9,'Introduction to Algorithms','10000000002','30000000004','Shelf B2','A textbook for algorithms and data structures.','Course Literature',4,'Available'),(10,'Introduction to Algorithms','10000000002','30000000005','Shelf B2','A textbook for algorithms and data structures.','Reference Literature',0,'Available'),(11,'The Oxford English Dictionary','10000000003','40000000001','Shelf C3','The comprehensive English language dictionary.','Standard Literature',8,'Available'),(12,'The Oxford English Dictionary','10000000003','40000000002','Shelf C3','The comprehensive English language dictionary.','Standard Literature',8,'Available'),(13,'The Oxford English Dictionary','10000000003','40000000003','Shelf C3','The comprehensive English language dictionary.','Reference Literature',0,'Available'),(14,'The Lord of the Rings: The Fellowship of the Ring','10000000004','50000000001','Shelf D4','The first book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(15,'The Lord of the Rings: The Fellowship of the Ring','10000000004','50000000002','Shelf D4','The first book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(16,'The Lord of the Rings: The Fellowship of the Ring','10000000004','50000000003','Shelf D4','The first book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(17,'The Lord of the Rings: The Fellowship of the Ring','10000000004','50000000004','Shelf D4','The first book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(18,'The Lord of the Rings: The Fellowship of the Ring','10000000004','50000000005','Shelf D4','The first book in J.R.R. Tolkien\'s epic trilogy.','Reference Literature',0,'Available'),(19,'The Lord of the Rings: The Two Towers','10000000005','50000000006','Shelf D5','The second book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(20,'The Lord of the Rings: The Two Towers','10000000005','50000000007','Shelf D5','The second book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(21,'The Lord of the Rings: The Two Towers','10000000005','50000000008','Shelf D5','The second book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(22,'The Lord of the Rings: The Two Towers','10000000005','50000000009','Shelf D5','The second book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(23,'The Lord of the Rings: The Two Towers','10000000005','50000000010','Shelf D5','The second book in J.R.R. Tolkien\'s epic trilogy.','Reference Literature',0,'Available'),(24,'The Lord of the Rings: The Return of the King','10000000006','50000000011','Shelf D6','The third book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(25,'The Lord of the Rings: The Return of the King','10000000006','50000000012','Shelf D6','The third book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(26,'The Lord of the Rings: The Return of the King','10000000006','50000000013','Shelf D6','The third book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(27,'The Lord of the Rings: The Return of the King','10000000006','50000000014','Shelf D6','The third book in J.R.R. Tolkien\'s epic trilogy.','Standard Literature',8,'Available'),(28,'The Lord of the Rings: The Return of the King','10000000006','50000000015','Shelf D6','The third book in J.R.R. Tolkien\'s epic trilogy.','Reference Literature',0,'Available'),(29,'The Matrix','10000000007','60000000001','Shelf E5','A science fiction film released in 1999.','DVD',2,'Available'),(30,'The Matrix','10000000007','60000000002','Shelf E5','A science fiction film released in 1999.','DVD',2,'Available'),(31,'The Matrix','10000000007','60000000003','Shelf E5','A science fiction film released in 1999.','DVD',2,'Available'),(32,'Avatar Nio','124123423','23423412312','avatar planeten','många gröna dudes','Standard Literature',8,'Available');
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;
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
