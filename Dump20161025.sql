-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: 3003_db
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bombshelterinfo`
--

DROP TABLE IF EXISTS `bombshelterinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bombshelterinfo` (
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bombshelterinfo`
--

LOCK TABLES `bombshelterinfo` WRITE;
/*!40000 ALTER TABLE `bombshelterinfo` DISABLE KEYS */;
INSERT INTO `bombshelterinfo` VALUES ('Boon Keng Mrt Station'),('Buangkok Mrt Station'),('Chinatown Mrt Station'),('City Hall Mrt Station'),('Clarke Quay Mrt Station'),('Farrer Park Mrt Station'),('Harbourfront Mrt Station'),('Hougang Mrt Station'),('Kovan Mrt Station'),('Little India Mrt Station'),('Marina Bay Mrt Station'),('Newton Mrt Station'),('Outram Park Mrt Station'),('Potong Pasir Mrt Station'),('Raffles Place Mrt Station'),('Serangoon Mrt Station'),('Somerset Mrt Station'),('Woodleigh Mrt Station');
/*!40000 ALTER TABLE `bombshelterinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergencyservices`
--

DROP TABLE IF EXISTS `emergencyservices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emergencyservices` (
  `name` varchar(255) NOT NULL,
  `contactNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emergencyservices`
--

LOCK TABLES `emergencyservices` WRITE;
/*!40000 ALTER TABLE `emergencyservices` DISABLE KEYS */;
INSERT INTO `emergencyservices` VALUES ('Emergency ambulance',995),('Fire service',995),('Police',999);
/*!40000 ALTER TABLE `emergencyservices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fireincident`
--

DROP TABLE IF EXISTS `fireincident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fireincident` (
  `incidentID` int(11) NOT NULL,
  `numberOfCasualties` int(11) DEFAULT NULL,
  `firefightingTime` int(11) DEFAULT NULL,
  PRIMARY KEY (`incidentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fireincident`
--

LOCK TABLES `fireincident` WRITE;
/*!40000 ALTER TABLE `fireincident` DISABLE KEYS */;
INSERT INTO `fireincident` VALUES (1,0,1),(2,1,2),(3,0,2),(4,5,4),(11,0,1),(12,2,1);
/*!40000 ALTER TABLE `fireincident` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hazeinfo`
--

DROP TABLE IF EXISTS `hazeinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hazeinfo` (
  `incidentID` int(11) NOT NULL,
  `centralPsi` int(11) DEFAULT NULL,
  `northPsi` int(11) DEFAULT NULL,
  `southPsi` int(11) DEFAULT NULL,
  `eastPsi` int(11) DEFAULT NULL,
  `westPsi` int(11) DEFAULT NULL,
  PRIMARY KEY (`incidentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hazeinfo`
--

LOCK TABLES `hazeinfo` WRITE;
/*!40000 ALTER TABLE `hazeinfo` DISABLE KEYS */;
INSERT INTO `hazeinfo` VALUES (5,50,100,30,30,20),(6,100,200,20,10,50),(7,45,50,60,70,80),(8,45,50,60,70,80),(9,45,50,60,70,80),(10,100,202,60,70,80);
/*!40000 ALTER TABLE `hazeinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incident`
--

DROP TABLE IF EXISTS `incident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incident` (
  `incidentID` int(11) NOT NULL AUTO_INCREMENT,
  `reporterName` varchar(255) DEFAULT NULL,
  `reporterPhoneNumber` int(11) DEFAULT NULL,
  `typeOfIncident` varchar(45) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `typeOfAssistance` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `creationTimestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `isClosed` tinyint(1) DEFAULT NULL,
  `closureTimestamp` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `closureRemarks` varchar(255) DEFAULT NULL,
  `operatorUsername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`incidentID`),
  KEY `operatorName_idx` (`operatorUsername`),
  CONSTRAINT `operatorName` FOREIGN KEY (`operatorUsername`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incident`
--

LOCK TABLES `incident` WRITE;
/*!40000 ALTER TABLE `incident` DISABLE KEYS */;
INSERT INTO `incident` VALUES (1,'rname 1',12345,'fire','730467','fire service','desc','2016-10-25 08:07:44',1,'2016-10-25 07:55:39','Closed ','operator 2'),(2,'rname 2',12345,'fire','730333','fire service','desc','2016-10-25 08:07:44',1,'2016-10-25 07:56:08','Closed ','operator 3'),(3,'rname 3',12345,'fire','730500','fire service','desc','2016-10-25 08:07:44',1,'2016-10-25 07:56:33','Closed','operator 3'),(4,'rname 3',12345,'fire','730678','fire service','desc','2016-10-25 07:57:26',0,'2016-10-25 07:57:26',NULL,'operator 1'),(5,'nea',12345,'haze_info','na','na','desc','2016-10-25 08:15:43',1,NULL,NULL,'operator 1'),(6,'nea',12345,'haze_info','na','na','desc','2016-10-25 08:15:43',1,NULL,NULL,'operator 1'),(7,'nea',12345,'haze_info','na','na','desc','2016-10-25 08:15:43',1,NULL,NULL,'operator 1'),(8,'nea',12345,'haze_info','na','na','desc','2016-10-25 08:15:43',1,NULL,NULL,'operator 1'),(9,'nea',12345,'haze_info','na','na','desc','2016-10-25 08:13:23',1,NULL,NULL,'operator 1'),(10,'nea',12345,'haze_info','na','na','desc','2016-10-25 08:15:25',1,NULL,NULL,'operator 1'),(11,'rname 10',12345,'fire','730112','fire service','desc','2016-10-25 08:18:30',0,NULL,NULL,'operator 1'),(12,'rname 10',12345,'fire','730600','fire service','desc','2016-10-25 08:19:00',0,NULL,NULL,'operator 4');
/*!40000 ALTER TABLE `incident` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maskinfo`
--

DROP TABLE IF EXISTS `maskinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maskinfo` (
  `location` varchar(255) NOT NULL,
  `maskType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maskinfo`
--

LOCK TABLES `maskinfo` WRITE;
/*!40000 ALTER TABLE `maskinfo` DISABLE KEYS */;
INSERT INTO `maskinfo` VALUES ('Admiralty Community Centre','N95'),('Ang Mo Kio Community Centre','N95'),('Bedok Community Centre','N95'),('Bishan East Community Centre','FFP2'),('Boon Lay Community Centre','N95'),('Braddell Heights Community Centre','FFP2'),('Bukit Timah Community Centre','N95'),('Cairnhill Community Centre','FFP2'),('Changi Simei Community Centre','N95'),('Cheng San Community Centre','N95'),('Clementi Community Centre','FFP2'),('Eunos Community Centre','N95'),('Gek Poh Community Centre','N95'),('Geylang Serai Community Centre','N95'),('Henderson Community Centre','N95'),('Hougang Community Centre','N95'),('Jalan Besar Community Centre','N95'),('Kampong Chai Chee Community Centre','N95'),('Kampong Ubi Community Centre','N95'),('Kreta Ayer Community Centre','FFP2'),('Marsiling Community Centre  [N]','N95'),('Mountbatten Community Centre','N95'),('Nee Soon (East) Community Centre','N95'),('Pasir Ris Community Centre','N95'),('Pasir Ris Elias Community Centre','N95'),('Queenstown Community Centre','N95'),('Sembawang Community Centre','N95'),('Serangoon North Community Centre','N95'),('Tampines East Community Centre','N95'),('Tampines West Community Centre','N95'),('Tanglin Community Centre','FFP2'),('Tanjong Pagar Community Centre','FFP2'),('Teck Ghee Community Centre','FFP2'),('Telok Blangah Community Centre  [W]','FFP2'),('Thomson Community Centre','N95'),('Tiong Bahru Community Centre','N95'),('Toa Payoh Community Centre','N95'),('Toa Payoh West Community Centre','N95'),('Yew Tee Community Centre','N95'),('Yio Chu Kang Community Centre','FFP2');
/*!40000 ALTER TABLE `maskinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings` (
  `username` varchar(255) NOT NULL,
  `hazeInfo` tinyint(1) DEFAULT NULL,
  `fireInfo` tinyint(1) DEFAULT NULL,
  `maskInfo` tinyint(1) DEFAULT NULL,
  `bombshelterInfo` tinyint(1) DEFAULT NULL,
  `viaSms` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` VALUES ('operator 1',1,1,1,1,1),('operator 2',1,1,1,1,1),('operator 3',1,1,1,1,1),('operator 4',1,1,1,1,1),('operator 5',1,1,1,1,1),('user 1',1,1,1,1,1),('user 2',1,1,1,1,1),('user 3',1,1,1,1,1),('user 4',1,1,1,1,1),('user 5',1,1,1,1,1),('user 6',1,1,1,1,1),('user 7',1,1,1,1,1),('user 8',1,1,1,1,1);
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('operator 1','pass','operator_name 1',12345,1),('operator 2','pass','operator_name 2',12345,1),('operator 3','pass','operator_name 3',12345,1),('operator 4','pass','operator_name 4',12345,1),('operator 5','pass','operator_name 5',12345,1),('user 1','pass','name 1',12345,0),('user 2','pass','name 2',12345,0),('user 3','pass','name 3',12345,0),('user 4','pass','name 4',12345,0),('user 5','pass','name 5',12345,0),('user 6','pass','name 6',12345,0),('user 7','pass','name 7',12345,0),('user 8','pass','name 8',12345,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-26  9:33:10
