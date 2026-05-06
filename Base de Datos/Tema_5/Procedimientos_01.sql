DROP PROCEDURE ac07listEmpleadosConHijos;
-- 1. El procedimiento ac07listEmpleadosConHijos que muestre los empleados que tienen hijos.
DELIMITER //

CREATE PROCEDURE ac07listEmpleadosConHijos()
BEGIN
    SELECT e.CodEmp, e.NomEmp
    FROM empleado e
    INNER JOIN habemp h ON e.CodEmp = h.CodEmp
    WHERE h.CodHab = 'HIJO';
END //

DELIMITER ;
DROP PROCEDURE IF EXISTS ac07listEmpleadosConHijos;
-- 2. El procedimiento ac07contarEmpleados que muestre la cantidad de empleados.
DELIMITER //

CREATE PROCEDURE ac07listEmpleadosConHijos()
BEGIN
    SELECT e.CodEmp, e.NomEmp
    FROM empleado e
    INNER JOIN habemp h ON e.CodEmp = h.CodEmp
    WHERE h.CodHab = 'HIJO';
END //

DELIMITER ;
DROP PROCEDURE IF EXISTS ac07updSalarioEmpleados;
-- 3. El procedimiento ac07updSalarioEmpleados que incremente el salario de los empleados un 10%.
DELIMITER //

CREATE PROCEDURE ac07updSalarioEmpleados()
BEGIN
    UPDATE empleado
    SET SalEmp = SalEmp * 1.1;
END //

DELIMITER ;
-- 4. Recupera los procedimientos existentes.
SELECT * FROM mysql.proc WHERE db = 'empresa' AND type = 'PROCEDURE';
-- 5. Elimina el procedimiento ac07updSalarioEmpleados.
DROP PROCEDURE IF EXISTS ac07updSalarioEmpleados;