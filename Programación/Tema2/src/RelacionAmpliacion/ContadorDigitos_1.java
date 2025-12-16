package RelacionAmpliacion;
import java.util.*;
public class ContadorDigitos_1 {
	private static Scanner sc = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	public static void main(String[] args) {
		int num, cont;//Creo las variables numero y constante
		cont = 1;//Inicio la constante en 1
		System.out.println("Introduzca su numero");
		num = sc.nextInt();
		//Creo un bucle para determinar el numero de cifras a excepcion de la primera q esa la cuento en el contador
		while(num>=10){
			num = num/10;
			cont++;
		}System.out.println("El numero de cifras es:" + cont);
	}
}
