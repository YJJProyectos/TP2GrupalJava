package recolectables;

import tp2.Mineral;

public class CentroDeMineral extends EstructuraRecoleccionMineral implements
		Recolectable {

	public CentroDeMineral(Mineral mineral) {
		super(mineral);
	}

	public boolean Recolectar() {

		return true;
	}
}
