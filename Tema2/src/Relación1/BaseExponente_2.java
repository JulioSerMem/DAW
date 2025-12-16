package Relación1;
import java.util.Scanner;
public class BaseExponente_2 {
	private static Scanner sc = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[]args) {
	int num, exponente,result;//Creo las variables numero, exponente y resultado
	result = 0;//Inicio la variable en 0
	do{//Pide numero y exponente
	System.out.println("Introduzca un numero");
	num = sc.nextInt();
	System.out.println("Introduzca un exponente");
	exponente = sc.nextInt();
	}while(num<0 || exponente<0);//Creo un bucle para que me vuelva a pedir tanto el numero como el exponente si alguno de estos es negativo
	result = (int) Math.pow(num,exponente);
	System.out.println("El resulado es:" + result);
	}
}