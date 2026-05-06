-- En la base de datos empresa, crea:

-- 1º El procedimiento ac09semanaIf que reciba como entrada un entero que represente un día de la semana y que devuelva una cadena con el nombre del día de la semana correspondiente (utilizando IF). Por ejemplo, para la entrada 1 debería devolver Lunes.
DELIMITER $$
CREATE PROCEDURE ac09semanaIf (
    IN  p_dia INT,
    OUT p_nombre VARCHAR(20)
)
BEGIN
    IF p_dia = 1 THEN
        SET p_nombre := 'Lunes';
    ELSEIF p_dia = 2 THEN
        SET p_nombre := 'Martes';
    ELSEIF p_dia = 3 THEN
        SET p_nombre := 'Miércoles';
    ELSEIF p_dia = 4 THEN
        SET p_nombre := 'Jueves';
    ELSEIF p_dia = 5 THEN
        SET p_nombre := 'Viernes';
    ELSEIF p_dia = 6 THEN
        SET p_nombre := 'Sábado';
    ELSEIF p_dia = 7 THEN
        SET p_nombre := 'Domingo';
    ELSE
        SET p_nombre := 'Valor no válido';
    END IF;
END$$

-- 2º El procedimiento ac09semanaCase que reciba como entrada un entero que represente un día de la semana y que devuelva una cadena con el nombre del día de la semana correspondiente (utilizando CASE)
DELIMITER $$
CREATE PROCEDURE ac09semanaCase (
    IN  p_dia INT,
    OUT p_nombre VARCHAR(20)
)
BEGIN
    CASE p_dia
        WHEN 1 THEN SET p_nombre := 'Lunes';
        WHEN 2 THEN SET p_nombre := 'Martes';
        WHEN 3 THEN SET p_nombre := 'Miércoles';
        WHEN 4 THEN SET p_nombre := 'Jueves';
        WHEN 5 THEN SET p_nombre := 'Viernes';
        WHEN 6 THEN SET p_nombre := 'Sábado';
        WHEN 7 THEN SET p_nombre := 'Domingo';
        ELSE
            SET p_nombre := 'Valor no válido';
    END CASE;
END$$

-- 3º El procedimiento ac09semanaCasIng que reciba como entrada un entero que represente un día de la semana y una cadena con el idioma (los posibles valores son CAS o ING) y que devuelva una cadena con el nombre del día de la semana correspondiente en el idioma indicado (puedes utilizar las sentencias condicionales que consideres). Por ejemplo, para 1 y CAS, devolverá Lunes, pero si es ING devolverá Monday.
-- Debes pensar y argumentar qué sucede si cualquiera de los parámetros recibidos como entrada no contienen alguno de los valores esperados.
DELIMITER $$
CREATE PROCEDURE ac09semanaCasIng (
    IN  p_dia    INT,
    IN  p_idioma CHAR(3),
    OUT p_nombre VARCHAR(20)
)
BEGIN
    IF p_idioma = 'CAS' THEN
        CASE p_dia
            WHEN 1 THEN SET p_nombre := 'Lunes';
            WHEN 2 THEN SET p_nombre := 'Martes';
            WHEN 3 THEN SET p_nombre := 'Miércoles';
            WHEN 4 THEN SET p_nombre := 'Jueves';
            WHEN 5 THEN SET p_nombre := 'Viernes';
            WHEN 6 THEN SET p_nombre := 'Sábado';
            WHEN 7 THEN SET p_nombre := 'Domingo';
            ELSE
                SET p_nombre := 'Día no válido';
        END CASE;
    ELSEIF p_idioma = 'ING' THEN
        CASE p_dia
            WHEN 1 THEN SET p_nombre := 'Monday';
            WHEN 2 THEN SET p_nombre := 'Tuesday';
            WHEN 3 THEN SET p_nombre := 'Wednesday';
            WHEN 4 THEN SET p_nombre := 'Thursday';
            WHEN 5 THEN SET p_nombre := 'Friday';
            WHEN 6 THEN SET p_nombre := 'Saturday';
            WHEN 7 THEN SET p_nombre := 'Sunday';
            ELSE
                SET p_nombre := 'Invalid day';
        END CASE;
    ELSE
        SET p_nombre := 'Idioma no válido';
    END IF;
END$$


-- A continuación, sobre la tabla habilidad, crea:

-- 1º El procedimiento ac09insertaHabilidad que reciba como entrada un código de habilidad y su descripción, y que sólo la inserte si el código de la habilidad tiene un tamaño de 5 caracteres.
DELIMITER $$
CREATE PROCEDURE ac09insertaHabilidad (
    IN p_cod  VARCHAR(5),
    IN p_desc VARCHAR(100)
)
BEGIN
    IF p_cod IS NOT NULL
    AND CHAR_LENGTH(p_cod) = 5
    AND p_desc IS NOT NULL THEN

        INSERT INTO habilidad (cod_habilidad, descripcion)
        VALUES (p_cod, p_desc);

    END IF;
END$$

-- 2º El procedimiento ac09upsertHabilidad que reciba como entrada un código de habilidad y su descripción, y que sólo la inserte si el código de la habilidad tiene un tamaño de 5 caracteres. Si el código ya existe, debe modificar la habilidad con la nueva descripción, y si no, la insertará.
DELIMITER $$
CREATE OR REPLACE PROCEDURE ac09upsertHabilidad(IN cod CHAR(5), IN des VARCHAR(30))
BEGIN
    DECLARE contador INT DEFAULT 0;
    IF CHAR_LENGTH(cod) = 5 THEN
        SELECT COUNT(*) INTO contador
        FROM habilidad
        WHERE CodHab = cod;

        IF contador > 0 THEN -- si existe
            UPDATE habilidad
            SET DesHab = des
            WHERE CodHab = cod;
        ELSE -- no existe
            INSERT INTO habilidad (CodHab, DesHab)
            VALUES (cod, des);
        END IF;

    END IF;
END $$

-- 3º El procedimiento ac09upsertHabilidadPlus que además de todo lo anterior, informe al usuario de la operación realizada. En el caso de que los datos de entrada sean incorrectos o incompletos, deberá también informar de ello.
DELIMITER $$

CREATE OR REPLACE PROCEDURE ac09upsertHabilidadPlus(
    IN cod CHAR(5), 
    IN des VARCHAR(30), 
    OUT mensaje VARCHAR(100)
)
BEGIN
    DECLARE contador INT DEFAULT 0;

    IF CHAR_LENGTH(cod) = 5 THEN
        SELECT COUNT(*) INTO contador
        FROM habilidad
        WHERE CodHab = cod;

        IF contador > 0 THEN -- si existe
            UPDATE habilidad
            SET DesHab = des
            WHERE CodHab = cod;
            SET mensaje = 'Éxito: habilidad actualizada';
        ELSE -- no existe
            INSERT INTO habilidad (CodHab, DesHab)
            VALUES (cod, des);
            SET mensaje = 'Éxito: nueva habilidad insertada';
        END IF;
    ELSE
        SET mensaje = 'Error: el codigo debe tener 5 caracteres';
        -- Opcional: set mensaje = CONCAT('Error: el código ', cod, ' debe tener 5 caracteres');
    END IF;
END $$