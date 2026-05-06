-- En la base de datos empresa, crea:

-- 1º Las funciones ac10contarEmpleados y ac1009contarEmpleadosDpto reescribiendo los procedimientos ac10contarEmpleados y ac1003contarEmpleadosDpto de la actividad ACT 07.
DELIMITER $$
CREATE FUNCTION ac10contarEmpleados()
RETURNS INT
BEGIN
    DECLARE totalEmpleados INT;
    SELECT COUNT(*) INTO totalEmpleados FROM empleado;
    RETURN totalEmpleados;
END$$

DELIMITER $$
CREATE FUNCTION ac1003contarEmpleadosDpto(p_CodDep INT)
RETURNS INT
BEGIN
    DECLARE totalEmpleados INT;
    SELECT COUNT(*) INTO totalEmpleados FROM empleado WHERE empleado.codDep = p_CodDep;
    RETURN totalEmpleados;
END$$

-- 2º La función ac10presupuestoCentro que, a partir del código de un centro, devuelva su presupuesto (calculado como la suma de los presupuestos de sus departamentos).
DELIMITER $$
CREATE FUNCTION ac10presupuestoCentro(p_CodCen INT)
RETURNS INT
BEGIN
    DECLARE presupuestoTotal INT;
    SELECT SUM(preAnu) INTO presupuestoTotal 
    FROM departamento 
    WHERE departamento.codCen = p_CodCen;
    RETURN presupuestoTotal;
END$$

-- 3º La función ac10totalHabilidadesEmpleado que, a partir de un código de un empleado, devuelva cuantas habilidades tiene.
DROP FUNCTION IF EXISTS ac10totalHabilidadesEmpleado;
DELIMITER $$
CREATE FUNCTION ac10totalHabilidadesEmpleado(p_codEmp INT)
RETURNS INT
BEGIN
    DECLARE v_hab INT;
    SELECT COUNT(*) INTO v_hab FROM habemp WHERE CodEmp = p_codEmp;
    RETURN v_hab;
END$$

-- 4º La función ac10totalEmpleadosHabilidad que, a partir de un código de una habilidad, devuelva cuantos empleados la tienen.
DROP FUNCTION IF EXISTS ac10totalEmpleadosHabilidad;
DELIMITER $$
CREATE FUNCTION ac10totalEmpleadosHabilidad(p_codHab CHAR(5))
RETURNS INT
BEGIN
    DECLARE v_emp INT;
    SELECT COUNT(*) INTO v_emp FROM habemp WHERE CodHab = p_codHab;
    RETURN v_emp;
END$$


-- 5º La función ac10directorCentro que, a partir del código de un centro, devuelva el nombre de su director.
DROP FUNCTION IF EXISTS ac10directorCentro;
DELIMITER $$
CREATE FUNCTION ac10directorCentro(p_codCen CHAR(4))
RETURNS VARCHAR(40)
BEGIN
    DECLARE v_nom VARCHAR(40);
    SELECT e.NomEmp INTO v_nom 
    FROM centro c 
    INNER JOIN empleado e ON c.CodEmpDir = e.CodEmp 
    WHERE c.CodCen = p_codCen;
    RETURN COALESCE(v_nom, 'No asignado');
END$$

-- 6º La función ac10emailEmpleado que, a partir de un código de empleado, devuelva su email con la siguiente nomenclatura: CodEmp@CodDep.CodCen.com
DROP FUNCTION IF EXISTS ac10emailEmpleado;
DELIMITER $$
CREATE FUNCTION ac10emailEmpleado(p_codEmp INT)
RETURNS VARCHAR(100)
BEGIN
    DECLARE v_mail VARCHAR(100);
    SELECT CONCAT(e.CodEmp, '@', e.CodDep, '.', d.CodCen, '.com') INTO v_mail
    FROM empleado e
    INNER JOIN departamento d ON e.CodDep = d.CodDep
    WHERE e.CodEmp = p_codEmp;
    RETURN v_mail;
END$$

-- 7º La función ac10validaHijosEmpleados que a partir de un código de un empleado, compruebe si la cantidad de hijos de la tabla empleado coinciden con los de la tabla hijo.
DROP FUNCTION IF EXISTS ac10validaHijosEmpleados;
DELIMITER $$
CREATE FUNCTION ac10validaHijosEmpleados(p_codEmp INT)
RETURNS BOOLEAN
BEGIN
    DECLARE v_registrado INT;
    DECLARE v_real INT;

    SELECT NumHi INTO v_registrado FROM empleado WHERE CodEmp = p_codEmp; [cite: 4]
    SELECT COUNT() INTO v_real FROM hijo WHERE CodEmp = p_codEmp;

    RETURN (v_registrado = v_real);
END$$

-- 8º Comprueba las funciones existentes en la base de datos empresa.
SHOW FUNCTION STATUS WHERE Db = 'empresa';