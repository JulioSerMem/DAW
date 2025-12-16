package Relacion_1_Tema2;
import java.util.*;
public class BaseExponente_2_Tema2 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	// Método principal, punto de entrada del programa
	public static void main(String[]args) {
	//Inicio las variables para que funcione el programa
	int base = 0, exponente = 0, resultado = 0;
	//Les doy sus valores correspondientes gracias a los metodos
	base = base(base);
	exponente = exponente(exponente);
	resultado = resultado(base, exponente, resultado);
	//Imprimo la solucion
	System.out.println("La solucion de " + base + " elevado a " + exponente + " es " + resultado + ".");
	}
	//Metodo que solicita numeros para la base hasta que esta sea mayor a 0
	private static int base(int base) {
		System.out.println("Introduzca un numero para la base");
		base = teclado.nextInt();
		// Bucle que confirma que el número no sea negativo
		while(base<0) {
			System.out.println("La base debe ser mayo a 0");
			base = teclado.nextInt();
		}return base;
	}
	//Metodo que solicita numeros para el exponente hasta que esta sea mayor a 0
	private static int exponente(int exponente) {
		System.out.println("Introduzca un numero para el exponente");
		exponente = teclado.nextInt();
		// Bucle que confirma que el número no sea negativo
		while(exponente<0) {
			System.out.println("El exponente debe ser mayo a 0");
			exponente = teclado.nextInt();
		}return exponente;
	}
	//Metodo que calcula la cuanto da el numero base multplicado por si mismo tantas veces diga el exponente
	private static int resultado(int base, int exponente, int resultado) {
		resultado = (int) Math.pow(base,exponente);
		return resultado;
	}
}
