package Relación1;
import java.util.*;
public class AdivinarNumero_4{
	private static Scanner sc = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
	private static Random random = new Random();
	public static void main(String[] args) {
	//Inicio las variables
	int num, fallos, secreto;
	//Determino el numero secreto entre 1 y 100
	secreto = random.nextInt((101)+1);
	//El contador se inicia en 0
	fallos = 0;
		//Genero un bucle con un total de cinco intentos
		do{
			System.out.println("Introduzaca un numero");
			num = sc.nextInt();
			//Si acierta el numero, le digo en cuantos intentos lo adivino
			if(num==secreto) {
				System.out.println("Enhorabuena, lo has adivinado en " + (fallos+1) + " intentos.");
				break;
			//Identifico si el numero introducido en¡sta dentro del intervalo del numero secreto
			}else if(num<1 || 100<num){
				System.out.println("El numero qu buscas esta comprendido entre el 1 y el 100, intentalo con un numero que si este en ese intervalo");
			//Si no ha adivinado el numero, informo si el numero secreto es mayor	
			}else if(num<secreto) {
				System.out.println("El numero secreto es mayor");
			//Si no ha adivinado el numero, informo si el numero secreto es menor
			}else if(num>secreto) {
				System.out.println("El numero secreto es menor");
			}fallos++;
			//
			if(fallos!=5) {
				System.out.println("Intentalo de nuevo, te quedan " + (5-fallos) + " intentos");
			}
		}while(fallos!=5);
			System.out.println("El numero era: " + secreto);
	}
}