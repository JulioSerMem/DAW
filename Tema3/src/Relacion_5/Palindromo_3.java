package Relacion_5;
import java.util.*;
public class Palindromo_3 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String frase=pedirFrase();
		boolean palindromo=palindromo(frase);
		if(palindromo==true) {
			System.out.println("La frase es un palindromo");
		}else {
			System.out.println("La frase no es un palindromo");
		}
	}
	
	private static String pedirFrase() {
        System.out.println("Ingrese una frase: ");
        String frase = teclado.nextLine();
        return frase;
    }
	
	private static boolean palindromo(String frase) {
		int j=(frase.length()-1);
		boolean palindromo=true;
		for(int i=0; i<frase.length(); i++) {
			if(frase.charAt(i)==frase.charAt(j)) {
				palindromo=true;
			}else {
				palindromo=false;
				break;
			}j-=1;
		}return palindromo;
	}
}