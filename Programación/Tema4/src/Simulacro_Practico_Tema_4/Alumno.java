package Simulacro_Practico_Tema_4;
import java.util.*;
public class Alumno implements Comparable<Alumno> {
	private String nombre;
	private double nota;
	
	public Alumno(String nombre, double nota) throws NotaInvalidaException {
		if (nota < 0 || nota > 10) {
			throw new NotaInvalidaException("La nota debe de estar comprendida entre 0 y 10");
		}
		this.nombre=nombre;
		this.nota=nota;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getNota() { 
		return nota;
	}
	
	@Override
	public String toString() {
		return "Alumno: " + nombre + " nota: " + nota;
	}
	
	@Override
	public int compareTo(Alumno a) {
		if (this.nota < a.getNota())
			return -1;
		if (this.nota > a.getNota())
			return 1;
		return 0; }
}