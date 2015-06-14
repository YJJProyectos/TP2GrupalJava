package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;

public class Marine extends UnidadSoldado {

	public Marine(Jugador unJugador) {
		this.jugador = unJugador;
		this.danioAereo = 6;
		this.danioTerrestre = 6;
		this.vida = 40;
		this.rangoAereo = 4;
		this.rangoTerrestre = 4;
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