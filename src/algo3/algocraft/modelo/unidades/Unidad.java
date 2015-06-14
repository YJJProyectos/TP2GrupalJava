package algo3.algocraft.modelo.unidades;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;

public abstract class Unidad {

	protected Jugador jugador;
	protected Casilla posicion;
	protected int vida;

	public void recibirDanio(int danio) throws YaEstaDestruidoError {
		if (this.vida <= 0) {
			throw new YaEstaDestruidoError();
		}
		this.vida = this.vida - danio;
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

	public abstract boolean esTerrestre();

	public boolean posicionar(Casilla casilla) {
		if (casilla.ocupar(this)) {
			this.posicion = casilla;
			return true;
		}
		return false;
	}

	public abstract void pasarTurno();
	
	public Jugador getJugador(){
		return this.jugador;
	}
	
	public boolean esAliado(Unidad otro){
		return (this.jugador == otro.getJugador());
	}
}
