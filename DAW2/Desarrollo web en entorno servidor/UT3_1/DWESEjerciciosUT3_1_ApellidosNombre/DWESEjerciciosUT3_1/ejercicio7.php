<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        // EJERCICIO 7 (OBLIGATORIO) - Busca la fruta
        $primera = 127815;   // &#127815;
        $ultima  = 127827;   // &#127827;

        $cantidad = rand(7, 20);          // entre 7 y 20 frutas
        $frutas = [];
        for ($i = 0; $i < $cantidad; $i++) {
            $frutas[] = rand($primera, $ultima);
        }

        $frutaBuscada = $frutas[array_rand($frutas)];   // fruta elegida al azar (de las mostradas)
        $veces = 0;
        foreach ($frutas as $f) {
            if ($f === $frutaBuscada) {
                $veces++;
            }
        }
    ?>
    <h2>Ejercicio 7</h2>
    <h3>BUSCA LA FRUTA</h3>
    <p>Actualice la página para mostrar otra búsqueda.</p>
    <p><strong><?= $cantidad ?> frutas</strong></p>
    <p class="emoji frutas">
        <?php foreach ($frutas as $f): ?>
            &#<?= $f ?>;
        <?php endforeach; ?>
    </p>
    <p><strong>Resultado</strong></p>
    <p>La fruta <span class="emoji">&#<?= $frutaBuscada ?>;</span> está <strong><?= $veces ?></strong> <?= $veces === 1 ? 'vez' : 'veces' ?> en la lista.</p>
</body>
</html>