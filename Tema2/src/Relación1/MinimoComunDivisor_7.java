package Relación1;
import java.util.*;
public class MinimoComunDivisor_7 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//Determino las variables
		int num1, num2, mcd,  suma, resto1, resto2, container;
		mcd = 0;
		suma = 0;
		container = 0;
		//Creo un bucle que pida numeros y hasta que los dos no sean mayores que 0 acaba el bucle
		do{
			System.out.println("Introduzca el primer numero");
			num1 = sc.nextInt();
			System.out.println("Introduzca el segundo numero");
			num2 = sc.nextInt();
			if(num1<=0 || num2 <=0) {
				System.out.println("Debes introducir numeros mayores a 0");
			}
		}while(num1<=0 || num2 <=0);
		//Hago el primer calculo
		resto1 = num2;
		resto2 = 1;
		mcd = num1/num2;
		suma = suma + mcd;
		resto2 = num1%num2;
		//Hago un bucle que me haga calculos hasta que el resto sea 0
		while(resto2!=0) {
			mcd = resto1/resto2;
			container = resto2;
			suma = suma + mcd;
			resto2 = resto1%resto2;
			resto1 = container;
		}System.out.println("El m.c.d. de " + num1 + " y " + num2 + " es " + suma);
	}	
}