DROP DATABASE IF EXISTS Shapes;
CREATE DATABASE Shapes;
USE Shapes;

CREATE TABLE Shape (
    shape_id INT PRIMARY KEY AUTO_INCREMENT,
    color VARCHAR(255),
    filled BOOLEAN
);

CREATE TABLE Circle (
    shape_id INT PRIMARY KEY,
    radius DOUBLE,
    x DOUBLE,
    y DOUBLE,
    FOREIGN KEY (shape_id) REFERENCES Shape(shape_id)
);

CREATE TABLE Rectangle (
    shape_id INT PRIMARY KEY,
    width DOUBLE,
    height DOUBLE,
    topLeftX DOUBLE,
    topLeftY DOUBLE,
    bottomRightX DOUBLE,
    bottomRightY DOUBLE,
    FOREIGN KEY (shape_id) REFERENCES Shape(shape_id)
);

CREATE TABLE Square (
    shape_id INT PRIMARY KEY,
    FOREIGN KEY (shape_id) REFERENCES Shape(shape_id)
);

DELIMITER //
CREATE PROCEDURE InsertCircle(IN p_color VARCHAR(255), IN p_filled BOOLEAN, IN p_radius DOUBLE, IN p_x DOUBLE, IN p_y DOUBLE, OUT shape_id INT)
BEGIN
    INSERT INTO Shape (color, filled) VALUES (p_color, p_filled);
    SET shape_id = LAST_INSERT_ID();
    INSERT INTO Circle (shape_id, radius, x, y) VALUES (shape_id, p_radius, p_x, p_y);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertRectangle(IN p_color VARCHAR(255), IN p_filled BOOLEAN, IN p_width DOUBLE, IN p_height DOUBLE, IN p_topLeftX DOUBLE, IN p_topLeftY DOUBLE, IN p_bottomRightX DOUBLE, IN p_bottomRightY DOUBLE, OUT shape_id INT)
BEGIN
    INSERT INTO Shape (color, filled) VALUES (p_color, p_filled);
    SET shape_id = LAST_INSERT_ID();
    INSERT INTO Rectangle (shape_id, width, height, topLeftX, topLeftY, bottomRightX, bottomRightY)
    VALUES (shape_id, p_width, p_height, p_topLeftX, p_topLeftY, p_bottomRightX, p_bottomRightY);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertSquare(IN p_color VARCHAR(255), IN p_filled BOOLEAN, IN p_width DOUBLE, IN p_height DOUBLE, IN p_topLeftX DOUBLE, IN p_topLeftY DOUBLE, IN p_bottomRightX DOUBLE, IN p_bottomRightY DOUBLE, OUT shape_id INT)
BEGIN
    INSERT INTO Shape (color, filled) VALUES (p_color, p_filled);
    SET shape_id = LAST_INSERT_ID();
    INSERT INTO Rectangle (shape_id, width, height, topLeftX, topLeftY, bottomRightX, bottomRightY)
    VALUES (shape_id, p_width, p_height, p_topLeftX, p_topLeftY, p_bottomRightX, p_bottomRightY);
    INSERT INTO Square (shape_id) VALUES (shape_id);
END //
DELIMITER ;
