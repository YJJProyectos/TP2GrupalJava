package tp2;

import interfaces.Accionable;
import interfaces.Ocupable;
import interfaces.Navegable;
import interfaces.Ubicable;

import java.util.HashMap;

import excepciones.CoordenadaInvalidaError;


public class Mapa implements Navegable{

	HashMap<Ubicable, Ocupable> tablero = new HashMap<Ubicable, Ocupable>();
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

				Ubicable coordenada = new Coordenada(fila, columna);
				Ocupable ocupable = new CasillaTerrestre();
				ocupable.situar(coordenada, this);
				tablero.put(coordenada, ocupable);
			}

		}

	}

	public int tamanio() {
		// return tablero.length * tablero[0].length;
		return tablero.size();
	}

	public int distanciaEntre(Ubicable coordenadaA, Ubicable coordenadaB)
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
	
	public int distanciaEntre(Ocupable posicion1, Ocupable posicion2) {
		try {
			int distancia = this.distanciaEntre(posicion1.posicion(),posicion2.posicion());
			return distancia;
		} catch(CoordenadaInvalidaError error) {
			return -1;
		}
	}

	private void validarCoordenada(Ubicable coordenada)
			throws CoordenadaInvalidaError {

		int fila = coordenada.getFila();
		int columna = coordenada.getColumna();

		if ((fila < this.minFila || columna < this.minColumna)
				|| (fila > this.maxFila || columna > this.maxColumna)) {

			throw new CoordenadaInvalidaError();
		}

	}

	public void agregarElementoEnPosicion(Accionable elemento, Ubicable coordenada) {
		
		try {
			validarCoordenada(coordenada);
		} catch(CoordenadaInvalidaError error) {
			return;
		}
		Ocupable casillero = tablero.get(coordenada);
		elemento.posicionar(casillero);		
	}
	
	public Accionable obtenerElementoEnPosicion(Ubicable coordenada) {
		
		Ocupable casillero = tablero.get(coordenada);
		return casillero.ocupante();		
	}
}
