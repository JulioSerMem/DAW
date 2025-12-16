	package RelacionAmpliacion;
import java.util.*;
public class MayorMenorPromedio_4 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int numn, num, media = 0;
		int max = 0;
		int min = 0;
		System.out.println("Introduzca la cantidad de numeros que desea comparar");
		numn = teclado.nextInt();
		while(numn <= 0) {
			System.out.println("Introduzca un numer diferente a 0 y positivo");
			numn = teclado.nextInt();
		}
		
		for(int i=0; i<numn; i++) {
			System.out.println("Introduzca un numero");
			num = teclado.nextInt();
			media = media + num;
			if(i==0) {
				 max = num;
				 min = num;
			}else if(num>max) {
				max = num;
			}else if(num<min) {
				min = num;
			}			
		}
		System.out.println("El mayor numero que has introducido es: " + max);
		System.out.println("El mayor numero que has introducido es: " + min);
		System.out.println("La media de los numeros que has introducido es: " + media/numn);
	}
}