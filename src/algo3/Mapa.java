package algo3;

public class Mapa {
	Casilla [][] matriz;

	public Mapa(int largo) {
		matriz = new Casilla[largo][largo];
		return;
	}
	
	public int tamanio(){
		return matriz.length * matriz[0].length;
	}
}
