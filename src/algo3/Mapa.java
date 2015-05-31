package algo3;

import algo3.Ocupable;

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
