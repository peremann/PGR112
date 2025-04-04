-- Opprett databasen
DROP DATABASE IF EXISTS brettspill;
CREATE DATABASE brettspill;

-- Bruk databasen
USE brettspill;

-- Opprett tabellen
CREATE TABLE brettspill (
    brettspill_id INT AUTO_INCREMENT PRIMARY KEY,
    navn VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    antall_spillere INT NOT NULL,
    spilletid INT NOT NULL,
    aldersgrense INT NOT NULL,
    bilde VARCHAR(255)
);

DELIMITER $$
CREATE PROCEDURE `addBoardGame`(IN navn TEXT, IN type TEXT,
		IN antall_spillere INT, IN spilletid INT, IN aldersgrense INT, IN bilde TEXT, OUT generatedId INT)
BEGIN
         INSERT INTO brettspill (navn, type, antall_spillere, spilletid, aldersgrense, bilde)
         VALUES (navn, type, antall_spillere, spilletid, aldersgrense, bilde);
         COMMIT;
         SET generatedId = LAST_INSERT_ID();
       END$$
DELIMITER ;

-- Setter inn 5 rader med data
INSERT INTO brettspill (navn, type, antall_spillere, spilletid, aldersgrense, bilde) VALUES
('Monopol', 'Strategi', 2, 120, 8, 'monopol.jpg'),
('Trivial Pursuit', 'Trivia', 2, 90, 12, 'trivial_pursuit.jpg'),
('Uno', 'Kort', 2, 199, 99, 'uno.jpg'),
('Yahtzee', 'Terning', 2, 20, 6, 'yahtzee.jpg'),
('Citadels', 'Strategi', 5, 180, 12, 'citadels.jpg');