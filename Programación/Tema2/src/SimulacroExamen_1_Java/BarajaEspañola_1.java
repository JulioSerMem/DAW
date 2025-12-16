package SimulacroExamen_1_Java;
import java.util.*;
public class BarajaEspañola_1 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		char palo;
		//Creo un bucle para pedir un palo de la baraja o todos
		do {
			System.out.println("Ingrese el palo que deseas");
			palo = teclado.next().charAt(0);
		}while(palo != 'b' && palo != 'c' && palo != 'e' && palo != 'o' && palo != 't');
		//Si elije el palo bastos o b, se imprime por pantalla gracias al bucle for del numero uno al 7, con los if, el 8 y 9 no se escribe,el 10 se cambia por S de Sota, el 11 por la C de Caballo y el 12 por la R de Rey
			if(palo=='b') {
				for(int i=1; i<13; i++) {
					if(i==10) {
						System.out.print("S" + "-" + palo + "  ");
					}else if(i==11) {
						System.out.print("C" + "-" + palo + "  ");
					}else if(i==12) {
						System.out.print("R" + "-" + palo + "  ");
					}else if(i==8 || i==9){
						
					}else {
						System.out.print(i + "-" + palo + "  ");
					}
				}
			}//Si elije el palo copas o c, se imprime por pantalla gracias al bucle for del numero uno al 7, con los if, el 8 y 9 no se escribe,el 10 se cambia por S de Sota, el 11 por la C de Caballo y el 12 por la R de Rey
			else if(palo=='c') {
				for(int i=1; i<13; i++) {
					if(i==10) {
						System.out.print("S" + "-" + palo + "  ");
					}else if(i==11) {
						System.out.print("C" + "-" + palo + "  ");
					}else if(i==12) {
						System.out.print("R" + "-" + palo + "  ");
					}else if(i==8 || i==9){
						
					}else {
						System.out.print(i + "-" + palo + "  ");
					}
				}
			}//Si elije el palo espadas o e, se imprime por pantalla gracias al bucle for del numero uno al 7, con los if, el 8 y 9 no se escribe,el 10 se cambia por S de Sota, el 11 por la C de Caballo y el 12 por la R de Rey
			else if(palo=='e') {
				for(int i=1; i<13; i++) {
					if(i==10) {
						System.out.print("S" + "-" + palo + "  ");
					}else if(i==11) {
						System.out.print("C" + "-" + palo + "  ");
					}else if(i==12) {
						System.out.print("R" + "-" + palo + "  ");
					}else if(i==8 || i==9){
						
					}else {
						System.out.print(i + "-" + palo + "  ");
					}
				}
			}//Si elije el palo oros o o, se imprime por pantalla gracias al bucle for del numero uno al 7, con los if, el 8 y 9 no se escribe,el 10 se cambia por S de Sota, el 11 por la C de Caballo y el 12 por la R de Rey
			else if(palo=='o') {
				for(int i=1; i<13; i++) {
					if(i==10) {
						System.out.print("S" + "-" + palo + "  ");
					}else if(i==11) {
						System.out.print("C" + "-" + palo + "  ");
					}else if(i==12) {
						System.out.print("R" + "-" + palo + "  ");
					}else if(i==8 || i==9){
						
					}else {
						System.out.print(i + "-" + palo + "  ");
					}
				}
			}//Si elije todoslos palos o t, se imprime por pantalla gracias al bucle for del numero uno al 7, con los if, el 8 y 9 no se escribe,el 10 se cambia por S de Sota, el 11 por la C de Caballo y el 12 por la R de Rey, con todos los palos
			else {
				for(int i=1; i<13; i++) {
					if(i==10) {
						System.out.print("S" + "-o  ");
					}else if(i==11) {
						System.out.print("C" + "-o  ");
					}else if(i==12) {
						System.out.print("R" + "-o  ");
					}else if(i==8 || i==9){
						
					}else {
						System.out.print(i + "-o  ");
					}
				}System.out.println();
				for(int i=1; i<13; i++) {
					if(i==10) {
						System.out.print("S" + "-b  ");
					}else if(i==11) {
						System.out.print("C" + "-b  ");
					}else if(i==12) {
						System.out.print("R" + "-b  ");
					}else if(i==8 || i==9){
						
					}else {
						System.out.print(i + "-b  ");
					}
				}System.out.println();
				for(int i=1; i<13; i++) {
					if(i==10) {
						System.out.print("S" + "-c  ");
					}else if(i==11) {
						System.out.print("C" + "-c  ");
					}else if(i==12) {
						System.out.print("R" + "-c  ");
					}else if(i==8 || i==9){
						
					}else {
						System.out.print(i + "-c  ");
					}
				}System.out.println();
				for(int i=1; i<13; i++) {
					if(i==10) {
						System.out.print("S" + "-e  ");
					}else if(i==11) {
						System.out.print("C" + "-e  ");
					}else if(i==12) {
						System.out.print("R" + "-e  ");
					}else if(i==8 || i==9){
						
					}else {
						System.out.print(i + "-e  ");
					}
				}
			}
	}
}