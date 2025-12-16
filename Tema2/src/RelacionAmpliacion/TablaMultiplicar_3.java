package RelacionAmpliacion;
import java.util.*;
public class TablaMultiplicar_3 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int num, resultado = 0;
		do{
			System.out.println("Ingresa un numero");
			num = teclado.nextInt();
		}while(num<1 || num>10);
		System.out.println("Tabla de " + num + ":");
		for(int i=0; i<11; i++) {
			resultado = num * i;
			System.out.println(num + "x" + i + "=" + resultado);
		}
	}
}