package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.ComportamientoMagico;

public class UnidadMagica extends UnidadMovil{
	
	protected ComportamientoMagico comportamiento;
	protected int energia;
	
	protected UnidadMagica(Jugador jugador, ComportamientoMagico comportamiento) {
		super(jugador, comportamiento.getVida());
		this.comportamiento = comportamiento;
	}

	public boolean esTerrestre() {
		return comportamiento.esTerrestre();
	}

	public void pasarTurno() {
		this.energia += comportamiento.energiaPorTurno();
		if (this.energia>comportamiento.energiaLimite()) this.energia = comportamiento.energiaLimite();
		return;
	}
	
	public boolean mover(Casilla casilla) {
		if (comportamiento.mover(this, casilla)) {
			this.posicion = casilla;
			return true;
		}
		return false;
	}
	
	public boolean magiaHaciaCasilla(Casilla casilla) {
		return comportamiento.magiaHaciaCasilla(this.energia, casilla);
	}
	
	public boolean magiaHaciaUnidad(Unidad unidad){
		return comportamiento.magiaHaciaUnidad(this.energia, unidad);
	}
	

}