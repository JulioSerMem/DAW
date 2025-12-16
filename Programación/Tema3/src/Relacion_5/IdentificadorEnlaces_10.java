package Relacion_5;
import java.util.*;
public class IdentificadorEnlaces_10 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String url1=enlace();
		String url2=enlace();
		String url3=enlace();
		String url4=enlace();
		String url5=enlace();
		String url6=enlace();
		String url7=enlace();
		String url8=enlace();
		String url9=enlace();
		String url10=enlace();
	}
	
	private static String enlace() {
		System.out.println("Ingrese 10 enlaces");
		String enlace=teclado.nextLine().toLowerCase().trim();
		return enlace;
	}
	
	private static void comprobacion() {
		
	}
}
