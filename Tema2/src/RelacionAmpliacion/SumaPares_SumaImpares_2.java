package RelacionAmpliacion;
import java.util.*;
public class SumaPares_SumaImpares_2 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int num, sumap, sumai;
		sumap = 0;
		sumai = 0;
		for(int i=1; i<11; i++) {
			do{
			System.out.println("Introduzca un numero");
			num = teclado.nextInt();
			}while(num<0);
			if(num%2==0) {
				sumap = sumap + num;
			}else {
				sumai = sumai + num;
			}
		}System.out.println("La suma de los numeros pares es: " + sumap);
		System.out.println("La suma de los numeros impares es: " + sumai);
	}
}