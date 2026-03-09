package Examen;
import java.util.*;
public class Principal {
	public static void main(String[] args) {
		//Creo un objeto llamado teclado de tipo Scanner llamando al constructor scanner
		Scanner teclado = new Scanner(System.in);
		//Creo un array llamado vector productos de tipo producto, llamanndo al constructor producto 5 veces
		Producto vectorProductos[] = new Producto[5];
		//Hago un bucle for para que vaya rellenando los 5 objetos del array
		for(int i=0; i<vectorProductos.length; i++) {
			System.out.println("Introduce el nombre del producto: " + (i+1));
			//Introduce el nombre
			String nombre=teclado.nextLine();
		//Creo dos buleanos en false y establezco precio y stock de manera que no influya luego, por que con esos parametros dara error
		boolean precioValido=false;
		boolean stockValido=false;
		double precio=0;
		int stock=-1;
		//Creo un while para que se rellenen los dos parametros restantes del objetohasta que hambos sean validos y finalmente se implementen en el objeto
		while(!precioValido || !stockValido) {
			try {
				if(!precioValido) {
					System.out.println("Introduce el precio:");
					precio = teclado.nextDouble();
				}if(!stockValido) {
					System.out.println("Introduce el stock:");
					stock = teclado.nextInt();
					teclado.nextLine();
				}
			    vectorProductos[i] = new Producto(nombre, precio, stock);
			    precioValido = true;
			    stockValido=true;
				
			} 
			//Capturo los posibles errores con la  excepcion que he creado
			catch (ProductoInvalidoException e) {
				System.out.println("Error: " + e.getMessage());
				System.out.println("Vuelve a introducir tanto el precio como el stock.");
			}
		}
		}
		
		// 4. Mostrar lista original
			System.out.println("\nLista original de alumnos:");
			for (Producto p : vectorProductos) {
				System.out.println(p);
			}
			
		// 5. Ordenar por precio
			Arrays.sort(vectorProductos);
			
		// 6. Mostrar el producto más caro.
			Producto masCaro= vectorProductos[vectorProductos.length - 1];
			System.out.println("\nProducto mas caro:");
			System.out.println(masCaro);
			
		// 7. Reducir el stock en 2
			for (Producto p : vectorProductos) {
				int nuevoStock=0;
				if(p.getStock()>=2) {
					nuevoStock=p.getStock() - 2;
				}else {
					nuevoStock=0;
				}p.setStock(nuevoStock);
			}
			
			// 8. Mostrar lista final
			System.out.println("\nLista final tras restar 2 stock:");
			for (Producto p : vectorProductos) {
				System.out.println(p);
			}	
	}
}