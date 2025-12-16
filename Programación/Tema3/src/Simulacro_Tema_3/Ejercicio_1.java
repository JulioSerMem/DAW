package Simulacro_Tema_3;
import java.util.*;
public class Ejercicio_1 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		boolean otraOpcion=true;
		String frase=pedirFrase();
		do{
			int opcion=menuOpciones();
			switch (opcion){
				case 1:
					System.out.println("El numero de letras es: " + contarLetras(frase));
					break;
				case 2:
					System.out.println("El nuemero de palabras es: " + contarPalabras(frase));
					break;
				case 3:
					System.out.println("La frase con las primeras letras de cada palabra en mayusculas es: " + mayusculas(frase));
					break;
				case 4:
					System.out.println("La frase invertida es: " + inversa(frase));
					break;
				case 5:
					break;					
			}
			otraOpcion=repeticion();
		}while(otraOpcion==true);
		if(otraOpcion==false) {
			System.out.println("Nos vemos maquina");
		}
	}
	
	private static String pedirFrase() {
        System.out.println("Ingrese una frase o palabra");
        String frase = teclado.nextLine().toLowerCase();
        return frase;
    }
	
	private static int menuOpciones() {
		System.out.println("Menu:");
		System.out.println("1. Contar letras");
		System.out.println("2. Contar palabras");
		System.out.println("3. Mayusculas");
		System.out.println("4. Invertir");
		System.out.println("5. Salir del menu");
		System.out.println("Ingrese una opcion");
		int opcion = teclado.nextInt();
		teclado.nextLine();
		while(opcion<1 || opcion>5) {
			System.out.println("El numero no entra dentro de las opciones intentelo de nuevo");
			opcion = teclado.nextInt();
			teclado.nextLine();
		}
		return opcion;
	}
	
	private static int contarLetras(String frase) {
		int numLetras=0;
		for(int i=0; i<frase.length(); i++) {
			if(Character.isLetter(frase.charAt(i))==true) {
				numLetras++;
			}
		}return numLetras;
	}
	
	private static int contarPalabras(String frase) {
		int numPalabras=0;
		for(int i=0; i<frase.length(); i++) {
			if(i==0) {
				if(Character.isLetter(frase.charAt(i))==true) {
					numPalabras++;
				}
			}else if(Character.isLetter(frase.charAt(i))==true && frase.charAt(i-1)==' ') {
				numPalabras++;
			}
		}return numPalabras;
	}
	
	private static String mayusculas(String frase) {
		char letra=' ';
		String mayusculas="";
		for(int i=0; i<frase.length(); i++) {
			if(i==0) {
				if(Character.isLetter(frase.charAt(i))==true) {
					letra=frase.toUpperCase().charAt(i);
				}
			}else if(Character.isLetter(frase.charAt(i))==true && frase.charAt(i-1)==' ') {
				letra=frase.toUpperCase().charAt(i);
			}else{
				letra=frase.charAt(i);
			}mayusculas+=letra;
		}
		return mayusculas;
	}
	
	private static String inversa(String frase) {
		String inversa="";
		boolean palabra=false;
		for(int i=0; i<frase.length(); i++) {
			
		}
		return inversa;
	}
	
	private static boolean repeticion() {
		String repeticion="true";
		System.out.println("¿Desea hacer alguna otra operacion?(true/false)");
		repeticion= teclado.nextLine();
		while(!repeticion.equalsIgnoreCase("true") && !repeticion.equalsIgnoreCase("false")) {
			System.out.println("Debes responder con true o false");
			repeticion= teclado.nextLine();
		}
		return Boolean.parseBoolean(repeticion);
	}
}