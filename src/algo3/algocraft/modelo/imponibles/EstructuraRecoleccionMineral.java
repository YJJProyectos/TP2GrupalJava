package algo3.algocraft.modelo.imponibles;

import algo3.algocraft.modelo.accionables.Unidad;
import algo3.algocraft.modelo.recolectables.Recolectable;

public abstract class EstructuraRecoleccionMineral extends Unidad implements Recolector{

	protected Recolectable mineral;

	public EstructuraRecoleccionMineral(Recolectable mineral) {

		this.mineral = mineral;
	}

}
