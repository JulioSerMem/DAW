package Bollycao;
import java.util.*;
public class Bollyejercicio {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Introduzca una frase de caracteres");
		String frase = teclado.nextLine();
		int palabras=numeroPalabras(frase);
		System.out.println("Palabras: " + palabras);
		String cadenaSinEspadios = frase.substring(3);
		System.out.println("Normalizada: " + cadenaSinEspadios);
	}
	
	private static String numeroPalabras(String frase) {
		for(int i=0; i<frase.length(); i++) {
			if(frase.charAt(i)==' ') {
				
			}
		}
	}
}