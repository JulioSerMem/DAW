package Examen_tema5;
public abstract class Pokemon implements Entrenable{
	protected int numeroPokedex;
	protected String nombre;
	protected Tipo tipo;
	protected int nivelActual;
	protected Movimiento[] movimientos;
	protected int[][] aprendizaje;
	
	public Pokemon (int numeroPokedex, String nombre, Tipo tipo, int nivelActual,Movimiento[] movimientos, int[][] aprendizaje) {
		this.numeroPokedex=numeroPokedex;
		this.nombre=nombre;
		this.tipo=tipo;
		this.nivelActual=nivelActual;
		this.movimientos=movimientos;
		this.aprendizaje=aprendizaje;
	}
	
	public int getNumeroPokedex() {
		return numeroPokedex;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public int getNivelActual() {
		return nivelActual;
	}
	
	public Movimiento[] getMovimientos() {
		return movimientos;
	}
	
	public int[][] getAprencizaje(){
		return aprendizaje;
	}
	
	@Override
    public String toString() {
        return "Numero Pokedex: " + numeroPokedex + " | Nombre: " + nombre + " | Tipo: " + tipo + " | Nivel Actual: " + nivelActual + " | Movimientos: " + movimientos + " | Aprendizaje: " + aprendizaje;
    }
	
	public int contarMovimientosDisponible() {
		int total=0;
		for(int i=0; i<(aprendizaje.length-1); i++) {
			for(int j=0; j<aprendizaje[i].length; j++) {
				if(aprendizaje[i][j]==getNivelActual()) {
					total+=aprendizaje[i][j];
					break;
				}
			}
		}
		total+=movimientos.length;
		return total;
	}
	
	public double calcularPotenciaMediaDisponible() {
		double media=0;
		int contador=0;
		for(int i=0; i<movimientos.length; i++) {
			media+=movimientos[i].potencia;
			contador++;
		}
		return media/contador;
	}
	
	public void mostrarMovimientosDisponibles() {
		for(int i=0; i<movimientos.length; i++) {
			System.out.println(movimientos[i].nombre);
		}
	}
	
	public abstract double calcularIndiceCombate();
}