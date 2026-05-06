/*
Haciendo uso de cursores y la base de datos empresa, se pide:

La empresa se está planteando ampliar la cantidad de departamentos para fomentar la conciliación familiar. De esta manera, aquellos departamentos que tengan más de 2 trabajadores con hijos se dividirán en dos, y sus empleados se repartirán entre ellos. Para ello, en una nueva tabla departamentoFamiliar almacenaremos una copia de los departamentos, junto a las nuevas versiones familiares.

Tened en consideración los siguientes puntos:

Actualizar la fila recién insertada en departamentoFamiliar reduciendo su presupuesto anual

Creación de Sub-departamento: Insertar una segunda fila en departamentoFamiliar que represente una "sección familiar" con las siguientes modificaciones:

Código: El nuevo código será el original pero sustituyendo el quinto carácter por un "2" (ej. 'ADMZS' pasa a ser 'ADMZ2').

Nombre: Se le añadirá el sufijo "** Familiar**" al nombre original (ej. 'Ventas Zona Sur' pasa a ser 'Ventas Zona Sur Familiar').

Dependencia: Este nuevo departamento tendrá como departamento superior (CodDepDep) al departamento original.

Presupuesto: Recibirá la otra mitad del presupuesto original.
*/

DROP TABLE IF EXISTS departamentoFamiliar;
CREATE TABLE departamentoFamiliar LIKE departamento;

INSERT INTO departamentoFamiliar 
SELECT * FROM departamento;

DELIMITER $$

CREATE OR REPLACE PROCEDURE CrearDepartamentosFamiliares()
BEGIN
    DECLARE dep ROW TYPE OF departamento;
    
    DECLARE fin INT DEFAULT 0;

    DECLARE nuevoPresupuesto DECIMAL(12,2);
    DECLARE nuevoCodigo CHAR(5);
    DECLARE nuevoNombre VARCHAR(60);
    
    DECLARE cur_departamentos CURSOR FOR 
        SELECT d.*
        FROM departamento d, empleado e
        WHERE d.CodDep = e.CodDep 
        AND e.NumHi > 0
        GROUP BY d.CodDep
        HAVING COUNT(DISTINCT e.CodEmp) >= 2;
        
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    
    OPEN cur_departamentos;
    
    WHILE fin = 0 DO
        FETCH cur_departamentos INTO dep;
        
            SET nuevoPresupuesto = dep.PreAnu / 2;
            UPDATE departamentoFamiliar 
            SET PreAnu = nuevoPresupuesto 
            WHERE CodDep = dep.CodDep;
            
            SET nuevoCodigo = CONCAT(SUBSTRING(dep.CodDep, 1, 4), '2');
            SET nuevoNombre = CONCAT(dep.NomDep, ' Familiar');

            INSERT INTO departamentoFamiliar (CodDep, CodEmpDir, CodDepDep, CodCen, NomDep, PreAnu, TiDir)
            VALUES (
                nuevoCodigo, 
                dep.CodEmpDir, 
                dep.CodDep, 
                dep.CodCen, 
                nuevoNombre, 
                nuevoPresupuesto, 
                dep.TiDir
            );
            
        
    END WHILE;
    CLOSE cur_departamentos; 
END $$