-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: career_compass_ai
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `resumes`
--

DROP TABLE IF EXISTS `resumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resumes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `uploaded_at` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `resume_text` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKbwy42hdh23n1jypl7y8hna8y7` (`user_id`),
  CONSTRAINT `FK340nuaivxiy99hslr3sdydfvv` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resumes`
--

LOCK TABLES `resumes` WRITE;
/*!40000 ALTER TABLE `resumes` DISABLE KEYS */;
INSERT INTO `resumes` VALUES (2,'DurgaDevi_JavaFullStack_Technical_Resume.pdf','uploads\\DurgaDevi_JavaFullStack_Technical_Resume.pdf','application/pdf','2026-07-22 16:10:51.608498',2,NULL),(3,'DurgaDevi_JavaFullStack_Technical_Resume.pdf','uploads\\DurgaDevi_JavaFullStack_Technical_Resume.pdf','application/pdf','2026-07-22 16:28:20.848245',5,NULL),(4,'DurgaDevi_JavaFullStack_Technical_Resume.pdf','uploads\\DurgaDevi_JavaFullStack_Technical_Resume.pdf','application/pdf','2026-07-23 11:57:47.680063',4,NULL),(6,'DurgaDevi_JavaFullStack_Technical_Resume.pdf','uploads\\DurgaDevi_JavaFullStack_Technical_Resume.pdf','application/pdf','2026-07-25 20:33:58.287442',6,'DURGA DEVI KANDHASAMY \r\nChennai, Tamil Nadu  |  durgadevi96260@gmail.com  |  +91 9626020826  |  GitHub  |  LinkedIn \r\nPROFESSIONAL SUMMARY \r\nB.Tech Information Technology graduate (2025, CGPA 8.00) with hands-on, project-based experience across the Java stack — \r\nSpring Boot, JDBC, JSP/Servlets, MySQL — and front-end development using HTML, CSS, JavaScript, and Bootstrap. Built 4 \r\nfull-stack applications through structured training, covering authentication, CRUD operations, and database-driven workflows. \r\nLooking to start my career as a Java Developer and grow into a full-stack role.  \r\nTECHNICAL SKILLS \r\nLanguages:  Java, HTML5, CSS3, JavaScript, SQL \r\nFrameworks / Libraries:  Spring Boot, JDBC, JSP, Servlets, Bootstrap \r\nDatabase:  MySQL \r\nTools & Practices:  Eclipse, IntelliJ IDEA, VS Code, Git, GitHub, Swagger, SQL Workbench \r\nPROJECTS \r\nBus Booking Management System  (Java, JDBC, MySQL) — TNS India Foundation \r\n•​ Developed a simple Java mini-application to book bus seats, connected to a MySQL database using JDBC \r\n•​ Implemented logic to check seat availability before confirming a booking, preventing duplicate seat assignment \r\n•​ Performed CRUD operations (add, view, update, delete bookings) with basic SQL queries \r\nGitHub: https://github.com/durga2523/Bus-Booking-Management-System_miniproject \r\nReselling Book Management System  (Java, JSP/Servlets, MySQL, HTML, CSS, Bootstrap) — Softlogic Institute \r\n•​ Built a full-stack book reselling web app with user login/signup, book listings, and order management \r\n•​ Implemented server-side logic using JSP and Servlets to handle requests between frontend and database \r\n•​ Integrated MySQL for persistent storage of users, listings, and orders \r\n•​ Designed a responsive UI using HTML, CSS, and Bootstrap for a smooth browsing and ordering experience. \r\nGitHub: https://github.com/durga2523/Reselling-Booking-Management-System \r\nUser Authentication & Authorization System  (Spring Boot, MySQL, HTML, CSS, JS, Bootstrap) — Softlogic Institute \r\n•​ Built a standalone user registration and login system using Spring Boot with backend field validation \r\n•​ Connected frontend forms to backend endpoints for a complete registration-to-login flow \r\n•​ Currently stores credentials as plain text (learning project); next planned step is password hashing (e.g., BCrypt) for \r\nproduction-readiness. \r\nGitHub: https://github.com/durga2523/springboot-registration-demo-intellij \r\nVilla Booking & Portfolio Website  (HTML5, CSS, JavaScript, Bootstrap) — Softlogic Institute \r\n•​ Designed a responsive, mobile-friendly static website for villa booking display and a personal portfolio \r\n•​ Built interactive UI components (navigation, layout sections) using JavaScript and Bootstrap \r\n•​ Focused on cross-device responsiveness and clean UI/UX layout — frontend only, no backend integration. \r\nGitHub: https://github.com/durga2523/SLA_Frontend_NOTES-PROJECTS/tree/main/Main_Project_Boostrap \r\nCERTIFICATIONS \r\n•​ Java Full Stack Development — Softlogic Academy (SLA), Chennai [August/2025] \r\n•​ Core Java, Spring Boot & MySQL — TNS India Foundation, Chennai [January/2025] \r\n•​ Core Java — Smart Skill Institute, Chennai [April/2024r] \r\nEDUCATION \r\nB.Tech, Information Technology — Mohamed Sathak A.J. College of Engineering, Siruseri, Chennai  |  2021 – 2025  |   \r\nCGPA: 8.00 \r\nHSC (Bio-Mathematics) — Oxford Matric Hr. Sec. School, Kallakurichi, Tamil Nadu  |  2020 – 2021  |  89% \r\nSSLC — Oxford Matric Hr. Sec. School, Kallakurichi, Tamil Nadu  |  2018 – 2019  |  89% \r\nACHIEVEMENTS & LEADERSHIP \r\n•​ Best Student Award — 2023 \r\n•​ Department Secretary — Led technical and student initiatives \r\n•​ Event Coordinator — Organized symposiums and cultural programs \r\nSOFT SKILLS & LANGUAGES \r\nSoft Skills: Time Management, Team Collaboration, Adaptability, Problem-Solving, Communication, Continuous Learning \r\nLanguages: Tamil, English \r\n');
/*!40000 ALTER TABLE `resumes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-07-27  9:27:14
