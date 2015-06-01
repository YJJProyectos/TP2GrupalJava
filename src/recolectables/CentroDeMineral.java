package recolectables;

import tp2.Mineral;

public class CentroDeMineral extends EstructuraRecoleccionMineral implements
		Recolectable {

	private int cantidadMineralRecolectado;

	public CentroDeMineral(Mineral mineral) {
		super(mineral);
		this.cantidadMineralRecolectado = 0;
	}

	public boolean recolectar() {

		boolean sePudoRecolectar = false;
		int cantidadMineralSacado;

		cantidadMineralSacado = super.mineral.sacarMineral(10);
		if (cantidadMineralSacado > 0) { // ver si hacerlo en una excepcion
			this.cantidadMineralRecolectado += cantidadMineralSacado;
			sePudoRecolectar = true;
		}

		return sePudoRecolectar;
	}

	public int getCantidadRecursoRecolectado() {
		return this.cantidadMineralRecolectado;
	}
}
