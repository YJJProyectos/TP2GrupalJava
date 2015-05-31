package recolectables;

import tp2.Mineral;

public abstract class EstructuraRecoleccionMineral  {

	protected Mineral mineral;

	public EstructuraRecoleccionMineral(Mineral mineral) {

		this.mineral = mineral;
	}


	public int getMineral() {

		return this.mineral.getMineral();
	}

}
