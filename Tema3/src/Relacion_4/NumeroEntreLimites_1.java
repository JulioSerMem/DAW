package Relacion_4;
import java.util.*;
public class NumeroEntreLimites_1 {
	private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	private static Random random = new Random();//Permito generar un numero random
	public static void main(String[] args) {// Método principal, punto de entrada del programa
		//Inicio las variables
		int num = 0, limiteInferior = 0, limiteSuperior = 0, container = 0;
		//Se determinan los limites
		limiteInferior = limites(num);
		limiteSuperior = limites(num);
		//Si el limite inferior es mayor al superior, se intercambian os valores
		if(limiteInferior>limiteSuperior) {
			limiteInferior = container;
			limiteInferior = limiteSuperior;
			limiteSuperior = container;
		}
		//Se determina el numero elegido entre los limites
		num = numero(num,limiteInferior,limiteSuperior);
	}
	//Metodo que solicita un numero por pantalla
	private static int limites(int num) {
		num = random.nextInt();
		return num;
	}
	//Metodo que genera dos dos numeros aleatorios para que sen el limite inferior y el superior
	private static int numero(int num, int limiteInferior, int limiteSuperior) {
		System.out.println("Inserte un numero");
		num = teclado.nextInt();
		//Si el numero no esta entre el intervalo, se vuelve a pedir
		while(limiteInferior>num || limiteSuperior<num) {
			System.out.println("El numero debe estar comprendido entre los limites");
			num = teclado. nextInt();
		}return num;
	}
}