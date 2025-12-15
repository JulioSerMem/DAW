package Relacion_1_Tema2;
import java.util.*;
public class CifrasNumero_3_Tema2 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el etecladoaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		//Inicio las variables
		int num = 0, cifras = 1;
		//Pido un numero al usuario
		num = numero(num);
		//Calculo el numero de cifras del numero
		cifras = contadorCifras(num, cifras); 
		//Imprimo por pantalla el numero de cifras del numero
		System.out.println("El numero de cifras es: " + cifras);
	}
	//Metodo para pedir un numero al usuario
	private static int numero(int num) {
		System.out.println("Introduca un numero");
		num = teclado.nextInt();
		return num;
	}
	//Metodo que calcula el numero de cifras mediante un buce while
	private static int contadorCifras(int num, int cifras) {
		while(num>=10) {
			num = num/10;
			cifras++;
		}return cifras;
	}
}