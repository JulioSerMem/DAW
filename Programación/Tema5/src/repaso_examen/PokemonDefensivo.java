package repaso_examen;
class PokemonDefensivo extends Pokemon{
	private int resistencia;
	
	public PokemonDefensivo (int numeroPokedex, String nombre, Tipo tipo, int nivelActual, Movimiento[] movimientos, int[][] aprendizaje, int ataquesFuertes) {
		super (numeroPokedex, nombre, tipo, nivelActual, movimientos, aprendizaje);
		this.resistencia=resistencia;
	}
	
	public int getResistencia() {
		return resistencia;
	}
	
	@Override
    public boolean calcularIndiceCombate() {
		return calcularPotenciaMediaDisponible() + resistencia * 1.5;
	}
}
