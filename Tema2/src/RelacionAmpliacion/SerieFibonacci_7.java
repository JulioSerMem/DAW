package RelacionAmpliacion;
import java.util.*;
public class SerieFibonacci_7 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//Genero todas la variables
		int cantidad, cont, container,  num1, num2, resultado1, resultado2;
		num1 = 0;
		num2 = 1;
		cont = 0;
		container = 0;
		//Pido la cantidad de numeros que quiere solicitar
		System.out.println("Ingresa la cantidad de numeros que deseas");
		cantidad = sc.nextInt();
		//Hago el primer calculo
		resultado2 = num1+num2;
		System.out.println(num1 + " + " + num2 + " = " + resultado2);//muestro la operacion en pantalla
		resultado1 = num2;
		//Hago un bucle donde se vayan generando los demas calculos hasta llegar al numero de calculos deseado
		do {
			//Si solo pide un calcolu, como este se hace fuera del bucle, que directamente no haga el bucle y se salga para terminar
			if(cantidad==1) {
				break;
			}
			container = resultado1 + resultado2;
			System.out.println(resultado1 + " + " + resultado2 + " = " + container);//voy mostrando el resto de operaciones siempre que sea diferente al numero introducido
			resultado1 = resultado2;
			resultado2 = container;
			cont++;
		}while(cont!=(cantidad-1));
	}
}