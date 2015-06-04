package imponibles;

import recolectables.Recolectable;

public abstract class Refineria extends EstructuraRecoleccionMineral implements
		Imponible {

	public Refineria(Recolectable mineral) {
		super(mineral);
	}
}
