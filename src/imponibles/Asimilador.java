package imponibles;

import recolectables.Recolectable;

public abstract class Asimilador extends EstructuraRecoleccionMineral implements
		Imponible {

	public Asimilador(Recolectable mineral) {
		super(mineral);
	}
}
