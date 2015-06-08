package algo3.algocraft.modelo.imponibles;

import algo3.algocraft.modelo.recolectables.Recolectable;

public abstract class Asimilador extends EstructuraRecoleccionMineral implements
		Recolector {

	public Asimilador(Recolectable mineral) {
		super(mineral);
	}
}
