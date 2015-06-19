package algo3.algocraft.modelo.unidades;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public abstract class Unidad {

	protected Jugador jugador;
	protected Casilla posicion;
	protected int vida;
	protected PlanoAccion plano;
	
	protected Unidad(Jugador jugador, int vida, PlanoAccion plano){
		this.plano = plano;
		this.vida = vida;
		this.jugador = jugador;
	}

	public void recibirDanio(int danioAereo, int danioTerrestre) throws YaEstaDestruidoError {
		if (this.vida <= 0) {
			throw new YaEstaDestruidoError();
		}
		this.vida = this.vida - plano.recibirDanio(danioAereo, danioTerrestre);
	}

	public int vidaRestante() {
		return this.vida;
	}

	public boolean estaDestruido() {
		return (this.vida <= 0);
	}

	public Casilla posicion() {
		return this.posicion;
	}
	
	public void nuevaPosicion(Casilla casilla) {
		this.posicion = casilla;
	}

	public boolean posicionar(Casilla casilla) {
		return plano.mover(this, casilla);
	}

	public abstract void pasarTurno();

	public Jugador getJugador() {
		return this.jugador;
	}

	public boolean esAliado(Unidad otro) {
		return (this.jugador == otro.getJugador());
	}
}
