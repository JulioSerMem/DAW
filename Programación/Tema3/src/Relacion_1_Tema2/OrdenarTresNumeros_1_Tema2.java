package Relacion_1_Tema2;
import java.util.*;
public class OrdenarTresNumeros_1_Tema2 { // Definición de la clase principal
    private static Scanner teclado = new Scanner(System.in);// Se crea un objeto Scanner para poder leer datos desde el teclado
    public static void main(String[] args) { // Método principal, punto de entrada del programa
        double num = -1;
        // Se piden tres números al usuario
        double num1 = numeros(num);
        double num2 = numeros(num);
        double num3 = numeros(num);
        // Se determinan el número mayor, el menor y el del medio
        double max = ordenarMayor(num1, num2, num3);
        double min = ordenarMenor(num1, num2, num3);
        double medio = ordenarMedio(num1, num2, num3, max, min);
        // Se muestran los números ordenados de mayor a menor
        System.out.println(max + " > " + medio + " > " + min);
    }
    
    // Método que solicita un número positivo al usuario hasta que se introduzca uno válido.
    private static double numeros(double num) {
        System.out.println("Introduzca un numero");
        num = teclado.nextDouble(); // Lee el número desde el teclado
        // Bucle que confirma que el número no sea negativo
        while (num < 0) {
            System.out.println("Ese numero no es valido, intentalo otra vez");
            num = teclado.nextDouble();
        }
        // Devuelve el número introducido
        return num;
    }

     //Método que devuelve el número mayor entre tres valores.
    private static double ordenarMayor(double num1, double num2, double num3) {
        // Si num1 es mayor o igual que los otros dos, es el máximo
        if (num1 >= num2 && num1 >= num3) {
            return num1;
        // Si no, se comprueba si num2 es el mayor
        } else if (num2 >= num3 && num2 >= num1) {
            return num2;
        }
        // Si no se cumple ninguna de las anteriores, el mayor es num3
        return num3;
    }

    //Método que devuelve el número menor entre tres valores.
    private static double ordenarMenor(double num1, double num2, double num3) {
        // Si num1 es menor o igual que los otros dos, es el mínimo
        if (num1 <= num2 && num1 <= num3) {
            return num1;
        // Si no, se comprueba si num2 es el menor
        } else if (num2 <= num1 && num2 <= num3) {
            return num2;
        }
        // Si no se cumple ninguna de las anteriores, el menor es num3
        return num3;
    }
    
    //Método que determina el número "medio" (ni el mayor ni el menor).
    private static double ordenarMedio(double num1, double num2, double num3, double max, double min) {
        // Si num1 no es ni el máximo ni el mínimo, debe ser el medio
        if (num1 != max && num1 != min) {
            return num1;
        }
        // Si num2 no es ni el máximo ni el mínimo, debe ser el medio
        if (num2 != max && num2 != min) {
            return num2;
        }
        // Si hay números repetidos:
        // Si num1 es igual a alguno de los otros, devolvemos num1 (es el medio en ese caso)
        if (num1 == num2 || num1 == num3) {
            return num1;
        }
        // Si num2 es igual a num3, devolvemos num2
        if (num2 == num3) {
            return num2;
        }
        // Caso de seguridad: si por alguna razón no entra en ninguno de los anteriores, devuelve num3
        return num3;
    }
}