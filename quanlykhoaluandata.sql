-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlykhoaluan
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `giang_vien_cham_diem`
--

DROP TABLE IF EXISTS `giang_vien_cham_diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giang_vien_cham_diem` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diem` float NOT NULL,
  `ngay_cham` datetime NOT NULL,
  `giang_vien_thuoc_hoi_dong_id` int NOT NULL,
  `khoa_luan_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `giang_vien_thuoc_hoi_dong_id` (`giang_vien_thuoc_hoi_dong_id`),
  KEY `khoa_luan_id` (`khoa_luan_id`),
  CONSTRAINT `giang_vien_cham_diem_ibfk_1` FOREIGN KEY (`giang_vien_thuoc_hoi_dong_id`) REFERENCES `giang_vien_thuoc_hoi_dong` (`id`),
  CONSTRAINT `giang_vien_cham_diem_ibfk_2` FOREIGN KEY (`khoa_luan_id`) REFERENCES `khoa_luan_tot_nghiep` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giang_vien_cham_diem`
--

LOCK TABLES `giang_vien_cham_diem` WRITE;
/*!40000 ALTER TABLE `giang_vien_cham_diem` DISABLE KEYS */;
/*!40000 ALTER TABLE `giang_vien_cham_diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giang_vien_huong_dan_khoa_luan`
--

DROP TABLE IF EXISTS `giang_vien_huong_dan_khoa_luan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giang_vien_huong_dan_khoa_luan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ngay_bat_dau_huong_dan` datetime NOT NULL,
  `nguoi_dung_id` int NOT NULL,
  `khoa_luan_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nguoi_dung_id` (`nguoi_dung_id`),
  KEY `khoa_luan_id` (`khoa_luan_id`),
  CONSTRAINT `giang_vien_huong_dan_khoa_luan_ibfk_1` FOREIGN KEY (`nguoi_dung_id`) REFERENCES `nguoi_dung` (`id`),
  CONSTRAINT `giang_vien_huong_dan_khoa_luan_ibfk_2` FOREIGN KEY (`khoa_luan_id`) REFERENCES `khoa_luan_tot_nghiep` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giang_vien_huong_dan_khoa_luan`
--

