-- Crea la tabla empleado_copia con la misma estructura que la tabla empleado (mediante CREATE TABLE .... LIKE ...)..

CREATE TABLE empleado_copia LIKE empleado;

-- Crea el procedimiento ac1111empleadosSinHijos, para que, utilizando cursores y recuperando todos los empleados que no tienen hijos en la consulta, recorra el resultado e inserte en empleado_copia aquellos empleados que no tiene hijos.

DELIMITER $$
CREATE OR REPLACE PROCEDURE ac1111empleadosSinHijos()
BEGIN

DECLARE empl ROW TYPE OF empleado;
DECLARE fin INT DEFAULT 0;

DECLARE cur_sin_hijos CURSOR FOR SELECT codEmp, codDep, exTelEmp, FecInEmp, fecNaEmp, NifEmp, NomEmp, Numhi, salEmp FROM empleado WHERE numHi = 0;

DECLARE CONTINUE HANDLER FOR NOT FOUND  SET fin = 1;
OPEN cur_sin_hijos;

bucle: LOOP
	FETCH cur_sin_hijos INTO empl;
    
    IF fin = 1 THEN
    	LEAVE bucle;
    END IF;
    
    INSERT INTO empleado_copia(codEmp, codDep, exTelEmp, FecInEmp, fecNaEmp, NifEmp, NomEmp, NumHi, salEmp)
    VALUES (empl.codEmp, empl.codDep, empl.exTelEmp, empl.FecInEmp, empl.fecNaEmp, empl.NifEmp,empl.NomEmp, empl.NumHi, empl.salEmp);

END LOOP;
CLOSE cur_sin_hijos;

END $$

call ac1111empleadosSinHijos();

-- Crea el procedimiento ac1111empleadosNumHijos, para que, utilizando cursores con parámetros, recorra la tabla de empleados e inserte en empleado_copia aquellos empleados que tienen la cantidad de hijos recibidos como un parámetro de entrada del procedimiento.

DELIMITER $$
CREATE OR REPLACE PROCEDURE ac1111empleadosNumHijos(IN numHijos INT)
BEGIN

DECLARE empl ROW TYPE OF empleado;
DECLARE fin INT DEFAULT 0;

DECLARE cur_sin_hijos CURSOR FOR SELECT codEmp, codDep, exTelEmp, FecInEmp, fecNaEmp, NifEmp, NomEmp, Numhi, salEmp FROM empleado WHERE numHi = numHijos;

DECLARE CONTINUE HANDLER FOR NOT FOUND  SET fin = 1;
OPEN cur_sin_hijos;

bucle: LOOP
	FETCH cur_sin_hijos INTO empl;
    
    IF fin = 1 THEN
    	LEAVE bucle;
    END IF;
    
    INSERT INTO empleado_copia(codEmp, codDep, exTelEmp, FecInEmp, fecNaEmp, NifEmp, NomEmp, NumHi, salEmp)
    VALUES (empl.codEmp, empl.codDep, empl.exTelEmp, empl.FecInEmp, empl.fecNaEmp, empl.NifEmp,empl.NomEmp, empl.NumHi, empl.salEmp);

END LOOP;
CLOSE cur_sin_hijos;

END $$

call ac1111empleadosNumHijos(1);