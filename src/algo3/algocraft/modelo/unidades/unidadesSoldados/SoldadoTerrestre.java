package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.mapa.Casilla;

public class SoldadoTerrestre extends UnidadSoldado {

	public boolean mover(Casilla casilla) {
		return false;
	}

	public boolean esTerrestre() {
		return true;
	}

}
