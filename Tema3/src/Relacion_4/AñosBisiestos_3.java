package Relacion_4;
import java.util.*;
public class AñosBisiestos_3 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int ano=0;
		ano=anos(ano);
		boolean comprobacion = calculo(ano);
		if(comprobacion==true) {
			System.out.println("El año es bisiesto");
		}else if(comprobacion==false) {
			System.out.println("El año no es bisiesto");
		}
	}
	
	private static int anos(int ano) {
		System.out.println("Inetroduzca el numero del año");
		ano = teclado.nextInt();
		while(ano<0) {
			System.out.println("Debes introducir un año en positivo");
			ano = teclado.nextInt();
		}return ano;
	}
	
	private static boolean calculo(int ano) {
		boolean prueba= false;
		if(ano%4==0 || ano%100==0) {
			prueba = true;
			if(ano%400==0) {
				prueba=false;
			}
		}return prueba;
	}
}