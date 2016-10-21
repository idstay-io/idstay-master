CREATE DATABASE  IF NOT EXISTS `idstay_standalone` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `idstay_standalone`;

DROP TABLE IF EXISTS `housekeeping_history`;
DROP TABLE IF EXISTS `housekeeping_remarks`;
DROP TABLE IF EXISTS `housekeeping`;
DROP TABLE IF EXISTS `crew`;
DROP TABLE IF EXISTS `room`;
DROP TABLE IF EXISTS `room_type`;
DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotel_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for restaurantTable `hotel`
--

LOCK TABLES `hotel` WRITE;
INSERT INTO `hotel` VALUES (1,'MAKERS HOTEL');
UNLOCK TABLES;


CREATE TABLE `room_type` (
  `room_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_type_name` varchar(255) DEFAULT NULL,
  `sort_id` int(11) NOT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`room_type_id`),
  KEY `ROOM_TYPE_FK_01` (`hotel_id`),
  CONSTRAINT `ROOM_TYPE_FK_01` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for restaurantTable `room_type`
--

LOCK TABLES `room_type` WRITE;
INSERT INTO `room_type` VALUES (-1,'NA',-1,1),(1,'MODERN_DOUBLE',1,1),(2,'SEMI_DOUBLE',2,1),(3,'CLASSIC_TWIN',3,1),(4,'DORMITORY_TWIN',4,1),(5,'DORMITORY_TRIPLE',5,1),(6,'MAKERS_SUITE',6,1),(7,'ACCESSIBLE_DOUBLE',7,1);
UNLOCK TABLES;


CREATE TABLE `room` (
  `room_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `floor` int(11) NOT NULL,
  `room_name` varchar(255) DEFAULT NULL,
  `sort_id` int(11) NOT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  `room_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  KEY `ROOM_FK_01` (`hotel_id`),
  KEY `ROOM_FK_02` (`room_type_id`),
  CONSTRAINT `ROOM_FK_02` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`room_type_id`),
  CONSTRAINT `ROOM_FK_01` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

--
-- Dumping data for restaurantTable `room`
--

LOCK TABLES `room` WRITE;
INSERT INTO `room` VALUES (-1,-1,'---',-1,1,-1),(2,3,'301',301,1,1),(3,4,'401',401,1,1),(4,5,'501',501,1,1),(5,6,'601',601,1,1),(6,7,'701',701,1,1),(7,8,'801',801,1,1),(8,9,'901',901,1,1),(9,10,'1001',1001,1,1),(11,2,'203',203,1,2),(12,3,'303',303,1,2),(13,4,'403',403,1,2),(14,5,'503',503,1,2),(15,6,'603',603,1,2),(16,7,'703',703,1,3),(17,8,'803',803,1,2),(18,9,'903',903,1,2),(19,10,'1003',1003,1,2),(21,2,'202',202,1,3),(22,3,'302',302,1,3),(23,4,'402',402,1,3),(24,5,'502',502,1,3),(25,6,'602',602,1,3),(26,7,'702',702,1,3),(27,8,'802',802,1,3),(28,9,'902',902,1,3),(29,10,'1002',1002,1,3),(31,2,'204',204,1,4),(32,3,'304',304,1,4),(33,4,'404',404,1,4),(34,5,'504',504,1,4),(35,6,'604',604,1,4),(36,7,'704',704,1,4),(37,8,'804',804,1,4),(42,3,'305',305,1,5),(43,4,'405',405,1,5),(44,5,'505',505,1,5),(45,6,'605',605,1,5),(46,7,'705',705,1,5),(47,8,'805',805,1,5),(58,9,'904',904,1,6),(59,10,'1004',1004,1,6),(61,2,'205',205,1,7);
UNLOCK TABLES;



