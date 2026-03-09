-- 1. Comprueba los usuarios existentes en nuestro SGBD.
SELECT * FROM mysql.user;
-- 2. Crea un usuario ac901local con contraseña s8a que sólo pueda conectarse desde localhost. Comprueba que puedes acceder con el nuevo usuario.
CREATE USER 'ac901local'@'localhost' IDENTIFIED BY 's8a';
-- 3. Crea un usuario ac901remoto con contraseña s8a que pueda conectarse desde cualquier lugar. Comprueba que puedes acceder con el nuevo usuario.
CREATE USER ac901remoto IDENTIFIED BY 's8a';
-- 4. Modifica la contraseña del usuario ac901remoto para que sea severo. Comprueba que puedes acceder con la nueva contraseña.
ALTER USER ac901remoto IDENTIFIED BY 'severo';
-- 5. Vuelve a comprobar los usuarios existentes en nuestro SGBD.
SELECT * FROM mysql.user;
-- 6. Elimina el usuario ac901remoto.
DROP USER ac901remoto;