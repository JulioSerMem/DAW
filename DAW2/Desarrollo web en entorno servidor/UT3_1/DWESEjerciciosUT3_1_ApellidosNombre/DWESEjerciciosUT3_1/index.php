<?php
// ---------- DATOS PERSONALES ----------
$nombre = "Julio Serrano Membrive";
$curso  = "2ºY DAW";
$modulo = "Desarrollo web en entorno servidor (DWES)";
// -----------------------------------------------------------------

$ejercicios = [
    1 => "ejercicio1.php",
    2 => "ejercicio2.php",
    3 => "ejercicio3.php",
    4 => "ejercicio4.php",
    5 => "ejercicio5.php",
    6 => "ejercicio6.php",
    7 => "ejercicio7.php",
    8 => "ejercicio8.php",
];

$ej = isset($_GET['ej']) ? (int) $_GET['ej'] : 1;
if (!isset($ejercicios[$ej])) {
    $ej = 1;
}
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ejercicios UT3_1 Estructuras de control - 2ºDAW</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
    <header>
        <h1>Ejercicios UT3_1 Estructuras de control - 2ºDAW</h1>
        <div class="datos">
            <p>Nombre: <?= htmlspecialchars($nombre) ?></p>
            <p>Curso: <?= htmlspecialchars($curso) ?></p>
            <p>Módulo: <?= htmlspecialchars($modulo) ?></p>
        </div>
    </header>

    <nav class="tabs" aria-label="Ejercicios">
        <ul>
            <?php foreach ($ejercicios as $n => $fichero): ?>
                <li><a href="index.php?ej=<?= $n ?>"<?= $n === $ej ? ' class="activa" aria-current="page"' : '' ?>>Ejercicio <?= $n ?></a></li>
            <?php endforeach; ?>
        </ul>
    </nav>

    <main>
        <section class="ejercicio">
            <?php include __DIR__ . '/' . $ejercicios[$ej]; ?>
        </section>
    </main>
</body>
</html>
