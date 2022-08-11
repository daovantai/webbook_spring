-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: webbook
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `idbill` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sdt` int DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `datee` date DEFAULT NULL,
  `total` int DEFAULT NULL,
  PRIMARY KEY (`idbill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (4,'33','33@gmail.com',33,'Ha Noi','Hong Minh Phu Xuyen','2022-08-01',87000),(5,'taibu','daotai2309@gmail.com',347268701,'Ha Noi','Hong Minh Phu Xuyen','2022-08-01',75000),(6,'taibu','daotai2309@gmail.com',347268701,'Ha Noi','Hong Minh Phu Xuyen','2022-08-01',75000),(7,'taibu','daotai2309@gmail.com',347268701,'Ha Noi','vv','2022-08-02',60000),(8,'taibu','daotai2309@gmail.com',347268701,'Ha Noi','Hong Minh Phu Xuyen','2022-08-04',52000),(9,'taibu','daotai2309@gmail.com',347268701,'Ha Noi','Hong Minh Phu Xuyen','2022-08-04',40000),(10,'22','22@gmail.com',22,'t','t','2022-08-06',17000);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `idcart` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `idsach` varchar(45) DEFAULT NULL,
  `tensach` varchar(45) DEFAULT NULL,
  `gia` int DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `num` int DEFAULT NULL,
  `tong` int DEFAULT NULL,
  PRIMARY KEY (`idcart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (18,'1','MS0007','Ô Long Viện',35000,'img/1.jpg',1,35000),(19,'cc','MS0009','Lão hạc',42000,'img/2.jpg',2,84000),(21,'1','MS0006','Cậu Bé Bút Chì',40000,'img/8.jpg',1,40000),(24,'1','MS0009','Lão hạc',42000,'img/2.jpg',1,42000),(25,'cc','MS0004','Ông Lão Đánh Cá',24000,'img/6.jpg',4,96000),(26,'33','MS0006','Cậu Bé Bút Chì',40000,'img/8.jpg',1,40000),(27,'33','MS0008','Lão hạc',42000,'img/2.jpg',1,42000),(28,'22','MS0006','Cậu Bé Bút Chì',40000,'img/8.jpg',2,80000),(32,'taibu','MS0006','Cậu Bé Bút Chì',40000,'img/8.jpg',2,80000),(34,'22','MS0007','Ô Long Viện',35000,'img/1.jpg',2,70000),(35,'22','MS0005','Lập Trình Web',17000,'img/7.jpg',1,17000),(36,'22','MS0008','Lão hạc',42000,'img/2.jpg',1,42000),(37,'taibu','MS0003','Toeic',20000,'img/4.jpg',1,20000);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khosach`
--

DROP TABLE IF EXISTS `khosach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khosach` (
  `idsach` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tensach` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tacgia` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `nxb` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `theloai` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tinhtrang` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sluong` int DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `hot` int DEFAULT NULL,
  `gia` int DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`idsach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khosach`
--

LOCK TABLES `khosach` WRITE;
/*!40000 ALTER TABLE `khosach` DISABLE KEYS */;
INSERT INTO `khosach` VALUES ('MS0001','Đắc nhân tâm','TB','Kim dong','Tiểu thuyết','3',10,'img/2.jpg',1,12000,1),('MS0002','Nhà Giả Kim','Nhu','HCM','Văn học','chua muon',44,'img/voi.jpg',1,15000,2),('MS0003','Toeic','Thảo híp','Zenlish','Khoa học','cc',16,'img/4.jpg',1,20000,3),('MS0004','Ông Lão Đánh Cá','Leonado','2012','Tiểu thuyết','1',26,'img/6.jpg',1,24000,1),('MS0005','Lập Trình Web','Trần Công','Ptit','Khoa học','1',11,'img/7.jpg',1,17000,3),('MS0006','Cậu Bé Bút Chì','Shin','Kim đồng','Tryện tranh','0',55,'img/8.jpg',1,40000,4),('MS0007','Ô Long Viện','Xiao Ming','HCM','Tryện tranh','3',111,'img/1.jpg',1,35000,4),('MS0008','Lão hạc','Nam Cao','Hà nội','Văn học','6',19,'img/2.jpg',0,42000,2),('MS0010','123','13','12','Văn học','1',4,'112',0,3001,2);
/*!40000 ALTER TABLE `khosach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `hoten` varchar(45) NOT NULL,
  `tendn` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sdt` int DEFAULT NULL,
  `matkhau` varchar(45) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tendn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('1','1','1',1,'1',NULL),('2','22','22@gmail.com',22,'22',NULL),('33','33','33',33,'33',NULL),('8','8','8',8,'8',NULL),('cc','cc','cc',11,'cc',NULL),('daotai','taibu','daotai2309@gmail.com',347268701,'1','img/1.jpg');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typebook`
--

DROP TABLE IF EXISTS `typebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typebook` (
  `id` int NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typebook`
--

LOCK TABLES `typebook` WRITE;
/*!40000 ALTER TABLE `typebook` DISABLE KEYS */;
INSERT INTO `typebook` VALUES (1,'Tiểu thuyết'),(2,'Văn học'),(3,'Khoa học'),(4,'Tryện tranh'),(5,'tb');
/*!40000 ALTER TABLE `typebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `id` int NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `tensach` varchar(45) DEFAULT NULL,
  `sluong` int DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `gia` int DEFAULT NULL,
  `idsach` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
INSERT INTO `wishlist` VALUES (4,'taibu','Ô Long Viện',0,'img/1.jpg',35000,'MS0007'),(5,'taibu','Cậu Bé Bút Chì',7,'img/8.jpg',40000,'MS0006'),(6,'taibu','Lão hạc',19,'img/2.jpg',42000,'MS0008');
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-11 14:51:41
