package Relación1;
import java.util.Scanner;
public class OrdenaTresNumeros_1{
    private static Scanner teclado = new Scanner(System.in);//Arranco el escaner para que luego lea lo introducido por el teclado
    public static void main(String[]args){
        double num1, num2, num3;//Creo las variables num1, num2, num3
        double max, min, medio;//Creo las variables mx, min, medio
        System.out.println("Introduce el numero 1");
        num1 = teclado.nextDouble();
        max = 0;
        min = 0;
        medio = 0;
        System.out.println("Introduce el numero 2");
        num2 = teclado.nextDouble();
        System.out.println("Introduce el numero 3");
        num3 = teclado.nextDouble();
        //Compruebo cual es el numero mayor
        if(num1>=num2 && num1>=num3){
            max = num1;
        }else if(num2>=num3 && num2>=num1){
             max = num2;
        }else if(num3>=num1 && num3>=num2){
             max = num3;
        //Compruebo cual en sel numero menor
        }if(num1<=num2 && num1<=num3){
             min = num1;
        }else if(num2<=num1 && num2<=num3){
             min = num2;
        }else if(num3<=num1 && num3<=num2){
             min = num3;
        //Determino q el numero q queda sera el del medio
        }if(max>=num1 && num1>=min){
             medio = num1;
        }else if(max>=num2 && num2>=min){
             medio = num2;
        }else if(max>=num3 && num3>=min){
             medio = num3;
        }
        System.out.println("El orden de los numeros de menor a mayor es:" + min + "<" + medio + "<" + max);
    }
}