package tp2;

import interfaces.Accionable;
import interfaces.Ocupable;

import java.util.HashMap;

import excepciones.CoordenadaInvalidaError;


public class Mapa {

	HashMap<Coordenada, Ocupable> tablero = new HashMap<Coordenada, Ocupable>();
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
				Ocupable ocupable = new CasillaTerrestre();
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

	private void validarCoordenada(Coordenada coordenada)
			throws CoordenadaInvalidaError {

		int fila = coordenada.getFila();
		int columna = coordenada.getColumna();

		if ((fila < this.minFila || columna < this.minColumna)
				|| (fila > this.maxFila || columna > this.maxColumna)) {

			throw new CoordenadaInvalidaError();
		}

	}

	public void agregarElementoEnPosicion(Accionable elemento, Coordenada coordenada) {
		
		Ocupable casillero = tablero.get(coordenada);
		casillero.ocupar(elemento);		
	}
	
	public Accionable obtenerElementoEnPosicion(Coordenada coordenada) {
		
		Ocupable casillero = tablero.get(coordenada);
		return casillero.ocupante();		
	}
}
