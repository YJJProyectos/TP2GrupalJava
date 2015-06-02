package tp2;

import java.util.HashMap;

import Excepciones.CoordenadaInvalidaError;
import tp2.Ocupable;

public class Mapa {
	
	HashMap<Coordenada,Ocupable> tablero = new HashMap<Coordenada,Ocupable>();
	private int minFila = 1;
	private int minColumna = 1;
	private int maxFila;
	private int maxColumna;
	
	// Ocupable[][] tablero;

	public Mapa(int bases) {
		
		//tablero = new Ocupable[bases * 5][bases * 5];
		this.maxFila = (bases * 5);
		this.maxColumna = (bases * 5);
		Coordenada coordenada;
		Ocupable ocupable;
		for (int fila = this.minFila; fila <= this.maxFila;fila++){
			for (int columna = this.minColumna; columna <= this.maxColumna; columna++){
				
			    coordenada = new Coordenada(fila,columna);
			    ocupable = new CasillaTerrestre();
				tablero.put(coordenada,ocupable);
			}
			
		}  

	}

	public int tamanio() {
		//return tablero.length * tablero[0].length;
		return tablero.size();
	}

	public int distanciaEntre(Coordenada coordenadaA, Coordenada coordenadaB) throws CoordenadaInvalidaError {
		
		int distancia;
		int filaA = coordenadaA.getFila(); 
		int columnaA = coordenadaA.getColumna();
		int filaB = coordenadaB.getFila();
		int columnaB = coordenadaB.getColumna();
		this.validarCoordenada(coordenadaA);
		this.validarCoordenada(coordenadaB);
		double X = Math.pow( (filaA - filaB ), 2);
		double Y = Math.pow( (columnaA - columnaB), 2);
		double resultadoRaiz = Math.sqrt( X + Y );
		distancia = (int) Math.round(resultadoRaiz);
		
		return distancia;
	}
	private void validarCoordenada(Coordenada coordenada) throws CoordenadaInvalidaError{
		
		int fila = coordenada.getFila();
		int columna = coordenada.getColumna();
		
		if ( ( fila < this.minFila || columna < this.minColumna) || 
				( fila > this.maxFila || columna > this.maxColumna) ) {

			throw new CoordenadaInvalidaError();
		}

	}
}
