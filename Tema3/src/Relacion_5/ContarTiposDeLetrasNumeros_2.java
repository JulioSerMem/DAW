package Relacion_5;
import java.util.*;
public class ContarTiposDeLetrasNumeros_2 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String frase=pedirFrase();
		contadorMayusculas(frase);
		contadorMinusculas(frase);
		contadorNumeros(frase);
	}
	
	private static String pedirFrase() {
        System.out.println("Ingrese una frase: ");
        String frase = teclado.nextLine();
        return frase;
    }
	
	private static void contadorMayusculas(String frase) {
		int contador=0;
		for(int i=0; i<frase.length(); i++) {
			if(Character.isUpperCase(frase.charAt(i))) {
				contador++;
			}
		}System.out.println("Mayusculas: " + contador);
	}
	
	private static void contadorMinusculas(String frase) {
		int contador=0;
		for(int i=0; i<frase.length(); i++) {
			if(Character.isLowerCase(frase.charAt(i))) {
				contador++;
			}
		}System.out.println("Minusculas: " + contador);
	}
	
	private static void contadorNumeros(String frase) {
		int contador=0;
		for(int i=0; i<frase.length(); i++) {
			if(Character.isDigit(frase.charAt(i))) {
				contador++;
			}
		}System.out.println("Numeros: " + contador);
	}
}	