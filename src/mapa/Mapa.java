package mapa;

import interfaces.Accionable;

import java.util.HashMap;

import ocupables.Casilla;
import ocupables.CasillaTerrestre;
import excepciones.CoordenadaInvalidaError;

public class Mapa  {

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
				Casilla ocupable = new CasillaTerrestre();
				ocupable.situar(coordenada, this);
				tablero.put(coordenada, ocupable);
			}

		}

	}

	public int tamanio() {
		// return tablero.length * tablero[0].length;
		return tablero.size();
	}

	public int distanciaEntre(Coordenada coordenadaA, Coordenada coordenadaB)
			throws CoordenadaInvalidaError {

		int filaA = coordenadaA.getFila();
		int columnaA = coordenadaA.getColumna();
		int filaB = coordenadaB.getFila();
		int columnaB = coordenadaB.getColumna();
		this.validarCoordenada(coordenadaA);
		this.validarCoordenada(coordenadaB);
		double X = Math.pow((filaA - filaB), 2);
		double Y = Math.pow((columnaA - columnaB), 2);
		double resultadoRaiz = Math.sqrt(X + Y);
		int distancia = (int) Math.round(resultadoRaiz);

		return distancia;
	}

	public int distanciaEntre(Casilla posicion1, Casilla posicion2) {
		try {
			int distancia = this.distanciaEntre(posicion1.posicion(),
					posicion2.posicion());
			return distancia;
		} catch (CoordenadaInvalidaError error) {
			return -1;
		}
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

	public void agregarElementoEnPosicion(Accionable elemento,
			Coordenada coordenada) {

		try {
			validarCoordenada(coordenada);
		} catch (CoordenadaInvalidaError error) {
			return;
		}
		Casilla casillero = tablero.get(coordenada);
		elemento.posicionar(casillero);
	}

	public Accionable obtenerElementoEnPosicion(Coordenada coordenada) {

		Casilla casillero = tablero.get(coordenada);
		return casillero.ocupante();
	}
}
