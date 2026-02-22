package Ejercicio_1_Arrays;
import java.util.*;
public class BuscarNumero_4 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int vectorNumeros[] = {1, 5, 18, 9, 12, 6, 21};
		int numeroBuscado=numeroBuscado();
		encontrarNumero(vectorNumeros, numeroBuscado);
	}
	
	public static int numeroBuscado() {
		System.out.println("Introduzca el numero que quiere buscar");
		int numeroBuscado=teclado.nextInt();
		return numeroBuscado;
	}
	
	public static void encontrarNumero(int vectorNumeros[], int numeroBuscado) {
		int cont=1;
		boolean encontrado=false;
		for(int numero : vectorNumeros) {
			if(numero==numeroBuscado) {
				System.out.println("El numero esta, y su posición es la numero " + cont);
				encontrado=true;
				break;
			}
			cont++;
		}
		if(!encontrado) {
			System.out.println("Numero no enontrado");
		}
	}
}