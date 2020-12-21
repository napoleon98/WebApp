-- MySQL dump 10.14  Distrib 5.5.57-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: mydatabase
-- ------------------------------------------------------
-- Server version	5.5.57-MariaDB

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
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) DEFAULT NULL,
  `dept_locations_locid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  KEY `FKtrx5jqrfam6frc20v7ug9sle7` (`dept_locations_locid`),
  CONSTRAINT `FKtrx5jqrfam6frc20v7ug9sle7` FOREIGN KEY (`dept_locations_locid`) REFERENCES `dept_locations` (`locid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Economics',1),(2,'Software Development',1),(3,'Hardware Design',2),(4,'Marketing',3),(5,'Research and Development ',3);
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept_locations`
--

DROP TABLE IF EXISTS `dept_locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept_locations` (
  `locid` bigint(20) NOT NULL AUTO_INCREMENT,
  `locname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`locid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept_locations`
--

LOCK TABLES `dept_locations` WRITE;
/*!40000 ALTER TABLE `dept_locations` DISABLE KEYS */;
INSERT INTO `dept_locations` VALUES (1,'Rethymno'),(2,'Chania'),(3,'Heraklion');
/*!40000 ALTER TABLE `dept_locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `empid` bigint(20) NOT NULL AUTO_INCREMENT,
  `comm` float DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  `departnemts_dept_id` bigint(20) DEFAULT NULL,
  `manager_empid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`empid`),
  KEY `FKt2p3qfksifnnk0qoa00l4t85x` (`departnemts_dept_id`),
  KEY `FKh5pn3wtihg1m71r91vecwqx4b` (`manager_empid`),
  CONSTRAINT `FKh5pn3wtihg1m71r91vecwqx4b` FOREIGN KEY (`manager_empid`) REFERENCES `employees` (`empid`),
  CONSTRAINT `FKt2p3qfksifnnk0qoa00l4t85x` FOREIGN KEY (`departnemts_dept_id`) REFERENCES `departments` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,10000,'Napoleon','2020-12-12','Engineer','Papoutsakis',500,1,1),(2,15000,'Giorgos','2019-10-11','Developer','Pappas',600,2,1),(3,20000,'Eleni','2018-10-10','Data Analyst','Tzagkaraki',800,3,1),(4,12000,'Eleftheria','2017-10-10','Developer','Tsiamalou',900,1,1),(5,9000,'Nikos','2018-10-09','Developer','Papadopoulos',700,2,1),(6,10000,'Kostas','2019-11-11','Data Analyst','Sotiriou',800,3,1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-22  1:12:49
