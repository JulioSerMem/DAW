package Relación1;
import java.util.*;
public class NotasExamen_6 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//Determino las variables
		int alumnos, numnotas, notas;
		double media;
		numnotas = 0;
		media = 0;
		//Pido el numero de alumnos
		System.out.println("Introduzca el numero de alumnos");
		alumnos = sc.nextInt();
		//Creo un bucle para que vaya introduciendo las notas
		while (numnotas!=alumnos) {
			System.out.println("Introduzca una nota");
			notas = sc.nextInt(11);
			if(notas>=5) {
				media++;
			}numnotas++;
		}//Calcula y muestra la media de las notas
		media = media*100/alumnos;
		System.out.println("La media de  aprobados es de un " + media + "% y la de suspensos es de un " + (100-media) + "%");
	}
}