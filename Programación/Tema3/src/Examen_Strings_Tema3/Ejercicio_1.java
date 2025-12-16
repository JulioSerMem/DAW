package Examen_Strings_Tema3;
import java.util.*;
public class Ejercicio_1 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		//Creo un bucle para que pida y convierta la frase 5 veces
		for(int i=0; i<5; i++) {
		String frase=pedirFrase();
		frasePi(frase);
		}
	}
	//Metodo que pide una frase por teclado
	private static String pedirFrase() {
        System.out.println("Ingrese una frase");
        String frase = teclado.nextLine();
        return frase;
    }
	//Metodo que convierte la frase introducida al tipo frase Pi
	private static void frasePi(String frase) {
		//Creo una string vacia donde guardare los cambios
		String frasePi="";
		//Creo un bucle for para recorrer la frase
		for(int i=0; i<frase.length(); i++) {
			//Creo una condicion para que cuando se encuentra una vocal diferente a la e, se agregue la palabra Pi de seguido a esa vocal
			if(frase.charAt(i)=='a' || frase.charAt(i)=='A' || frase.charAt(i)=='i' ||frase.charAt(i)=='I' ||frase.charAt(i)=='o' || frase.charAt(i)=='O' || frase.charAt(i)=='u' ||frase.charAt(i)=='U') {
				frasePi+=frase.charAt(i) + "Pi";
			}
			//Si no es vocal, guarda el caracter
			else {
				frasePi+=frase.charAt(i);
			}
		}
		//Imprime la frase en modo Pi
		System.out.println("Resultado: " + frasePi);
	}
}