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
}
