package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesSoldados.comportamientos.ComportamientoMarine;

public class Marine extends UnidadSoldado {

	public Marine(Jugador unJugador) {
		super(ComportamientoMarine.getInstancia(), unJugador);
	}

	/*public boolean mover(Casilla casilla) {
		if (casilla.ocuparTerrestre(this)) {
			this.posicion = casilla;
			return true;
		}
		return false;
	}

	public boolean esTerrestre() {
		return true;
	}*/
}