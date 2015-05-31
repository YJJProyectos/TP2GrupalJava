package recolectables;

import tp2.GasVespeno;

public abstract class EstructuraRecoleccionGas {

	protected GasVespeno gasVespeno;

	public EstructuraRecoleccionGas(GasVespeno gasVespeno) {

		this.gasVespeno = gasVespeno;
	}


	public int getGas() {

		return this.gasVespeno.getGas();
	}
}
