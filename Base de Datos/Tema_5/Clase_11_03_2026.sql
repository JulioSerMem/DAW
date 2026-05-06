DELIMITER //
CREATE OR REPLACE PROCEDURE cantidadUsuarioPorDepartamento(IN codDepartmnto char(5), OUT total int)
COMMENT "Recuperar los usuarios del departamento pasado como parametro"
BEGIN
	-- declarar variable
    DECLARE total int DEFAULT 0;
    -- modificar select
    -- SELECT count(*) into total from usuario where departamento = codDepartamento;
    set total = (SELECT COUNT(*) FROM usuario WHERE departamento = codDepartamento);
    -- mostrar el nº de usuarios del departamento
	SELECT total;
END;
//
DELIMITER ;

CALL cantidadUsuarioPorDepartamento('IT', @total);
SELECT @total;