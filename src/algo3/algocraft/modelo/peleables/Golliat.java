package algo3.algocraft.modelo.peleables;

import algo3.algocraft.modelo.mapa.Casilla;

public class Golliat extends UnidadSoldado {

	public Golliat() {
		this.danioAereo = 10;
		this.danioTerrestre = 12;
		this.vida = 125;
		this.rangoAereo = 5;
		this.rangoTerrestre = 6;
	}

	public boolean mover(Casilla casilla) {
		if (casilla.ocuparTerrestre(this)) {
			this.posicion = casilla;
			return true;
		}
		return false;
	}

	public boolean esTerrestre() {
		return true;
	}
}