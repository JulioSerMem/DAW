<?php
// EJERCICIO 2 (OPCIONAL) - Adivina la nota del curso
$nota = mt_rand(100, 1000) / 100;   // número aleatorio entre 1,00 y 10,00

if ($nota < 5) {
    $calificacion = "Insuficiente";
} elseif ($nota < 6) {
    $calificacion = "Suficiente";
} elseif ($nota < 7) {
    $calificacion = "Bien";
} elseif ($nota < 9) {
    $calificacion = "Notable";
} else {
    $calificacion = "Sobresaliente";
}
?>
<h2>Ejercicio 2</h2>
<p>Adivino la nota que obtendrás en el curso. Actualiza la página para otra predicción.</p>
<p class="resultado">
    Número generado: <strong><?= number_format($nota, 2, ',', '') ?></strong><br>
    Tu nota será: <strong><?= $calificacion ?></strong>
</p>
<ul>
    <li>Insuficiente: [0, 5)</li>
    <li>Suficiente: [5, 6)</li>
    <li>Bien: [6, 7)</li>
    <li>Notable: [7, 9)</li>
    <li>Sobresaliente: [9, 10]</li>
</ul>
