package Relación1;
import java.util.*;
public class TrianguloSinForma_10_1 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int base;
		char caracter;
		//Creo un bucle para que ingresen un numero positivo impar y aprovecho para pedir el caracter
		do {
			System.out.println("Intoduzca el valor impar de la base");
			base = sc.nextInt();
			//Si esl numero no sirve, le informo
			if(base<0 || base%2==0) {
				System.out.println("Tiene que ser un numero mayor a 0 o impar");	
			}System.out.println("Introduzca el caracte");
			 caracter = sc.next().charAt(0);
		}while(base<0 || base%2==0);
		//Hago dos bucles for, uno para las lineas y otro para lo que sakga en esas lineas, en este caso la cantidad de caracteres
		for(int i = 0; i<base; i+=2) {
			for(int j = 0; j<=i; j++) {
				System.out.print(caracter + " ");
			}System.out.println();
		}
	}
}