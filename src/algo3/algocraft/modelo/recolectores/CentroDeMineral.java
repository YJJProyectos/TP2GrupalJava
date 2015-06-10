package algo3.algocraft.modelo.recolectores;

import algo3.algocraft.modelo.recolectables.Recolectable;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;

public class CentroDeMineral extends UnidadEdificio implements Recolector {

	private int cantidadMineralRecolectado;
	private Recolectable mineral;

	public CentroDeMineral(Recolectable unMineral) {
		this.mineral = unMineral;
		this.cantidadMineralRecolectado = 0;
	}

	public boolean recolectar() {
		int cantidadMineralSacado = this.mineral.extraerRecurso(10);
		if (cantidadMineralSacado > 0) {
			this.cantidadMineralRecolectado += cantidadMineralSacado;
			return true;
		}
		return false;
	}

	public int getCantidadRecursoRecolectado() {
		return this.cantidadMineralRecolectado;
	}

	public boolean esTerrestre() {
		return true;
	}

	public int tiempoDeConstruccion() {
		return 4;
	}
}
