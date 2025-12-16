package ExamenRecuperacion_Tema_2;
import java.util.*;
public class Ejercicio_1 {
	private static Scanner teclado= new Scanner(System.in);
	public static void main(String[] args) {
		//Inicio las variables
		int base, espacios;
		//Inicio una variable que guarde el caracter asterisco
		char caracter='*';
		//Creo un bucle para que ingresen un numero positivo impar
		do {
			System.out.println("Intoduzca el valor impar de la base");
			base = teclado.nextInt();
			if(base<0 || base%2==0) {
				System.out.println("Tiene que ser un numero mayor a 0 o impar");	
			}
		}while(base<0 || base%2==0);
		//Hago la piramide a la inversa
		//Hgo un bucle para saber cuantos caracteres hay por linea
		for(int i = base; i>=0; i-=2) {
			//Hgo un bucle para saber cuantos espacios hay por linea
			for(espacios= 0;espacios<(base-i)/2;espacios++) {
				System.out.print("  ");
			}//Imprimo los caracteres
			for(int j = 0; j<i; j++) {
				System.out.print(caracter + " ");
			}System.out.println();
		}
		//Hgo un bucle para saber cuantos caracteres hay por linea
		for(int i = 2; i<base; i+=2) {
			//Hgo un bucle para saber cuantos espacios hay por linea
			for(espacios = 0; espacios<(base-i)/2; espacios++) {
				System.out.print("  ");
			}//Hgo un bucle para escribir todos los caracteres
			for(int j = 0; j<=i; j++) {
				System.out.print(caracter + " ");
			}System.out.println();
		}
	}
}
