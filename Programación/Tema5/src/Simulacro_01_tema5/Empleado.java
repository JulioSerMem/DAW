package Simulacro_01_tema5;
public abstract class Empleado implements Reconocible{
	private String nombre;
	private String id;
	private Departamento departamento;
	private double horasTrabajadas[][];
	
	public Empleado(String nombre, String id, Departamento departamento) {
		this.nombre=nombre;
		this.id=id;
		this.departamento=departamento;
		this.horasTrabajadas=new double[5][2];
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento=departamento;
	}
	
	public double [][] getHorasTrabajadas() {
		return horasTrabajadas;
	}
	
	public void setHorasTrabajadas(double [][] horasTrabajadas) {
		this.horasTrabajadas=horasTrabajadas;
	}
	
	@Override
	public String toString() {
		return "Empleado: " + nombre + "\nid: " + id + "\ndepartamento: " + departamento + "\nhoras trabajadas: " + horasTrabajadas;
	}
}