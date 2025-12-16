package Examen_1;
import java.util.Scanner;
public class Ejercicio_1 {
	private static Scanner teclado = new Scanner(System.in);//Inicio el escaner
	public static void main(String[] args) {
		//Creo la variable
		int n;
		System.out.println("Ingresa un numero entero positivo");//Lanzo un mensaje por pantalla para peidr el valor de la variable
		n = teclado.nextInt();//Asigno el valor introucido por teclado a la variable
		//Creo un bocle para que mientras el numero introducido sea menor que 0 siga pidiendo numeros hasta que se cumpla esta condicion
		while(n<0) {
			System.out.println("Ingrese un numero entero positivo");
			n = teclado.nextInt();
		}
		//Imprimo los primeros tres numeros primos que la condicion no imprime
		if(n>=2) {
			System.out.print("2, 3, 5, ");
		}else if(n>=3) {
			System.out.print("3, 5, ");
		}else if(n>=5) {
			System.out.print("5, ");
		}
		//Cre un bucle for que recorra todos los numeros desde el numero introducido hasta el numero introducido, elevado a 4
		for(int i=n; i<(n*n*n*n); i++) {
			//Creo una condicion para que cuando el numero introducido por pantalla sea igual a 0, muestre un mensaje y termine el programa
			if(n==0) {
				System.out.println("Venga máquina, hasta luego");
				break;
			}
			//Creo otro bucle for que recorra todos los numeros desde el 1 hasta i que se va incrementando para ver que numeros son primos
			for(int j=i; j<(i+1); j++) {
				if(i%2==0 || i%3==0 || i%5==0){
				}else if(i%j==0) {
			
					System.out.print(j + ", ");
				}
			}
		}
	}
}