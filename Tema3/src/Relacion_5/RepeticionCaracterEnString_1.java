package Relacion_5;
import java.util.*;
public class RepeticionCaracterEnString_1 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String frase = pedirFrase();
		char caracter = pedirPalabra();
		repeticionCaracter(frase, caracter);
	}
	
	private static String pedirFrase() {
        System.out.println("Ingrese una frase");
        String frase = teclado.nextLine().toLowerCase();
        return frase;
    }
	
	private static char pedirPalabra() {
		System.out.println("Ingrese una palabra");
        char caracter = teclado.next().toLowerCase().charAt(0);
        return caracter;
    }
	
	private static void repeticionCaracter(String frase, char caracter) {
		int contador=0;
		for(int i=0; i<frase.length(); i++) {
			if(frase.charAt(i)==caracter) {
				contador++;
			}
		}
		System.out.println("El caracter se repite en la frase " + contador + " veces.");
	}
}