CREATE TABLE `crew` (
  `crew_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `call_sign` varchar(255) NOT NULL,
  `language` varchar(255) DEFAULT 'en_US',
  `activate` tinyint(1) DEFAULT '1',
  `hotel_id` bigint(20) NOT NULL,
  `crew_name` varchar(255) NOT NULL,
  `locale` varchar(255) DEFAULT 'en_US',
  PRIMARY KEY (`crew_id`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8;

--
-- Dumping data for restaurantTable `crew`
--

LOCK TABLES `crew` WRITE;
INSERT INTO `crew` VALUES (10,'@ally',NULL,1,1,'@ally','en_US'),(20,'@amy',NULL,1,1,'@amy','en_US'),(30,'@giny',NULL,1,1,'@giny','en_US'),(40,'@jay',NULL,1,1,'@jay','en_US'),(50,'@joe',NULL,1,1,'@joe','en_US'),(60,'@joy',NULL,1,1,'@joy','en_US'),(70,'@julia',NULL,1,1,'@julia','en_US'),(80,'@june',NULL,1,1,'@june','en_US'),(90,'@ken',NULL,1,1,'@ken','en_US'),(100,'@kyle',NULL,1,1,'@kyle','en_US'),(110,'@may',NULL,1,1,'@may','en_US'),(120,'@paula',NULL,1,1,'@paula','en_US'),(121,'@rachel',NULL,1,1,'@rachel','en_US'),(130,'@tg',NULL,1,1,'@tg','en_US'),(135,'@will',NULL,1,1,'@will','en_US'),(138,'ELZA',NULL,1,1,'ELZA','ru_RU'),(140,'EVDOKIA',NULL,1,1,'EVDOKIA','en_US'),(150,'ARINA',NULL,1,1,'ARINA','en_US'),(160,'NINA',NULL,1,1,'NINA','en_US'),(165,'LARISA',NULL,1,1,'LARISA','ru_RU'),(170,'LUDA',NULL,1,1,'LUDA','en_US'),(180,'TALYA',NULL,1,1,'TALYA','ru_RU'),(200,'@lilly',NULL,1,1,'@lilly','en_US'),(201,'@todd',NULL,1,1,'@todd','en_US'),(202,'@jazmin',NULL,1,1,'@jazmin','en_US'),(300,'keeper',NULL,1,1,'keeper','en_US');
UNLOCK TABLES;



CREATE TABLE `housekeeping` (
  `housekeeping_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `reservation_status` varchar(255) DEFAULT NULL,
  `cleaning_status` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `room_status` varchar(255) DEFAULT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL,
  `room_type_id` bigint(20) DEFAULT NULL,
  `sort_id` int(11) DEFAULT NULL,
  `crew_name` varchar(255) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`housekeeping_id`),
  KEY `HOUSEKEEPING_FK_01` (`hotel_id`),
  KEY `HOUSEKEEPING_FK_02` (`room_id`),
  KEY `HOUSEKEEPING_FK_03` (`room_type_id`),
  CONSTRAINT `HOUSEKEEPING_FK_01` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`),
  CONSTRAINT `HOUSEKEEPING_FK_02` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `HOUSEKEEPING_FK_03` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`room_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8;

--
-- Dumping data for restaurantTable `housekeeping`
--

