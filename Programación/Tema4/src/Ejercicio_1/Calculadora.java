package Ejercicio_1;
import java.util.*;
public class Calculadora {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String mensaje="Introduzca un numero";
		int a=leerEntero(teclado, mensaje);
		int b=leerEntero(teclado, mensaje);
		char op=leerOperacion(teclado);
	}
	
	private static int leerEntero(Scanner teclado, String mensaje) {
		System.out.println(mensaje);
		int num= teclado.nextInt();
		return num;
	}
	
	private static char leerOperacion(Scanner teclado) {
		System.out.println("Introduzca un operador");
		char operador=teclado.next().charAt(0);
		return operador;
	}
	
	private static double calcular(int a, int b, char op) {
		double supu=0;
		return supu;
	}
} 