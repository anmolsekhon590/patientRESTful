CREATE TABLE Patient(
    ID NUMERIC PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR,
    systole NUMERIC,
    diastole NUMERIC,
    temperatureInFahrenheit NUMERIC,
    hasCovid BIT
);