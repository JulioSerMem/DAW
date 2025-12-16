package Relacion_4;
import java.util.*;
public class Factoriales_2 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		int numLimite=0;
		System.out.println("Introduzca el numero limite");
		numLimite = teclado.nextInt();
		System.out.println("Introduce un número límite para calcular facoriale: " + numLimite);
		System.out.println("0! = 1");
		for(int i = 1; i<=numLimite; i++) {
			System.out.println(i + "! = " + factoriales(numLimite, i));
		}
	}
	
	private static int factoriales(int numLimite, int i) {
		int container=1;
		for(int j = i; j>1; j--) {
			container=container*j;
		}return container;
	}
}