LOCK TABLES `giang_vien_huong_dan_khoa_luan` WRITE;
/*!40000 ALTER TABLE `giang_vien_huong_dan_khoa_luan` DISABLE KEYS */;
INSERT INTO `giang_vien_huong_dan_khoa_luan` VALUES (1,'2023-07-25 00:00:00',1,1);
/*!40000 ALTER TABLE `giang_vien_huong_dan_khoa_luan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giang_vien_thuoc_hoi_dong`
--

DROP TABLE IF EXISTS `giang_vien_thuoc_hoi_dong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giang_vien_thuoc_hoi_dong` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vai_tro` varchar(13) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ngay_vao_hoi_dong` datetime NOT NULL,
  `nguoi_dung_id` int NOT NULL,
  `hoi_dong_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nguoi_dung_id` (`nguoi_dung_id`),
  KEY `hoi_dong_id` (`hoi_dong_id`),
  CONSTRAINT `giang_vien_thuoc_hoi_dong_ibfk_1` FOREIGN KEY (`nguoi_dung_id`) REFERENCES `nguoi_dung` (`id`),
  CONSTRAINT `giang_vien_thuoc_hoi_dong_ibfk_2` FOREIGN KEY (`hoi_dong_id`) REFERENCES `hoi_dong_bao_ve_khoa_luan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giang_vien_thuoc_hoi_dong`
--

LOCK TABLES `giang_vien_thuoc_hoi_dong` WRITE;
/*!40000 ALTER TABLE `giang_vien_thuoc_hoi_dong` DISABLE KEYS */;
/*!40000 ALTER TABLE `giang_vien_thuoc_hoi_dong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoi_dong_bao_ve_khoa_luan`
--

DROP TABLE IF EXISTS `hoi_dong_bao_ve_khoa_luan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoi_dong_bao_ve_khoa_luan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ngay_thanh_lap` datetime NOT NULL,
  `ngay_khoa` datetime NOT NULL,
  `ten_hoi_dong` varchar(60) COLLATE utf8mb4_vi_0900_ai_ci NOT NULL,
  `is_active` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoi_dong_bao_ve_khoa_luan`
--

LOCK TABLES `hoi_dong_bao_ve_khoa_luan` WRITE;
/*!40000 ALTER TABLE `hoi_dong_bao_ve_khoa_luan` DISABLE KEYS */;
INSERT INTO `hoi_dong_bao_ve_khoa_luan` VALUES (1,'2023-07-18 00:00:00','2023-07-18 00:00:00','test',0);
/*!40000 ALTER TABLE `hoi_dong_bao_ve_khoa_luan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa_luan_tot_nghiep`
--

DROP TABLE IF EXISTS `khoa_luan_tot_nghiep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa_luan_tot_nghiep` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_khoa_luan` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ngay_ghi_nhan` datetime NOT NULL,
  `ngay_ket_thuc` datetime DEFAULT NULL,
  `giao_vu_id` int NOT NULL,
  `hoi_dong_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `giao_vu_id` (`giao_vu_id`),
  KEY `hoi_dong_id` (`hoi_dong_id`),
  CONSTRAINT `khoa_luan_tot_nghiep_ibfk_1` FOREIGN KEY (`giao_vu_id`) REFERENCES `nguoi_dung` (`id`),
  CONSTRAINT `khoa_luan_tot_nghiep_ibfk_2` FOREIGN KEY (`hoi_dong_id`) REFERENCES `hoi_dong_bao_ve_khoa_luan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa_luan_tot_nghiep`
--

LOCK TABLES `khoa_luan_tot_nghiep` WRITE;
/*!40000 ALTER TABLE `khoa_luan_tot_nghiep` DISABLE KEYS */;
INSERT INTO `khoa_luan_tot_nghiep` VALUES (1,'kltest','2023-07-18 00:00:00',NULL,1,1),(2,'sada','2023-07-18 00:00:00',NULL,1,1);
/*!40000 ALTER TABLE `khoa_luan_tot_nghiep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoi_dung`
--

DROP TABLE IF EXISTS `nguoi_dung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoi_dung` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ten` varchar(25) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `tai_khoan` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `mat_khau` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `sdt` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `avatar` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `vai_tro` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `khoa_luan_id` int DEFAULT NULL,
  `is_active` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `khoa_luan_id` (`khoa_luan_id`),
  CONSTRAINT `nguoi_dung_ibfk_1` FOREIGN KEY (`khoa_luan_id`) REFERENCES `khoa_luan_tot_nghiep` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_dung`
--

LOCK TABLES `nguoi_dung` WRITE;
/*!40000 ALTER TABLE `nguoi_dung` DISABLE KEYS */;
INSERT INTO `nguoi_dung` VALUES (1,'adm','in','admin','admin','123','test','test','test','2023-07-18 00:00:00',2,0),(2,'test','test','test','test','test','test','test','test1','2023-07-18 00:00:00',NULL,0),(3,'test5','test5','test5','test5','test5','test5','test5','test5','2023-07-22 00:00:00',NULL,0);
/*!40000 ALTER TABLE `nguoi_dung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tieu_chi`
--

DROP TABLE IF EXISTS `tieu_chi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tieu_chi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `noi_dung_tieu_chi` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `diem` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tieu_chi`
--

LOCK TABLES `tieu_chi` WRITE;
/*!40000 ALTER TABLE `tieu_chi` DISABLE KEYS */;
INSERT INTO `tieu_chi` VALUES (1,'test',2.5);
/*!40000 ALTER TABLE `tieu_chi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tieu_chi_thuoc_khoa_luan`
--

DROP TABLE IF EXISTS `tieu_chi_thuoc_khoa_luan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tieu_chi_thuoc_khoa_luan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `khoa_luan_id` int NOT NULL,
  `tieu_chi_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tieu_chi_id` (`tieu_chi_id`),
  KEY `khoa_luan_id` (`khoa_luan_id`),
  CONSTRAINT `tieu_chi_thuoc_khoa_luan_ibfk_1` FOREIGN KEY (`tieu_chi_id`) REFERENCES `tieu_chi` (`id`),
  CONSTRAINT `tieu_chi_thuoc_khoa_luan_ibfk_2` FOREIGN KEY (`khoa_luan_id`) REFERENCES `khoa_luan_tot_nghiep` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tieu_chi_thuoc_khoa_luan`
--

LOCK TABLES `tieu_chi_thuoc_khoa_luan` WRITE;
/*!40000 ALTER TABLE `tieu_chi_thuoc_khoa_luan` DISABLE KEYS */;
/*!40000 ALTER TABLE `tieu_chi_thuoc_khoa_luan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-01  8:11:56
