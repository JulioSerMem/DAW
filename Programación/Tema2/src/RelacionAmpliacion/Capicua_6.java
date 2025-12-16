package RelacionAmpliacion;
import java.util.Scanner;
public class Capicua_6 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		char cifra1='.', cifra2='.';
		//Pido por pantalla un numero 
		System.out.println("Introduzca un numero");
		String num = teclado.nextLine();
		//Inicio el contador que recorre el numero al reves
		int j=((num.length()-1));
		//Hago un bucle para que ingrese un numero de almenos 2 cifras
		/*while(num.length()<2) {
			System.out.println("Ingrese un numero de al menos 2 cifras");
			num = teclado.nextLine();
		}*/
		//Comienzo un bucle para recorrer el numero de izquierda a derecha e ir comprobando si coinciden los digitos de derecha a izquierda
		for(int i=0; i<num.length(); i++) {
			cifra1 = num.charAt(i);
			cifra2 = num.charAt(j);
			j--;
			//Si algun digito no coincide con su espejo, termina y muestra que no es capicua
			if(cifra1!=cifra2) {
				System.out.println("El numero no es capicua");
				break;
			}
			//Si los comprueba todos sin salirse muestra que es capicua
			else if(i==num.length() || j==0) {
				System.out.println("El numero es capicua");
			}
		}
	}
}