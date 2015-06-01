package recolectables;

import tp2.GasVespeno;

public class Refineria extends EstructuraRecoleccionGas implements Recolectable {

	public Refineria(GasVespeno gasVespeno) {

		super(gasVespeno);
	}

	public boolean Recolectar() {

		// Gas elGas = (Gas) gas;
		// elGas.cantidad()
		// this.cantidadGas += 5;
		return true;
	}

	public int getCantidadRecursoRecolectado() {
		return 0;
	}

}
