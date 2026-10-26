<?php
// EJERCICIO 5 (OPCIONAL) - Tabla UNICODE del 0 al 50000 con la sintaxis &#número;
// Los caracteres de control (0-32 y 127-159) no se pueden escribir como
// referencia numérica en HTML5 (el validador de W3C los marca como error),
// por eso en esas celdas se muestra un guion.
?>
<h2>Ejercicio 5</h2>
<p>Tabla UNICODE del 0 al 50000.</p>
<table class="unicode">
    <caption>Código y carácter (&amp;#número;)</caption>
    <tbody>
<?php
$max = 50000;
for ($i = 0; $i <= $max; $i++) {
    if ($i % 10 === 0) {
        echo "<tr>";
    }
    $esControl = ($i <= 32) || ($i >= 127 && $i <= 159);
    $caracter = $esControl ? "&ndash;" : "&#$i;";
    echo "<td><span class=\"cod\">$i</span>$caracter</td>";
    if ($i % 10 === 9) {
        echo "</tr>\n";
    }
}
echo "</tr>\n";   // cierra la última fila (solo contiene el 50000)
?>
    </tbody>
</table>
