<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ejercicio_3</title>
</head>
<body>
    <h1>Contador de coincidencias</h1>
    <form method="POST" action="">
        <label for="frase">Introduce una frase:</label>
        
        <br>

        <input type="text" id="frase" name="frase" required>

        <br>
        <br>
        
        <label for="buscar">¿Qué quieres buscar?</label>
        
        <br>
        
        <input type="text" id="buscar" name="buscar" required>
        
        <br>
        <br>

        <input type="submit" name="enviar" value="Contar coincidencias">

    </form>
    <?php
    if (isset($_POST["enviar"])) {

        $frase = $_POST["frase"];
        $buscar = $_POST["buscar"];

        $contador = substr_count($frase, $buscar);

        echo "<h2>Resultado</h2>";
        echo "La frase es: " . $frase . "<br>";
        echo "Buscamos: " . $buscar . "<br>";
        echo "Número de coincidencias: " . $contador;

    }
    ?>
</body>
</html>