package Ejercicio_1_Arrays;
import java.util.*;
public class Crear_Mostrar {
	public static void main(String[] args) {
		int vectorNums[] = {1, 2, 3, 4, 5};
		bucleFor(vectorNums);
		bucleForEach(vectorNums);
	}
	
	public static void bucleFor(int vectorNums[]) {
		for(int i=0; i<vectorNums.length; i++) {
			System.out.println(vectorNums[i]);
		}
	}
	
	public static void bucleForEach(int vectorNums[]) {
		for(int numero : vectorNums) {
			System.out.println(numero);
		}
	}
}