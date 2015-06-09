package algo3.algocraft.modelo.accionables;

import algo3.algocraft.modelo.mapa.Casilla;

public abstract class Unidad {

	protected Casilla posicion;
	protected int vida;

	public void recibirDanio(int danio) {
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
}
