package algo3.algocraft.modelo.imponibles;

import algo3.algocraft.modelo.edificables.UnidadEdificio;
import algo3.algocraft.modelo.recolectables.Recolectable;

public abstract class EstructuraRecoleccionMineral extends UnidadEdificio {

	protected Recolectable mineral;

	public EstructuraRecoleccionMineral(Recolectable mineral) {

		this.mineral = mineral;
	}

}
