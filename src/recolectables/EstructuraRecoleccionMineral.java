package recolectables;

import interfaces.Recolectable;
import tp2.Unidad;

public abstract class EstructuraRecoleccionMineral extends Unidad {

	protected Recolectable mineral;

	public EstructuraRecoleccionMineral(Recolectable mineral) {

		this.mineral = mineral;
	}

}
