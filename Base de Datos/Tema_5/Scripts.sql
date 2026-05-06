-- 1. Crea una tabla dashboard_dpto que muestre para cada departamento, además de su código y nombre y presupuesto anual, cuantos empleados y su gasto en salarios.
DROP TABLE IF EXISTS dashboard_dpto;
CREATE TABLE dashboard_dpto AS
SELECT 
    d.CodDep, 
    d.NomDep, 
    d.PreAnu, 
    COUNT(e.CodEmp) AS total_empleados, 
    SUM(ifNull(e.SalEmp, 0)) AS total_salarios
FROM departamento d
LEFT JOIN empleado e ON d.CodDep = e.CodDep
GROUP BY d.CodDep, d.NomDep, d.PreAnu;

SELECT * FROM dashboard_dpto;

-- 2. Crea una tabla dashboard_centro que muestre para cada centro, además de su código y nombre, cuantos departamentos contiene y el presupuesto anual (entendido como la suma de los presupuestos de sus departamentos).
DROP TABLE IF EXISTS dashboard_centro;

CREATE TABLE dashboard_centro AS
SELECT 
    c.CodCen, 
    c.NomCen, 
    COUNT(d.CodDep) AS total_departamentos, 
    SUM((ifNull d.PreAnu, 0)) AS presupuesto_total
FROM centro c
LEFT JOIN departamento d ON c.CodCen = d.CodCen
GROUP BY c.CodCen, c.NomCen;

SELECT * FROM dashboard_centro;