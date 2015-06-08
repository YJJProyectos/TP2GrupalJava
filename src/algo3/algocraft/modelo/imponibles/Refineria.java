package algo3.algocraft.modelo.imponibles;

import algo3.algocraft.modelo.recolectables.Recolectable;

public abstract class Refineria extends EstructuraRecoleccionMineral implements
		Recolector {

	public Refineria(Recolectable mineral) {
		super(mineral);
	}
}
