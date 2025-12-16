package Relación1;
import java .util.*;
public class AnchoAltoRectangulo_8 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int ancho, alto;
		char caracter=' ';
		//Creo un bucle en el que me ingresen el ancho, el alto mayor o igual a 1 y e caracter
		do {
			System.out.println("Ingrese el ancho del rectangulo");
			ancho = sc.nextInt();
			System.out.println("Ingrese el alto del rectangulo");
			alto = sc.nextInt();
			System.out.println("Ingrese el caracter deseado");
			caracter = sc.next().charAt(0);
		}while(ancho<=0 || alto<=0);
		//Hago dos bucles para que me imrima tanto el ancho como el alto del rectangulo
		for(int i = 0; i<alto; i++) {
			for(int j = 0; j<ancho; j++) {
				System.out.print(" " + caracter);
			}
		System.out.println();
		}
	}
}