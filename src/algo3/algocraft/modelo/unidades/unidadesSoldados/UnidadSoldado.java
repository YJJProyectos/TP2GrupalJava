package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public class UnidadSoldado extends Unidad {

	protected ComportamientoSoldado comportamiento;
	protected EstadoDeAtaque estadoDeAtaque;
	
	public UnidadSoldado (ComportamientoSoldado comportamiento, Jugador jugador) {
		
		this.vida = comportamiento.getVida();
		this.comportamiento = comportamiento;
		this.jugador = jugador;
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
