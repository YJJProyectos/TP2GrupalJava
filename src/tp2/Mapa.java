package tp2;

import java.util.HashMap;

import tp2.Ocupable;

public class Mapa {
	
	HashMap<Coordenada,Ocupable> tablero = new HashMap<Coordenada,Ocupable>();
	
	// Ocupable[][] tablero;

	public Mapa(int bases) {
		
		//tablero = new Ocupable[bases * 5][bases * 5];
		Coordenada coordenada;
		Ocupable ocupable;
		for (int fila = 1; fila <= (bases * 5);fila++){
			for (int columna = 1; columna <= (bases * 5); columna++){
				
			    coordenada = new Coordenada(fila,columna);
			    ocupable = null;
				tablero.put(coordenada,ocupable);
			}
			
		}  

	}

	public int tamanio() {
		//return tablero.length * tablero[0].length;
		return tablero.size();
	}

	public long distanciaEntre(Coordenada coordenadaA, Coordenada coordenadaB) {
		
		long distancia;
		int filaA = coordenadaA.getFila(); 
		int columnaA = coordenadaA.getColumna();
		int filaB = coordenadaB.getFila();
		int columnaB = coordenadaB.getColumna();
		double X = Math.pow( (filaA - filaB ), 2);
		double Y = Math.pow( (columnaA - columnaB), 2);
		double XCuadradoMasYCuadrado = X + Y;
		double resultadoRaiz = Math.sqrt( XCuadradoMasYCuadrado);
		
		distancia =  Math.round(resultadoRaiz);
		
		return distancia;
	}
}
