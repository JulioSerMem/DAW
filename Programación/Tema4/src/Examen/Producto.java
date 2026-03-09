package Examen;
import java.util.*;
public class Producto implements Comparable<Producto>{
	private String nombre;
	private double precio;
	private int stock;
	
	//Creo la instancia de la clase objeto
	public Producto(String nombre, double precio, int stock) throws ProductoInvalidoException{
		this.nombre=nombre;
		if(precio<=0) {
			throw new ProductoInvalidoException("El precio debe ser mayor a 0");
		}
		this.precio=precio;
		if(stock<0) {
			throw new ProductoInvalidoException("Puede no haber productos, pero no puedes deber productos");
		}
		this.stock=stock;
	}
	
	//Getters y Setters
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String setNombre(String nombre) {
		return this.nombre=nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public double setPrecio(double precio) {
		return this.precio=precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public int setStock(int nuevoStock) {
		return this.stock=nuevoStock;
	}
	
	//ToString
	
	@Override
	public String toString() {
		return "Producto: " + nombre + " precio: " + precio + " stock: " + stock;
	}
	
	//CompareTo
	
	@Override
	public int compareTo(Producto p) {
		if (this.precio < p.getPrecio())
			return -1;
		if (this.precio > p.getPrecio())
			return 1;
		return 0; }
}
