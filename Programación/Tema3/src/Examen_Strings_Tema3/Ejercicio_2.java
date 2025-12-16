package Examen_Strings_Tema3;
import java.util.Scanner;
public class Ejercicio_2 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		//Guardo la frase introducida en el metodo en una string
		String frase=pedirFrase();
		//Arranco el metodo que convierte la frase a frase Cani
		fraseCani(frase);
	}
	//Metodo que pide una frase por teclado
	private static String pedirFrase() {
        System.out.println("Ingrese una frase");
        String frase = teclado.nextLine();
        return frase;
    }
	//Metodo que combia la frase introducida a frase Cani y lla muestra por pantalla
	private static void fraseCani(String frase) {
		//inicio el contador que indicara si la letra va en mayuscula o minuscula
		int contador=0;
		//Creo una string vacia donde guardare los cambios
		String fraseCani="";
		//Creo un bucle que recorra la frase
		for(int i=0; i<frase.length(); i++) {
			//Guardo cada caracter para luego comparar
			char c=frase.charAt(i);
			//Si la letra es mayuscula y tiene que serlo, se queda igual y se incrementa el contador
			if((c>=65 && c<=90) && contador%2==0) {
				fraseCani+=c;
				contador++;
			}
			//si es minuscula y tiene que ser mayuscula, se cambia y se incrementael contador
			else if((c>=97 && c<=122) && contador%2==0) {
				c= (char) (c-32);
				fraseCani+=c;
				contador++;
			}
			//Si la letra es mayuscula y debe ser minuscula, se cambia y se incrementa el contador
			else if((c>=65 && c<=90) && contador%2!=0) {
				c= (char) (c+32);
				fraseCani+=c;
				contador++;
			}
			//Si hayun espacio se guarda, pero no incrementa el contador
			else if(c==' ') {
				fraseCani+=c;
			}
			//Entra todo lo demas
			else {
				fraseCani+=c;
				contador++;
			}
		}
		//Imprime la frase final en modo cani por la pantalla
		System.out.println("Resultado: " + fraseCani);
	}
}