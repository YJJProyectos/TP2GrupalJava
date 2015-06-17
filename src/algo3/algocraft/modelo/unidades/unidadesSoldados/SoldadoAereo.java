package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;

public class SoldadoAereo extends UnidadSoldado {
	
	public SoldadoAereo (String tipo, Jugador jugador) {
		
		switch (tipo) {
		case "Espectro": this.settearInfo(20, 8, 120, 5, 5);
		}
		
		this.jugador = jugador;
		this.estadoDeAtaque = new EstadoNoAtaco();
	}
	
	public boolean mover(Casilla casilla) {
		if (casilla.ocuparAereo(this)) {
			this.posicion = casilla;
			return true;
		}
		return false;
	}

	public boolean esTerrestre() {
		return false;
	}
}