LOCK TABLES `housekeeping` WRITE;
INSERT INTO `housekeeping` VALUES (202,'Checkout_in','Under_cleaning','','Vacant',1,21,3,202,NULL,'2016-10-02 00:08:19'),(203,'Stay','Dirty','','Occupied',1,11,2,203,NULL,'2016-10-01 23:29:41'),(204,'Check_in','Clean','손님 화장실 사용-청소요망','Vacant',1,31,4,204,NULL,'2016-10-02 00:08:23'),(205,'NA','NA','','Out_of_service',1,61,7,205,NULL,'2016-10-01 03:07:39'),(301,'Checkout_in','Request_for_cleaning','','Vacant',1,2,1,301,NULL,'2016-10-01 23:47:28'),(302,'Checkout_in','Request_for_cleaning','','Occupied',1,22,3,302,NULL,'2016-10-01 22:47:06'),(303,'Stay','Dirty','','Occupied',1,12,2,303,NULL,'2016-10-01 23:29:56'),(304,'Stay','Dirty','','Occupied',1,32,4,304,NULL,'2016-10-01 23:30:01'),(305,'Checkout_in','Dirty','','Occupied',1,42,5,305,NULL,'2016-10-01 23:30:10'),(401,'Stay','Dirty','','Occupied',1,3,1,401,NULL,'2016-10-01 23:30:33'),(402,'Stay','Dirty','','Occupied',1,23,3,402,NULL,'2016-10-01 23:30:40'),(403,'Stay','Dirty','','Occupied',1,13,2,403,NULL,'2016-10-01 23:30:45'),(404,'Checkout_in','Dirty','','Occupied',1,33,4,404,NULL,'2016-10-01 23:30:52'),(405,'Check_in','Ready_for_sale','','Vacant',1,43,5,405,NULL,'2016-10-01 16:55:51'),(501,'Stay','Dirty','','Occupied',1,4,1,501,NULL,'2016-10-01 23:31:00'),(502,'Stay','Dirty','','Occupied',1,24,3,502,NULL,'2016-10-01 23:31:04'),(503,'Stay','Dirty','','Occupied',1,14,2,503,NULL,'2016-10-01 23:31:07'),(504,'Checkout_in','Dirty','','Occupied',1,34,4,504,NULL,'2016-10-01 23:31:13'),(505,'Checkout_in','Dirty','','Occupied',1,44,5,505,NULL,'2016-10-01 23:31:19'),(601,'Checkout_in','Dirty','','Occupied',1,5,1,601,NULL,'2016-10-01 23:31:24'),(602,'Stay','Dirty','','Occupied',1,25,3,602,NULL,'2016-10-01 23:31:28'),(603,'Stay','Dirty','','Occupied',1,15,2,603,NULL,'2016-10-01 23:31:32'),(604,'Checkout_in','Under_cleaning','','Occupied',1,35,4,604,NULL,'2016-10-02 00:09:25'),(605,'Stay','Dirty','손님 창문에 빨래 널어 놓으셔서 창문 열어 놓음','Occupied',1,45,5,605,NULL,'2016-10-01 23:31:38'),(701,'Stay','Dirty','','Occupied',1,6,1,701,NULL,'2016-10-01 23:31:49'),(702,'Stay','Dirty','','Occupied',1,26,3,702,NULL,'2016-10-01 23:31:54'),(703,'Stay','Dirty','','Occupied',1,16,2,703,NULL,'2016-10-01 23:32:01'),(704,'Stay','Dirty','','Occupied',1,36,4,704,NULL,'2016-10-01 23:32:05'),(705,'Stay','Dirty','','Occupied',1,46,5,705,NULL,'2016-10-01 23:32:09'),(801,'Stay','Dirty','','Occupied',1,7,1,801,NULL,'2016-10-01 23:32:16'),(802,'Stay','Dirty','','Occupied',1,27,3,802,NULL,'2016-10-01 23:32:21'),(803,'Checkout_in','Dirty','','Occupied',1,17,2,803,NULL,'2016-10-01 23:32:28'),(804,'Stay','Dirty','','Occupied',1,37,4,804,NULL,'2016-10-01 23:32:32'),(805,'Stay','Dirty','904 베개 하나 더 넣어드림(9/29)\r\n문 꽉 닫기!','Occupied',1,47,5,805,NULL,'2016-10-01 23:32:38'),(901,'Stay','Dirty','','Occupied',1,8,1,901,NULL,'2016-10-01 23:32:44'),(902,'Stay','Dirty','','Occupied',1,28,3,902,NULL,'2016-10-01 23:32:48'),(903,'Stay','Dirty','문 꽉 닫기!','Occupied',1,18,2,903,NULL,'2016-10-01 23:32:51'),(904,'Check_in','Ready_for_sale','','Vacant',1,58,6,904,NULL,'2016-10-01 16:58:36'),(1001,'Stay','Dirty','','Occupied',1,9,1,1001,NULL,'2016-10-01 23:33:01'),(1002,'Stay','Dirty','','Occupied',1,29,3,1002,NULL,'2016-10-01 23:33:05'),(1003,'Stay','Dirty','담배냄새 계속 탈취 필요(10/1)\r\n','Occupied',1,19,2,1003,NULL,'2016-10-01 23:33:09'),(1004,'Check_out','Dirty','','Occupied',1,59,6,1004,NULL,'2016-10-01 23:32:57');
UNLOCK TABLES;




