package RelacionAmpliacion;
import java.util.*;
public class NumeroVocales_NumeroConsonantes_8 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int vocal = 0,consonante = 0;
		char caracter;
		//Pido la frase por pantalla
		System.out.println("Ingrese una frase");
		String frase = teclado.nextLine();
		// Convertir a minúsculas para simplificar la comparación
		frase = frase.toLowerCase();
		//Creo un bucle for para que pase por todos los caracteres de la frase
		for(int i=0; i<frase.length(); i++) {
			//Lee el caracter correspondiente segun la i se va incrementando
			caracter = frase.charAt(i);
			//Hago una condicion para que si el caracter es una vocal, me incremente la variable vocal
			if(caracter=='a' || caracter=='e' || caracter=='i' || caracter=='o' || caracter=='u') {
				vocal++;
			}
			//Hago una condicion para que si el caracter es algun signo de puntuacion, no lo cuente
			else if(caracter==' ' || caracter==',' || caracter=='.' || caracter==';' || caracter==':'|| caracter=='_' || caracter=='-' || caracter=='!' || caracter=='¡'|| caracter=='?' || caracter=='¿' || caracter=='(' || caracter==')') {
				
			}
			//Hago una condicion para que si el caracter es una vocal, me incremente la variable consonante
			else {
				consonante++;
			}
		}
		System.out.println("La frase tiene " + vocal + " vocales y " + consonante + " consonante");
	}	
}