package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public class UnidadSoldado extends UnidadMovil {

	protected EstadoDeAtaque estadoDeAtaque;
	protected int danioAereo;
	protected int danioTerrestre;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public UnidadSoldado(int vida, Jugador jugador, PlanoAccion plano,
			int costoMineral, int costoGas, int suministro, String nombre)
			throws RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {
		super(jugador, vida, plano, costoMineral, costoGas, suministro, nombre);
		this.estadoDeAtaque = new EstadoNoAtaco();
	}

	public void inicializar(int danioAereo, int danioTerrestre, int rangoAereo,
			int rangoTerrestre) {
		this.danioAereo = danioAereo;
		this.danioTerrestre = danioTerrestre;
		this.rangoAereo = rangoAereo;
		this.rangoTerrestre = rangoTerrestre;
	}

	public void atacarEnemigo(Unidad enemigo, Jugador unJugador)
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, JugadorIncorrectoError {
		if (this.jugador != unJugador) {
			throw new JugadorIncorrectoError();
		}
		if (this.getJugador() == enemigo.getJugador()) {
			throw new PerteneceAlMismoJugadorError();
		}
		estadoDeAtaque.atacar(this, enemigo);
	}

	public void mover(Casilla casilla, Jugador unJugador)
			throws CasillaOcupadaError, JugadorIncorrectoError {
		if (this.jugador != unJugador) {
			throw new JugadorIncorrectoError();
		}
		plano.mover(this, casilla);
		this.posicion = casilla;
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
