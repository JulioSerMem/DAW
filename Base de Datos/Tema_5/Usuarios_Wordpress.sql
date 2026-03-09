-- 1. Crea una base de datos llamada wordpress para la aplicación web WordPress.
DROP DATABASE IF EXISTS wordpress;
CREATE DATABASE wordpress ;
USE wordpress;
-- 2. Crea un usuario llamado wp_local_user que tenga todos los privilegios sobre la base de datos wordpress. Tenga en cuenta que el usuario wp_local_user sólo podrá conectarse desde la máquina local.
CREATE USER 'wp_local_user'@'localhost';
GRANT ALL PRIVILEGES ON wordpress.* TO 'wp_local_user'@'localhost';
FLUSH PRIVILEGES;
-- 3. Crea un usuario llamado wp_remote_user que tenga todos los privilegios sobre la base de datos wordpress y que pueda conectarse desde cualquier máquina.
CREATE USER wp_remote_user;
GRANT ALL PRIVILEGES ON wordpress.* TO wp_remote_user;
FLUSH PRIVILEGES;
-- 4. Crea un usuario llamado wp_read_user que sólo tenga permisos de lectura sobre la base de datos wordpress y que pueda conectarse desde cualquier máquina.
CREATE USER wp_read_user;
GRANT SELECT ON wordpress.* TO wp_read_user;
-- 5. Vuelva a crear un usuario llamado wp_read_user que tenga todos los privilegios sobre la base de datos wordpress y que sí pueda conectarse desde cualquier máquina. Utilice una contraseña diferente a la que utilizó para el usuario anterior.
DROP USER wp_read_user;
CREATE USER wp_read_user IDENTIFIED BY 's8a';
GRANT ALL PRIVILEGES ON wordpress.* TO wp_read_user;
-- 6. Quítele los privilegios de CREATE, DROP, INSERT, DELETE y UPDATE al usuario wp_read_user que puede conectarse desde cualquier máquina sobre a base de datos wordpress.
REVOKE ALL PRIVILEGES ON wordpress.* FROM wp_read_user;
-- 7. Muestre un listado de todos lo usuarios que ha creado en MySQL.
SELECT user, host FROM mysql.user;
-- 8. Muestre los permisos que tiene el usuario wp_read_user que puede conectarse desde cualquier máquina.
SHOW GRANTS FOR wp_read_user;
-- 9. Elimine el usuario wp_read_user que puede conectarse desde cualquier máquina.
DROP USER wp_read_user;