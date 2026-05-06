-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-04-2026 a las 20:06:08
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alumno`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ac11actualizarColumnaEmail` ()   BEGIN
    UPDATE alumnado SET email = crearEmail(nombre, apellidos, curso);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `rellenar_t3_con_cursor` ()   BEGIN
    -- Variables donde guardaremos lo que leemos del cursor
    DECLARE v_datos VARCHAR(16);
    DECLARE v_id_menor INT UNSIGNED;
    
    -- Variable bandera para saber cuándo el cursor se queda sin filas
    DECLARE fin_cursor INT DEFAULT 0;
    
    -- 1. Definimos el cursor: va a recorrer todas las filas de t1, columna 'datos'
    DECLARE cur_t1 CURSOR FOR 
        SELECT datos FROM t1;
        
    -- 2. Handler para cuando no haya más filas (NOT FOUND). 
    --    Al saltar, ponemos fin_cursor a 1.
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin_cursor = 1;
    
    -- 3. Sacamos el menor id de t2. Será el mismo para todas las inserciones.
    SELECT MIN(id) INTO v_id_menor FROM t2;
    
    -- 4. Abrimos el cursor (empezamos a leer)
    OPEN cur_t1;
    
    -- 5. Bucle de lectura
    bucle_lectura: LOOP
        -- Leemos una fila del cursor y metemos el valor en v_datos
        FETCH cur_t1 INTO v_datos;
        
        -- Si ya hemos llegado al final, salimos del bucle
        IF fin_cursor = 1 THEN
            LEAVE bucle_lectura;
        END IF;
        
        -- Insertamos en t3: el dato leído y el id menor que calculamos antes
        INSERT INTO t3 (datos, id) VALUES (v_datos, v_id_menor);
    END LOOP;
    
    -- 6. Cerramos el cursor (buena práctica)
    CLOSE cur_t1;
    
END$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `crearEmail` (`nombre` VARCHAR(50), `apellidos` VARCHAR(50), `curso` VARCHAR(50)) RETURNS VARCHAR(255) CHARSET utf8mb4 COLLATE utf8mb4_general_ci  BEGIN
    DECLARE email VARCHAR(255);
    SET email = CONCAT(
        LOWER(LEFT(nombre, 1)),
        LOWER(LEFT(apellidos, 5)),
        LENGTH(apellidos),
        '@',
        LOWER(curso),
        '.kursal.es'
    );
    RETURN email;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnado`
--

CREATE TABLE `alumnado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `curso` varchar(50) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnado`
--

INSERT INTO `alumnado` (`id`, `nombre`, `apellidos`, `curso`, `email`) VALUES
(1, 'Alberto', 'Morales', 'BD', 'amoral7@bd.kursal.es'),
(2, 'Maria', 'Garcia Lopez', 'DWEB', 'mgarci12@dweb.kursal.es'),
(3, 'Juan', 'Perez', 'DEW', 'jperez5@dew.kursal.es'),
(4, 'Ana', 'Martinez', 'DAW', 'amarti8@daw.kursal.es'),
(5, 'Luis', 'Fernandez Ruiz', 'DWC', 'lferna14@dwc.kursal.es');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `nota` float DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t1`
--

CREATE TABLE `t1` (
  `id` int(10) UNSIGNED NOT NULL,
  `datos` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `t1`
--

INSERT INTO `t1` (`id`, `datos`) VALUES
(1, 'A'),
(2, 'B'),
(30, 'C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t2`
--

CREATE TABLE `t2` (
  `id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `t2`
--

INSERT INTO `t2` (`id`) VALUES
(10),
(20),
(3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t3`
--

CREATE TABLE `t3` (
  `datos` varchar(16) DEFAULT NULL,
  `id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnado`
--
ALTER TABLE `alumnado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `t1`
--
ALTER TABLE `t1`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
