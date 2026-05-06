START TRANSACTION;
INSERT INTO departamento (CodDep, NomDep, CodDepDep) VALUES ("TX1", "TX1 apuntará a TX2", "TX2");
INSERT INTO departamento (CodDep, NomDep, CodDepDep) VALUES ("TX2", "TX2 apunta a TX1", "TX1");
COMMIT;
-- ¿Se ha insertado algún registro? ¿Ambos?
-- No se inserta nada porque TX2 no existe y le estas diciendo que inserte TX1 partiendo de TX2, como TX2 no existe, TX1 no puede insertar nada.

-- Y si lo cambiamos por la siguiente transacción ¿Cambia algo?
-- Ahora como TX1 esta como null, los crea vacío, y ya ejecuta estos registros y actualiza TX1 para que dependa de TX2.

START TRANSACTION;
INSERT INTO departamento (CodDep, NomDep, CodDepDep) VALUES ("TX1", "TX1 apuntará a TX2", NULL);
INSERT INTO departamento (CodDep, NomDep, CodDepDep) VALUES ("TX2", "TX2 apunta a TX1", "TX1");
UPDATE departamento SET CodDepDep = "TX2" WHERE CodDep = "TX1";
COMMIT;