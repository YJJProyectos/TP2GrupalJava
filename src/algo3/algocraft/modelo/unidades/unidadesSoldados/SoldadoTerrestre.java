package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;

public class SoldadoTerrestre extends UnidadSoldado {

	public SoldadoTerrestre (String tipo, Jugador jugador) {
		
		switch (tipo) {
		case "Marine": this.settearInfo(6, 6, 40, 4, 4);
			break;
		case "Golliat": this.settearInfo(10, 12, 125, 5, 6);
			break;
		}
		this.jugador = jugador;
		this.estadoDeAtaque = new EstadoNoAtaco();
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
