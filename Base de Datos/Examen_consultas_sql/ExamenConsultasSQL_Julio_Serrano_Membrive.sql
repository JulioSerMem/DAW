-- a)Profesores que no imparten clase
SELECT D.PROFESOR FROM D LEFT JOIN I ON D.PROFESOR = I.PROFESOR WHERE I.PROFESOR IS NULL;

-- b)Profesores que imparten clase en dos módulos
SELECT DISTINCT D.PROFESOR FROM D JOIN I ON D.PROFESOR = I.PROFESOR GROUP BY D.PROFESOR HAVING COUNT(DISTINCT I.MODULO) = 2;

-- c) Departamentos que imparten módulos en más de un ciclo
SELECT D.DEPARTAMENTO FROM D INNER JOIN I ON D.PROFESOR = I.PROFESOR INNER JOIN E ON I.MODULO = E.MODULO 
GROUP BY D.DEPARTAMENTO HAVING COUNT(DISTINCT E.CICLO) > 1;

-- d)Alumnos que aprueban todos los módulos a los que se presentan
SELECT M.ALUMNO FROM M GROUP BY M.ALUMNO HAVING SUM(M.NOTA < 5) = 0;

-- e)Media de las notas medias de los alumnos que aprobarosn por lo menos la mitad de los módulos en los que estaban matriculados
SELECT AVG(NotasMedias) FROM (SELECT M.ALUMNO, AVG(M.NOTA) AS NotasMedias FROM M WHERE M.NOTA>=5 GROUP BY M.ALUMNO HAVING COUNT DISTINCT(M.MODULO) >= (SELECT COUNT(DISTINCT MODULO) / 2 FROM M WHERE NOTA >= 5)) AS NotasMedias;

-- f)Lista el nombre de todos los móodulos que pertenecen al ciclo 'DAW', ordenados alfabéticamente
SELECT E.MODULO FROM E WHERE E.CICLO = 'DAW' ORDER BY E.MODULO ASC;

-- g)Busca al profesor que imparte el mayor número de módulos.Muestra su nombre y la cantidad de módulos que tiene a su cargo
SELECT D.PROFESOR, COUNT(DISTINCT I.MODULO) AS num_modules FROM D JOIN I ON D.PROFESOR = I.PROFESOR GROUP BY D.PROFESOR ORDER BY num_modules DESC LIMIT 1;