<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio_1</title>
    <style>
        .p {
            font-size: <?= $tamano ?>%;
        }
    </style>
</head>
<body>
    <?php
        $num = rand(1, 100);
        $tamano = rand(200, 800);
    ?>
    <h1>Ejercicio 1</h1>
    <p>El numero generado aleatoriamente es: <?= $num ?></p>
    <p class="p" style="font-size: <?= $tamano ?>%"><?= $num ?></p>
    <p>El tamaño del numero es: <?= $tamano ?>%</p>
</body>
</html>