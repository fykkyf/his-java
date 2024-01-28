-- MySQL dump 10.13  Distrib 8.2.0, for macos13 (x86_64)
--
-- Host: 127.0.0.1    Database: his
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administration`
--

DROP TABLE IF EXISTS `administration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administration` (
  `administration_id` int NOT NULL AUTO_INCREMENT,
  `administration_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`administration_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administration`
--

LOCK TABLES `administration` WRITE;
/*!40000 ALTER TABLE `administration` DISABLE KEYS */;
INSERT INTO `administration` VALUES (1,'PO '),(2,'IM'),(3,'IVPB'),(4,'Wound'),(5,'Radiation'),(6,'Physical Therapy'),(7,'Surgery'),(11,'Subq'),(12,'Topical');
/*!40000 ALTER TABLE `administration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic_lab`
--

DROP TABLE IF EXISTS `clinic_lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinic_lab` (
  `clinic_lab_id` int NOT NULL AUTO_INCREMENT,
  `visitor_id` int DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `lab_result` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `test_date` datetime DEFAULT NULL,
  `test_status` tinyint DEFAULT NULL,
  PRIMARY KEY (`clinic_lab_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic_lab`
--

LOCK TABLES `clinic_lab` WRITE;
/*!40000 ALTER TABLE `clinic_lab` DISABLE KEYS */;
INSERT INTO `clinic_lab` VALUES (1,1,10,NULL,NULL,1),(2,1,10,NULL,NULL,1);
/*!40000 ALTER TABLE `clinic_lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic_order`
--

DROP TABLE IF EXISTS `clinic_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinic_order` (
  `clinic_order_id` int NOT NULL AUTO_INCREMENT,
  `visitor_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `treatment_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `administration_id` int DEFAULT NULL,
  `dosage_id` int DEFAULT NULL,
  `treatment_count` int DEFAULT NULL,
  `execution_time` datetime DEFAULT NULL,
  `dispense_time` datetime DEFAULT NULL,
  PRIMARY KEY (`clinic_order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic_order`
--

LOCK TABLES `clinic_order` WRITE;
/*!40000 ALTER TABLE `clinic_order` DISABLE KEYS */;
INSERT INTO `clinic_order` VALUES (1,1,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(2,1,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(3,1,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL),(5,1,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL),(7,7,2,1,'0.9% Sodium Chloride',1,2,2,'2024-01-05 19:43:26',NULL),(8,10,2,1,'0.9% Sodium Chloride',4,9,2,'2024-01-05 20:17:41',NULL),(9,15,1,1,'0.9% Sodium Chloride',1,2,5,'2024-01-05 21:29:41',NULL),(10,17,3,1,'0.9% Sodium Chloride',1,2,5,'2024-01-05 21:36:01',NULL),(11,1,2,10,'FNID',NULL,NULL,NULL,'2024-01-09 18:35:29',NULL),(12,1,2,6,'Abdominal Color Doppler Ultrasound',NULL,NULL,NULL,'2024-01-09 18:35:49',NULL);
/*!40000 ALTER TABLE `clinic_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic_raidology`
--

DROP TABLE IF EXISTS `clinic_raidology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinic_raidology` (
  `clinic_raidology_id` int NOT NULL AUTO_INCREMENT,
  `visitor_id` int DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `test_date` datetime DEFAULT NULL,
  `test_status` tinyint DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`clinic_raidology_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic_raidology`
--

LOCK TABLES `clinic_raidology` WRITE;
/*!40000 ALTER TABLE `clinic_raidology` DISABLE KEYS */;
INSERT INTO `clinic_raidology` VALUES (1,1,12,'D:\\vscode\\code\\his\\his\\src\\assets\\images\\','2023-10-23 17:26:48',2,'1698053209242.jpg'),(2,1,6,NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `clinic_raidology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disease`
--

DROP TABLE IF EXISTS `disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disease` (
  `disease_id` int NOT NULL AUTO_INCREMENT,
  `disease_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`disease_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disease`
--

LOCK TABLES `disease` WRITE;
/*!40000 ALTER TABLE `disease` DISABLE KEYS */;
INSERT INTO `disease` VALUES (1,'Stage 3 Hypertension'),(2,'Lumbar Disc Herniation'),(3,'Dizziness Syndrome'),(4,'cholelithiasis'),(5,'Chronic Gastritis');
/*!40000 ALTER TABLE `disease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dosage`
--

DROP TABLE IF EXISTS `dosage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dosage` (
  `dosage_id` int NOT NULL AUTO_INCREMENT,
  `dosage_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`dosage_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dosage`
--

LOCK TABLES `dosage` WRITE;
/*!40000 ALTER TABLE `dosage` DISABLE KEYS */;
INSERT INTO `dosage` VALUES (2,'100ml '),(3,'50mg '),(9,'100 ml/hr'),(10,'3 gm');
/*!40000 ALTER TABLE `dosage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Jackson Lawrence'),(2,'Olivia Tate\n'),(3,'Daniel Ramsey'),(4,'Mia Foster'),(5,'Henry Cole'),(6,'Stella Morgan'),(7,'Benjamin Hayes'),(8,'Chloe Reynolds'),(9,'Lincoln Turner'),(10,'Grace Mitchell');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_menu`
--

DROP TABLE IF EXISTS `employee_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_menu` (
  `employee_menu_id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `menu_id` int DEFAULT NULL,
  PRIMARY KEY (`employee_menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_menu`
--

LOCK TABLES `employee_menu` WRITE;
/*!40000 ALTER TABLE `employee_menu` DISABLE KEYS */;
INSERT INTO `employee_menu` VALUES (27,10,1),(28,10,2),(29,10,3),(30,10,4),(31,10,5),(32,10,6),(33,10,7),(34,10,8),(35,10,9),(45,1,3),(46,1,12),(47,1,15),(48,1,29),(49,1,5),(50,1,16),(51,1,19),(52,1,21),(53,1,22),(54,1,27),(55,1,28),(56,1,6),(57,1,17),(58,1,18),(59,1,20),(60,1,7),(61,1,25),(62,1,26),(63,1,31),(64,1,32),(65,1,33),(66,1,34),(67,1,35),(68,1,36),(69,1,37),(70,1,38);
/*!40000 ALTER TABLE `employee_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_role`
--

DROP TABLE IF EXISTS `employee_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_role` (
  `employee_role_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`employee_role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_role`
--

LOCK TABLES `employee_role` WRITE;
/*!40000 ALTER TABLE `employee_role` DISABLE KEYS */;
INSERT INTO `employee_role` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,7,7),(8,8,8),(9,9,9),(10,10,2);
/*!40000 ALTER TABLE `employee_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_unit`
--

DROP TABLE IF EXISTS `employee_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_unit` (
  `employee_unit_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int DEFAULT NULL,
  `unit_id` int DEFAULT NULL,
  PRIMARY KEY (`employee_unit_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_unit`
--

LOCK TABLES `employee_unit` WRITE;
/*!40000 ALTER TABLE `employee_unit` DISABLE KEYS */;
INSERT INTO `employee_unit` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,1),(6,6,1),(7,7,1),(8,8,2),(9,9,3),(10,10,4);
/*!40000 ALTER TABLE `employee_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insurance`
--

DROP TABLE IF EXISTS `insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insurance` (
  `insurance_id` int NOT NULL AUTO_INCREMENT,
  `id_number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`insurance_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insurance`
--

LOCK TABLES `insurance` WRITE;
/*!40000 ALTER TABLE `insurance` DISABLE KEYS */;
INSERT INTO `insurance` VALUES (1,'110120200001010201');
/*!40000 ALTER TABLE `insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `location_id` int NOT NULL AUTO_INCREMENT,
  `location_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `location_status` tinyint DEFAULT NULL,
  PRIMARY KEY (`location_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'1W101',1),(2,'1W102',2),(3,'1W103',1),(4,'1W104',1),(5,'1W201',1),(6,'1W202',1),(7,'1W203',1),(8,'1W204',1),(9,'1E101',1),(10,'1E102',1),(12,'1E103',1),(13,'1E104',1),(14,'1N101',1);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `menu_id` int NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `pmenu_id` int DEFAULT NULL,
  `isdelete` int DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Clinic',NULL,0,0),(2,'Work Station','/doctorOrder',1,0),(3,'Pharmacy','',0,0),(4,'Clinic Med Test','',0,0),(5,'Inpatient','',0,0),(6,'Nurse Station','',0,0),(7,'Medical Test','',0,0),(8,'Clinic Register','/clinicOrder',1,0),(9,'Clinic Payment','/clinicPay',1,0),(11,'Clinic dispense','/clinicMed',3,0),(12,'Dispense','/patientMed',3,0),(13,'Clinic Record','/selectClinicMed',3,0),(15,'Dispense Record','/selectPatientMed',3,0),(16,'Registration','/registration',5,0),(17,'Location','/addLocation',6,0),(18,'Vital Signs','/regularTest',6,0),(19,'Physician','/docStation',5,0),(20,'Order Verification','/checkOrder',6,0),(21,'Discharge','/discharge',5,0),(22,'Payment','/patientPay',5,0),(23,'Clinic Radiology','/clinicTable',4,0),(24,'clinic Lab Test','/clinicLab',4,0),(25,'Radiology','/patientRadio',7,0),(26,'Lab Test','/patientLab',7,0),(27,'Patient Infomation','/patientInfo',5,0),(28,'Patient Daily Order','/patientDailyOrder',5,0),(29,'Drug Administration','/manageMed',3,0),(30,'Clinic refund','/clinicRefund',1,0),(31,'Setting',NULL,0,0),(32,'Indication','/setAdministration',31,0),(33,'Dosage','/setDosage',31,0),(34,'Location','/setLocation',31,0),(35,'Unit','/setUnit',31,0),(36,'Treatment','/setTrestment',31,0),(37,'Employee','/setEmployee',31,0),(38,'Role','/setRole',31,0);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_bill`
--

DROP TABLE IF EXISTS `patient_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_bill` (
  `patient_bill_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `drug_count` int DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `payment_status` tinyint DEFAULT NULL,
  `manipulate_status` tinyint DEFAULT NULL,
  `dispense_time` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_bill_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_bill`
--

LOCK TABLES `patient_bill` WRITE;
/*!40000 ALTER TABLE `patient_bill` DISABLE KEYS */;
INSERT INTO `patient_bill` VALUES (1,1,7,NULL,0,'2023-10-23 14:47:57','2024-01-05 20:52:16',3,2,NULL),(2,1,1,2,1,'2023-10-17 19:49:35','2024-01-05 20:52:16',3,1,NULL),(3,1,5,5,4,NULL,'2024-01-05 20:52:16',3,1,NULL),(5,1,8,3,30,NULL,'2024-01-05 20:52:16',3,2,'2023-10-20 14:47:11'),(7,2,1,5,1,NULL,'2023-12-29 20:07:22',3,2,'2023-10-22 22:39:01'),(8,1,6,NULL,68,NULL,'2024-01-05 20:52:16',3,1,NULL),(9,2,7,NULL,0,'2023-12-27 14:33:11','2023-12-29 20:07:22',3,2,NULL),(10,1,5,3,21,'2023-10-09 00:42:04','2024-01-05 20:52:16',3,2,'2023-10-12 00:42:29'),(11,1,NULL,2,8,'2023-10-23 16:38:01','2024-01-05 20:52:16',3,1,NULL),(12,1,8,4,120,'2023-10-23 17:21:59','2024-01-05 20:52:16',3,1,NULL),(13,2,7,NULL,0,'2023-12-27 14:33:11','2023-12-29 20:07:22',3,2,NULL),(14,1,10,NULL,NULL,NULL,'2024-01-05 20:52:16',3,2,NULL),(15,2,7,NULL,0,'2023-12-27 14:33:11','2023-12-29 20:07:22',3,2,NULL),(16,11,7,NULL,0,NULL,NULL,1,1,NULL),(17,3,7,NULL,0,'2023-12-27 14:34:28','2023-12-29 20:07:28',3,2,NULL),(18,2,7,NULL,0,'2023-12-27 14:33:11','2023-12-29 20:07:22',3,2,NULL),(19,3,7,NULL,0,'2023-12-27 14:34:28','2023-12-29 20:07:28',3,2,NULL),(20,4,1,2,8,'2023-12-27 15:05:07','2024-01-05 22:02:00',3,1,NULL),(21,4,1,1,4,'2023-12-29 16:27:05','2024-01-05 22:02:00',3,1,NULL),(22,4,5,3,12,'2023-12-29 16:27:06','2024-01-05 22:02:00',3,1,NULL),(23,4,6,1,68,'2023-12-29 20:07:42','2024-01-05 22:02:00',3,2,NULL),(24,4,6,1,68,'2023-12-29 20:24:23','2024-01-05 22:02:00',3,2,NULL),(25,5,14,1,35,'2023-12-29 20:38:07',NULL,2,2,NULL),(26,4,7,NULL,0,'2024-01-05 22:01:28','2024-01-05 22:02:00',3,2,NULL),(27,5,7,NULL,0,'2024-01-11 18:18:49',NULL,2,2,NULL),(28,6,11,1,64,'2024-01-11 18:23:15',NULL,2,1,NULL),(29,5,1,2,8,'2024-01-11 18:25:11',NULL,2,1,NULL),(30,6,5,2,8,'2024-01-11 18:25:16',NULL,2,1,NULL);
/*!40000 ALTER TABLE `patient_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_info`
--

DROP TABLE IF EXISTS `patient_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_info` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `visitor_id` int DEFAULT NULL,
  `patient_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` tinyint DEFAULT NULL,
  `age` int DEFAULT NULL,
  `id_number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `unit_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `insurance_status` tinyint DEFAULT NULL,
  `in_time` datetime DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `clinic_diagnosis_id` int DEFAULT NULL,
  `admission_diagnosis_id` int DEFAULT NULL,
  `discharge_diagnosis_id` int DEFAULT NULL,
  `location_id` int DEFAULT NULL,
  `paid_time` datetime DEFAULT NULL,
  `stay_status` tinyint DEFAULT NULL,
  `payment_status` tinyint DEFAULT NULL,
  PRIMARY KEY (`patient_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_info`
--

LOCK TABLES `patient_info` WRITE;
/*!40000 ALTER TABLE `patient_info` DISABLE KEYS */;
INSERT INTO `patient_info` VALUES (1,2,'Caleb Reynolds',1,19,'223456789',1,3,2,'2023-10-16 11:59:35','2023-10-23 14:58:28',2,2,1,1,'2024-01-05 20:52:16',2,2),(2,3,'Zoe Parker',1,20,'123456788',2,4,1,NULL,'2023-12-27 14:33:30',3,NULL,1,NULL,'2023-12-29 20:07:22',2,2),(3,4,'Leo Hamilton',1,21,'123456787',3,2,2,NULL,'2023-12-27 14:35:02',4,NULL,2,NULL,'2023-12-29 20:07:28',2,2),(4,5,'Ava Barnes',1,22,'123456786',4,3,1,NULL,'2024-01-05 22:01:43',5,NULL,3,NULL,'2024-01-05 22:02:00',2,2),(5,6,'Owen Foster',2,25,'123456785',1,4,1,NULL,'2024-01-11 18:20:23',1,NULL,4,NULL,NULL,2,1),(6,7,'Lily Griffin',2,30,'123456784',2,2,1,NULL,NULL,2,NULL,NULL,2,NULL,1,1),(7,8,'Carter Hayes',2,12,'123456783',3,3,2,NULL,NULL,3,NULL,NULL,NULL,NULL,1,1),(9,1,'Savannah Mitchell',1,10,'123456789',2,8,0,'2023-10-21 17:36:20',NULL,NULL,NULL,NULL,3,NULL,2,1),(10,1,'Savannah Mitchell',1,10,'123456789',2,8,0,'2023-10-21 17:39:16',NULL,1,NULL,NULL,2,NULL,2,1),(11,1,'Savannah Mitchell',1,10,'123456789',2,8,0,'2023-10-21 17:50:04',NULL,1,NULL,1,NULL,NULL,1,1);
/*!40000 ALTER TABLE `patient_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_lab`
--

DROP TABLE IF EXISTS `patient_lab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_lab` (
  `patient_lab_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `lab_result` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `test_date` datetime DEFAULT NULL,
  `test_status` tinyint DEFAULT NULL,
  PRIMARY KEY (`patient_lab_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_lab`
--

LOCK TABLES `patient_lab` WRITE;
/*!40000 ALTER TABLE `patient_lab` DISABLE KEYS */;
INSERT INTO `patient_lab` VALUES (1,1,10,'WBC 7.2 x 10^9/L, RBC 4.8 x 10^12/L, Hb 14.2 g/dL, PLT 250 x 10^9/L','2024-01-11 18:03:39',2),(2,5,14,'WBC 8.2 x 10^9/L, RBC 5.2 x 10^12/L, Hb 15.2 g/dL, PLT 320 x 10^9/L','2024-01-11 18:04:40',2);
/*!40000 ALTER TABLE `patient_lab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_order`
--

DROP TABLE IF EXISTS `patient_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_order` (
  `patient_order_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `treatment_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `administration_id` int DEFAULT NULL,
  `dosage_id` int DEFAULT NULL,
  `treatment_count` int DEFAULT NULL,
  `execution_time` datetime DEFAULT NULL,
  `dispense_time` datetime DEFAULT NULL,
  `execution_status` tinyint DEFAULT NULL,
  `order_type` tinyint DEFAULT NULL,
  PRIMARY KEY (`patient_order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_order`
--

LOCK TABLES `patient_order` WRITE;
/*!40000 ALTER TABLE `patient_order` DISABLE KEYS */;
INSERT INTO `patient_order` VALUES (1,1,3,1,'0.9%氯化钠注射液',1,2,2,'2023-10-16 17:08:09',NULL,4,2),(2,1,3,7,'办理出院',1,2,NULL,NULL,NULL,4,1),(3,1,2,7,'办理出院',1,2,NULL,NULL,NULL,4,1),(4,1,3,5,'头孢呋辛注射液',1,2,NULL,NULL,NULL,4,2),(5,1,3,8,'氨溴索口服液',2,2,3,NULL,NULL,4,1),(6,2,4,1,'0.9%氯化钠注射液',5,1,5,NULL,NULL,4,1),(7,1,3,6,'腹部彩超',6,1,NULL,NULL,NULL,4,1),(12,1,2,7,'办理出院',4,1,NULL,NULL,NULL,4,1),(14,1,2,8,'氨溴索口服液',1,2,4,'2023-10-23 17:21:59',NULL,4,1),(15,1,3,1,'0.9%氯化钠注射液',3,2,10,NULL,NULL,4,1),(19,2,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,NULL),(20,2,4,7,'办理出院',NULL,NULL,NULL,NULL,NULL,4,1),(21,11,8,7,'办理出院',NULL,NULL,NULL,NULL,NULL,3,1),(22,3,2,7,'办理出院',NULL,NULL,NULL,NULL,NULL,4,1),(23,2,4,7,'Discharge',NULL,NULL,NULL,'2023-12-27 14:33:11',NULL,4,1),(24,3,2,7,'Discharge',NULL,NULL,NULL,'2023-12-27 14:34:28',NULL,4,1),(25,4,3,1,'0.9% Sodium Chloride',2,2,2,'2023-12-27 15:05:07',NULL,4,2),(26,4,3,5,'Cefuroxime Sodium',1,1,3,'2023-12-29 16:27:06',NULL,4,1),(27,4,3,1,'0.9% Sodium Chloride',1,2,1,'2023-12-29 16:27:05',NULL,4,1),(28,4,3,6,'Abdominal Color Doppler Ultrasound',NULL,NULL,NULL,'2023-12-29 20:07:43',NULL,4,1),(29,4,3,6,'Abdominal Color Doppler Ultrasound',NULL,NULL,NULL,'2023-12-29 20:24:23',NULL,4,1),(30,5,4,14,'Kidney Function',NULL,NULL,NULL,'2023-12-29 20:38:08',NULL,2,1),(31,4,3,7,'Discharge',NULL,NULL,NULL,'2024-01-05 22:01:28',NULL,4,1),(32,5,4,7,'Discharge',NULL,NULL,NULL,'2024-01-11 18:18:49',NULL,2,1),(33,5,4,1,'0.9% Sodium Chloride',1,3,2,'2024-01-11 18:25:11',NULL,2,1),(34,6,2,5,'Cefuroxime Sodium',1,3,2,'2024-01-11 18:25:16',NULL,2,1),(35,6,2,11,'PA chest X-ray',NULL,NULL,NULL,'2024-01-11 18:23:15',NULL,2,1);
/*!40000 ALTER TABLE `patient_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_raidology`
--

DROP TABLE IF EXISTS `patient_raidology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_raidology` (
  `patient_raidology_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `test_date` datetime DEFAULT NULL,
  `test_status` tinyint DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`patient_raidology_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_raidology`
--

LOCK TABLES `patient_raidology` WRITE;
/*!40000 ALTER TABLE `patient_raidology` DISABLE KEYS */;
INSERT INTO `patient_raidology` VALUES (2,4,6,'/Users/yukuanfeng/Projects/his-web/src/assets/images//','2023-12-29 20:24:43',1,'1703899483009.jpg'),(3,6,11,NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `patient_raidology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regular_test`
--

DROP TABLE IF EXISTS `regular_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regular_test` (
  `regular_test_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `pressure` int DEFAULT NULL,
  `sugar` decimal(10,0) DEFAULT NULL,
  `temp` decimal(10,0) DEFAULT NULL,
  `test_date` datetime DEFAULT NULL,
  PRIMARY KEY (`regular_test_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regular_test`
--

LOCK TABLES `regular_test` WRITE;
/*!40000 ALTER TABLE `regular_test` DISABLE KEYS */;
INSERT INTO `regular_test` VALUES (1,1,100,5,100,'2023-10-23 10:27:47'),(2,3,500,70,23,'2023-10-23 15:58:48'),(3,2,120,6,38,'2023-12-29 18:17:21'),(4,3,50,6,40,'2023-12-29 18:18:26');
/*!40000 ALTER TABLE `regular_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `isdelete` int DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin',NULL,0),(2,'Chief Physician',2,0),(3,'Associate Physician',3,0),(4,'Attending Physician',4,0),(5,'Nurse',NULL,0),(6,'Pharmacist',NULL,0),(7,'Radiologist',NULL,0),(8,'Medical Laboratory Scientist ',NULL,0),(9,'Front Desk Staff',NULL,0),(12,'Cleaner',NULL,1),(13,'cle',NULL,1),(14,'Respiratory Therapist',NULL,0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treatment` (
  `treatment_id` int NOT NULL AUTO_INCREMENT,
  `treatment_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `drug_code` int DEFAULT NULL,
  `manufacturer` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `production_time` datetime DEFAULT NULL,
  `expired_time` datetime DEFAULT NULL,
  `storage` int DEFAULT NULL,
  `specification` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `treatment_price` decimal(10,0) DEFAULT NULL,
  `insurance_price` decimal(10,0) DEFAULT NULL,
  `treatment_status` tinyint DEFAULT NULL,
  `treatment_category` tinyint DEFAULT NULL,
  PRIMARY KEY (`treatment_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
INSERT INTO `treatment` VALUES (1,'0.9% Sodium Chloride',1001,'Abbott Laboratories Ltd','2019-01-02 00:00:00','2023-10-20 00:00:00',88,'1000ml/Bag',4,2,1,1),(2,'Chief Physician Registration Fee',NULL,NULL,NULL,NULL,NULL,NULL,100,30,1,2),(3,'Associate Physician Registration Fee',NULL,NULL,NULL,NULL,NULL,NULL,50,50,1,2),(4,'Attending Physician Registration Fee',NULL,NULL,NULL,NULL,NULL,NULL,10,10,1,2),(5,'Cefuroxime Sodium',1002,'Johnson & Johnson Pharmaceuticals Ltd','2022-10-01 00:00:00','2023-10-25 00:00:00',26,'100ml/Bottle',4,2,1,1),(6,'Abdominal Color Doppler Ultrasound',NULL,NULL,NULL,NULL,NULL,NULL,68,40,1,4),(7,'Discharge',NULL,NULL,NULL,NULL,NULL,NULL,0,0,1,2),(8,'Ambroxol Hydrochloride',1003,'Johnson & Johnson Pharmaceuticals Ltd','2022-11-11 00:00:00','2024-11-13 00:00:00',34,'50ml/Bottle',30,24,1,1),(9,'Coagulation Profile',NULL,NULL,NULL,NULL,NULL,NULL,120,60,1,3),(10,'FNID',NULL,NULL,NULL,NULL,NULL,NULL,160,90,1,3),(11,'PA chest X-ray',NULL,NULL,NULL,NULL,NULL,NULL,64,20,1,4),(12,'lateral lumbar spine radiograph',NULL,NULL,NULL,NULL,NULL,NULL,64,20,1,4),(13,'Blood Sugar Test',NULL,NULL,NULL,NULL,NULL,NULL,15,6,1,3),(14,'Kidney Function',NULL,NULL,NULL,NULL,NULL,NULL,35,10,1,3),(17,'CT',NULL,NULL,NULL,NULL,NULL,NULL,600,200,1,4),(19,'Vitamin C',1004,'Nature Made','2023-10-01 00:00:00','2025-10-14 00:00:00',202,'20 Tablet/Box',2,1,1,1);
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
  `unit_id` int NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`unit_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'Orthopedics'),(2,'Neurology'),(3,'ENT'),(4,'Dental care'),(6,'OB'),(16,'Oncology'),(17,'ICU'),(18,'Emergency Room');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `employee_id` int DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `isdelete` int DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'aaa','d9f6e636e369552839e7bb8057aeb8da',1,NULL,NULL),(2,'bbb','bbb123',2,NULL,NULL),(3,'ccc','ccc123',3,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_patain`
--

DROP TABLE IF EXISTS `v_patain`;
/*!50001 DROP VIEW IF EXISTS `v_patain`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_patain` AS SELECT 
 1 AS `patient_id`,
 1 AS `visitor_id`,
 1 AS `patient_name`,
 1 AS `gender`,
 1 AS `age`,
 1 AS `id_number`,
 1 AS `insurance_status`,
 1 AS `in_time`,
 1 AS `out_time`,
 1 AS `location_id`,
 1 AS `location_name`,
 1 AS `paid_time`,
 1 AS `stay_status`,
 1 AS `payment_status`,
 1 AS `unit_id`,
 1 AS `unit_name`,
 1 AS `employee_id`,
 1 AS `employee_name`,
 1 AS `clinic_disease_id`,
 1 AS `clinic_disease_name`,
 1 AS `admission_disease_id`,
 1 AS `admission_disease_name`,
 1 AS `discharge_disease_id`,
 1 AS `discharge_disease_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `visitor_bill`
--

DROP TABLE IF EXISTS `visitor_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor_bill` (
  `visitor_bill_id` int NOT NULL AUTO_INCREMENT,
  `visitor_id` int DEFAULT NULL,
  `treatment_id` int DEFAULT NULL,
  `drug_count` int DEFAULT NULL,
  `treatment_price` decimal(10,0) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  `payment_status` tinyint DEFAULT NULL,
  `manipulate_status` tinyint DEFAULT NULL,
  `dispense_time` datetime DEFAULT NULL,
  PRIMARY KEY (`visitor_bill_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor_bill`
--

LOCK TABLES `visitor_bill` WRITE;
/*!40000 ALTER TABLE `visitor_bill` DISABLE KEYS */;
INSERT INTO `visitor_bill` VALUES (1,1,12,NULL,100,'2023-10-17 11:44:50','2023-10-21 16:34:57',2,2,NULL),(2,1,1,2,2,'2023-10-16 11:45:53','2023-10-21 15:56:11',2,2,'2023-10-22 22:40:14'),(3,1,5,1,4,'2023-10-17 09:47:05','2023-10-21 15:56:11',2,2,'2023-10-20 14:29:47'),(5,1,5,6,4,'2023-10-19 23:50:00','2023-10-21 16:42:27',2,2,'2024-01-05 20:11:05'),(6,19,3,NULL,50,'2023-10-21 15:46:26',NULL,1,1,NULL),(7,20,NULL,NULL,NULL,'2023-10-23 11:35:54',NULL,1,1,NULL),(8,21,NULL,NULL,NULL,'2023-10-23 11:35:54',NULL,1,1,NULL),(9,22,NULL,NULL,NULL,'2023-10-23 11:38:47',NULL,1,1,NULL),(10,23,NULL,NULL,NULL,'2023-10-23 11:38:47',NULL,1,1,NULL),(11,24,NULL,NULL,NULL,'2023-10-23 11:40:28',NULL,1,1,NULL),(12,25,NULL,NULL,NULL,'2023-10-23 11:40:28',NULL,1,1,NULL),(13,1,10,NULL,NULL,NULL,NULL,2,1,NULL),(14,26,2,NULL,100,'2023-10-26 15:12:41',NULL,2,1,NULL),(15,7,1,2,4,'2024-01-05 19:43:26','2024-01-05 19:46:33',2,2,'2024-01-05 20:10:43'),(16,10,1,2,4,'2024-01-05 20:17:41','2024-01-05 20:18:02',2,2,'2024-01-05 20:29:12'),(17,15,1,5,4,'2024-01-05 21:29:41','2024-01-05 21:34:50',2,1,NULL),(18,17,1,5,4,'2024-01-05 21:36:01','2024-01-05 21:36:38',2,1,NULL),(19,1,10,NULL,160,'2024-01-09 18:35:29',NULL,1,1,NULL),(20,1,6,NULL,68,'2024-01-09 18:35:49',NULL,1,1,NULL);
/*!40000 ALTER TABLE `visitor_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor_info`
--

DROP TABLE IF EXISTS `visitor_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitor_info` (
  `visitor_id` int NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `age` int DEFAULT NULL,
  `id_number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone` bigint DEFAULT NULL,
  `unit_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `disease_id` int DEFAULT NULL,
  `clinic_start_time` date DEFAULT NULL,
  `clinic_status` tinyint DEFAULT NULL,
  PRIMARY KEY (`visitor_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor_info`
--

LOCK TABLES `visitor_info` WRITE;
/*!40000 ALTER TABLE `visitor_info` DISABLE KEYS */;
INSERT INTO `visitor_info` VALUES (1,'Savannah Mitchell',1,10,'123456789',18981131603,1,2,1,'2024-01-11',2),(2,'Caleb Reynolds',1,19,'223456789',13087968611,1,3,2,'2023-10-21',3),(3,'Zoe Parker',1,20,'123456788',12449987982,2,4,3,NULL,3),(4,'Leo Hamilton',1,21,'123456787',12043485934,3,2,4,NULL,3),(5,'Ava Barnes',1,22,'123456786',13043543958,4,3,2,'2024-01-05',3),(6,'Owen Foster',2,25,'123456785',18955228985,1,4,1,NULL,3),(7,'Lily Griffin',2,30,'123456784',17732957345,2,2,2,'2024-01-05',3),(8,'Carter Hayes',2,12,'123456783',19345394692,3,3,3,NULL,3),(9,'Bella Sullivan',2,18,'123456782',18534952435,4,4,4,NULL,3),(10,'Mason Caldwell',1,80,'123456781',16434592348,1,2,5,'2024-01-05',2),(11,'Isabella Price',1,30,'987456321',16434592348,1,1,1,NULL,3),(15,'Liam Donovan',1,26,'987456321',16434592343,1,1,2,'2024-01-05',3),(16,'Scarlett Murphy',1,23,'741258963',16434592366,1,1,3,NULL,3),(17,'Elijah Collins',1,26,'963258741',16434592333,3,3,1,'2024-01-05',3),(18,'Penelope Nelson',1,23,'789963321',16434592377,3,3,NULL,NULL,1),(19,'Wyatt Peterson',1,23,'123321456',16434592399,3,3,NULL,NULL,1),(20,'Aria Simmons',1,26,'753951852',16434592999,1,1,NULL,NULL,1),(21,'Noah Chandler',1,26,'753951852',16434592999,1,1,NULL,NULL,1),(22,'Grace Fletcher',1,23,'789123654',16434592666,1,5,NULL,NULL,1),(23,'Lucas Bennett',1,23,'789123654',16434592666,1,5,NULL,NULL,1),(24,'Harper Watkins',1,23,'741321963',16434599999,1,5,NULL,NULL,1),(25,'Logan Montgomery',1,23,'741321963',16434599999,1,5,NULL,NULL,1),(26,'Sophia Patton',1,18,'5201314hy',12345678901,2,2,NULL,NULL,1);
/*!40000 ALTER TABLE `visitor_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `v_patain`
--

/*!50001 DROP VIEW IF EXISTS `v_patain`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_patain` AS select `pi`.`patient_id` AS `patient_id`,`pi`.`visitor_id` AS `visitor_id`,`pi`.`patient_name` AS `patient_name`,`pi`.`gender` AS `gender`,`pi`.`age` AS `age`,`pi`.`id_number` AS `id_number`,`pi`.`insurance_status` AS `insurance_status`,`pi`.`in_time` AS `in_time`,`pi`.`out_time` AS `out_time`,`l`.`location_id` AS `location_id`,`l`.`location_name` AS `location_name`,`pi`.`paid_time` AS `paid_time`,`pi`.`stay_status` AS `stay_status`,`pi`.`payment_status` AS `payment_status`,`u`.`unit_id` AS `unit_id`,`u`.`unit_name` AS `unit_name`,`e`.`employee_id` AS `employee_id`,`e`.`employee_name` AS `employee_name`,`clinic_d`.`disease_id` AS `clinic_disease_id`,`clinic_d`.`disease_name` AS `clinic_disease_name`,`admission_d`.`disease_id` AS `admission_disease_id`,`admission_d`.`disease_name` AS `admission_disease_name`,`discharge_d`.`disease_id` AS `discharge_disease_id`,`discharge_d`.`disease_name` AS `discharge_disease_name` from ((((((`patient_info` `pi` left join `unit` `u` on((`pi`.`unit_id` = `u`.`unit_id`))) left join `employee` `e` on((`pi`.`doctor_id` = `e`.`employee_id`))) left join `location` `l` on((`pi`.`location_id` = `l`.`location_id`))) left join `disease` `clinic_d` on((`pi`.`clinic_diagnosis_id` = `clinic_d`.`disease_id`))) left join `disease` `admission_d` on((`pi`.`admission_diagnosis_id` = `admission_d`.`disease_id`))) left join `disease` `discharge_d` on((`pi`.`discharge_diagnosis_id` = `discharge_d`.`disease_id`))) where (`pi`.`patient_id` = 2) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-27 21:47:55
