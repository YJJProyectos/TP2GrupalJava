package ocupables;

import interfaces.Accionable;
import interfaces.Recolectable;

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
