package Ejercicio_1_Arrays;
import java.util.*;
public class SumaDeElementos {
	public static void main(String[] args) {
		int vectorNums[] = {1, 2, 3, 4, 5, 6};
		sumaTotal(vectorNums);
		media(vectorNums);
	}
	
	public static void sumaTotal(int vectorNums[]) {
		int sumaTotal=0;
		for(int numero : vectorNums) {
			sumaTotal+=numero;
		}
		System.out.println("La suma total es: " + sumaTotal);
	}
	
	public static void media(int vectorNums[]) {
		double media=0;
		for(int numero : vectorNums) {
			media+=numero;
		}
		System.out.println("La media es: " + (media/vectorNums.length));
	}
}
