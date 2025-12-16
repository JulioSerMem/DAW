package Relacion_5;
import java.util.*;
public class BuscarPalabra_4 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String frase=frase();
		String palabra=palabraEscondida();
		buscarPalabra(frase,palabra);
	}
	
	private static String frase() {
		System.out.println("Intoduzca un frase");
		String frase= teclado.nextLine().toLowerCase();
		while(frase.length()==0) {
			System.out.println("Intoduzca alguna frase");
			frase= teclado.nextLine().toLowerCase();
		}
		return frase;
	}
	
	private static String palabraEscondida() {
		System.out.println("Intoduzca un palabra");
		String palabra= teclado.nextLine().toLowerCase();
		while(palabra.length()==0) {
			System.out.println("Intoduzca alguna palabra");
			palabra= teclado.nextLine().toLowerCase();
		}
		return palabra;
	}
	
	private static void buscarPalabra(String frase, String palabra) {
		int j=0;
		for(int i=0; i<frase.length(); i++) {
			if(j==palabra.length()) {
				break;
			}else if(frase.charAt(i)==palabra.charAt(j)) {
				j++;
			}
		}
		if(j==palabra.length()) {
			System.out.println("Palabra encontrada");
		}else {
			System.out.println("Palabra no encontrada");
		}
	}
}
