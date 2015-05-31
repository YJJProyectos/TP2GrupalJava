package tp2;

import tp2.Ocupable;

public class Mapa {
	Ocupable[][] tablero;

	public Mapa(int largo) {
		tablero = new Ocupable[largo][largo];
		return;
	}

	public int tamanio() {
		return tablero.length * tablero[0].length;
	}
}
