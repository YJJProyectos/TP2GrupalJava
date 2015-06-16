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
		estadoDeAtaque.atacarEnemigo(enemigo);
		estadoDeAtaque = new EstadoYaAtaco();
	}

	public abstract boolean mover(Casilla casilla);

	public void pasarTurno() {
		this.estadoDeAtaque = new EstadoNoAtaco(this);
	}
	
	public int getRangoTerrestre(){
		return this.rangoTerrestre;
	}
	
	public int getDanioTerrestre(){
		return this.danioTerrestre;
	}

}
