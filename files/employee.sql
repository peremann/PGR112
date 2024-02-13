-- Slett databasen hvis den finnes fra før
DROP DATABASE IF EXISTS MinBedrift;
-- Opprett databasen
CREATE DATABASE MinBedrift;

-- Bruk databasen
USE MinBedrift;

-- Opprett Employee-tabellen
CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT
);

-- Opprett RegularEmployee-tabellen
CREATE TABLE RegularEmployee (
    eid INT PRIMARY KEY,
    salary FLOAT,
    bonus INT,
    FOREIGN KEY (eid) REFERENCES Employee(id)
);

-- Opprett ContractEmployee-tabellen
CREATE TABLE ContractEmployee (
    eid INT PRIMARY KEY,
    payPerHour FLOAT,
    contractPeriod TEXT,
    FOREIGN KEY (eid) REFERENCES Employee(id)
);

-- Sett inn eksempeldata i Employee-tabellen
INSERT INTO Employee (id, name) VALUES
    (1, 'Alice'),
    (2, 'Bob'),
    (3, 'Charlie'),
    (4, 'Ben'),
    (5, 'Yolanda'),
    (6, 'Stephen');

-- Sett inn eksempeldata i RegularEmployee-tabellen
INSERT INTO RegularEmployee (eid, salary, bonus) VALUES
    (1, 60000, 5000),
    (2, 55000, 4500),
    (3, 62000, 5500);

-- Sett inn eksempeldata i ContractEmployee-tabellen
INSERT INTO ContractEmployee (eid, payPerHour, contractPeriod) VALUES
    (4, 150, '6 måneder'),
    (5, 140, '3 måneder'),
    (6, 160, '9 måneder');

DELIMITER //
CREATE PROCEDURE AddRegularEmployee(
    IN empName TEXT,
    IN empSalary FLOAT,
    IN empBonus INT,
    OUT empId INT
)
BEGIN
    -- Legg til en ny ansatt i Employee-tabellen
    INSERT INTO Employee (name) VALUES (empName);
    SET empId = LAST_INSERT_ID();

    -- Legg til den nye ansatte i RegularEmployee-tabellen
    INSERT INTO RegularEmployee (eid, salary, bonus) VALUES (empId, empSalary, empBonus);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetAllEmployeesWithType()
BEGIN
    -- Hent alle ansatte med detaljer fra Employee-tabellen
    SELECT e.id, e.name,
           CASE WHEN re.salary IS NOT NULL THEN 'Regular' ELSE 'Contract' END AS Type,
           re.salary AS RegularSalary, re.bonus AS RegularBonus,
           ce.payPerHour AS ContractPayPerHour, ce.contractPeriod AS ContractPeriod
    FROM Employee e
    LEFT JOIN RegularEmployee re ON e.id = re.eid
    LEFT JOIN ContractEmployee ce ON e.id = ce.eid;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetAllRegularEmployees()
BEGIN
    -- Hent alle ansatte fra RegularEmployee-tabellen
    SELECT e.id, e.name, re.salary, re.bonus
    FROM Employee e
	JOIN RegularEmployee re ON e.id = re.eid;
END //
DELIMITER ;