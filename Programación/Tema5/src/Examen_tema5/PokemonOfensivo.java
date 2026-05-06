package Examen_tema5;
class PokemonOfensivo extends Pokemon{
	private int ataquesFuertes;
	
	public PokemonOfensivo (int numeroPokedex, String nombre, Tipo tipo, int nivelActual,Movimiento[] movimientos, int[][] aprendizaje, int ataquesFuertes) {
		super (numeroPokedex, nombre, tipo, nivelActual, movimientos, aprendizaje);
		this.ataquesFuertes=ataquesFuertes;
	}
	
	public int getAtaquesFuertes() {
		return ataquesFuertes;
	}
	
	@Override
    public boolean calcularIndiceCombate() {
		return calcularPotenciaMediaDisponible() +ataquesFuertes * 2;
	}
}