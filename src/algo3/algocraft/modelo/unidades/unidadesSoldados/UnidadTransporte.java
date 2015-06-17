package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;

public class UnidadTransporte extends UnidadMovil{

	protected ComportamientoTransporte comportamiento;
	
	protected UnidadTransporte(Jugador jugador, ComportamientoTransporte comportamiento) {
		super(jugador, comportamiento.getVida());
		this.comportamiento = comportamiento;
	}

	public boolean esTerrestre() {
		return false;
	}

	public void pasarTurno() {
			
	}

}
