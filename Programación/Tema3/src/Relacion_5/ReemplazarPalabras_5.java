package Relacion_5;
import java.util.*;
public class ReemplazarPalabras_5 {
	private static Scanner teclado = new Scanner(System.in);
	public static  void main(String[] args) {
		String frase=pedirfrase();
		String palabraBuscar=palabraBuscar();
		boolean buscarPalabra=buscarPalabra(frase, palabraBuscar);
		if(buscarPalabra==true) {
			String palabraReemplazar=palabraReemplazar();
			reemplazarPalabra(frase, palabraBuscar, palabraReemplazar);
		}else {
			System.out.println("No se ha encontrado la palabra que busca reemplazar");
		}
	}
	
	private static String pedirfrase() {
		System.out.println("Ingrese una frase");
		String frase = teclado.nextLine();
		while(frase.length()==0) {
			System.out.println("Ingrese alguna frase");
			frase = teclado.nextLine();
		}return frase;
	}
	
	private static String palabraBuscar() {
		System.out.println("Intoduzca una palabra para buscar en la frase");
		String palabra= teclado.nextLine().toLowerCase();
		while(palabra.length()==0) {
			System.out.println("Intoduzca alguna palabra");
			palabra= teclado.nextLine().toLowerCase();
		}
		return palabra;
	}
	
	private static String palabraReemplazar() {
		System.out.println("Intoduzca una palabra para reemplazar en la frase");
		String palabra= teclado.nextLine().toLowerCase();
		while(palabra.length()==0) {
			System.out.println("Intoduzca alguna palabra");
			palabra= teclado.nextLine().toLowerCase();
		}
		return palabra;
	}
	
	private static boolean buscarPalabra(String frase, String palabraBuscar) {
		int j=0;
		boolean buscarPalabra=false;
		for(int i=0; i<frase.length(); i++) {
			if(j==palabraBuscar.length()) {
				break;
			}else if(frase.charAt(i)==palabraBuscar.charAt(j)) {
				j++;
			}
		}
		if(j==palabraBuscar.length()) {
			buscarPalabra=true;
		}else {
			buscarPalabra=false;
		}return buscarPalabra;
	}
	
	private static void reemplazarPalabra(String frase, String palabraBuscar, String palabraReemplazar) {
		String[] partes=frase.split(palabraBuscar);
		String fraseFinal="";
		fraseFinal+=partes[0];
		for(int i=1; i<partes.length; i++) {
			fraseFinal+=(palabraReemplazar + partes[i]);
		}System.out.println(fraseFinal);
	}
}