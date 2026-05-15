-- 1 .
DELIMITER $$
CREATE PROCEDURE departamentos_en_canada()
BEGIN
	SELECT COUNT(*) AS numero_departamentos_canada FROM Departments d
    JOIN Locations l ON d.location_id = l.location_id
	WHERE l.country_id = 'CA';    
END $$
DELIMITER ;
-- 2.
DELIMITER $$
CREATE PROCEDURE IF NOT EXISTS lastEmployes()
Begin
	CREATE TABLE lastEmployes(
		employee_id INT PRIMARY KEY,
	);
	INSERT INTO lastEmployes(employee_id)
	SELECT employee_id FROM Employees
	ORDER BY employee_id DESC
	LIMIT 10;
END $$
DELIMITER ;

-- 3.
DELIMITER $$
CREATE FUNCTION IF NOT EXISTS Iniciales()
RETURNS VARCHAR(255)
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE nombre VARCHAR(255);
	DECLARE apellido VARCHAR(255);
	DECLARE iniciales VARCHAR(255);
	DECLARE cur CURSOR FOR SELECT first_name, last_name FROM Employees;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	OPEN cur;
	read_loop: LOOP
		FETCH cur INTO nombre, apellido
		IF done THEN
			LEAVE read_loop;
		ELSEIF

-- 4.
DELIMITER $$
CREATE PROCEDURE IF NOT EXISTS aumentarSalarioMinimo(IN aumento DECIMAL(8,2), OUT suma DECIMAL(8,2))
BEGIN
	UPDATE Jobs
	SET min_salary = min_salary + aumento
	WHERE min_salary < 4000.00;
	SELECT SUM(min_salary) INTO suma FROM Jobs;
END $$
DELIMITER ;