CREATE TABLE `housekeeping_remarks` (
  `remark_id` bigint(20) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  KEY `HOUSEKEEPING_REMARKS_FK_01` (`remark_id`),
  CONSTRAINT `HOUSEKEEPING_REMARKS_FK_01` FOREIGN KEY (`remark_id`) REFERENCES `housekeeping` (`housekeeping_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for restaurantTable `housekeeping_remarks`
--

LOCK TABLES `housekeeping_remarks` WRITE;
INSERT INTO `housekeeping_remarks` VALUES (404,'Air_cleaner'),(504,'Air_cleaner'),(704,'Double_bed'),(801,'Topper'),(804,'Double_bed'),(805,'Pillow'),(1001,'Topper'),(1003,'Bad_smell');
UNLOCK TABLES;


CREATE TABLE `housekeeping_history` (
  `housekeepinghistory_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `housekeeping_id` bigint(20) DEFAULT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  `hotel_name` varchar(255) DEFAULT NULL,
  `room_type_id` bigint(20) DEFAULT NULL,
  `room_type_name` varchar(255) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL,
  `room_name` varchar(255) DEFAULT NULL,
  `room_status` varchar(255) DEFAULT NULL,
  `cleaning_status` varchar(255) DEFAULT NULL,
  `last_update_crew_name` varchar(255) DEFAULT NULL,
  `last_update_crew_id` bigint(20) DEFAULT NULL,
  `memo` varchar(1000) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `housekeeping_remarks` varchar(255) DEFAULT NULL,
  `crew_id` bigint(20) DEFAULT NULL,
  `call_sign` varchar(255) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  PRIMARY KEY (`housekeepinghistory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10128 DEFAULT CHARSET=utf8;


LOCK TABLES `housekeeping_history` WRITE;
INSERT INTO `housekeeping_history` VALUES (10101,602,1,'MAKERS HOTEL',3,'CLASSIC_TWIN',25,'602','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:31:28'),(10102,603,1,'MAKERS HOTEL',2,'SEMI_DOUBLE',15,'603','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:31:32'),(10103,605,1,'MAKERS HOTEL',5,'DORMITORY_TRIPLE',45,'605','Occupied','Dirty','@amy',20,'손님 창문에 빨래 널어 놓으셔서 창문 열어 놓음',NULL,NULL,NULL,NULL,'2016-10-01 23:31:38'),(10104,701,1,'MAKERS HOTEL',1,'MODERN_DOUBLE',6,'701','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:31:49'),(10105,702,1,'MAKERS HOTEL',3,'CLASSIC_TWIN',26,'702','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:31:54'),(10106,703,1,'MAKERS HOTEL',2,'SEMI_DOUBLE',16,'703','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:32:01'),(10107,704,1,'MAKERS HOTEL',4,'DORMITORY_TWIN',36,'704','Occupied','Dirty','@amy',20,'','Double_bed|',NULL,NULL,NULL,'2016-10-01 23:32:05'),(10108,705,1,'MAKERS HOTEL',5,'DORMITORY_TRIPLE',46,'705','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:32:09'),(10109,801,1,'MAKERS HOTEL',1,'MODERN_DOUBLE',7,'801','Occupied','Dirty','@amy',20,'','Topper|',NULL,NULL,NULL,'2016-10-01 23:32:16'),(10110,802,1,'MAKERS HOTEL',3,'CLASSIC_TWIN',27,'802','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:32:21'),(10111,803,1,'MAKERS HOTEL',2,'SEMI_DOUBLE',17,'803','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:32:28'),(10112,804,1,'MAKERS HOTEL',4,'DORMITORY_TWIN',37,'804','Occupied','Dirty','@amy',20,'','Double_bed|',NULL,NULL,NULL,'2016-10-01 23:32:32'),(10113,805,1,'MAKERS HOTEL',5,'DORMITORY_TRIPLE',47,'805','Occupied','Dirty','@amy',20,'904 베개 하나 더 넣어드림(9/29)\r\n문 꽉 닫기!','Pillow|',NULL,NULL,NULL,'2016-10-01 23:32:38'),(10114,901,1,'MAKERS HOTEL',1,'MODERN_DOUBLE',8,'901','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:32:44'),(10115,902,1,'MAKERS HOTEL',3,'CLASSIC_TWIN',28,'902','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:32:48'),(10116,903,1,'MAKERS HOTEL',2,'SEMI_DOUBLE',18,'903','Occupied','Dirty','@amy',20,'문 꽉 닫기!',NULL,NULL,NULL,NULL,'2016-10-01 23:32:51'),(10117,1004,1,'MAKERS HOTEL',6,'MAKERS_SUITE',59,'1004','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:32:57'),(10118,1001,1,'MAKERS HOTEL',1,'MODERN_DOUBLE',9,'1001','Occupied','Dirty','@amy',20,'','Topper|',NULL,NULL,NULL,'2016-10-01 23:33:01'),(10119,1002,1,'MAKERS HOTEL',3,'CLASSIC_TWIN',29,'1002','Occupied','Dirty','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:33:05'),(10120,1003,1,'MAKERS HOTEL',2,'SEMI_DOUBLE',19,'1003','Occupied','Dirty','@amy',20,'담배냄새 계속 탈취 필요(10/1)\r\n','Bad_smell|',NULL,NULL,NULL,'2016-10-01 23:33:09'),(10121,301,1,'MAKERS HOTEL',1,'MODERN_DOUBLE',2,'301','Vacant','Request_for_cleaning','@ally',10,'',NULL,NULL,NULL,NULL,'2016-10-01 23:46:41'),(10122,301,1,'MAKERS HOTEL',1,'MODERN_DOUBLE',2,'301','Vacant','Request_for_cleaning','@ally',10,'',NULL,NULL,NULL,NULL,'2016-10-01 23:47:28'),(10123,202,1,'MAKERS HOTEL',3,'CLASSIC_TWIN',21,'202','Vacant','Request_for_cleaning','@amy',20,'',NULL,NULL,NULL,NULL,'2016-10-01 23:54:34'),(10124,204,1,'MAKERS HOTEL',4,'DORMITORY_TWIN',31,'204','Vacant','Under_cleaning','@ally',10,'손님 화장실 사용-청소요망',NULL,NULL,NULL,NULL,'2016-10-02 00:07:02'),(10125,202,1,'MAKERS HOTEL',3,'CLASSIC_TWIN',21,'202','Vacant','Under_cleaning','@ally',10,'',NULL,NULL,NULL,NULL,'2016-10-02 00:08:19'),(10126,204,1,'MAKERS HOTEL',4,'DORMITORY_TWIN',31,'204','Vacant','Clean','@ally',10,'손님 화장실 사용-청소요망',NULL,NULL,NULL,NULL,'2016-10-02 00:08:23'),(10127,604,1,'MAKERS HOTEL',4,'DORMITORY_TWIN',35,'604','Occupied','Under_cleaning','@ally',10,'',NULL,NULL,NULL,NULL,'2016-10-02 00:09:25');
UNLOCK TABLES;

select * from housekeeping_history;
