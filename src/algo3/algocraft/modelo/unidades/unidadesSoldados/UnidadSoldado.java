package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.comportamientos.ComportamientoSoldado;

public class UnidadSoldado extends UnidadMovil {

	protected ComportamientoSoldado comportamiento;
	protected EstadoDeAtaque estadoDeAtaque;
	
	public UnidadSoldado (ComportamientoSoldado comportamiento, Jugador jugador) {
		
		super(jugador,comportamiento.getVida());
		this.comportamiento = comportamiento;
		this.estadoDeAtaque = new EstadoNoAtaco();
				
	}
	
	public void atacarEnemigo(Unidad enemigo) throws YaEstaDestruidoError,
			PerteneceAlMismoJugadorError, NoPuedeAtacarMultiplesVecesError {
		if (this.jugador == enemigo.getJugador()) {
			throw new PerteneceAlMismoJugadorError();
		}
		estadoDeAtaque.atacarEnemigo(this, enemigo, comportamiento.getDanioTerrestre());
	}

	public boolean mover(Casilla casilla) {
		if (comportamiento.mover(this, casilla)) {
			this.posicion = casilla;
			return true;
		}
		return false;
	}
	
	public void pasarTurno() {
		this.nuevoEstadoDeAtaque(new EstadoNoAtaco());
	}
		
	public void nuevoEstadoDeAtaque(EstadoDeAtaque estado) {
		this.estadoDeAtaque = estado;
	}
	
	public boolean alcanzaPosicion(Casilla posicion) {
		return (this.posicion.distanciaA(posicion) <= comportamiento.getRangoTerrestre());
	}

	public boolean esTerrestre() {
		return comportamiento.esTerrestre();
	}
	
}
