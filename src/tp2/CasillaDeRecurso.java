package tp2;

import recolectables.Recolectable;
import tp2.CasillaTerrestre;

public class CasillaDeRecurso extends CasillaTerrestre {

	private Recolectable recurso;

	public CasillaDeRecurso(Recolectable unRecolectable) {

		this.recurso = unRecolectable;
	}

	public boolean estaOcupadaPorUnEdificio() {
		return (ocupante != null);
	}

	public boolean estaOcupada() {
		return (recurso != null);
	}

	public void agregarRecolectante(Accionable edificio) {
		this.ocupante = edificio;

	}
}
