<?php
// EJERCICIO 6 (OPCIONAL) - Tabla de multiplicar de un número aleatorio
$numero = mt_rand(1, 10);
?>
<h2>Ejercicio 6</h2>
<p>Número aleatorio generado: <strong><?= $numero ?></strong>. Actualiza la página para generar otro.</p>
<table class="tabla">
    <caption>Tabla de multiplicar del <?= $numero ?></caption>
    <tbody>
<?php for ($i = 1; $i <= 10; $i++): ?>
        <tr><td><?= $numero ?> x <?= $i ?></td><td>=</td><td><?= $numero * $i ?></td></tr>
<?php endfor; ?>
    </tbody>
</table>
