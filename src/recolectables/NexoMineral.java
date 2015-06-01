package recolectables;

import tp2.Mineral;

public class NexoMineral extends EstructuraRecoleccionMineral implements
		Recolectable {

	public NexoMineral(Mineral mineral) {
		super(mineral);
	}

	@Override
	public boolean recolectar() {

		return true;
	}

	public int getCantidadRecursoRecolectado() {
		return 0;
	}
	public boolean edificar(){
		return true;
	}
}
