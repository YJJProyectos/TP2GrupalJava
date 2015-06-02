package recolectables;

import interfaces.Imponible;
import interfaces.Recolectable;

public abstract class Refineria extends EstructuraRecoleccionMineral implements
		Imponible {

	public Refineria(Recolectable mineral) {
		super(mineral);
	}
}
