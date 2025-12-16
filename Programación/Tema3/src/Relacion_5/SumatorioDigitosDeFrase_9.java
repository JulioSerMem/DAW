package Relacion_5;
import java.util.*;
public class SumatorioDigitosDeFrase_9 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		String frase=pedirFrase();
		sumatorioNumeros(frase);
	}
	
	private static String pedirFrase() {
        System.out.println("Ingrese una frase");
        String frase = teclado.nextLine().toLowerCase();
        return frase+=".";
    }
	
	private static void sumatorioNumeros(String frase) {
		int num=0, suma=0;
		boolean isDigit=false;
		String numero="";
		for(int i=0; i<frase.length(); i++) {
			if(Character.isDigit(frase.charAt(i))) {
				numero+=frase.charAt(i);
				isDigit=true;
			}else if(!Character.isDigit(frase.charAt(i)) && isDigit==true){
				num=Integer.parseInt(numero);
				suma=suma+num;
				isDigit=false;
				numero="";
			}
		}System.out.println(suma);
	}
}