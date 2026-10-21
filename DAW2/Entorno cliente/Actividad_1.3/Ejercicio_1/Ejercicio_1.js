// Definimos el array con todas las imágenes
const imagenes = ['Goomy.png', 'Sliggoo.png', 'Goodra.png', 'Lugia.png'];

// Variable para llevar el control de la imagen actual
let indice = 0;

// Función auxiliar para actualizar el src de la imagen en el DOM
function actualizarImagen() {
    var imagen = document.getElementById('visualizador');
    imagen.src = imagenes[indice];
}

// Función para avanzar
function avanzar() {
    indice = (indice + 1) % imagenes.length;
    actualizarImagen();
}

// Función para retroceder
function retroceder() {
    indice = (indice - 1 + imagenes.length) % imagenes.length;
    actualizarImagen();
}