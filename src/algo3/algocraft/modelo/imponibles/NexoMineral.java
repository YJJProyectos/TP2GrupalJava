package algo3.algocraft.modelo.imponibles;

import algo3.algocraft.modelo.recolectables.Recolectable;

public abstract class NexoMineral extends EstructuraRecoleccionMineral
		implements Recolector {

	public NexoMineral(Recolectable mineral) {
		super(mineral);
	}
}
