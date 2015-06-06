package imponibles;

import recolectables.Recolectable;

public abstract class Asimilador extends EstructuraRecoleccionMineral implements
		Recolector {

	public Asimilador(Recolectable mineral) {
		super(mineral);
	}
}
