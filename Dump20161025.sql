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
-- Table structure for table `ll`
--

DROP TABLE IF EXISTS `ll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ll` (
  `id` varchar(255) NOT NULL,
  `place` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `long` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ll`
--

LOCK TABLES `ll` WRITE;
/*!40000 ALTER TABLE `ll` DISABLE KEYS */;
INSERT INTO `ll` VALUES ('ID_00000','Clementi Woods Park',103.7063048,1.336294351),('ID_00001','Tiong Bahru Park',103.7063048,1.336294351),('ID_00002','Hougang Ave 3 Park Connector',103.7068208,1.33699146),('ID_00002','Hougang Ave 3 Park Connector',103.7068208,1.33699146),('ID_00003','Hougang Ave 3 Park Connector',103.7070351,1.334738115),('ID_00006','Pasir Ris Park Connector',103.7070351,1.334738115),('ID_00006','Pasir Ris Park Connector',103.7071931,1.334531321),('ID_00006','Pasir Ris Park Connector',103.7071931,1.334531321),('ID_00007','Pedestrian Overhead Bridge',103.7072425,1.336421935),('ID_00008','West Coast Park Connector',103.7072425,1.336421935),('ID_00008','West Coast Park Connector',103.7073129,1.336380203),('ID_00008','West Coast Park Connector',103.7073129,1.336380203),('ID_00008','West Coast Park Connector',103.7165388,1.33943427),('ID_00009','West Coast Park Connector',103.7165388,1.33943427),('ID_00009','West Coast Park Connector',103.7212881,1.342496511),('ID_00010','Geylang Park Connector',103.7212881,1.342496511),('ID_00011','Geylang Park Connector',103.727803,1.344119923),('ID_00011','Geylang Park Connector',103.727803,1.344119923),('ID_00012','Ulu Pandan Park Connector',103.7298755,1.343256503),('ID_00013','Ulu Pandan Park Connector',103.7298755,1.343256503),('ID_00013','Ulu Pandan Park Connector',103.7448104,1.342626345),('ID_00014','Kallang Park Connector',103.7448104,1.342626345),('ID_00015','Geylang Park Connector',103.7449094,1.392148767),('ID_00015','Geylang Park Connector',103.7449094,1.392148767),('ID_00017','Ang Mo Kio Town Garden West',103.7449094,1.392148767),('ID_00017','Ang Mo Kio Town Garden West',103.7449094,1.392148767),('ID_00017','Ang Mo Kio Town Garden West',103.7449094,1.392148767),('ID_00018','West Coast Park',103.7449094,1.392148767),('ID_00019','West Coast Park',103.7460307,1.388754349),('ID_00020','West Coast Park',103.7460307,1.388754349),('ID_00021','West Coast Park',103.7460307,1.388754349),('ID_00021','West Coast Park',103.7460307,1.388754349),('ID_00022','West Coast Park',103.7460307,1.388754349),('ID_00022','West Coast Park',103.7460307,1.388754349),('ID_00023','Hillview Park Connector',103.7461127,1.344472462),('ID_00024','Dairy Farm Nature Park',103.7461127,1.344472462),('ID_00024','Dairy Farm Nature Park',103.7464873,1.384902404),('ID_00025','Jurong Park Connector',103.7464873,1.384902404),('ID_00025','Jurong Park Connector',103.7484267,1.340788519),('ID_00026','Bukit Batok Park Connector',103.7484267,1.340788519),('ID_00026','Bukit Batok Park Connector',103.7484386,1.340754247),('ID_00026','Bukit Batok Park Connector',103.7484386,1.340754247),('ID_00027','Choa Chu Kang Park Connector',103.7490193,1.356609256),('ID_00027','Choa Chu Kang Park Connector',103.7490193,1.356609256),('ID_00027','Choa Chu Kang Park Connector',103.7490193,1.356609256),('ID_00028','Jurong Park Connector',103.7490193,1.356609256),('ID_00029','Jurong Park Connector',103.7490193,1.356609256),('ID_00030','Simpang Kiri Park Connector',103.7490193,1.356609256),('ID_00030','Simpang Kiri Park Connector',103.7494305,1.31780562),('ID_00031','Bukit Batok East Park Connector',103.7494305,1.31780562),('ID_00033','Marsiling Park Connector',103.7494305,1.31780562),('ID_00033','Marsiling Park Connector',103.7494305,1.31780562),('ID_00034','Jalan Pelikat Park Connector',103.7494305,1.31780562),('ID_00037','Henderson Park Connector',103.7494305,1.31780562),('ID_00038','Ulu Pandan Park Connector',103.75115,1.320935108),('ID_00038','Ulu Pandan Park Connector',103.75115,1.320935108),('ID_00038','Ulu Pandan Park Connector',103.7513415,1.322519243),('ID_00040','Ang Mo Kio Town Garden West',103.7513415,1.322519243),('ID_00041','Ang Mo Kio Avenue 5 Park Connector',103.7514364,1.32244814),('ID_00041','Ang Mo Kio Avenue 5 Park Connector',103.7514364,1.32244814),('ID_00044','Kallang Park Connector',103.7514831,1.32156442),('ID_00044','Kallang Park Connector',103.7514831,1.32156442),('ID_00045','Ulu Pandan Park Connector',103.7514831,1.32156442),('ID_00045','Ulu Pandan Park Connector',103.7514831,1.32156442),('ID_00046','Ulu Pandan Park Connector',103.7515048,1.32248061),('ID_00046','Ulu Pandan Park Connector',103.7515048,1.32248061),('ID_00047','Bedok Park Connector',103.7515812,1.35815612),('ID_00047','Bedok Park Connector',103.7515812,1.35815612),('ID_00047','Bedok Park Connector',103.7515968,1.323198227),('ID_00049','Bishan-Ang Mo Kio Park',103.7515968,1.323198227),('ID_00052','Khatib Bongsu Park Connector',103.7525453,1.393520563),('ID_00052','Khatib Bongsu Park Connector',103.7525453,1.393520563),('ID_00052','Khatib Bongsu Park Connector',103.7597105,1.35163894),('ID_00052','Khatib Bongsu Park Connector',103.7597105,1.35163894),('ID_00052','Khatib Bongsu Park Connector',103.7601344,1.351724665),('ID_00053','Woodlands Waterfront Park',103.7601344,1.351724665),('ID_00055','Khatib Bongsu Park Connector',103.7609815,1.347876654),('ID_00056','Khatib Bongsu Park Connector',103.7609815,1.347876654),('ID_00058','Sun Plaza Park',103.7625263,1.301233508),('ID_00058','Sun Plaza Park',103.7625263,1.301233508),('ID_00059','Serangoon Park Connector',103.7625263,1.301233508),('ID_00060','Woodlands Park Connector',103.7625263,1.301233508),('ID_00061','Pedestrian Overhead Bridge',103.7625263,1.301233508),('ID_00061','Pedestrian Overhead Bridge',103.7625263,1.301233508),('ID_00062','Pedestrian Overhead Bridge',103.7630088,1.297110754),('ID_00063','Sims Ave Park Connector',103.7630088,1.297110754),('ID_00064','Punggol Promenade Punggol Point Walk',103.7630236,1.297167387),('ID_00065','Sembawang Park Connector',103.7630236,1.297167387),('ID_00066','Canberra Park Connector',103.7630891,1.297119225),('ID_00066','Canberra Park Connector',103.7630891,1.297119225),('ID_00067','Simpang Kiri Park Connector',103.7633828,1.29907154),('ID_00068','Coastal Park Connector',103.7633828,1.29907154),('ID_00069','Bukit Timah Park Connector',103.7657884,1.34739395),('ID_00070','Bukit Batok Nature Park',103.7657884,1.34739395),('ID_00070','Bukit Batok Nature Park',103.7658758,1.301916494),('ID_00071','West Coast Park',103.7658758,1.301916494),('ID_00072','Ulu Pandan Park Connector',103.766834,1.380708751),('ID_00072','Ulu Pandan Park Connector',103.766834,1.380708751),('ID_00073','Kallang Park Connector',103.7677736,1.36296097),('ID_00074','Geylang Park Connector',103.7677736,1.36296097),('ID_00075','Whampoa Park Connector',103.7699164,1.289811969),('ID_00076','Kallang Park Connector',103.7699164,1.289811969),('ID_00076','Kallang Park Connector',103.7710003,1.437589735),('ID_00077','Whampoa Park Connector',103.7710003,1.437589735),('ID_00077','Whampoa Park Connector',103.7715374,1.437100085),('ID_00078','Geylang Park Connector',103.7715374,1.437100085),('ID_00080','Bishan-Ang Mo Kio Park',103.7762819,1.375090089),('ID_00080','Bishan-Ang Mo Kio Park',103.7762819,1.375090089),('ID_00081','Choa Chu Kang North Park Connector',103.7784295,1.36518489),('ID_00081','Choa Chu Kang North Park Connector',103.7784295,1.36518489),('ID_00082','Choa Chu Kang North Park Connector',103.7784598,1.410635404),('ID_00082','Choa Chu Kang North Park Connector',103.7784598,1.410635404),('ID_00082','Choa Chu Kang North Park Connector',103.7788885,1.451732049),('ID_00082','Choa Chu Kang North Park Connector',103.7788885,1.451732049),('ID_00084','Woodlands Park Connector',103.7821969,1.434534389),('ID_00085','Woodlands Park Connector',103.7821969,1.434534389),('ID_00085','Woodlands Park Connector',103.7881286,1.43456462),('ID_00085','Woodlands Park Connector',103.7881286,1.43456462),('ID_00086','Loyang Park Connector',103.7881286,1.43456462),('ID_00086','Loyang Park Connector',103.7881286,1.43456462),('ID_00087','Geylang Park Connector',103.7881286,1.43456462),('ID_00088','Geylang Park Connector',103.7881286,1.43456462),('ID_00089','West Coast Park Connector',103.7884144,1.412267303),('ID_00089','West Coast Park Connector',103.7884144,1.412267303),('ID_00089','West Coast Park Connector',103.7888132,1.43798976),('ID_00090','Bishan-Ang Mo Kio Park',103.7888132,1.43798976),('ID_00091','Pandan Gardens Park Connector',103.7952419,1.423321077),('ID_00091','Pandan Gardens Park Connector',103.7952419,1.423321077),('ID_00091','Pandan Gardens Park Connector',103.7957922,1.439129294),('ID_00092','Zhenghua Park',103.7957922,1.439129294),('ID_00093','Zhenghua Park',103.8122127,1.447396783),('ID_00094','Ulu Pandan Park Connector',103.8122127,1.447396783),('ID_00094','Ulu Pandan Park Connector',103.812888,1.447520902),('ID_00095','Pang Sua Park Connector',103.812888,1.447520902),('ID_00095','Pang Sua Park Connector',103.812888,1.447520902),('ID_00096','West Coast Park',103.812888,1.447520902),('ID_00097','Serangoon Park Connector',103.8129352,1.447826081),('ID_00097','Serangoon Park Connector',103.8129352,1.447826081),('ID_00098','Serangoon Park Connector',103.8226882,1.288492264),('ID_00099','Siglap Park Connector',103.8226882,1.288492264),('ID_00099','Siglap Park Connector',103.8262652,1.448052155),('ID_00100','Siglap Park Connector',103.8262652,1.448052155),('ID_00100','Siglap Park Connector',103.8262652,1.448052155),('ID_00101','Mandai Park Connector',103.8262652,1.448052155),('ID_00101','Mandai Park Connector',103.8262652,1.448052155),('ID_00102','Khatib Bongsu Park Connector',103.8262652,1.448052155),('ID_00102','Khatib Bongsu Park Connector',103.8295889,1.410242393),('ID_00102','Khatib Bongsu Park Connector',103.8295889,1.410242393),('ID_00103','Woodlands Park Connector',103.829839,1.40982079),('ID_00103','Woodlands Park Connector',103.829839,1.40982079),('ID_00105','Jurong Park Connector',103.830198,1.409415091),('ID_00105','Jurong Park Connector',103.830198,1.409415091),('ID_00106','Bedok Park Connector',103.8305432,1.40943338),('ID_00107','Bedok Park Connector',103.8305432,1.40943338),('ID_00107','Bedok Park Connector',103.830803,1.441448088),('ID_00107','Bedok Park Connector',103.830803,1.441448088),('ID_00108','Tampines Park Connector',103.8319564,1.453527918),('ID_00109','Sembawang Park Connector',103.8319564,1.453527918),('ID_00109','Sembawang Park Connector',103.8320087,1.409725368),('ID_00110','Woodlands Park Connector',103.8320087,1.409725368),('ID_00110','Woodlands Park Connector',103.833189,1.451725751),('ID_00111','Tampines Park Connector',103.833189,1.451725751),('ID_00113','Siglap Park Connector',103.8339377,1.411018553),('ID_00113','Siglap Park Connector',103.8339377,1.411018553),('ID_00114','Siglap Park Connector',103.8348788,1.422813174),('ID_00114','Siglap Park Connector',103.8348788,1.422813174),('ID_00115','Punggol Park Connector',103.8348788,1.422813174),('ID_00116','Central Catchment Park Connector',103.8348788,1.422813174),('ID_00118','Bukit Batok East Park Connector',103.8348788,1.422813174),('ID_00118','Bukit Batok East Park Connector',103.8348788,1.422813174),('ID_00119','Punggol Waterway',103.8364461,1.459203245),('ID_00120','Punggol Waterway',103.8364461,1.459203245),('ID_00120','Punggol Waterway',103.8369409,1.46245616),('ID_00120','Punggol Waterway',103.8369409,1.46245616),('ID_00121','Tampines Park Connector',103.8369409,1.46245616),('ID_00122','Choa Chu Kang North Park Connector',103.8369409,1.46245616),('ID_00122','Choa Chu Kang North Park Connector',103.8405813,1.425777139),('ID_00123','Hillview Park Connector',103.8405813,1.425777139),('ID_00123','Hillview Park Connector',103.8435502,1.375877409),('ID_00124','Ulu Sembawang Park Connector',103.8435502,1.375877409),('ID_00124','Ulu Sembawang Park Connector',103.843635,1.363563735),('ID_00125','Jurong Park Connector',103.843635,1.363563735),('ID_00127','Punggol Waterway',103.8436895,1.431310048),('ID_00127','Punggol Waterway',103.8436895,1.431310048),('ID_00127','Punggol Waterway',103.8436911,1.431076989),('ID_00127','Punggol Waterway',103.8436911,1.431076989),('ID_00127','Punggol Waterway',103.84441,1.375810564),('ID_00128','Punggol Waterway',103.84441,1.375810564),('ID_00128','Punggol Waterway',103.8462468,1.360948136),('ID_00128','Punggol Waterway',103.8462468,1.360948136),('ID_00128','Punggol Waterway',103.8550153,1.351443254),('ID_00129','Punggol Waterway',103.8550153,1.351443254),('ID_00130','Punggol Waterway',103.8581802,1.343486077),('ID_00131','Punggol Waterway',103.8581802,1.343486077),('ID_00131','Punggol Waterway',103.858291,1.324331),('ID_00132','Woodlands Park Connector',103.858291,1.324331),('ID_00133','Kallang Park Connector',103.858317,1.343539),('ID_00133','Kallang Park Connector',103.858317,1.343539),('ID_00134','Pelton Canal Park Connector',103.858647,1.32383),('ID_00134','Pelton Canal Park Connector',103.858647,1.32383),('ID_00134','Pelton Canal Park Connector',103.8659422,1.329365051),('ID_00137','Whampoa Park Connector',103.8659422,1.329365051),('ID_00138','Kallang Park Connector',103.866074,1.328654),('ID_00139','Kallang Park Connector',103.866074,1.328654),('ID_00139','Kallang Park Connector',103.866563,1.32569),('ID_00139','Kallang Park Connector',103.866563,1.32569),('ID_00139','Kallang Park Connector',103.8667034,1.326224358),('ID_00140','West Coast Park Connector',103.8667034,1.326224358),('ID_00140','West Coast Park Connector',103.8667258,1.326252217),('ID_00140','West Coast Park Connector',103.8667258,1.326252217),('ID_00141','Kallang Park Connector',103.866788,1.326309),('ID_00142','Paya Lebar Park Connector',103.866788,1.326309),('ID_00143','Punggol Waterway',103.8671587,1.320914624),('ID_00143','Punggol Waterway',103.8671587,1.320914624),('ID_00143','Punggol Waterway',103.8675892,1.324029381),('ID_00143','Punggol Waterway',103.8675892,1.324029381),('ID_00145','Tampines Park Connector',103.8676757,1.320916188),('ID_00145','Tampines Park Connector',103.8676757,1.320916188),('ID_00146','Simei Park Connector',103.8703285,1.31567952),('ID_00146','Simei Park Connector',103.8703285,1.31567952),('ID_00147','Bedok Park Connector',103.8763973,1.379153102),('ID_00147','Bedok Park Connector',103.8763973,1.379153102),('ID_00149','Bedok Town Park',103.8763973,1.379153102),('ID_00151','Tampines Park Connector',103.8763973,1.379153102),('ID_00151','Tampines Park Connector',103.8763973,1.379153102),('ID_00153','Jurong Park Connector',103.8763973,1.379153102),('ID_00153','Jurong Park Connector',103.8813826,1.322071069),('ID_00153','Jurong Park Connector',103.8813826,1.322071069),('ID_00154','Pasir Ris Town Park',103.8813891,1.322085011),('ID_00155','Pasir Ris Park',103.8813891,1.322085011),('ID_00155','Pasir Ris Park',103.8834095,1.396291238),('ID_00156','Pasir Ris Park',103.8834095,1.396291238),('ID_00156','Pasir Ris Park',103.8837023,1.30487652),('ID_00157','Punggol Park',103.8837023,1.30487652),('ID_00158','Punggol Park',103.8840077,1.397246102),('ID_00158','Punggol Park',103.8840077,1.397246102),('ID_00159','Punggol Park',103.8848313,1.305262206),('ID_00160','Punggol Waterway',103.8848313,1.305262206),('ID_00160','Punggol Waterway',103.8850979,1.398299071),('ID_00161','Tampines-Loyang Park Connector',103.8850979,1.398299071),('ID_00161','Tampines-Loyang Park Connector',103.8853306,1.305225711),('ID_00163','Punggol Park Connector',103.8853306,1.305225711),('ID_00164','Jurong Central Park',103.8854282,1.305400728),('ID_00165','Jurong Central Park',103.8854282,1.305400728),('ID_00166','Jurong Central Park',103.8858481,1.39608989),('ID_00166','Jurong Central Park',103.8858481,1.39608989),('ID_00167','Jurong Central Park',103.8875548,1.400555172),('ID_00167','Jurong Central Park',103.8875548,1.400555172),('ID_00168','Pasir Ris Park',103.8893024,1.33396584),('ID_00169','Pasir Ris Park',103.8893024,1.33396584),('ID_00169','Pasir Ris Park',103.889443,1.309090059),('ID_00170','Changi Beach Park',103.889443,1.309090059),('ID_00171','Siglap Park Connector',103.8918184,1.355558389),('ID_00172','Sengkang Riverside Park',103.8918184,1.355558389),('ID_00172','Sengkang Riverside Park',103.8951344,1.409070327),('ID_00173','Sengkang Riverside Park',103.8951344,1.409070327),('ID_00173','Sengkang Riverside Park',103.8954943,1.361967498),('ID_00175','Jurong Park Connector',103.8954943,1.361967498),('ID_00176','Jurong Park Connector',103.8958985,1.409364588),('ID_00176','Jurong Park Connector',103.8958985,1.409364588),('ID_00178','Canberra Park Connector',103.8960192,1.409710489),('ID_00178','Canberra Park Connector',103.8960192,1.409710489),('ID_00178','Canberra Park Connector',103.896048,1.410202908),('ID_00179','Ulu Pandan Park Connector',103.896048,1.410202908),('ID_00179','Ulu Pandan Park Connector',103.8966339,1.409357528),('ID_00180','Jurong Park Connector',103.8966339,1.409357528),('ID_00181','Jurong Park Connector',103.8966363,1.409612527),('ID_00181','Jurong Park Connector',103.8966363,1.409612527),('ID_00182','Bukit Batok West Park Connector',103.8966363,1.409612527),('ID_00182','Bukit Batok West Park Connector',103.8966363,1.409612527),('ID_00183','Bukit Batok West Park Connector',103.8966363,1.409612527),('ID_00183','Bukit Batok West Park Connector',103.8966363,1.409612527),('ID_00183','Bukit Batok West Park Connector',103.8968518,1.378364978),('ID_00184','Yishun Park Connector',103.8968518,1.378364978),('ID_00184','Yishun Park Connector',103.8969043,1.378309625),('ID_00185','Canberra-Sembawang Park Connector',103.8969043,1.378309625),('ID_00185','Canberra-Sembawang Park Connector',103.897117,1.378119082),('ID_00185','Canberra-Sembawang Park Connector',103.897117,1.378119082),('ID_00186','Punggol Promenade Nature Walk',103.9003392,1.379208735),('ID_00187','Punggol Promenade Nature Walk',103.9003392,1.379208735),('ID_00188','Punggol Promenade Nature Walk',103.9029308,1.412010949),('ID_00189','Bedok Park Connector',103.9029308,1.412010949),('ID_00189','Bedok Park Connector',103.9041179,1.379814881),('ID_00190','Bedok Park Connector',103.9041179,1.379814881),('ID_00191','Sengkang Riverside Park',103.910616,1.328441),('ID_00192','Sun Plaza Park',103.910616,1.328441),('ID_00193','Jurong Central Park',103.9128543,1.320624138),('ID_00193','Jurong Central Park',103.9128543,1.320624138),('ID_00194','Punggol Promenade Nature Walk',103.9136723,1.403802374),('ID_00194','Punggol Promenade Nature Walk',103.9136723,1.403802374),('ID_00195','Punggol Waterway',103.9138047,1.403702288),('ID_00195','Punggol Waterway',103.9138047,1.403702288),('ID_00196','Punggol Park Connector',103.9140195,1.416152192),('ID_00196','Punggol Park Connector',103.9140195,1.416152192),('ID_00197','Pedestrian Overhead Bridge',103.9170496,1.408463933),('ID_00197','Pedestrian Overhead Bridge',103.9170496,1.408463933),('ID_00198','Pedestrian Overhead Bridge',103.9171584,1.408331055),('ID_00199','Pedestrian Overhead Bridge',103.9171584,1.408331055),('ID_00200','Pedestrian Overhead Bridge',103.918385,1.400471245),('ID_00200','Pedestrian Overhead Bridge',103.918385,1.400471245),('ID_00201','Pedestrian Overhead Bridge',103.918602,1.333706),('ID_00202','Pedestrian Overhead Bridge',103.918602,1.333706),('ID_00202','Pedestrian Overhead Bridge',103.9186753,1.30394938),('ID_00202','Pedestrian Overhead Bridge',103.9186753,1.30394938),('ID_00203','Pedestrian Overhead Bridge',103.921354,1.404569297),('ID_00203','Pedestrian Overhead Bridge',103.921354,1.404569297),('ID_00204','Pedestrian Overhead Bridge',103.9213816,1.397807064),('ID_00204','Pedestrian Overhead Bridge',103.9213816,1.397807064),('ID_00204','Pedestrian Overhead Bridge',103.9215838,1.398026432),('ID_00205','Pedestrian Overhead Bridge',103.9215838,1.398026432),('ID_00205','Pedestrian Overhead Bridge',103.9223679,1.39772356),('ID_00206','Pedestrian Overhead Bridge',103.9223679,1.39772356),('ID_00207','Pedestrian Overhead Bridge',103.9251473,1.338323179),('ID_00207','Pedestrian Overhead Bridge',103.9251473,1.338323179),('ID_00209','Pedestrian Overhead Bridge',103.9251706,1.33528589),('ID_00209','Pedestrian Overhead Bridge',103.9251706,1.33528589),('ID_00210','Pedestrian Overhead Bridge',103.9330648,1.338094485),('ID_00210','Pedestrian Overhead Bridge',103.9330648,1.338094485),('ID_00210','Pedestrian Overhead Bridge',103.93313,1.336459),('ID_00211','Pedestrian Overhead Bridge',103.93313,1.336459),('ID_00211','Pedestrian Overhead Bridge',103.93345,1.336543),('ID_00212','Punggol Park Connector',103.93345,1.336543),('ID_00212','Punggol Park Connector',103.9356231,1.339727139),('ID_00213','Simpang Kiri Park Connector',103.9356231,1.339727139),('ID_00214','Jurong West Park Connector',103.9358155,1.339511733),('ID_00215','Yishun Park',103.9358155,1.339511733),('ID_00216','Lower Seletar Reservoir Park',103.9363316,1.340572243),('ID_00216','Lower Seletar Reservoir Park',103.9363316,1.340572243),('ID_00217','Lower Seletar Reservoir Park',103.9377756,1.337021802),('ID_00219','Lower Seletar Reservoir Park',103.9377756,1.337021802),('ID_00219','Lower Seletar Reservoir Park',103.9394823,1.388347113),('ID_00220','Lower Seletar Reservoir Park',103.9394823,1.388347113),('ID_00220','Lower Seletar Reservoir Park',103.940654,1.336531),('ID_00221','Lower Seletar Reservoir Park',103.940654,1.336531),('ID_00221','Lower Seletar Reservoir Park',103.940654,1.336531),('ID_00222','Lower Seletar Reservoir Park',103.940654,1.336531),('ID_00223','Lower Seletar Reservoir Park',103.940899,1.336214),('ID_00225','Punggol Park',103.940899,1.336214),('ID_00225','Punggol Park',103.940909,1.336223),('ID_00226','Pasir Ris Park',103.940909,1.336223),('ID_00227','Pasir Ris Park',103.940909,1.336223),('ID_00228','Pasir Ris Park',103.940909,1.336223),('ID_00229','Pasir Ris Park',103.940909,1.336223),('ID_00231','Yishun Park Connector',103.940909,1.336223),('ID_00231','Yishun Park Connector',103.9442849,1.359707649),('ID_00231','Yishun Park Connector',103.9442849,1.359707649),('ID_00232','Sembawang Park Connector',103.9443413,1.3603855),('ID_00233','Buangkok Park Connector',103.9443413,1.3603855),('ID_00233','Buangkok Park Connector',103.9443995,1.384804781),('ID_00234','Punggol Waterway',103.9443995,1.384804781),('ID_00234','Punggol Waterway',103.9484759,1.349237709),('ID_00235','Kallang Park Connector',103.9484759,1.349237709),('ID_00236','Bedok Park Connector',103.9488505,1.382237191),('ID_00236','Bedok Park Connector',103.9488505,1.382237191),('ID_00237','East Coast Park',103.9497446,1.381890163),('ID_00238','Punggol Waterway',103.9497446,1.381890163),('ID_00239','Pang Sua Park Connector',103.9517471,1.32981128),('ID_00240','Pang Sua Park Connector',103.9517471,1.32981128),('ID_00241','Bukit Panjang Park Connector',103.9517471,1.32981128),('ID_00242','Sungei Serangoon Park Connector',103.9517471,1.32981128),('ID_00244','Punggol Waterway',103.9517471,1.32981128),('ID_00245','Pasir Ris Park',103.9517471,1.32981128),('ID_00245','Pasir Ris Park',103.9525391,1.374909379),('ID_00246','Pasir Ris Park',103.9525391,1.374909379),('ID_00247','Sembawang Park Connector',103.9531904,1.38070571),('ID_00248','Admiralty West Park Connector',103.9531904,1.38070571),('ID_00249','Admiralty West Park Connector',103.9535083,1.370446606),('ID_00251','Woodlands Town Garden',103.9535083,1.370446606),('ID_00252','Punggol Waterway Park',103.9537132,1.370610681),('ID_00253','Sembawang Park',103.9537132,1.370610681),('ID_00254','Sembawang Park',103.95378,1.365187),('ID_00254','Sembawang Park',103.95378,1.365187),('ID_00254','Sembawang Park',103.954371,1.365618),('ID_00254','Sembawang Park',103.954371,1.365618),('ID_00254','Sembawang Park',103.9544086,1.38048622),('ID_00255','Tampines Park Connector',103.9544086,1.38048622),('ID_00255','Tampines Park Connector',103.9558252,1.380799453),('ID_00256','Pasir Ris Town Park',103.9558252,1.380799453),('ID_00256','Pasir Ris Town Park',103.9591564,1.314568809),('ID_00257','Sengkang Riverside Park',103.9591564,1.314568809),('ID_00257','Sengkang Riverside Park',103.9598346,1.380637835),('ID_00257','Sengkang Riverside Park',103.9598346,1.380637835),('ID_00258','Pasir Ris Park',103.9666234,1.366047889),('ID_00258','Pasir Ris Park',103.9666234,1.366047889),('ID_00259','Choa Chu Kang Park',103.9666234,1.366047889),('ID_00259','Choa Chu Kang Park',103.9666234,1.366047889),('ID_00259','Choa Chu Kang Park',103.9666234,1.366047889),('ID_00260','Woodlands Park Connector',103.9666234,1.366047889),('ID_00260','Woodlands Park Connector',104.004768,1.373043055),('ID_00260','Woodlands Park Connector',104.004768,1.373043055);
/*!40000 ALTER TABLE `ll` ENABLE KEYS */;
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
INSERT INTO `settings` VALUES ('user 1',1,1,1,1,1),('user 2',0,1,1,0,1),('user 3',1,1,1,0,1),('user 4',1,0,0,0,1),('user 5',1,1,1,1,1),('user 6',1,0,1,1,1),('user 7',1,1,0,1,1),('user 8',0,0,0,0,0);
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

-- Dump completed on 2016-11-01  8:55:53
