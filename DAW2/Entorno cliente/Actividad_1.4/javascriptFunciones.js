function  calcularDiasDiferencia(){
    const strInicio = document.getElementById('fechaInicio').value;
    const strFin = document.getElementById('fechaFin').value;
    const fechaInicio = new Date(strInicio);
    const fechaFin = new Date(strFin);
    const msI = fechaInicio.getTime();
    const msF = fechaFin.getTime();
    let msResta = Math.round(msF - msI);
    let dias = msResta / 86400000;
    document.getElementById('resultado').innerText = `La diferencia es de ${dias} días.`;
}
function obtenerUltimoDiaMes() {
    const año = document.getElementById('año').value;
    const mes = document.getElementById('mes').value;
    let fecha = new Date(año,mes,0);
    let dia = fecha.getDate();

    document.getElementById('resultado').innerText = `Ese mes tiene ${dia} Días.`;
}
function formatearFechaEspanola() {
    const fecha = document.getElementById('fecha').value;
    const fecha2 = new Date(fecha);
    let dia = fecha2.getDate();
    let mes = fecha2.getMonth();
    let año = fecha2.getFullYear();
    let hora = fecha2.getHours();
    let minuto = fecha2.getMinutes();
    let dias = dia.toString().padStart(2,"0");
    let meses2 = mes+1;
    let meses = meses2.toString().padStart(2,"0");
    let horas = hora.toString().padStart(2,"0");
    let minutos = minuto.toString().padStart(2,"0");
    let cadena = String(dias+"/" + meses +"/" + año +" " + horas +":"+ minutos);
    document.getElementById('resultado').innerText = `Fecha: ${cadena}`;
}
