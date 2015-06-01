package tp2;

import tp2.Ocupable;

public class Mapa {
	Ocupable[][] tablero;

	public Mapa(int bases) {
		tablero = new Ocupable[bases * 5][bases * 5];
	}

	public int tamanio() {
		return tablero.length * tablero[0].length;
	}
}
