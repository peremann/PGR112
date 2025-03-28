DROP DATABASE IF EXISTS memorabilia;
CREATE DATABASE memorabilia;

USE memorabilia;

-- Tabell for Poster
CREATE TABLE Poster (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year INT,
    celebrityInvolved VARCHAR(255),
    description TEXT,
    askingPrice INT,
    width INT,
    height INT
);

-- Tabell for Skateboard
CREATE TABLE Skateboard (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year INT,
    celebrityInvolved VARCHAR(255),
    description TEXT,
    askingPrice INT,
    skateboardType VARCHAR(255)
);

-- Tabell for SportsEquipment
CREATE TABLE SportEquipment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year INT,
    celebrityInvolved VARCHAR(255),
    description TEXT,
    askingPrice INT,
    sport VARCHAR(255)
);