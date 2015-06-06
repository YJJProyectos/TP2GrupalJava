package imponibles;

import recolectables.Recolectable;

public class CentroDeMineral extends EstructuraRecoleccionMineral {

	private int cantidadMineralRecolectado;

	public CentroDeMineral(Recolectable recurso) {
		super(recurso);
		this.cantidadMineralRecolectado = 0;
	}

	public boolean recolectar() {

		boolean sePudoRecolectar = false;

		int cantidadMineralSacado = super.mineral.extraerRecurso(10);
		if (cantidadMineralSacado > 0) { // ver si hacerlo en una excepcion
			this.cantidadMineralRecolectado += cantidadMineralSacado;
			sePudoRecolectar = true;
		}

		return sePudoRecolectar;
	}

	public int getCantidadRecursoRecolectado() {
		return this.cantidadMineralRecolectado;
	}

	public boolean edificar() {

		return true;
	}

	public boolean esTerrestre() {
		return true;
	}
}
