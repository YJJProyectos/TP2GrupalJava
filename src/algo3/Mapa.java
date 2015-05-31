package algo3;

import algo3.Ocupable;

public class Mapa {
	Ocupable [][] matriz;

	public Mapa(int largo) {
		matriz = new Ocupable[largo][largo];
		return;
	}
	
	public int tamanio(){
		return matriz.length * matriz[0].length;
	}
}
