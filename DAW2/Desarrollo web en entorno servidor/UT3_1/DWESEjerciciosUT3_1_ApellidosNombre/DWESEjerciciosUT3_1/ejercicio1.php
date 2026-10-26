<?php
// EJERCICIO 1 (OPCIONAL) - Lanzar una moneda al aire
$esCara = (random_int(0, 1) === 0);
$imagen = $esCara ? 'img/cara.svg' : 'img/cruz.svg';
$texto  = $esCara ? 'Cara' : 'Cruz';
?>
<h2>Ejercicio 1</h2>
<p>Lanzamiento de una moneda. Actualiza la página para volver a lanzarla.</p>
<figure>
    <img class="moneda" src="<?= $imagen ?>" width="150" height="150">
    <figcaption><?= $texto ?></figcaption>
</figure>
<p class="resultado">Ha salido: <strong><?= $texto ?></strong></p>
