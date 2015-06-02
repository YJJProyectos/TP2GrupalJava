package recolectables;

import interfaces.Imponible;
import interfaces.Recolectable;

public abstract class Asimilador extends EstructuraRecoleccionMineral implements
		Imponible {

	public Asimilador(Recolectable mineral) {
		super(mineral);
	}
}
