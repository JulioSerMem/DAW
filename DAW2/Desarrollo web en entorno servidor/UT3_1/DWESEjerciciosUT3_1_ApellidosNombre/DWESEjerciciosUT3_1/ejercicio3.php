<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio_3</title>
</head>
<body>
    <h2>Ejercicio 3</h2>
    <p>Escribe tres números positivos y comprueba si son iguales.</p>

    <?php
        // Si se accede con POST es que se han enviado los datos
        if ($_SERVER["REQUEST_METHOD"] == "POST") {

        $a = (int) $_POST["numero1"];
        $b = (int) $_POST["numero2"];
        $c = (int) $_POST["numero3"];

            if ($a >= 0 && $b >= 0 && $c >= 0) {

                if ($a == $b && $b == $c) {
                    $mensaje = "hay tres números iguales a $a";
                    $tipo = "exito";
                } elseif ($a == $b) {
                    $mensaje = "hay dos números iguales a $a";
                    $tipo = "aviso";
                } elseif ($a == $c) {
                    $mensaje = "hay dos números iguales a $a";
                    $tipo = "aviso";
                } elseif ($b == $c) {
                    $mensaje = "hay dos números iguales a $b";
                    $tipo = "aviso";
                } else {
                    $mensaje = "no hay números iguales";
                    $tipo = "neutro";
                }

                echo "<p class=\"$tipo\">Has introducido: $a, $b, $c<br>$mensaje</p>";

            } else {
                echo "<p class=\"error\">Los tres números deben ser positivos. Vuelve a intentarlo.</p>";
            }
        }
    ?>

    <form action="index.php?ej=3" method="post">
        <fieldset>
            <legend>Introduce tres números positivos</legend>
            <label for="numero1">Número 1:</label>
            <input type="number" id="numero1" name="numero1" min="0" required>
            <label for="numero2">Número 2:</label>
            <input type="number" id="numero2" name="numero2" min="0" required>
            <label for="numero3">Número 3:</label>
            <input type="number" id="numero3" name="numero3" min="0" required>
            <input type="submit" value="Comprobar">
        </fieldset>
    </form>
</body>
</html>