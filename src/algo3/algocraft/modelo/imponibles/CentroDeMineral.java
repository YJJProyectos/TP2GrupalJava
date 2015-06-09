package algo3.algocraft.modelo.imponibles;

import algo3.algocraft.modelo.edificables.UnidadEdificio;
import algo3.algocraft.modelo.recolectables.Recolectable;

public class CentroDeMineral extends UnidadEdificio implements Recolector {

	private int cantidadMineralRecolectado;
	private Recolectable mineral;

	public CentroDeMineral(Recolectable unMineral) {
		this.mineral = unMineral;
		this.cantidadMineralRecolectado = 0;
	}

	public boolean recolectar() {

		boolean sePudoRecolectar = false;

		int cantidadMineralSacado = this.mineral.extraerRecurso(10);
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

	public int tiempoDeConstruccion() {
		return 4;
	}
}
