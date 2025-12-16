package Relación1;
import java.util.*;
public class TrianguloConForma_10_2 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int base;
		char caracter;
		//Creo un bucle para que ingresen un numero positivo impar y aprovecho para pedir el caracter
		do {
			System.out.println("Intoduzca el valor impar de la base");
			base = sc.nextInt();
			if(base<0 || base%2==0) {
				System.out.println("Tiene que ser un numero mayor a 0 e impar");	
			}System.out.println("Introduzca el caracte");
			 caracter = sc.next().charAt(0);
		}while(base<0 || base%2==0);
		//Hgo un bucle para saber cuantos caracteres hay por linea
		for(int i = 0; i<base; i+=2) {
			//Hgo un bucle para saber cuantos espacios hay por linea
			for(int espacios = 0; espacios<(base-i)/2; espacios++) {
				System.out.print("  ");
			}//Hgo un bucle para escribir todos los caracteres
			for(int j = 0; j<=i; j++) {
				System.out.print(caracter + " ");
			}System.out.println();
		}
	}
}