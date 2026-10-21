const inputPrecio = document.getElementById('precioBase');
const selectIVA = document.getElementById('tipoIVA');
const boton = document.getElementById('btnCalcular');
const ticket = document.getElementById('ticket');

boton.addEventListener('click', () => {
    const precio = parseFloat(inputPrecio.value);
    const porcentajeIVA = parseFloat(selectIVA.value);
    const iva = precio * (porcentajeIVA / 100);
    const total = precio + iva;
    ticket.innerHTML = `
        <h3>--- TICKET DE COMPRA ---</h3>
        <p>Base Imponible: ${precio.toFixed(2)} €</p>
        <p>IVA (${porcentajeIVA}%): ${iva.toFixed(2)} €</p>
        <hr>
        <p><strong>TOTAL: ${total.toFixed(2)} €</strong></p>
    `;
});