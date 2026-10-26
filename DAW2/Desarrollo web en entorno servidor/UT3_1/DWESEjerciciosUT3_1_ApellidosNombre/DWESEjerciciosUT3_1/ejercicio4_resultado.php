<?php
// EJERCICIO 4 (OPCIONAL) - Página de resultado
$error = "";
$suma  = 0;
$numero = null;

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['numero'])) {
    $numero = filter_var(trim($_POST['numero']), FILTER_VALIDATE_INT, ['options' => ['min_range' => 0]]);
    if ($numero === false) {
        $error = "El valor introducido no es un número entero positivo.";
    } else {
        for ($i = 0; $i < $numero; $i += 2) {   // pares anteriores al número
            $suma += $i;
        }
    }
} else {
    $error = "No se ha recibido ningún número desde el formulario.";
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ejercicio 4 - Resultado</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
    <h1>Ejercicio 4 - Resultado</h1>
<?php if ($error !== ""): ?>
    <p class="error"><?= htmlspecialchars($error) ?></p>
<?php else: ?>
    <p class="resultado">La suma de todos los números pares anteriores a <strong><?= $numero ?></strong> es <strong><?= $suma ?></strong>.</p>
<?php endif; ?>
    <p><a href="index.php?ej=4">Volver al formulario</a></p>
</body>
</html>