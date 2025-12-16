package Examen_1;
import java.util.Scanner;
public class Ejercicio_2 {
	private static Scanner teclado = new Scanner(System.in);//Inicio el escaner
	public static void main(String[] args) {
		//Creo las variables y los contadores los inicio a 0
		int n, n1, billetes500=0, billetes200=0, billetes100=0, billetes50=0, billetes20=0, billetes10=0, billetes5=0, monedas2=0, monedas1=0;
		//Pido el primer numero por pantala
		System.out.println("Ingresa un numero");//Lanzo un mensaje por pantalla para peidr el valor de la variable
		n = teclado.nextInt();//Inicio la variable co el numero introducido
		//Inicio esta variable como el nuemor introducido por teclado para oeperar con el
		n1=n;
		//Creo un bucle para obliga a que se introduzca un numero mayor a 0, el 0 no esta incluido
		while(n<=0) {
			System.out.println("Siga intentandolo");
			n = teclado.nextInt();
			n1=n;
		}
		//Inicio un bucle para que cada vez que pueda entrar un un if, reduzca el numreo hasta llegar a 0 y los contadores de los billetes se van actualizando
		while(n1!=0){
			if(n1>=500) {
				n1=n1-500;
				billetes500++;
			}else if(n1>=200) {
				n1=n1-200;
				billetes200++;
			}else if(n1>=100) {
				n1=n1-100;
				billetes100++;
			}else if(n1>=50) {
				n1=n1-50;
				billetes50++;
			}else if(n1>=20) {
				n1=n1-20;
				billetes20++;
			}else if(n1>=10) {
				n1=n1-10;
				billetes10++;
			}else if(n1>=5) {
				n1=n1-5;
				billetes5++;
			}else if(n1>=2) {
				n1=n1-2;
				monedas2++;
			}else {
				n1=n1-1;
				monedas1++;
			}
		}
		//Segun el tamaño del numero introducido muestro por pantalla la cantidad minima de billetes utlizados
		if(n>500) {
			System.out.println(billetes500 + " billete de 500");
			System.out.println(billetes200 + " billete de 200");
			System.out.println(billetes100 + " billete de 100");
			System.out.println(billetes50 + " billete de 50");
			System.out.println(billetes20 + " billete de 20");
			System.out.println(billetes10 + " billete de 10");
			System.out.println(billetes5 + " billete de 5");
			System.out.println(monedas2 + " monedas de 2");
		}else if(n>200) {
			System.out.println(billetes200 + " billete de 200");
			System.out.println(billetes100 + " billete de 100");
			System.out.println(billetes50 + " billete de 50");
			System.out.println(billetes20 + " billete de 20");
			System.out.println(billetes10 + " billete de 10");
			System.out.println(billetes5 + " billete de 5");
			System.out.println(monedas2 + " monedas de 2");
		}else if(n>100) {
			System.out.println(billetes100 + " billete de 100");
			System.out.println(billetes50 + " billete de 50");
			System.out.println(billetes20 + " billete de 20");
			System.out.println(billetes10 + " billete de 10");
			System.out.println(billetes5 + " billete de 5");
			System.out.println(monedas2 + " monedas de 2");
		}else if(n>50) {
			System.out.println(billetes20 + " billete de 20");
			System.out.println(billetes10 + " billete de 10");
			System.out.println(billetes5 + " billete de 5");
			System.out.println(monedas2 + " monedas de 2");
		}else if(n>20) {
			System.out.println(billetes20 + " billete de 20");
			System.out.println(billetes10 + " billete de 10");
			System.out.println(billetes5 + " billete de 5");
			System.out.println(monedas2 + " monedas de 2");
		}else if(n>10) {
			System.out.println(billetes10 + " billete de 10");
			System.out.println(billetes5 + " billete de 5");
			System.out.println(monedas2 + " monedas de 2");
		}else if(n>5) {
			System.out.println(billetes5 + " billete de 5");
			System.out.println(monedas2 + " monedas de 2");
		}else if(n>2) {
			System.out.println(monedas2 + " monedas de 2");
		}if(monedas1>=1){
			System.out.println(monedas1 + " monedas de 1");
		}
	}
}
