CREATE DATABASE  IF NOT EXISTS idstay;
USE idstay;

-- -----------------------------------------------------
-- DROP ALL Table --------------------------------------
-- -----------------------------------------------------

DROP TABLE IF EXISTS crew;
DROP TABLE IF EXISTS room_dirty;
DROP TABLE IF EXISTS housekeeping_history;
DROP TABLE IF EXISTS housekeeping_remarks;
DROP TABLE IF EXISTS housekeeping;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS room_type;
DROP TABLE IF EXISTS hotel;

-- -----------------------------------------------------
-- HOTEL
-- -----------------------------------------------------
DROP TABLE IF EXISTS hotel;
CREATE TABLE hotel (
  hotel_id bigint(20) NOT NULL AUTO_INCREMENT,
  hotel_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (hotel_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES hotel WRITE;
INSERT INTO hotel VALUES(1,'MAKERS HOTEL');
UNLOCK TABLES;

-- -----------------------------------------------------
-- room_type
-- -----------------------------------------------------

DROP TABLE IF EXISTS room_type;
CREATE TABLE room_type (
  room_type_id bigint(20) NOT NULL AUTO_INCREMENT,
  room_type_name varchar(255) DEFAULT NULL,
  sort_id int(11) NOT NULL,
  hotel_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (room_type_id),
  KEY ROOM_TYPE_FK_01 (hotel_id),
  CONSTRAINT ROOM_TYPE_FK_01 FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

LOCK TABLES room_type WRITE;
INSERT INTO room_type VALUES(1, 'MODERN_DOUBLE',              1,1);
INSERT INTO room_type VALUES(2, 'SEMI_DOUBLE',                2,1);
INSERT INTO room_type VALUES(3, 'CLASSIC_TWIN',               3,1);
INSERT INTO room_type VALUES(4, 'DORMITORY_TWIN',             4,1);
INSERT INTO room_type VALUES(5, 'DORMITORY_TRIPLE',            5,1);
INSERT INTO room_type VALUES(6, 'MAKERS_SUITE',               6,1);
INSERT INTO room_type VALUES(7, 'ACCESSIBLE_DOUBLE',          7,1);
INSERT INTO room_type VALUES(-1, 'NA',                      -1,1);
UNLOCK TABLES;
;

-- -----------------------------------------------------
-- room
-- -----------------------------------------------------
DROP TABLE IF EXISTS room;
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

LOCK TABLES room WRITE;
-- modern double
INSERT INTO room VALUES( 2,   3,  '301',  301,  1, 1);
INSERT INTO room VALUES( 3,   4,  '401',  401,  1, 1);
INSERT INTO room VALUES( 4,   5,  '501',  501,  1, 1);
INSERT INTO room VALUES( 5,   6,  '601',  601,  1, 1);
INSERT INTO room VALUES( 6,   7,  '701',  701,  1, 1);
INSERT INTO room VALUES( 7,   8,  '801',  801,  1, 1);
INSERT INTO room VALUES( 8,   9,  '901',  901,  1, 1);
INSERT INTO room VALUES( 9,  10, '1001', 1001,  1, 1);

-- semi double
INSERT INTO room VALUES(11,   2,  '203',  203,  1, 2);
INSERT INTO room VALUES(12,   3,  '303',  303,  1, 2);
INSERT INTO room VALUES(13,   4,  '403',  403,  1, 2);
INSERT INTO room VALUES(14,   5,  '503',  503,  1, 2);
INSERT INTO room VALUES(15,   6,  '603',  603,  1, 2);
INSERT INTO room VALUES(16,   7,  '703',  703,  1, 3);
INSERT INTO room VALUES(17,   8,  '803',  803,  1, 2);
INSERT INTO room VALUES(18,   9,  '903',  903,  1, 2);
INSERT INTO room VALUES(19,  10, '1003', 1003,  1, 2);

-- classic twin
INSERT INTO room VALUES(21,   2,  '202',  202,  1, 3);
INSERT INTO room VALUES(22,   3,  '302',  302,  1, 3);
INSERT INTO room VALUES(23,   4,  '402',  402,  1, 3);
INSERT INTO room VALUES(24,   5,  '502',  502,  1, 3);
INSERT INTO room VALUES(25,   6,  '602',  602,  1, 3);
INSERT INTO room VALUES(26,   7,  '702',  702,  1, 3);
INSERT INTO room VALUES(27,   8,  '802',  802,  1, 3);
INSERT INTO room VALUES(28,   9,  '902',  902,  1, 3);
INSERT INTO room VALUES(29,  10, '1002', 1002,  1, 3);

-- domitory twin
INSERT INTO room VALUES(31,   2,  '204',  204,  1, 4);
INSERT INTO room VALUES(32,   3,  '304',  304,  1, 4);
INSERT INTO room VALUES(33,   4,  '404',  404,  1, 4);
INSERT INTO room VALUES(34,   5,  '504',  504,  1, 4);
INSERT INTO room VALUES(35,   6,  '604',  604,  1, 4);
INSERT INTO room VALUES(36,   7,  '704',  704,  1, 4);
INSERT INTO room VALUES(37,   8,  '804',  804,  1, 4);

-- domitory triple
INSERT INTO room VALUES(42,   3,  '305',  305,  1, 5);
INSERT INTO room VALUES(43,   4,  '405',  405,  1, 5);
INSERT INTO room VALUES(44,   5,  '505',  505,  1, 5);
INSERT INTO room VALUES(45,   6,  '605',  605,  1, 5);
INSERT INTO room VALUES(46,   7,  '705',  705,  1, 5);
INSERT INTO room VALUES(47,   8,  '805',  805,  1, 5);

-- makers suite
INSERT INTO room VALUES(58,   9,  '904',  904,  1, 6);
INSERT INTO room VALUES(59,  10, '1004', 1004,  1, 6);

-- accesible double
INSERT INTO room VALUES(61,   2,  '205',  205,  1, 7);

INSERT INTO room VALUES(-1,  -1,  '---',  -1,  1, -1);

UNLOCK TABLES;

-- -----------------------------------------------------
-- housekeeping
-- -----------------------------------------------------
DROP TABLE IF EXISTS housekeeping;
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


LOCK TABLES housekeeping WRITE;
INSERT INTO housekeeping VALUES(202, 'NA', 'Vacant', 'NA', null, 1, 21, 3, 202, null, now());
INSERT INTO housekeeping VALUES(203, 'NA', 'Vacant', 'NA', null, 1, 11, 2, 203, null, now());
INSERT INTO housekeeping VALUES(204, 'NA', 'Vacant', 'NA', null, 1, 31, 4, 204, null, now());
INSERT INTO housekeeping VALUES(205, 'NA', 'Vacant', 'NA', null,  1, 61, 7, 205, null, now());
INSERT INTO housekeeping VALUES(301, 'NA', 'Vacant', 'NA', null,  1, 2, 1,  301, null, now());
INSERT INTO housekeeping VALUES(302, 'NA', 'Vacant', 'NA', null,  1, 22, 3, 302, null, now());
INSERT INTO housekeeping VALUES(303, 'NA', 'Vacant', 'NA', null,  1, 12, 2, 303, null, now());
INSERT INTO housekeeping VALUES(304, 'NA', 'Vacant', 'NA', null,  1, 32, 4, 304, null, now());
INSERT INTO housekeeping VALUES(305, 'NA', 'Vacant', 'NA', null,  1, 42, 5, 305, null, now());
INSERT INTO housekeeping VALUES(401, 'NA', 'Vacant', 'NA', null,  1, 3, 1, 401, null, now());
INSERT INTO housekeeping VALUES(402, 'NA', 'Vacant', 'NA', null,  1, 23, 3, 402, null, now());
INSERT INTO housekeeping VALUES(403, 'NA', 'Vacant', 'NA', null,  1, 13, 2, 403, null, now());
INSERT INTO housekeeping VALUES(404, 'NA', 'Vacant', 'NA', null,  1, 33, 4, 404, null, now());
INSERT INTO housekeeping VALUES(405, 'NA', 'Vacant', 'NA', null,  1, 43, 5, 405, null, now());
INSERT INTO housekeeping VALUES(501, 'NA', 'Vacant', 'NA', null,  1, 4, 1, 501, null, now());
INSERT INTO housekeeping VALUES(502, 'NA', 'Vacant', 'NA', null,  1, 24, 3, 502, null, now());
INSERT INTO housekeeping VALUES(503, 'NA', 'Vacant', 'NA', null,  1, 14, 2, 503, null, now());
INSERT INTO housekeeping VALUES(504, 'NA', 'Vacant', 'NA', null,  1, 34, 4, 504, null, now());
INSERT INTO housekeeping VALUES(505, 'NA', 'Vacant', 'NA', null,  1, 44, 5, 505, null, now());
INSERT INTO housekeeping VALUES(601, 'NA', 'Vacant', 'NA', null,  1, 5, 1, 601, null, now());
INSERT INTO housekeeping VALUES(602, 'NA', 'Vacant', 'NA', null,  1, 25, 3, 602, null, now());
INSERT INTO housekeeping VALUES(603, 'NA', 'Vacant', 'NA', null,  1, 15, 2, 603, null, now());
INSERT INTO housekeeping VALUES(604, 'NA', 'Vacant', 'NA', null,  1, 35, 4, 604, null, now());
INSERT INTO housekeeping VALUES(605, 'NA', 'Vacant', 'NA', null,  1, 45, 5, 605, null, now());
INSERT INTO housekeeping VALUES(701, 'NA', 'Vacant', 'NA', null,  1, 6, 1, 701, null, now());
INSERT INTO housekeeping VALUES(702, 'NA', 'Vacant', 'NA', null,  1, 26, 3, 702, null, now());
INSERT INTO housekeeping VALUES(703, 'NA', 'Vacant', 'NA', null,  1, 16, 2, 703, null, now());
INSERT INTO housekeeping VALUES(704, 'NA', 'Vacant', 'NA', null,  1, 36, 4, 704, null, now());
INSERT INTO housekeeping VALUES(705, 'NA', 'Vacant', 'NA', null,  1, 46, 5, 705, null, now());
INSERT INTO housekeeping VALUES(801, 'NA', 'Vacant', 'NA', null,  1, 7, 1, 801, null, now());
INSERT INTO housekeeping VALUES(802, 'NA', 'Vacant', 'NA', null,  1, 27, 3, 802, null, now());
INSERT INTO housekeeping VALUES(803, 'NA', 'Vacant', 'NA', null,  1, 17, 2, 803, null, now());
INSERT INTO housekeeping VALUES(804, 'NA', 'Vacant', 'NA', null,  1, 37, 4, 804, null, now());
INSERT INTO housekeeping VALUES(805, 'NA', 'Vacant', 'NA', null,  1, 47, 5, 805, null, now());
INSERT INTO housekeeping VALUES(901, 'NA', 'Vacant', 'NA', null,  1, 8, 1, 901, null, now());
INSERT INTO housekeeping VALUES(902, 'NA', 'Vacant', 'NA', null,  1, 28, 3, 902, null, now());
INSERT INTO housekeeping VALUES(903, 'NA', 'Vacant', 'NA', null,  1, 18, 2, 903, null, now());
INSERT INTO housekeeping VALUES(904, 'NA', 'Vacant', 'NA', null,  1, 58, 6, 904, null, now());
INSERT INTO housekeeping VALUES(1001, 'NA', 'Vacant', 'NA', null,  1, 9, 1, 1001, null, now());
INSERT INTO housekeeping VALUES(1002, 'NA', 'Vacant', 'NA', null,  1, 29, 3, 1002, null, now());
INSERT INTO housekeeping VALUES(1003, 'NA', 'Vacant', 'NA', null,  1, 19, 2, 1003, null, now());
INSERT INTO housekeeping VALUES(1004, 'NA', 'Vacant', 'NA', null,  1, 59, 6, 1004, null, now());
UNLOCK TABLES;

-- -----------------------------------------------------
-- housekeeping_remarks
-- -----------------------------------------------------
DROP TABLE IF EXISTS housekeeping_remarks;
CREATE TABLE housekeeping_remarks (
  remark_id bigint(20) NOT NULL,
  remarks varchar(255) DEFAULT NULL,
  KEY HOUSEKEEPING_REMARKS_FK_01 (remark_id),
  CONSTRAINT HOUSEKEEPING_REMARKS_FK_01 FOREIGN KEY (remark_id) REFERENCES housekeeping (housekeeping_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- CREW
-- -----------------------------------------------------

DROP TABLE IF EXISTS crew;
CREATE TABLE crew (
  crew_id bigint(20) NOT NULL AUTO_INCREMENT,
  hotel_id bigint(20) NOT NULL,
  crew_name varchar(255) NOT NULL,
  locale  varchar(255) DEFAULT 'en_US',
  activate  boolean DEFAULT true,
  PRIMARY KEY (crew_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

;
LOCK TABLES crew WRITE;
INSERT INTO crew VALUES(10, 1, '@ally', 'en_US', true);
INSERT INTO crew VALUES(20, 1,  '@amy', 'en_US', true);
INSERT INTO crew VALUES(30, 1,  '@giny', 'en_US', true);
INSERT INTO crew VALUES(40, 1,  '@jay', 'en_US', true);
INSERT INTO crew VALUES(50, 1,  '@joe', 'en_US', true);
INSERT INTO crew VALUES(60, 1,  '@joy', 'en_US', true);
INSERT INTO crew VALUES(70, 1,  '@julia', 'en_US', true);
INSERT INTO crew VALUES(80, 1,  '@june', 'en_US', true);
INSERT INTO crew VALUES(90, 1,  '@ken', 'en_US', true);
INSERT INTO crew VALUES(100, 1,  '@kyle', 'en_US', true);
INSERT INTO crew VALUES(110, 1,  '@may', 'en_US', true);
INSERT INTO crew VALUES(120, 1,  '@paula', 'en_US', true);
INSERT INTO crew VALUES(130, 1,  '@tg', 'en_US', true);
INSERT INTO crew VALUES(135, 1,  '@will', 'en_US', true);
INSERT INTO crew VALUES(140, 1,  'EVDOKIA', 'ru_RU', true);
INSERT INTO crew VALUES(150, 1,  'ARINA', 'ru_RU', true);
INSERT INTO crew VALUES(160, 1,  'NINA', 'ru_RU', true);
INSERT INTO crew VALUES(170, 1,  'LUDA', 'ru_RU', true);
UNLOCK TABLES;

-- -----------------------------------------------------
-- housekeeping_history
-- -----------------------------------------------------
DROP TABLE IF EXISTS housekeeping_history;
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

-- -----------------------------------------------------
-- housekeeping_history
-- -----------------------------------------------------
update housekeeping
set reservation_status = 'NA',
    room_status = 'Vacant',
    cleaning_status = 'NA'
where housekeeping_id > -1;
