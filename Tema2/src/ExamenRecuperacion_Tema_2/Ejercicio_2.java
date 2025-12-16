package ExamenRecuperacion_Tema_2;
import java.util.*;
public class Ejercicio_2 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		//Creo las variables
		int num=0, pasos=0;
		//Creo un bucle para que me introduzcan un numero y no salga hasta que el numero no sea mayor  a 1
		do {
			System.out.println("Introduzca un numero mayor a 1");
			num = teclado.nextInt();
		}while(num<=1);
		//Determino otra variable maximo, para guardar el numero como el mas alto y luego actualizarlo
		int max=num;
		//Mientras el numero sea diferente a 1, se ejecuta el bucle
		while(num!=1) {
			//Si el numero es par se divide entre 2
			if(num%2==0) {
				System.out.print(num + "/2=");
				num/=2;
				System.out.print(num);
				System.out.println();
				//Se ingrementa la variable pasos
				pasos++;
			}
			//Los demas que son los impares se van a multiplicar por tres y sumar uno
			else {
				System.out.print(num + "*3=");
				num*=3;
				System.out.print(num + "+1=");
				num++;
				//Se comprueba si el numero es el maximo hasta el momento
				if(max<=num) {
					max=num;
				}
				System.out.print(num);
				System.out.println();
				//Se ingrementa la variable pasos
				pasos++;
			}
		}
		//Se imprime por pantalla el output pedido
		System.out.println("Total de pasos: " + pasos);
		System.out.println("Valor maximo alcanzado: " + max);
	}
}
