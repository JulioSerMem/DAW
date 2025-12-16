package Relación1;
import java.util.*;
public class CombinacióCuatroCifras_5 {
	private static Scanner sc = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	private static Random random = new Random();
	public static void main(String[] args) {
		int num1, num2, num3, num4, fallos;//Creo las variables num1, num2, num3, num4 y fallos
		fallos = 0;//Inicializo la variable fallos en 0
		//Genero un numero entre el 0 y el 9
		int secreto1 = random.nextInt(10);
		int secreto2 = random.nextInt(10);
		int secreto3 = random.nextInt(10);
		int secreto4 = random.nextInt(10);
		//Comienzo un bucle, para ir pidiendo digitos de la contraseña y que luego al comprobar, muestre si ha fallado o no, si no ha fallado termina, si falla hasta 5 veces se vuelve a pedir los digitos
		do{
		System.out.println("Ingrese el primer digito");
		num1 = sc.nextInt(10);
		System.out.println("Ingrese el segundo digito");
		num2 = sc.nextInt(10);
		System.out.println("Ingrese el tercer digito");
		num3 = sc.nextInt(10);
		System.out.println("Ingrese el cuarto digito");
		num4 = sc.nextInt(10);
		//Comprueba si los digitos de la contraseña coinciden con los digitos escritos,con un numero de 5 fallosposibles
		if(num1!=secreto1 || num2!=secreto2 || num3!=secreto3 || num4!=secreto4) {
			System.out.println("Lo siento, esa no es la combinación");
		}else {
			System.out.println("La caja fuerte se ha abierto satisfactoriamente");
			break;//Por si aierta la contraseña, termina el bucle
		}fallos++;//Incrementa el numero de fallos en la variable
		System.out.println("El numero de intentos es: " + (5-fallos));//Indica el numero de intentos restantes
		}while(fallos!=5);
		//Muestra por pantalla la contraseña
	System.out.println("La conraseña era: " + secreto1 + secreto2 + secreto3 + secreto4);
	}
}