USE `nav_db` ;
SET autocommit = OFF;

-- -----------------------------------------------------
-- Table `nav_db`.`CITIES`
-- -----------------------------------------------------

INSERT INTO nav_db.CITIES (NAME) VALUES
  ('NYC'),
  ('New Jersey');

-- -----------------------------------------------------
-- Table `nav_db`.`STATIONS`
-- -----------------------------------------------------

INSERT INTO nav_db.STATIONS (NAME, CITY_ID, ADDRESS) VALUES
  ('A', 1, 'address a'), -- 1
  ('B', 1, 'address b'), -- 2
  ('C', 1, 'address c'), -- 3
  ('D', 1, 'address d'), -- 4
  ('E', 1, 'address e'), -- 5
  ('F', 1, 'address f'), -- 6
  ('G', 1, 'address g'), -- 7
  ('H', 1, 'address h'), -- 8
  ('I', 2, 'address i'), -- 9
  ('J', 2, 'address j'), -- 10
  ('K', 2, 'address k'); -- 11

-- -----------------------------------------------------
-- Table `nav_db`.`PATHS`
-- -----------------------------------------------------

INSERT INTO nav_db.PATHS (ORIGIN_ID, DESTINY_ID) VALUES
  (1, 2), -- 1 a b
  (1, 8), -- 2 a h
  (2, 3), -- 3 b c
  (3, 4), -- 4 c d
  (4, 5), -- 5 d e
  (4, 9), -- 6 d i
  (5, 6), -- 7 e f
  (5, 8), -- 8 e h
  (6, 7), -- 9 f g
  (6, 8), -- 10 f h
  (7, 8), -- 11 g h
  (9, 10), -- 12 i j
  (9, 11), -- 13 i k
  (10, 11); -- 14 j k
  
-- -----------------------------------------------------
-- Table `nav_db`.`TRANSPORTS`
-- -----------------------------------------------------  

START TRANSACTION;
INSERT INTO nav_db.TRANSPORTS (WEIGHT, MODEL, NAME, TRANSPORT_TYPE) VALUES
  (10000, '', 'GREEN TRAIN', 2), -- 1
  (5000, '', 'ORANGE TRAIN', 2), -- 2
  (8000, '', 'BROWN TRAIN', 2), -- 3
  (2000, '', 'BLUE BUS', 3), -- 4
  (3000, '', 'RED BUS', 3), -- 5
  (4000, '', 'PINK BUS', 3), -- 6
  (1000, '', 'TAXI', 1); -- 7

INSERT INTO nav_db.TRAINS (ID, WAGONS_AMOUNT)
VALUES
  (1, 8),
  (2, 7),
  (3, 8);

INSERT INTO nav_db.BUSES (ID, LINE)
VALUES
  (4, 'LINE 4'),
  (5, 'LINE 5'),
  (6, 'LINE 6');
  
INSERT INTO nav_db.TAXIS (ID, COMPANY)
VALUES
  (7, 'UBER');
  
COMMIT;

-- -----------------------------------------------------
-- Table `nav_db`.`PATH_has_TRANSPORTS`
-- -----------------------------------------------------
INSERT INTO nav_db.PATH_has_TRANSPORTS (PATH_ID, TRANSPORT_ID)
VALUES
  (1, 1),  -- 1
  (2, 1),  -- 2
  (3, 1),  -- 3
  (4, 2),  -- 4
  (4, 4),  -- 5
  (5, 1),  -- 6
  (6, 2),  -- 7
  (6, 4),  -- 8
  (7, 4),  -- 9
  (8, 1),  -- 10
  (9, 4),  -- 11
  (10, 5), -- 12
  (11, 4), -- 13
  (12, 6), -- 14
  (13, 1), -- 15
  (13, 4), -- 16
  (14, 3); -- 17

