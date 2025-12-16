package ejercicios_ampliacion_string;
import java.util.*;
public class NombreCompleto_1 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		String frase=pedirFrase();
	}
	//Metodo que pide la frase
	private static String pedirFrase() {
		System.out.println("Ingrese una frase o palabra");
		String frase = teclado.nextLine().toLowerCase();
		return frase;
	}
}