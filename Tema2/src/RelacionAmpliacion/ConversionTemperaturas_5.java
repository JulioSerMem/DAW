package RelacionAmpliacion;
import java.util.*;
public class ConversionTemperaturas_5 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		double celsius;
		//Pido la temperatura en celsius
		System.out.println("Introduzca la cantidad de grados en Celsius");
		celsius = teclado.nextDouble();
		//A la vez que imprimmo la solucion de la conversion de los grados, hago el calculo de la conversion
		System.out.println("Los grados Fahrenheit son: " + ((celsius*((double)9/5))+32));
		System.out.println("Los grados Kelvin son: " + (double)(celsius+273.15));
	}
}
