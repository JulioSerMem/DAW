-- 1. Comprueba los permisos del usuario ac901local.
SHOW GRANTS FOR 'ac901local'@'localhost';
-- 2. Sobre el usuario ac901local:
	-- 1. Comprueba sus permisos
    SHOW GRANTS FOR 'ac901local'@'localhost';
    -- 2. Asigna los permisos necesarios para que sólo pueda acceder a la tabla ayuntamiento.usuario, pudiendo hacer 		consultas, inserciones y borrados, pero no modificaciones sobre los datos.
    GRANT SELECT,INSERT,DELETE ON ayuntamiento.usuario TO 'ac901local'@'localhost';
    -- 3. Comprueba de nuevo los permisos.
    SHOW GRANTS FOR 'ac901local'@'localhost';
    -- 4. Insertar un nuevo usuario.
    INSERT INTO ayuntamiento.usuario (email, password, nombre, departamento) VALUES ("emailnuevo@gmail.com" , "Fillipo123" , "Fillipo" , "Ventas");
    -- 5. Intenta modificar el nuevo usuario
    UPDATE ayuntamiento.usuario SET departamento = 'IT' WHERE email = 'emailnuevo@gmail.com';
    -- 6. Elimina el usuario insertado.
    DELETE FROM ayuntamiento.usuario WHERE email = 'emailnuevo@gmail.com';
-- 3. Crea un nuevo usuario ac902lectura con contraseña s8a que únicamente pueda consultar todas las tablas de la base de datos de tu trabajo del tema anterior.
CREATE USER 'ac902lectura'@'localhost' IDENTIFIED BY 's8a';
GRANT SELECT ON ayuntamiento.* TO 'ac902lectura'@'localhost';
FLUSH PRIVILEGES;
-- 4. Crea un nuevo usuario ac903todo con contraseña s8a pueda hacer de todo en el sistema, a modo de administrador del sistema.
CREATE USER 'ac903todo'@'localhost' IDENTIFIED BY 's8a';
GRANT ALL PRIVILEGES ON *.* TO 'ac903todo'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
-- 5. Entra al sistema como el usuario ac903todo, y elimina los usuarios ac901local y ac902lectura.
DROP USER 'ac901local'@'localhost';
DROP USER 'ac902lectura'@'localhost';
-- 6. Recupera los usuarios existentes en el sistema.
SELECT user, host FROM mysql.user;