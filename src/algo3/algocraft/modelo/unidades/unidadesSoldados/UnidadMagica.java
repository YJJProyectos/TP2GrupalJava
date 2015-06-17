package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;

public class UnidadMagica extends UnidadMovil{
	
	protected ComportamientoMagico comportamiento;
	protected int energia;
	
	protected UnidadMagica(Jugador jugador, ComportamientoMagico comportamiento) {
		super(jugador, comportamiento.getVida());
		this.comportamiento = comportamiento;
	}

	public boolean esTerrestre() {
		return false;
	}

	public void pasarTurno() {
		return;
	}
	
	

}
