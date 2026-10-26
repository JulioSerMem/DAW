<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        // EJERCICIO 8 (OBLIGATORIO)
        $emoticonos = [128169, 128168, 127866, 128405, 129313];
    ?>

    <h2>Ejercicio 8</h2>
    <h3>Apartado 1</h3>
    <table class="cuadricula">
        <tbody>
            <?php for ($fila = 0; $fila < 10; $fila++): ?>
                <tr>
                    <?php for ($col = 1; $col <= 10; $col++): ?>
                        <td><?= $fila * 10 + $col ?></td>
                    <?php endfor; ?>
                </tr>
            <?php endfor; ?>
        </tbody>
    </table>

    <h3>Apartado 2</h3>
    <table class="cuadricula emojis">
        <tbody>
            <?php for ($fila = 0; $fila < 10; $fila++): ?>
                <tr>
                    <?php for ($col = 0; $col < 10; $col++): ?>
                        <td>&#<?= $emoticonos[array_rand($emoticonos)] ?>;</td>
                    <?php endfor; ?>
                </tr>
            <?php endfor; ?>
        </tbody>
    </table>
</body>
</html>