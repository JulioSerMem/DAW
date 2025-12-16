package RelacionAmpliacion;
import java.util.*;
public class NumerosPrimosEntreDosNumeros_9 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int filas;
		System.out.println("Ingresa el numero de filas");
		filas = teclado.nextInt();
		while(filas<2) {
			System.out.println("Ingresa al menos dos fila");
			filas = teclado.nextInt();
		}for(int i=1; i<=filas; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}System.out.println();
		}
	}
}
