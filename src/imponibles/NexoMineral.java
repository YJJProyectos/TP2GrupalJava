package imponibles;

import recolectables.Recolectable;

public abstract class NexoMineral extends EstructuraRecoleccionMineral
		implements Recolector {

	public NexoMineral(Recolectable mineral) {
		super(mineral);
	}
}
