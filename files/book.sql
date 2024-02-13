DROP DATABASE IF EXISTS books;
CREATE DATABASE IF NOT EXISTS books;
USE books;

-- Opprett tabellen for bøker
CREATE TABLE IF NOT EXISTS Book (
    isbn VARCHAR(10) PRIMARY KEY,
    published DATE,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    numberOfPages INT,
    genre VARCHAR(50),  -- Kunne vært en enum...
    minutesPerPage INT
);

-- Opprett tabellen for kapitler
CREATE TABLE IF NOT EXISTS Chapter (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_isbn VARCHAR(10) NOT NULL,
    title VARCHAR(255) NOT NULL,
    numberOfPages INT,
    FOREIGN KEY (book_isbn) REFERENCES Book(isbn)
);

INSERT INTO Book (isbn, published, title, author, numberOfPages, genre, minutesPerPage)
VALUES ('1234567890', '2023-01-15', 'The Mysterious Case', 'Sherlock Holmes', 300, 'CRIME', 2);

INSERT INTO Book (isbn, published, title, author, numberOfPages, genre, minutesPerPage)
VALUES ('9876543210', '2022-08-20', 'The Silent Witness', 'Detective Smith', 280, 'CRIME', 2);

INSERT INTO Book (isbn, published, title, author, numberOfPages, genre, minutesPerPage)
VALUES ('5678901234', '2021-11-05', 'Code Red: Cyber Espionage', 'Agent X', 350, 'ACTION', 3);

-- Bok: The Mysterious Case (ISBN: 1234567890)
INSERT INTO Chapter (book_isbn, title, numberOfPages)
VALUES ('1234567890', 'Chapter 1: The Stolen Diamond', 20),
       ('1234567890', 'Chapter 2: The Hidden Clues', 18),
       ('1234567890', 'Chapter 3: The Cryptic Message', 22);

-- Bok: The Silent Witness (ISBN: 9876543210)
INSERT INTO Chapter (book_isbn, title, numberOfPages)
VALUES ('9876543210', 'Prologue: A Dark Night', 15),
       ('9876543210', 'Chapter 1: Crime Scene', 25),
       ('9876543210', 'Chapter 2: Unraveling the Mystery', 20);

-- Bok: Code Red: Cyber Espionage (ISBN: 5678901234)
INSERT INTO Chapter (book_isbn, title, numberOfPages)
VALUES ('5678901234', 'Chapter 1: Breach Detected', 30),
       ('5678901234', 'Chapter 2: The Hacker\'s Trail', 28),
       ('5678901234', 'Chapter 3: Countdown to Chaos', 32);
