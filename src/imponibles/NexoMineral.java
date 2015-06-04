package imponibles;

import recolectables.Recolectable;

public abstract class NexoMineral extends EstructuraRecoleccionMineral
		implements Imponible {

	public NexoMineral(Recolectable mineral) {
		super(mineral);
	}
}
