package imponibles;

import recolectables.Recolectable;
import accionables.Unidad;

public abstract class EstructuraRecoleccionMineral extends Unidad {

	protected Recolectable mineral;

	public EstructuraRecoleccionMineral(Recolectable mineral) {

		this.mineral = mineral;
	}

}
