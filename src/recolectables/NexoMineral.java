package recolectables;

import tp2.Mineral;

public class NexoMineral extends EstructuraRecoleccionMineral implements
		Recolectable {

	public NexoMineral(Mineral mineral) {
		super(mineral);
	}

	@Override
	public boolean Recolectar() {

		return true;
	}

	public int getCantidadRecursoRecolectado() {
		return 0;
	}
}
