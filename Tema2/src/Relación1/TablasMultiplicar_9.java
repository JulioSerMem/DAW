package Relación1;
public class TablasMultiplicar_9 {
	public static void main(String[] args) {
		int resultado;
		//Creo un bucle for con otro bucle for dentro, ya que las variables de dentro funcionan como contadores y pasan por todos los numeros del uno al 10, formando asi las tablas de multiplicar
		for(int num1 = 0; num1<=10; num1++) {
			for(int num2 =0; num2<=10; num2++) {
				resultado = num1*num2;
				System.out.println(num1 + " x " + num2 + " = " + resultado);
			}
		}
	}
}