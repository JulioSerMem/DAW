package Relacion_5;
import java.util.*;
public class ContadorVocalesDiferentes_6 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		//Inicio la variable llamandola al metodo
		String frase=pedirFrase();
		contarVocalesDiferentes(frase);
	}
	//Metodo que pide la frase
	private static String pedirFrase() {
        System.out.println("Ingrese una frase o palabra");
        String frase = teclado.nextLine().toLowerCase();
        return frase;
    }
	//Metodo que cuenta las vocales diferentes
	private static void contarVocalesDiferentes(String frase) {
		//Creo una string que contenga las vocales que quiero buscar
		String vocales="aeiou";
		//Inicio el contador que contara el numero de vocales diferentes
		int contador=0;
		//Creo el primer bucle for que recorrera la string con las diferente vocales
		for(int i=0; i<vocales.length(); i++) {
			//Creo otro bucle para recorrer la frase en busca de las diferentes vocales
			for(int j=0; j<frase.length(); j++) {
				//Si encuentra la vocal entra
				if(frase.charAt(j)==vocales.charAt(i)) {
					//Incrementa el contador
					contador++;
					//El break, rompe el bucle para que cuando encuentre una vocal, deje de buscar y reinicie el bucle que recorre la frase luego de pasar a la siguiente vocal
					break;
				}
			}
		}
		//Imprime por pantalla el numero de vocales diferentes que encuentra en la frase
		System.out.println("Las vocales diferentes de esta frase son: " + contador);
	}
}