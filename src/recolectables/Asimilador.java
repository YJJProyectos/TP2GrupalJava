package recolectables;

import tp2.GasVespeno;

public class Asimilador extends EstructuraRecoleccionGas implements
		Recolectable {

	public Asimilador(GasVespeno gasVespeno) {
		super(gasVespeno);
	}

	@Override
	public boolean recolectar() {

		return true;
	}

	public int getCantidadRecursoRecolectado() {
		return 0;
	}
}
