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

}
