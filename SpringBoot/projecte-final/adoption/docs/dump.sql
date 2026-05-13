-- Dump

CREATE DATABASE IF NOT EXISTS adoption
DEFAULT CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_520_ci;

USE adoption;

CREATE TABLE IF NOT EXISTS Adopters (
    Code INTEGER AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(50) NOT NULL, -- Name: obligatori
    Age TINYINT UNSIGNED CHECK (Age BETWEEN 0 AND 120), -- Edat amb rang valid
    Tel VARCHAR(20) NOT NULL, -- Telefon: obligatori
    Email VARCHAR(50) NOT NULL, -- Email: obligatori
    Address VARCHAR(200),
    RegisterTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Species (
    Code INTEGER AUTO_INCREMENT PRIMARY KEY, 
    Type VARCHAR(50) NOT NULL, -- Type of species
    Description TEXT, -- Description
    CareTip TEXT -- Tip for care
);

CREATE TABLE IF NOT EXISTS Pets (
    Code INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL, -- Name: obligatori
    Adoptat TINYINT(1) DEFAULT 0, -- Bool, default unadopted (0)
    DataAdoptat DATE, -- Null by default
    BirthDate DATE,
    Gender ENUM('M', 'F', 'Altre') NOT NULL, -- Gender
    IdSpecie INTEGER NOT NULL, -- Foreign key a Species
    FOREIGN KEY (IdSpecie) REFERENCES Species(Code) ON DELETE CASCADE ON UPDATE CASCADE
);