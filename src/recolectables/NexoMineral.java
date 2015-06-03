package recolectables;

import interfaces.Imponible;
import interfaces.Recolectable;

public abstract class NexoMineral extends EstructuraRecoleccionMineral
		implements Imponible {

	public NexoMineral(Recolectable mineral) {
		super(mineral);
	}
}
