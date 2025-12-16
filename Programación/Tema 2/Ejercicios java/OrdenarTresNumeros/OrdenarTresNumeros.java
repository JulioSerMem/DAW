package OrdenarTresNumeros;

import java.util.Scanner;

public class OrdenarTresNumeros {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        double num1, num2, num3;
        double max, min, medio;
        System.out.println("Introduce el numero 1");
        num1 = sc.nextDouble();
        max = 0;
        min = 0;
        medio = 0;
        System.out.println("Introduce el numero 2");
        num2 = sc.nextDouble();
        System.out.println("Introduce el numero 3");
        num3 = sc.nextDouble();
        if(num1>=num2 && num1>=num3){
            max = num1;
        }else if(num2>=num3 && num2>=num1){
             max = num2;
        }else if(num3>=num1 && num3>=num2){
             max = num3;
        }if(num1<=num2 && num1<=num3){
             min = num1;
        }else if(num2<=num1 && num2<=num3){
             min = num2;
        }else if(num3<=num1 && num3<=num2){
             min = num3;
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
