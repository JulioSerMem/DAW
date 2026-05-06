-- En la base de datos empresa, se pide crear un conjunto de procedimientos que colaboren entre sí para generar un informe salarial por centro de trabajo. Para ello:

-- Crea el procedimiento ac12mediaSalarial que, a partir de un código de departamento (parámetro de entrada), devuelva en un parámetro de salida el salario medio de los empleados de dicho departamento.

DELIMITER $$
CREATE OR REPLACE PROCEDURE ac12mediaSalarial(IN p_CodDep CHAR(5), OUT p_SalarioMedio DECIMAL(12,2))
BEGIN
    SELECT AVG(SalEmp) INTO p_SalarioMedio
    FROM empleado
    WHERE CodDep = p_CodDep;
END $$

-- Crea la función ac12categoriaDepartamento que, a partir de un código de departamento (parámetro de entrada), devuelva la categoría según el salario medio de sus empleados:
/*
bajo si el salario medio es inferior a 2.000.000
medio si está entre 2.000.000 y 5.000.000
alto si es superior a 5.000.000
Esta función debe invocar a ac12mediaSalarial para obtener la media.
*/

DELIMITER $$
CREATE OR REPLACE FUNCTION ac12categoriaDepartamento(p_codDep CHAR(5))
RETURNS VARCHAR(10)
BEGIN
    DECLARE media DECIMAL(12,2);
    DECLARE categoria VARCHAR(10);
    CALL ac12mediaSalarial(p_codDep, media);
    IF media IS NULL THEN
        SET categoria = 'bajo';
    ELSEIF media < 2000000 THEN
        SET categoria = 'bajo';
    ELSEIF media <= 5000000 THEN
        SET categoria = 'medio';
    ELSE
        SET categoria = 'alto';
    END IF;
    RETURN categoria;
END $$

-- Crea la tabla informe_salarial con la siguiente estructura:
/*
CodDep CHAR(5)
NomDep VARCHAR(40)
NumEmpleados INT
SalarioMedio DECIMAL(12,2)
Categoria VARCHAR(10)
*/

CREATE TABLE IF NOT EXISTS informe_salarial (
    CodDep CHAR(5) PRIMARY KEY,
    NomDep VARCHAR(40),
    NumEmpleados INT,
    SalarioMedio DECIMAL(10,2),
    Categoria VARCHAR(10)
);

-- Crea el procedimiento ac12actualizaInforme que, a partir de un código de departamento (parámetro de entrada), actualice la fila correspondiente en informe_salarial con la cantidad de empleados, el salario medio y la categoría salarial. Este procedimiento debe invocar a ac12mediaSalarial y a ac12categoriaDepartamento.
DELIMITER $$
CREATE OR REPLACE PROCEDURE ac12actualizaInforme(IN p_CodDep CHAR(5))
BEGIN
    DECLARE numEmpleados INT;
    DECLARE salarioMedio DECIMAL(10,2);
    DECLARE categoria VARCHAR(10);

    SELECT COUNT(*) INTO numEmpleados
    FROM empleado
    WHERE CodDep = p_CodDep;

    CALL ac12mediaSalarial(p_CodDep, salarioMedio);

    SET categoria = ac12categoriaDepartamento(p_CodDep);

    UPDATE informe_salarial
    SET NumEmpleados = numEmpleados,
        SalarioMedio = salarioMedio,
        Categoria = categoria
    WHERE CodDep = p_CodDep;
END $$

-- Comprueba su funcionamiento insertando manualmente una fila en informe_salarial para el departamento PROZS (solo con CodDep y NomDep), invocando al procedimiento y verificando que se han rellenado el resto de columnas.
INSERT INTO informe_salarial (CodDep, NomDep)
VALUES ('PROZS', (SELECT NomDep FROM departamento WHERE CodDep = 'PROZS'));

SELECT * FROM informe_salarial WHERE CodDep = 'PROZS';

CALL ac12actualizaInforme('PROZS');

SELECT * FROM informe_salarial WHERE CodDep = 'PROZS';