<?php
// EJERCICIO 4 (OPCIONAL) - Formulario (el resultado se muestra en otra página)
?>
<h2>Ejercicio 4</h2>
<form action="ejercicio4_resultado.php" method="post">
    <fieldset>
        <legend>Suma de los números pares anteriores</legend>
        <label for="numero">Introduce un número:</label>
        <input type="number" id="numero" name="numero" min="0" step="1" required>
        <button type="submit">Calcular</button>
    </fieldset>
</form>
