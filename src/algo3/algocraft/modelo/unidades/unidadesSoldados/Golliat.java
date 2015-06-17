package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesSoldados.comportamientos.ComportamientoGolliat;

public class Golliat extends UnidadSoldado {

	public Golliat(Jugador unJugador) {
		super(ComportamientoGolliat.getInstancia(), unJugador);
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