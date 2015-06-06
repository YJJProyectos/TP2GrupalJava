package imponibles;

import recolectables.Recolectable;

public abstract class Refineria extends EstructuraRecoleccionMineral implements
		Recolector {

	public Refineria(Recolectable mineral) {
		super(mineral);
	}
}
