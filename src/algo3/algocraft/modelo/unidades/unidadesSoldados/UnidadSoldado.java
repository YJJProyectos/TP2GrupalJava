package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public abstract class UnidadSoldado extends Unidad {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int rangoAereo;
	protected int rangoTerrestre;
	protected EstadoDeAtaque estadoDeAtaque;

	public void atacarEnemigo(Unidad enemigo) throws YaEstaDestruidoError,
			PerteneceAlMismoJugadorError, NoPuedeAtacarMultiplesVecesError {
		if (this.jugador == enemigo.getJugador()) {
			throw new PerteneceAlMismoJugadorError();
		}
		estadoDeAtaque.atacarEnemigo(this, enemigo, this.danioTerrestre);
	}

	public abstract boolean mover(Casilla casilla);

	public void pasarTurno() {
		this.nuevoEstadoDeAtaque(new EstadoNoAtaco());
	}
		
	public void nuevoEstadoDeAtaque(EstadoDeAtaque estado) {
		this.estadoDeAtaque = estado;
	}
	
	public boolean alcanzaPosicion(Casilla posicion) {
		return (this.posicion.distanciaA(posicion) <= this.rangoTerrestre);
	}
	
}
