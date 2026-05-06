package Examen_tema5;
public class Movimiento {
	protected String nombre;
	protected Tipo tipo;
	protected int potencia;
	
	public Movimiento (String nombre, Tipo tipo, int potencia) {
		this.nombre= nombre;
		this.tipo=tipo;
		this.potencia=potencia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	 @Override
	    public String toString() {
	        return "Nombre: " + nombre + " | Tipo: " + tipo + " | Potencia: " + potencia;
	    }
}