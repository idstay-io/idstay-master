-- -----------------------------------------------------
-- HOTEL
-- -----------------------------------------------------
CREATE TABLE hotel (
  hotel_id bigint(20) NOT NULL AUTO_INCREMENT,
  hotel_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (hotel_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- room_type
-- -----------------------------------------------------

CREATE TABLE room_type (
  room_type_id bigint(20) NOT NULL AUTO_INCREMENT,
  room_type_name varchar(255) DEFAULT NULL,
  sort_id int(11) NOT NULL,
  hotel_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (room_type_id),
  KEY ROOM_TYPE_FK_01 (hotel_id),
  CONSTRAINT ROOM_TYPE_FK_01 FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- -----------------------------------------------------
-- room
-- -----------------------------------------------------
CREATE TABLE room (
  room_id bigint(20) NOT NULL AUTO_INCREMENT,
  floor int(11) NOT NULL,
  room_name varchar(255) DEFAULT NULL,
  sort_id int(11) NOT NULL,
  hotel_id bigint(20) DEFAULT NULL,
  room_type_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (room_id),
  KEY ROOM_FK_01 (hotel_id),
  KEY ROOM_FK_02 (room_type_id),
  CONSTRAINT ROOM_FK_02 FOREIGN KEY (room_type_id) REFERENCES room_type (room_type_id),
  CONSTRAINT ROOM_FK_01 FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- housekeeping
-- -----------------------------------------------------
CREATE TABLE housekeeping (
  housekeeping_id bigint(20) NOT NULL AUTO_INCREMENT,
  reservation_status varchar(255) DEFAULT NULL,
  room_status varchar(255) DEFAULT NULL,
  cleaning_status varchar(255) DEFAULT NULL,
  memo varchar(1000) DEFAULT NULL,
  hotel_id bigint(20) DEFAULT NULL,
  room_id bigint(20) DEFAULT NULL,
  room_type_id bigint(20) DEFAULT NULL,
  sort_id int(11) DEFAULT NULL,
  crew_name varchar(255) DEFAULT NULL,
  last_update DATETIME DEFAULT NULL,
  PRIMARY KEY (housekeeping_id),
  KEY HOUSEKEEPING_FK_01 (hotel_id),
  KEY HOUSEKEEPING_FK_02 (room_id),
  KEY HOUSEKEEPING_FK_03 (room_type_id),
  CONSTRAINT HOUSEKEEPING_FK_03 FOREIGN KEY (room_type_id) REFERENCES room_type (room_type_id),
  CONSTRAINT HOUSEKEEPING_FK_02 FOREIGN KEY (room_id) REFERENCES room (room_id),
  CONSTRAINT HOUSEKEEPING_FK_01 FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- -----------------------------------------------------
-- housekeeping_remarks
-- -----------------------------------------------------
CREATE TABLE housekeeping_remarks (
  remark_id bigint(20) NOT NULL,
  remarks varchar(255) DEFAULT NULL,
  KEY HOUSEKEEPING_REMARKS_FK_01 (remark_id),
  CONSTRAINT HOUSEKEEPING_REMARKS_FK_01 FOREIGN KEY (remark_id) REFERENCES housekeeping (housekeeping_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- CREW
-- -----------------------------------------------------

CREATE TABLE crew (
  crew_id bigint(20) NOT NULL AUTO_INCREMENT,
  hotel_id bigint(20) NOT NULL,
  crew_name varchar(255) NOT NULL,
  locale  varchar(255) DEFAULT 'en_US',
  activate  boolean DEFAULT true,
  PRIMARY KEY (crew_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- housekeeping_history
-- -----------------------------------------------------
CREATE TABLE housekeeping_history (
  housekeepinghistory_id bigint(20) NOT NULL AUTO_INCREMENT,
  housekeeping_id bigint(20) DEFAULT NULL,
  hotel_id bigint(20) DEFAULT NULL,
  hotel_name varchar(255) DEFAULT NULL,
  room_type_id bigint(20) DEFAULT NULL,
  room_type_name varchar(255) DEFAULT NULL,
  room_id bigint(20) DEFAULT NULL,
  room_name varchar(255) DEFAULT NULL,
  room_status varchar(255) DEFAULT NULL,
  cleaning_status varchar(255) DEFAULT NULL,
  remarks varchar(255) DEFAULT NULL,
  memo varchar(1000) DEFAULT NULL,
  last_update_crew_id bigint(20) DEFAULT NULL,
  last_update_crew_name varchar(255) DEFAULT NULL,
  last_update DATETIME DEFAULT NULL,
  PRIMARY KEY (housekeepinghistory_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE hotel_guest (
  hotel_guest_id bigint(20) NOT NULL AUTO_INCREMENT,
  guest_name varchar(255) NOT NULL,
  first_name varchar(255) NULL,
  last_name varchar(255) NULL,
  email varchar(255) NULL,
  PRIMARY KEY (hotel_guest_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `room_occupancy` (
  `room_occupancy_id` bigint(20) NOT NULL,
  `fromDate` date DEFAULT NULL,
  `toDate` date DEFAULT NULL,
  `hotel_guest_id` bigint(20) DEFAULT NULL,
  `room_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`room_occupancy_id`),
  KEY `ROOM_OCCUPANCY_FK_01` (`hotel_guest_id`),
  KEY `ROOM_OCCUPANCY_FK_02` (`room_id`),
  CONSTRAINT `ROOM_OCCUPANCY_FK_01` FOREIGN KEY (`hotel_guest_id`) REFERENCES `hotel_guest` (`hotel_guest_id`),
  CONSTRAINT `ROOM_OCCUPANCY_FK_02` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `hotel_guest_use` (
  `hotel_guest_use_id` bigint(20) NOT NULL,
  `hotel_guest_id` bigint(20) DEFAULT NULL,
  `room_occupancy_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`hotel_guest_use_id`),
  KEY `HOTEL_GUEST_USE_FK_01` (`hotel_guest_id`),
  KEY `HOTEL_GUEST_USE_FK_02` (`room_occupancy_id`),
  CONSTRAINT `HOTEL_GUEST_USE_FK_01` FOREIGN KEY (`hotel_guest_id`) REFERENCES `hotel_guest` (`hotel_guest_id`),
  CONSTRAINT `HOTEL_GUEST_USE_FK_02` FOREIGN KEY (`room_occupancy_id`) REFERENCES `room_occupancy` (`room_occupancy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
