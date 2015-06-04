package accionables;

import ocupables.Casilla;
import interfaces.Accionable;

public abstract class Unidad implements Accionable {

	protected Casilla posicion;
	protected int vida;

	public void recibirDanio(int danio) {
		vida = vida - danio;
	}

	public int vidaRestante() {
		return vida;
	}

	public boolean estaDestruido() {
		return (vida <= 0);
	}

	public Casilla posicion() {
		return posicion;
	}

	public void posicionar(Casilla casilla) {
		if (casilla.ocupar(this))
			this.posicion = casilla;
	}
}
