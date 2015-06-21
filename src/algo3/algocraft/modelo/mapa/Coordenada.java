package algo3.algocraft.modelo.mapa;

public class Coordenada {

	protected int fila;
	protected int columna;

	public Coordenada(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}

	@Override
	public int hashCode() {
		return (fila * fila + columna);
	}

	@Override
	public boolean equals(Object otroObjeto) {
		if (otroObjeto.getClass() != this.getClass()) {
			return false;
		} else {
			Coordenada otraCoordenada = (Coordenada) otroObjeto;
			return (otraCoordenada.getFila() == this.getFila() && otraCoordenada
					.getColumna() == this.getColumna());
		}
	}

	public int distanciaA(Coordenada otraCoordenada) {
		int otraFila = otraCoordenada.getFila();
		int otraColumna = otraCoordenada.getColumna();
		double X = Math.pow((this.fila - otraFila), 2);
		double Y = Math.pow((this.columna - otraColumna), 2);
		double resultadoRaiz = Math.sqrt(X + Y);
		int distancia = (int) Math.round(resultadoRaiz);
		return distancia;
	}

}
