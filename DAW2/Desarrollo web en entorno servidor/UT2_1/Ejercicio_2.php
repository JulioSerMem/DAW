<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio_2</title>
</head>
<body>
    <?php
    $emogi=rand(128512, 128586);
    ?>
    <p>Actualiza la pagina para cambiar el emoticono</p>
    <p style="font-size: 100px"><?= "&#$emogi;" ?></p>
</body>
</html>