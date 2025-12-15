//2. Realizar un método al que se le pase una cadena con un número de teléfono (999999999) y devuelva
//una nueva cadena con el teléfono formateado de esta forma 999-99-99-99.
package ejercicios_ampliacion_string;

public class Act_2 {

    // Método que recibe un teléfono de 9 cifras y lo formatea como 999-99-99-99
    public static String formatearTelefono(String tel) {

        // Comprobar longitud exacta
        if (tel.length() != 9) {
            return "ERROR: el teléfono debe tener 9 dígitos.";
        }

        // Comprobar que todos los caracteres son dígitos
        for (int i = 0; i < tel.length(); i++) {
            char c = tel.charAt(i);
            if (c < '0' || c > '9') {
                return "ERROR: el teléfono solo puede contener números.";
            }
        }

        // Construir manualmente la cadena formateada
        String resultado = "";

        for (int i = 0; i < tel.length(); i++) {
            // Añadimos el dígito actual
            resultado = resultado + tel.charAt(i);

            // Insertamos guiones después de ciertas posiciones
            if (i == 2 || i == 4 || i == 6) {
                resultado = resultado + "-";
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        String telefono = "999999999";
        String formateado = formatearTelefono(telefono);

        System.out.println("Teléfono formateado: " + formateado);
    }
}
