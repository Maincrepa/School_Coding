-- Dump

CREATE DATABASE IF NOT EXISTS adoption
DEFAULT CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE adoption;

CREATE TABLE IF NOT EXISTS Adopters (
    Code         INTEGER AUTO_INCREMENT PRIMARY KEY,
    Name         VARCHAR(50)  NOT NULL,                                  -- Name: obligatori
    Age          TINYINT UNSIGNED CHECK (Age BETWEEN 0 AND 120),         -- Edat amb rang valid
    Tel          VARCHAR(20)  NOT NULL,                                  -- Telefon: obligatori
    Email        VARCHAR(50)  NOT NULL,                                  -- Email: obligatori
    Address      VARCHAR(200),
    City         VARCHAR(100),                                           -- City
    PostalCode   VARCHAR(10),                                            -- Codigo postal
    DNI          VARCHAR(20)  UNIQUE,                                    -- DNI
    HousingType  ENUM('Apartment','House','Farm'),                       -- Type of home
    HasGarden    TINYINT(1)   DEFAULT 0,                                 -- Has outdoor space
    HasOtherPets TINYINT(1)   DEFAULT 0,                                 -- Already owns pets
    IsApproved   TINYINT(1)   DEFAULT 0,                                 -- Adoption approval status
    Notes        TEXT,                                                   -- Staff notes
    RegisterTime TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Species (
    Code              INTEGER AUTO_INCREMENT PRIMARY KEY,
    Type              VARCHAR(50) NOT NULL,                              -- Type of species
    Description       TEXT,                                              -- Description
    CareTip           TEXT,                                              -- Tip for care
    AverageLifespan   TINYINT UNSIGNED,                                  -- Average lifespan in years
    AverageWeight     DECIMAL(5,2),                                      -- Typical weight in kg
    SizeCategory      ENUM('Small','Medium','Large'),                    -- General size
    ActivityLevel     ENUM('Low','Medium','High'),                       -- Exercise needs
    IsHypoallergenic  TINYINT(1) DEFAULT 0,                              -- Suitable for allergy sufferers
    IsGoodWithChildren TINYINT(1) DEFAULT 1                              -- Child-friendly
);

CREATE TABLE IF NOT EXISTS Pets (
    Code          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Name          VARCHAR(50)   NOT NULL,                                -- Name: obligatori
    Adoptat       TINYINT(1)    DEFAULT 0,                               -- Bool, default unadopted (0)
    DataAdoptat   DATE,                                                  -- Null by default
    DataRegistrat TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,               -- When shelter registered the pet
    BirthDate     DATE,                                                  -- +Age
    Gender        ENUM('M', 'F', 'Altre') NOT NULL,                      -- Gender
    Weight        DECIMAL(5,2),                                          -- kg
    Height        DECIMAL(5,2),                                          -- cm
    Breed         VARCHAR(100),                                          -- Breed name
    Color         VARCHAR(50),                                           -- Main color
    Size          ENUM('XS','S','M','L','XL'),                           -- Size category
    IsNeutered    TINYINT(1)    DEFAULT 0,                               -- Neutered/spayed status
    IsVaccinated  TINYINT(1)    DEFAULT 0,                               -- vacunado?
    IsMicrochipped TINYINT(1)   DEFAULT 0,                               -- microchip?
    HealthStatus  ENUM('Healthy','NeedsAttention','UnderTreatment') DEFAULT 'Healthy',
    Temperament   VARCHAR(100),                                          -- e.g. 'friendly, shy'
    Description   TEXT,                                                  -- General description
    PhotoURL      VARCHAR(255),                                          -- Link to pet photo
    AdopterID     INTEGER,                                               -- FK to Adopters
    IdSpecie      INTEGER NOT NULL,                                      -- FK to Species
    FOREIGN KEY (IdSpecie)   REFERENCES Species(Code)  ON DELETE CASCADE  ON UPDATE CASCADE,
    FOREIGN KEY (AdopterID)  REFERENCES Adopters(Code) ON DELETE SET NULL ON UPDATE CASCADE
);

-- TEST Insert 1. Species
INSERT INTO Species (Type, Description, CareTip, AverageLifespan, AverageWeight, SizeCategory, ActivityLevel, IsHypoallergenic, IsGoodWithChildren) VALUES
('Cat',    'Feline pet, independent and affectionate',    'Keep indoors, provide scratching posts',         15,  4.5, 'Small',  'Low',    0, 1),
('Dog',    'Canine pet, loyal and social',                'Regular exercise and socialization needed',       12, 20.0, 'Medium', 'High',   0, 1),
('Rabbit', 'Small and gentle herbivore',                  'Needs spacious hutch and daily greens',           8,  2.0, 'Small',  'Medium', 1, 1),
('Parrot', 'Intelligent and vocal bird',                  'Mental stimulation and social interaction needed',30,  0.4, 'Small',  'Medium', 1, 0),
('Turtle', 'Calm and long-lived reptile',                 'UV lamp, proper diet of veggies and protein',    40,  1.5, 'Small',  'Low',    1, 1);

-- TEST Insert 2. Adopters
INSERT INTO Adopters (Name, Age, Tel, Email, Address, City, PostalCode, DNI, HousingType, HasGarden, HasOtherPets, IsApproved) VALUES
('Joan Pujol',    35, '600123456', 'joan@email.com',    'Carrer Mayor 10',      'Barcelona', '08001', '12345678A', 'House',     1, 0, 1),
('Maria Garcia',  28, '612456789', 'maria@email.com',   'Avinguda Diagonal 50', 'Barcelona', '08006', '87654321B', 'Apartment', 0, 1, 1),
('Pere Martínez', 45, '633987654', 'pere@email.com',    'Carrer Nou 3',         'Girona',    '17001', '11223344C', 'House',     1, 1, 0),
('Anna López',    32, '655112233', 'anna@email.com',    'Passeig Gràcia 80',    'Barcelona', '08008', '44332211D', 'Apartment', 0, 0, 1);

-- TEST Insert 3. Pets
INSERT INTO Pets (Name, Gender, BirthDate, IdSpecie, Adoptat, DataAdoptat, Weight, Height, Breed, Color, Size, IsNeutered, IsVaccinated, IsMicrochipped, HealthStatus, Temperament, Description, AdopterID) VALUES
('Fluffy',   'F', '2022-03-15', 1, 0, NULL,         3.50, 25.0, 'Persian',           'White',          'S',  1, 1, 1, 'Healthy',          'calm, affectionate',   'Calm and fluffy indoor cat',               NULL),
('Rex',      'M', '2021-07-22', 2, 0, NULL,        28.00, 60.0, 'German Shepherd',   'Black and tan',  'L',  1, 1, 1, 'Healthy',          'loyal, energetic',     'Energetic and loyal dog',                  NULL),
('Snowball', 'M', '2023-01-10', 1, 0, NULL,         4.20, 27.0, 'British Shorthair', 'Grey',           'S',  0, 1, 0, 'Healthy',          'playful, curious',     'Playful and curious kitten',               NULL),
('Luna',     'F', '2020-11-05', 2, 1, '2024-05-01',22.00, 55.0, 'Labrador',          'Golden',         'L',  1, 1, 1, 'Healthy',          'gentle, friendly',     'Gentle family dog, already adopted',       1),
('Pipo',     'M', '2021-06-20', 4, 0, NULL,         0.40, 30.0, 'African Grey',      'Grey with red',  'XS', 0, 1, 0, 'Healthy',          'vocal, intelligent',   'Talks and mimics sounds',                  NULL),
('Turbo',    'M', '2018-04-12', 5, 0, NULL,         1.20, 15.0, 'Red-eared Slider',  'Green and red',  'XS', 0, 0, 0, 'NeedsAttention',   'calm, shy',            'Needs UVB lamp check',                     NULL),
('Coco',     'F', '2022-09-01', 3, 1, '2025-03-10', 1.80, 20.0, 'Holland Lop',       'Brown and white','XS', 1, 1, 1, 'Healthy',          'gentle, timid',        'Loves leafy greens, adopted by Maria',     2);