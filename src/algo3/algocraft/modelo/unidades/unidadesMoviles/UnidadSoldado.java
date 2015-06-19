package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public class UnidadSoldado extends UnidadMovil {

	protected EstadoDeAtaque estadoDeAtaque;
	protected int danioAereo;
	protected int danioTerrestre;
	protected int rangoAereo;
	protected int rangoTerrestre;
	
	
	public UnidadSoldado (int vida, Jugador jugador, PlanoAccion plano) {
		super(jugador,vida, plano);
		this.estadoDeAtaque = new EstadoNoAtaco();
	}
	
	public void inicializar(int danioAereo, int danioTerrestre, int rangoAereo, int rangoTerrestre) {
		this.danioAereo = danioAereo;
		this.danioTerrestre = danioTerrestre;
		this.rangoAereo = rangoAereo;
		this.rangoTerrestre = rangoTerrestre;
	}
	
	public void atacarEnemigo(Unidad enemigo) throws YaEstaDestruidoError,
			PerteneceAlMismoJugadorError, NoPuedeAtacarMultiplesVecesError {
		if (this.getJugador() == enemigo.getJugador()) {
			throw new PerteneceAlMismoJugadorError();
		}
		estadoDeAtaque.atacarEnemigo(this, enemigo);
	}
	
	public boolean mover(Casilla casilla) {
		if (plano.mover(this, casilla)) {
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
	
	public int getRangoAereo() {
		return rangoAereo;
	}
	
	public int getRangoTerrestre() {
		return rangoTerrestre;
	}
	
	public int getDanioAereo() {
		return danioAereo;
	}
	
	public int getDanioTerrestre() {
		return danioTerrestre;
	}
	
}
