package Ejercicio_1_Arrays;
import java.util.*;
public class ContarNumerosPositivos {
	public static void main(String[] args) {
		int numeros[] = {4, -3, 7, 0, -2, 8};
		positivos(numeros);
	}
	
	public static void positivos(int numeros[]){
		int cont=0;
		for(int numero : numeros) {
			if(numero>0) {
				cont++;
			}
		}
		System.out.println("Hay " + cont + " valores positivos");
	}
}