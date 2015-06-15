package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public abstract class UnidadSoldado extends Unidad {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int rangoAereo;
	protected int rangoTerrestre;
	protected boolean yaAtaco;

	public void atacarEnemigo(Unidad enemigo) throws YaEstaDestruidoError,
			PerteneceAlMismoJugadorError, NoPuedeAtacarMultiplesVecesError {
		if (this.jugador == enemigo.getJugador()) {
			throw new PerteneceAlMismoJugadorError();
		}
		if (this.yaAtaco) {
			throw new NoPuedeAtacarMultiplesVecesError();
		}

		if (this.posicion.distanciaA(enemigo.posicion()) <= this.rangoTerrestre) {
			enemigo.recibirDanio(this.danioTerrestre);
			this.yaAtaco = true;
		}
	}

	public abstract boolean mover(Casilla casilla);

	public void pasarTurno() {
		this.yaAtaco = false;
	}

}
