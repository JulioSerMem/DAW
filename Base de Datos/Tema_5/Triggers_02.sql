-- Sobre la base de datos empresa, se pide:

-- 1. Crea el trigger triggerHolaHijo de manera que al insertar un nuevo hijo en la tabla hijo, automáticamente incremente el atributo NumHi de la tabla empleado del empleado correspondiente.

DELIMITER $$

CREATE OR REPLACE TRIGGER triggerHolaHijo
AFTER INSERT ON hijo
FOR EACH ROW
BEGIN
    UPDATE empleado 
    SET NumHi = NumHi + 1 
    WHERE CodEmp = NEW.CodEmp;
END $$

-- 2. Crea el trigger homónimo triggerAdiosHijo por si se diera el caso que falleciera el hijo de un empleado/a.

DELIMITER $$

CREATE OR REPLACE TRIGGER triggerAdiosHijo
AFTER DELETE ON hijo
FOR EACH ROW
BEGIN
    UPDATE empleado 
    SET NumHi = NumHi - 1 
    WHERE CodEmp = OLD.CodEmp;
END $$

-- 3. Escribe los triggers triggerSalariosEmpleadoAfterInsert y triggerSalariosEmpleadoAfterUpdate que nos permita llevar un control de las modificaciones en los salarios de los empleados. Los disparadores se ejecutarán después de cada inserción o modificación (si ha cambiado el salario), insertando un registro en la tabla salarios. La tabla debe cumplir
-- Crea una tabla llamada salarios dentro de la base de datos para realizar un seguimiento de las remuneraciones de los trabajadores. La tabla debe cumplir con las siguientes especificaciones:
/*
id: Un identificador único para cada registro, entero, que se incremente automáticamente y funcione como clave primaria.
fecha: tiempo del momento exacto de la inserción, con valor por defecto la fecha y hora actuales.
salario: Un valor decimal (12 dígitos en total, 2 decimales) que debe ser obligatoriamente mayor que cero.
codigo_empleado: fk al registro con el trabajador correspondiente.
*/

CREATE TABLE IF NOT EXISTS salarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    salario DECIMAL(12,2) NOT NULL CHECK (salario > 0),
    CodEmp INT NOT NULL
);

DELIMITER $$

CREATE OR REPLACE TRIGGER triggerSalariosEmpleadoAfterInsert
AFTER INSERT ON empleado
FOR EACH ROW
BEGIN
    IF NEW.SalEmp > 0 THEN
        INSERT INTO salarios (salario, CodEmp)
        VALUES (NEW.SalEmp, NEW.CodEmp);
    END IF;
END $$

CREATE OR REPLACE TRIGGER triggerSalariosEmpleadoAfterUpdate
AFTER UPDATE ON empleado
FOR EACH ROW
BEGIN
    IF OLD.SalEmp <> NEW.SalEmp THEN
        INSERT INTO salarios (salario, CodEmp)
        VALUES (NEW.SalEmp, NEW.CodEmp);
    END IF;
END $$

DELIMITER ;