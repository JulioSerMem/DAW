Create database if not exists transacciones;
Use transacciones;

CREATE TABLE cuentas (
    id INTEGER UNSIGNED PRIMARY KEY,
    saldo DECIMAL(11,2) CHECK (saldo >= 0)
);

INSERT INTO cuentas VALUES (1, 1000);
INSERT INTO cuentas VALUES (2, 2000);
INSERT INTO cuentas VALUES (3, 0);

START TRANSACTION;
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
-- ¿Qué contiene cuentas en este momento?
-- La transacción se ha ejecutado correctamente, por lo que el saldo de la cuenta 1 es ahora 900, el saldo de la cuenta 2 es ahora 2100 y el saldo de la cuenta 3 sigue siendo 0.

START TRANSACTION;
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 9999;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
COMMIT;
-- ¿Qué sucede cuando una cuenta no existe? ¿Se ha modificado el saldo de la cuenta 2?
-- El update de la cuenta 9999 no afecta a ninguna fila, por lo que no se produce ningún error. Sin embargo, el update de la cuenta 2 se ejecuta correctamente, por lo que el saldo de la cuenta 2 es ahora 2200.

START TRANSACTION;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 3;
COMMIT;
-- ¿Y si una cuenta no tiene saldo? ¿Se han modificado ambos los saldos?
-- El update de la cuenta 3 prodduce un error, por lo tanto, la transaccion se revierte y no se modifica el saldo de la cuenta 2. Por lo tanto, el saldo de la cuenta 2 sigue siendo 2200 y el saldo de la cuenta 3 sigue siendo 0.

-- 2. A continuación, indica las sentencias SQL necesarias para realizar las siguientes tareas dentro de una única operación:

/* Inserta una nueva cuenta, la 4, con un saldo de 400€.
Inserta la cuenta 5 con un saldo de 500€.
Modifica la cuenta 3 para que su saldo sea 300€.
Y en otra operación:*/
START TRANSACTION;
INSERT INTO cuentas VALUES (4, 400);
INSERT INTO cuentas VALUES (5, 500);
UPDATE cuentas SET saldo = 300 WHERE id = 3;
COMMIT;

-- 3. Inserta la cuenta 6 con un saldo de 600€.
/*Modifica las cuentas 4 y 5 y quítales 200€ (en una única operación).
Deshaz las dos últimas operaciones.*/
START TRANSACTION;
INSERT INTO cuentas VALUES (6, 600);
UPDATE cuentas SET saldo = saldo - 200 WHERE id = 4;
UPDATE cuentas SET saldo = saldo - 200 WHERE id = 5;
COMMIT;