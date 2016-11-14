DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `booking_type` varchar(31) NOT NULL,
  `booking_id` varchar(255) NOT NULL,
  `guest_profile_id` bigint(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL,
  `adults` int(11) NOT NULL,
  `children` int(11) NOT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `foo` varchar(255) DEFAULT NULL,
  `reservation_channel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `entity_sequences`;
CREATE TABLE `entity_sequences` (
  `entity_sequence_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sequence_int` bigint(20) DEFAULT NULL,
  `sequence_interval` bigint(20) DEFAULT NULL,
  `sequence_max` bigint(20) DEFAULT NULL,
  `entity_name` varchar(255) DEFAULT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`entity_sequence_id`),
  UNIQUE KEY `UK_hantgj35pgs5dn4yagma7dhu0` (`entity_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `facility_booking`;
CREATE TABLE `facility_booking` (
  `facility_booking_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `booking_date` varchar(255) DEFAULT NULL,
  `from_time` time DEFAULT NULL,
  `guest` varchar(255) DEFAULT NULL,
  `hotel_facility_id` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `payed_by` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `to_time` time DEFAULT NULL,
  PRIMARY KEY (`facility_booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `hotel_facility`;
CREATE TABLE `hotel_facility` (
  `hotel_facility_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hotel_facility_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hotel_facility_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `hotel_guest_profile`;
CREATE TABLE `hotel_guest_profile` (
  `hotel_guest_profile_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `guest_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hotel_guest_profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `hotel_guest_profile` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `payment_line`;
CREATE TABLE `payment_line` (
  `payment_line_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currancy` varchar(255) DEFAULT NULL,
  `value` bigint(20) DEFAULT NULL,
  `payment_methods` varchar(255) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`payment_line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




DROP TABLE IF EXISTS `restaurant_booking`;
CREATE TABLE `restaurant_booking` (
  `restaurant_booking_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `booking_date` varchar(255) DEFAULT NULL,
  `from_time` time DEFAULT NULL,
  `guest` varchar(255) DEFAULT NULL,
  `hotel_facility_id` bigint(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `payed_by` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `to_time` time DEFAULT NULL,
  PRIMARY KEY (`restaurant_booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `restarant_booking_tables`;
CREATE TABLE `restarant_booking_tables` (
  `table_id` bigint(20) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  KEY `FKaagxduwnnv7s3ipnselpwnnr5` (`table_id`),
  CONSTRAINT `FKaagxduwnnv7s3ipnselpwnnr5` FOREIGN KEY (`table_id`) REFERENCES `restaurant_booking` (`restaurant_booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `restaurant_booking_tables`;
CREATE TABLE `restaurant_booking_tables` (
  `table_id` bigint(20) NOT NULL,
  `tables` varchar(255) DEFAULT NULL,
  KEY `FK_` (`table_id`),
  CONSTRAINT `RESTAURANT_BOOKING_TABLES_FK_01` FOREIGN KEY (`table_id`) REFERENCES `restaurant_booking` (`restaurant_booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `stay`;
CREATE TABLE `stay` (
  `stay_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `booking_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stay_id`),
  KEY `FK3qg08nngxwx8b6vtkrn7nwfv` (`booking_id`),
  CONSTRAINT `FK3qg08nngxwx8b6vtkrn7nwfv` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `stay_line`;
CREATE TABLE `stay_line` (
  `stay_line_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_id` bigint(20) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `stay_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`stay_line_id`),
  KEY `FK7yqempbfoe50l9hqnbap5br90` (`stay_id`),
  CONSTRAINT `FK7yqempbfoe50l9hqnbap5br90` FOREIGN KEY (`stay_id`) REFERENCES `stay` (`stay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;