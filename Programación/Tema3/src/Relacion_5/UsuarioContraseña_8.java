package Relacion_5;
import java.util.*;
public class UsuarioContraseña_8 {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		usuario();
		contrasena();
	}
	
	private static boolean usuario() {
		boolean usuarioValido=true;
		System.out.println("Introduzca su usuario");
		String usuario=teclado.nextLine().toLowerCase();
		while(usuario.length()>30 || usuario.length()<1) {
			System.out.println("Ingrese algo como usuario pero sin pasarse de 30 caracteres");
			usuario=teclado.nextLine();
		}for(int i=0; i<usuario.length(); i++) {
			if(!Character.isAlphabetic(usuario.charAt(i))){
				usuarioValido=false;
			}
		}if(usuarioValido==false) {
			System.out.println("El usuario no puede contenter ni numeros ni caracteres especiales");
			while(usuarioValido==false) {
				usuarioValido=usuario();
			}
		}else {
			usuarioValido=true;
			System.out.println("Usuario valido");
		}return usuarioValido;
	}
	
	private static void contrasena() {
		int letra=0, digito=0, caracterEspecial=0;
		System.out.println("Introduzca su contrasena");
		String contrasena=teclado.nextLine();
		while(contrasena.length()<7) {
			System.out.println("Ingrese alguna contraseña con almenos 7 caracteres");
			contrasena=teclado.nextLine();
		}for(int i=0; i<contrasena.length(); i++) {
			if(Character.isAlphabetic(contrasena.charAt(i))) {
				letra++;
			}else if(Character.isDigit(contrasena.charAt(i))) {
				digito++;
			}else {
				caracterEspecial++;
			}
		}if(letra!=0 && digito!=0 && caracterEspecial!=0) {
			System.out.println("Contraseña valida");
		}else {
			System.out.println("La contraseña no es valida, debe de tener minimo una letra, un digito y un caracter no alfanumerico");
			contrasena();
		}
	}
}