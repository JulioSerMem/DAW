-- Reto 5 SQL avanzado
-- TRIGGERS
DELIMITER $$
CREATE OR REPLACE TRIGGER trg_fechaPrestamoBeforeInsert
BEFORE INSERT ON Prestamo FOR EACH ROW
BEGIN
    IF NEW.fecha_prestamo IS NULL THEN
        SET NEW.fecha_prestamo = CURDATE();
    END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE TRIGGER trg_estadoEjemplarAfterUpdatePrestamo
AFTER UPDATE ON Prestamo FOR EACH ROW
BEGIN
    IF OLD.fecha_devolucion IS NULL AND NEW.fecha_devolucion IS NOT NULL THEN
        UPDATE Ejemplares SET estado_ejemplar = 'disponible' WHERE id_ejemplar = NEW.id_ejemplar;
    END IF;
END $$
DELIMITER ;

-- PROCEDIMIENTOS CON TRANSACCIONES
DELIMITER $$
CREATE OR REPLACE PROCEDURE sp_registrarPrestamo(IN p_id_usuario INT, IN p_id_ejemplar INT, IN p_fecha DATE)
BEGIN
    DECLARE v_estado VARCHAR(20);
    SELECT estado_ejemplar INTO v_estado FROM Ejemplares WHERE id_ejemplar = p_id_ejemplar;
    IF v_estado = 'disponible' THEN
        START TRANSACTION;
        INSERT INTO Prestamo (id_usuario, id_ejemplar, fecha_prestamo) VALUES (p_id_usuario, p_id_ejemplar, p_fecha);
        UPDATE Ejemplares SET estado_ejemplar = 'prestado' WHERE id_ejemplar = p_id_ejemplar;
        COMMIT;
    END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE sp_devolverEjemplar(IN p_id_prestamo INT, IN p_fecha_devolucion DATE)
BEGIN
    DECLARE v_devuelto DATE;
    SELECT fecha_devolucion INTO v_devuelto FROM Prestamo WHERE id_prestamo = p_id_prestamo;
    IF v_devuelto IS NULL THEN
        START TRANSACTION;
        UPDATE Prestamo SET fecha_devolucion = p_fecha_devolucion WHERE id_prestamo = p_id_prestamo;
        COMMIT;
    END IF;
END $$
DELIMITER ;

-- PROCEDIMIENTOS CON CURSORES
DELIMITER $$
CREATE OR REPLACE PROCEDURE sp_registrarPrestamosActivos()
BEGIN
    DECLARE v_id_prestamo INT; DECLARE v_nombre VARCHAR(100); DECLARE v_titulo VARCHAR(200);
    DECLARE v_fecha DATE; DECLARE fin INT DEFAULT 0;
    DECLARE cur CURSOR FOR
        SELECT P.id_prestamo, U.nombre, L.titulo, P.fecha_prestamo
        FROM Prestamo P
        JOIN Usuarios U ON P.id_usuario = U.id_usuario
        JOIN Ejemplares E ON P.id_ejemplar = E.id_ejemplar
        JOIN Libros L ON E.isbn = L.isbn
        WHERE P.fecha_devolucion IS NULL;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    DELETE FROM log_prestamos_activos;
    OPEN cur;
    bucle: LOOP
        FETCH cur INTO v_id_prestamo, v_nombre, v_titulo, v_fecha;
        IF fin = 1 THEN LEAVE bucle; END IF;
        INSERT INTO log_prestamos_activos (id_prestamo, nombre_usuario, titulo_libro, fecha_prestamo)
        VALUES (v_id_prestamo, v_nombre, v_titulo, v_fecha);
    END LOOP bucle;
    CLOSE cur;
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE sp_liberarEjemplaresMantenimiento()
BEGIN
    DECLARE v_id INT; DECLARE v_copia VARCHAR(50); DECLARE v_isbn VARCHAR(20); DECLARE fin INT DEFAULT 0;
    DECLARE cur CURSOR FOR SELECT id_ejemplar, copia_ejemplar, isbn FROM Ejemplares WHERE estado_ejemplar = 'mantenimiento';
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    OPEN cur;
    bucle: LOOP
        FETCH cur INTO v_id, v_copia, v_isbn;
        IF fin = 1 THEN LEAVE bucle; END IF;
        INSERT INTO log_mantenimiento (id_ejemplar, copia_ejemplar, isbn) VALUES (v_id, v_copia, v_isbn);
        UPDATE Ejemplares SET estado_ejemplar = 'disponible' WHERE id_ejemplar = v_id;
    END LOOP bucle;
    CLOSE cur;
END $$
DELIMITER ;

-- FUNCIONES
DROP FUNCTION IF EXISTS fn_totalPrestamosUsuario;
DROP FUNCTION IF EXISTS fn_autorLibro;
DELIMITER $$
CREATE FUNCTION fn_totalPrestamosUsuario(p_id_usuario INT) RETURNS INT DETERMINISTIC
BEGIN
    DECLARE v_total INT;
    SELECT COUNT(*) INTO v_total FROM Prestamo WHERE id_usuario = p_id_usuario;
    RETURN v_total;
END $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION fn_autorLibro(p_isbn VARCHAR(20)) RETURNS VARCHAR(100) DETERMINISTIC
BEGIN
    DECLARE v_nombre VARCHAR(100);
    SELECT A.nombre_autor INTO v_nombre FROM Autor A JOIN es_escrito E ON A.id_autor = E.id_autor WHERE E.isbn = p_isbn LIMIT 1;
    RETURN COALESCE(v_nombre, 'Autor desconocido');
END $$
DELIMITER ;

DELIMITER $$
CREATE OR REPLACE PROCEDURE sp_generarDashboard()
BEGIN
    CALL sp_registrarPrestamosActivos();
    CALL sp_liberarEjemplaresMantenimiento();
    DELETE FROM dashboard_estadisticas;
    INSERT INTO dashboard_estadisticas (indicador, valor_numerico)
        SELECT CONCAT('Préstamos del usuario: ', nombre), fn_totalPrestamosUsuario(id_usuario) FROM Usuarios;
    INSERT INTO dashboard_estadisticas (indicador, valor_numerico) VALUES
        ('Total libros en catálogo',(SELECT COUNT(*) FROM Libros)),
        ('Total usuarios registrados',(SELECT COUNT(*) FROM Usuarios)),
        ('Total ejemplares',(SELECT COUNT(*) FROM Ejemplares)),
        ('Ejemplares disponibles',(SELECT COUNT(*) FROM Ejemplares WHERE estado_ejemplar = 'disponible')),
        ('Préstamos activos',(SELECT COUNT(*) FROM Prestamo WHERE fecha_devolucion IS NULL)),
        ('Préstamos totales (histórico)',(SELECT COUNT(*) FROM Prestamo));
    INSERT INTO dashboard_estadisticas (indicador, valor_texto)
        SELECT 'Libro más prestado', CONCAT(L.titulo, ' (', fn_autorLibro(L.isbn), ')')
        FROM Libros L JOIN Ejemplares E ON L.isbn = E.isbn JOIN Prestamo P ON E.id_ejemplar = P.id_ejemplar
        GROUP BY L.isbn, L.titulo ORDER BY COUNT(*) DESC LIMIT 1;
    SELECT 'OK: Dashboard generado correctamente.' AS mensaje;
END $$
DELIMITER ;

-- EJECUCIÓN
CALL sp_generarDashboard();
SELECT indicador, valor_numerico, valor_texto, fecha_actualizacion FROM dashboard_estadisticas;