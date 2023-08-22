-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlykhoaluan2
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giang_vien_cham_diem`
--

LOCK TABLES `giang_vien_cham_diem` WRITE;
/*!40000 ALTER TABLE `giang_vien_cham_diem` DISABLE KEYS */;
INSERT INTO `giang_vien_cham_diem` VALUES (3,8,'2023-07-18 00:00:00',1,1),(4,7,'2022-07-18 00:00:00',2,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giang_vien_huong_dan_khoa_luan`
--

LOCK TABLES `giang_vien_huong_dan_khoa_luan` WRITE;
/*!40000 ALTER TABLE `giang_vien_huong_dan_khoa_luan` DISABLE KEYS */;
INSERT INTO `giang_vien_huong_dan_khoa_luan` VALUES (1,'2023-07-25 00:00:00',1,1),(2,'2023-08-02 00:00:00',17,1),(5,'2023-08-11 00:00:00',17,2);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giang_vien_thuoc_hoi_dong`
--

LOCK TABLES `giang_vien_thuoc_hoi_dong` WRITE;
/*!40000 ALTER TABLE `giang_vien_thuoc_hoi_dong` DISABLE KEYS */;
INSERT INTO `giang_vien_thuoc_hoi_dong` VALUES (1,'test','2023-07-18 00:00:00',1,1),(2,'THU_KY','2023-07-18 00:00:00',3,1);
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
  `ten_hoi_dong` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_vi_0900_ai_ci NOT NULL,
  `is_active` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoi_dong_bao_ve_khoa_luan`
--

LOCK TABLES `hoi_dong_bao_ve_khoa_luan` WRITE;
/*!40000 ALTER TABLE `hoi_dong_bao_ve_khoa_luan` DISABLE KEYS */;
INSERT INTO `hoi_dong_bao_ve_khoa_luan` VALUES (1,'2023-07-18 00:00:00','2023-07-18 00:00:00','test',1),(2,'2023-07-18 00:00:00','2023-07-18 00:00:00','test1',1);
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
  `nganh` varchar(45) COLLATE utf8mb4_vi_0900_ai_ci NOT NULL,
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
INSERT INTO `khoa_luan_tot_nghiep` VALUES (1,'kltest','2023-07-18 00:00:00','2023-08-18 00:00:00',1,1,'CNTT'),(2,'sada','2023-07-18 00:00:00','2023-08-18 00:00:00',3,1,'KHMT');
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
  `ho` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tai_khoan` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mat_khau` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdt` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `avatar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `vai_tro` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime NOT NULL,
  `khoa_luan_id` int DEFAULT NULL,
  `is_active` tinyint NOT NULL,
  `nganh` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tai_khoan_UNIQUE` (`tai_khoan`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `sdt_UNIQUE` (`sdt`),
  KEY `khoa_luan_id` (`khoa_luan_id`),
  CONSTRAINT `nguoi_dung_ibfk_1` FOREIGN KEY (`khoa_luan_id`) REFERENCES `khoa_luan_tot_nghiep` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_dung`
--

LOCK TABLES `nguoi_dung` WRITE;
/*!40000 ALTER TABLE `nguoi_dung` DISABLE KEYS */;
INSERT INTO `nguoi_dung` VALUES (1,'adm','in','admin','Hoangbrato@gmail.com','$2a$10$/JiD7FFmOOScNGG5VwyeE.IFAKg0srPq8TGEID6cna8FpEZDNbB5m','1234567897','https://res.cloudinary.com/dtlqyvkvu/image/upload/v1691990852/uyaxwbdtxbrrefc3qt7j.png','GIAO_VU','2023-07-18 00:00:00',NULL,1,'CNTT'),(3,'test5','test5','test5','test5','test5','test5','test5','test5','2023-07-22 00:00:00',NULL,1,'CNTT'),(16,'asdsad','asdasd','sadasd','asdasdasd','$2a$10$nB7wfbdw0DHdMXCk.7fJGeZcyo6bDVBGEBFcRP2sHISp4apQuld/2','1234567891','asdasdas','asdsadas','2023-08-02 00:00:00',NULL,1,'CNTT'),(17,'thao','thao','thao','quocthao9899@gmail.com','$2a$10$nB7wfbdw0DHdMXCk.7fJGeZcyo6bDVBGEBFcRP2sHISp4apQuld/2','1234567892','https://res.cloudinary.com/dtlqyvkvu/image/upload/v1692432157/eymcqxwrxru3qi6jjopc.jpg','GIAO_VU','2023-08-03 00:00:00',NULL,1,NULL),(18,'asdasd','asdasd','asdada','test5@gmail.com','$2a$10$AoqfZSMSVSPdHhYCBtWxYuFvb66cctUGWcLWTFfoOhF76KDKAeHme','1234567893','sadada','GIAO_VU','2023-08-08 00:00:00',NULL,1,'KHMT'),(19,'sadsa','dasdasda','asdasda','sadasdsada@gmail.com','$2a$10$44PGTWSDcjW9va4V4cREA.4w4in7wpCnkkzlQj10pN3ZK5CN419vq','1234567894','sdadada','GIANG_VIEN','2023-08-08 00:00:00',NULL,1,'Kế toán'),(20,'ssss','ssss','ssss','ssss@gmail.com','$2a$10$OeEzBX5/nyFib4z/lVRnruUt91tYAU6xbtTaXhTb5RprVMHsvJN9i','1234567895','https://res.cloudinary.com/dtlqyvkvu/image/upload/v1691939502/qb25pwa3szyt5bo4avhe.png','SINH_VIEN','2023-08-13 00:00:00',2,1,'Quản trị'),(22,'sadas','asdsad','admin1','test51@gmail.com','$2a$10$24OAPWkII//wmFDniBotKOXeF2BW7YuDnPNgBxfMYfuqb7LVERek2','1234567898','https://res.cloudinary.com/dtlqyvkvu/image/upload/v1691994364/mu9iflbrpl7yu30fbdps.jpg','GIAO_VU','2023-08-14 00:00:00',NULL,1,'Ngôn ngữ học'),(23,'asdas','asdsa','admin2','test52@gmail.com','$2a$10$Ivg2N8pkbexVH64KE.HRo.ybcsD9r8amvPjwfgpSZJNGO7T0g4l.a','1234567899','https://res.cloudinary.com/dtlqyvkvu/image/upload/v1691995108/nljis7ksqq5aixsiksox.jpg','GIAO_VU','2023-08-14 00:00:00',NULL,1,'Nhật ngữ'),(24,'sadasdas','asdsadas','admina','test5a@gmail.com','$2a$10$WxmjaQhHQ8ecZb.9WEH5/eicXnI.f2b.BVMT/Xd8OaB2OAhi5MgB.','1234567896','https://res.cloudinary.com/dtlqyvkvu/image/upload/v1692194358/vq5c6rx9ccejqs7dooxa.png','SINH_VIEN','2023-08-16 00:00:00',1,1,'Nhật ngữ');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vi_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tieu_chi_thuoc_khoa_luan`
--

LOCK TABLES `tieu_chi_thuoc_khoa_luan` WRITE;
/*!40000 ALTER TABLE `tieu_chi_thuoc_khoa_luan` DISABLE KEYS */;
INSERT INTO `tieu_chi_thuoc_khoa_luan` VALUES (1,1,1);
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

-- Dump completed on 2023-08-22 23:44:13
