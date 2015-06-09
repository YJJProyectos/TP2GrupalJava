package algo3.algocraft.modelo.mapa;

import java.util.HashMap;

import algo3.algocraft.modelo.accionables.Unidad;

public class Mapa {

	HashMap<Coordenada, Casilla> tablero = new HashMap<Coordenada, Casilla>();
	private int minFila = 1;
	private int minColumna = 1;
	private int maxFila;
	private int maxColumna;

	// Ocupable[][] tablero;

	public Mapa(int bases) {

		// tablero = new Ocupable[bases * 5][bases * 5];
		this.maxFila = (bases * 5);
		this.maxColumna = (bases * 5);

		for (int fila = this.minFila; fila <= this.maxFila; fila++) {
			for (int columna = this.minColumna; columna <= this.maxColumna; columna++) {

				Coordenada coordenada = new Coordenada(fila, columna);
				Casilla casilla = new Casilla();
				casilla.situar(coordenada);
				tablero.put(coordenada, casilla);
			}

		}

	}

	public int tamanio() {
		// return tablero.length * tablero[0].length;
		return tablero.size();
	}

	private void validarCoordenada(Coordenada coordenada)
			throws CoordenadaInvalidaError {

		int fila = coordenada.getFila();
		int columna = coordenada.getColumna();

		if ((fila < this.minFila || columna < this.minColumna)
				|| (fila > this.maxFila || columna > this.maxColumna)) {

			throw new CoordenadaInvalidaError();
		}

	}

	public boolean agregarElementoEnPosicion(Unidad elemento,
			Coordenada coordenada) {

		try {
			validarCoordenada(coordenada);
		} catch (CoordenadaInvalidaError error) {
			return false;
		}
		Casilla casillero = tablero.get(coordenada);
		elemento.posicionar(casillero);
		return true;
	}

	public Unidad obtenerElementoTerrestreEnPosicion(Coordenada coordenada) {

		Casilla casillero = tablero.get(coordenada);
		return casillero.getOcupanteTerrestre();
	}
}
