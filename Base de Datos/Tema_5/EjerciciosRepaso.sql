-- 1. Realice los siguientes procedimientos y funciones sobre la base de datos jardineria.
/*
Función: calcular_precio_total_pedido
Descripción: Dado un código de pedido la función debe calcular la suma total del pedido. Tenga en cuenta que un pedido puede contener varios productos diferentes y varias cantidades de cada producto.
Parámetros de entrada: codigo_pedido (INT)
Parámetros de salida: El precio total del pedido (DECIMAL)
*/
DELIMITER $$
CREATE OR REPLACE FUNCTION calcular_precio_total_pedido(codigo_pedido INT)
RETURNS DECIMAL(10,2)
BEGIN
    DECLARE total DECIMAL(10,2);
    SELECT SUM(cantidad * precio_unidad) INTO total
    FROM detalle_pedido
    WHERE codigo_pedido = codigo_pedido;
    RETURN total;
END $$
DELIMITER ;

SELECT calcular_precio_total_pedido(1) AS total_pedido;

/*
Función: calcular_suma_pedidos_cliente
Descripción: Dado un código de cliente la función debe calcular la suma total de todos los pedidos realizados por el cliente. Deberá hacer uso de la función calcular_precio_total_pedido que ha desarrollado en el apartado anterior.
Parámetros de entrada: codigo_cliente (INT)
Parámetros de salida: La suma total de todos los pedidos del cliente (DECIMAL)
*/
DELIMITER $$
CREATE OR REPLACE FUNCTION calcular_suma_pedidos_cliente(codigo_cliente INT)
RETURNS DECIMAL(10,2)
BEGIN
    DECLARE suma_pedidos DECIMAL(10,2);
    SELECT SUM(calcular_precio_total_pedido(codigo_pedido)) INTO suma_pedidos
    FROM pedido
    WHERE codigo_cliente = codigo_cliente;
    RETURN suma_pedidos;
END $$
DELIMITER ;

SELECT calcular_suma_pedidos_cliente(1) AS total_pedidos;

/*rámetros de entrada: codigo_cliente (INT)
Parámet
Función: calcular_suma_pagos_cliente
Descripción: Dado un código de cliente la función debe calcular la suma total de los pagos realizados por ese cliente.
Paros de salida: La suma total de todos los pagos del cliente (DECIMAL)
*/
DELIMITER $$
CREATE OR REPLACE FUNCTION calcular_suma_pagos_cliente(codigo_cliente INT)
RETURNS DECIMAL(10,2)
BEGIN
    DECLARE suma_pagos DECIMAL(10,2);
    SELECT SUM(total) INTO suma_pagos
    FROM pago
    WHERE codigo_cliente = codigo_cliente;
    RETURN suma_pagos;
END $$
DELIMITER ;

SELECT calcular_suma_pagos_cliente(1) AS total_pagos;

/*
Procedimiento: calcular_pagos_pendientes
Descripción: Deberá calcular los pagos pendientes de todos los clientes. Para saber si un cliente tiene algún pago pendiente deberemos calcular cuál es la cantidad de todos los pedidos y los pagos que ha realizado. Si la cantidad de los pedidos es mayor que la de los pagos entonces ese cliente tiene pagos pendientes.
Deberá utilizar las funciones calcular_suma_pedidos_cliente y calcular_suma_pagos_cliente, que ha desarrollado en los ejercicios anteriores.
Deberá insertar en una tabla llamada clientes_con_pagos_pendientes los siguientes datos:

codigo_cliente
suma_total_pedidos
suma_total_pagos
pendiente_de_pago
*/

-- 2. Crea una tabla que se llame notificaciones que tenga las siguientes columnas:
/*
id (entero sin signo, autoincremento y clave primaria)
fecha_hora: marca de tiempo con el instante del pago (fecha y hora)
total: el valor del pago (real)
codigo_cliente: código del cliente que realiza el pago (entero)
*/

-- 3. Escriba un trigger que nos permita llevar un control de los pagos que van realizando los clientes. Los detalles de implementación son los siguientes:
/*
Nombre: trigger_notificar_pago
Se ejecuta sobre la tabla pago.
Se ejecuta después de hacer la inserción de un pago.
Cada vez que un cliente realice un pago (es decir, se hace una inserción en la tabla pago), el trigger deberá insertar un nuevo registro en una tabla llamada notificaciones.
*/