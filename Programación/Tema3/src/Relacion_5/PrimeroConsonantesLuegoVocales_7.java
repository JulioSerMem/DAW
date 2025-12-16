package Relacion_5;
import java.util.*;
public class PrimeroConsonantesLuegoVocales_7 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String frase=pedirFrase();
		String fraseSinEspacios=fraseSinEspacios(frase);
		String vocales=vocales(fraseSinEspacios);
		String consonantes=consonantes(fraseSinEspacios);
		fraseFinal(vocales, consonantes);
	}
	
	private static String pedirFrase() {
        System.out.println("Ingrese una frase o palabra");
        String frase = teclado.nextLine().toLowerCase();
        return frase;
    }
	
	private static String fraseSinEspacios(String frase) {
		String fraseSinEspacios = frase.replace(" ","");
	    return fraseSinEspacios;
	}
	
	private static String vocales(String fraseSinEspacios) {
		String vocales="";
		for(int i=0; i<fraseSinEspacios.length(); i++) {
			if(fraseSinEspacios.charAt(i)=='a' || fraseSinEspacios.charAt(i)=='e' || fraseSinEspacios.charAt(i)=='i' || fraseSinEspacios.charAt(i)=='o' || fraseSinEspacios.charAt(i)=='u') {
				vocales+=fraseSinEspacios.charAt(i);
			}
		}
		return vocales;
	}
	
	private static String consonantes(String fraseSinEspacios) {
		String consonantes="";
		for(int i=0; i<fraseSinEspacios.length(); i++) {
			if(fraseSinEspacios.charAt(i)!='a' && fraseSinEspacios.charAt(i)!='e' && fraseSinEspacios.charAt(i)!='i' && fraseSinEspacios.charAt(i)!='o' && fraseSinEspacios.charAt(i)!='u') {
				consonantes+=fraseSinEspacios.charAt(i);
			}
		}
		return consonantes;
	}
	
	private static void fraseFinal(String vocales, String consonantes) {
		String fraseFinal=consonantes.concat(vocales);
		System.out.println(fraseFinal);
	}
}
