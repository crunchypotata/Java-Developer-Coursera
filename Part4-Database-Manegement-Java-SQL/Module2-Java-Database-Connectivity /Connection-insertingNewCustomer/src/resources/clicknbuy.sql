CREATE DATABASE  IF NOT EXISTS `clicknbuy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clicknbuy`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: clicknbuy
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `reward_points` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'johndoe','johndoe@email.com','John','Doe','+11536198741',14320),(2,'janedoe','janedoe@email.com','Jane','Doe','+11536219842',12050),(3,'michael_smith','michael.smith@email.com','Michael','Smith','+11536298753',11340),(4,'emily.jones','emily.jones@email.com','Emily','Jones','+11536376482',9800),(5,'david_lee','david.lee@email.com','David','Lee','+11536492837',15430),(6,'linda.brown','linda.brown@email.com','Linda','Brown','+11536537284',10230),(7,'james.johnson','james.johnson@email.com','James','Johnson','+11536691853',17320),(8,'patricia_miller','patricia.miller@email.com','Patricia','Miller','+11536765234',15740),(9,'robert_wilson','robert.wilson@email.com','Robert','Wilson','+11536829574',13490),(10,'barbara.moore','barbara.moore@email.com','Barbara','Moore','+11536917532',16250),(11,'charles.taylor','charles.taylor@email.com','Charles','Taylor','+11536987234',11890),(12,'joseph_thomas','joseph.thomas@email.com','Joseph','Thomas','+11536076234',10760),(13,'susan_anderson','susan.anderson@email.com','Susan','Anderson','+11536096475',14560),(14,'karen.martin','karen.martin@email.com','Karen','Martin','+11536103784',13840),(15,'richard_jackson','richard.jackson@email.com','Richard','Jackson','+11536183752',15030),(16,'nancy_harris','nancy.harris@email.com','Nancy','Harris','+11536209834',17280),(17,'daniel_clark','daniel.clark@email.com','Daniel','Clark','+11536247531',13370),(18,'lisa_rodriguez','lisa.rodriguez@email.com','Lisa','Rodriguez','+11536273184',11040),(19,'steven_white','steven.white@email.com','Steven','White','+11536302837',14950),(20,'betty.martinez','betty.martinez@email.com','Betty','Martinez','+11536328475',16570),(21,'george_garcia','george.garcia@email.com','George','Garcia','+11536367341',12000);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-20 16:09:22
