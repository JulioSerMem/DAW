package SimulacroExamen_1_Java;
import java.util.*;
public class PiramideMultiplos_2 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int altura, num;
		num = 2;
		//Creo un bucle para que introduzca un numero de filas positivo
		do {
			System.out.println("Introduzca el numero de filas que desea");
			altura = teclado.nextInt();
		}while(altura<0);
		//Creo un primer bucle for para que vaya fila por fila, hasta llegar a la altura deseadas
		for(int i=0; i<altura; i++) {
			//Creo un otro bucle for para que incluya espacios por fila y que se genere la forma de piramide
			for(int espacios = 0; espacios<(altura-i); espacios++) {
				System.out.print("  ");
			}//Creo un ultimo bucle para que desoues de los espacios  se vayan escribiendo los numeros que van a formar parte de la piramide
			for(int j=0; j<=i; j++) {
				System.out.print(num + "   ");
				num = num+2;
			}
			//Salto de linea
			System.out.println();
		}
	}
}