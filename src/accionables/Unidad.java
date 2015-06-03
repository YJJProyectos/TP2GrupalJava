package accionables;

import interfaces.Accionable;
import interfaces.Ocupable;

public abstract class Unidad implements Accionable {

	protected Ocupable posicion;
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

	public Ocupable posicion() {
		return posicion;
	}

	public void posicionar(Ocupable casilla) {
		if (casilla.ocupar(this))
			this.posicion = casilla;
	}
}
