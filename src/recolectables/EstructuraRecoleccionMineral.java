package recolectables;

import accionables.Unidad;
import interfaces.Recolectable;

public abstract class EstructuraRecoleccionMineral extends Unidad {

	protected Recolectable mineral;

	public EstructuraRecoleccionMineral(Recolectable mineral) {

		this.mineral = mineral;
	}

}
