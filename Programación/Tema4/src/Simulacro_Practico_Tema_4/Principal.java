package Simulacro_Practico_Tema_4;
import java.util.*;
public class Principal {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Alumno vectorAlumnos[] = new Alumno[5];
		for(int i=1; i<=vectorAlumnos.length; i++) {
			System.out.println("Introduce el nombre del alumno: " + i);
			String nombre=teclado.nextLine();
			boolean notaValida=false;
			while(!notaValida) {
				System.out.println("Introduce la nota:");
				try {
					double nota = teclado.nextDouble();
				    vectorAlumnos[i] = new Alumno(nombre, nota);
				    notaValida = true; // si llega aquí, la nota es válida
				} catch (NotaInvalidaException e) {
					System.out.println("Error: " + e.getMessage());
					System.out.println("Vuelve a introducir la nota.");
				}
			}
		}
		// 4. Mostrar lista original
		System.out.println("\nLista original de alumnos:");
		for (Alumno a : vectorAlumnos) {
			System.out.println(a);
		}
		
		// 5. Ordenar por nota
		Arrays.sort(vectorAlumnos);
		
		// 6. Mostrar el mejor alumno (el último tras ordenar)
		Alumno mejor = vectorAlumnos[vectorAlumnos.length - 1];
		System.out.println("\nMejor alumno:");
		System.out.println(mejor);
		
		// 7. Subir 1 punto a todos (sin superar 10)
		for (Alumno a : vectorAlumnos) {
			double nuevaNota = a.getNota() + 1;
			if (nuevaNota > 10) {
				nuevaNota = 10;
			}
			// Creamos un nuevo Alumno con la nota subida
			try {
				// Como nombre no cambia, lo reutilizamos
				a = new Alumno(a.getNombre(), nuevaNota);
			} catch (NotaInvalidaException e) {
				// No debería ocurrir, pero lo dejamos por seguridad
				System.out.println("Error inesperado al subir nota.");
			}
		}
		
		// 8. Mostrar lista final
		System.out.println("Lista final tras subir 1 punto:");
		for (Alumno a : vectorAlumnos) {
			System.out.println(a);
		}
		
		teclado.close();
	}
}