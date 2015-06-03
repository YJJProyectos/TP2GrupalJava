package edificables;

import interfaces.Edificable;
import interfaces.Ocupable;

public abstract class Estructura implements Edificable {

	protected Ocupable posicion;
	protected int vida;

	@Override
	public void posicionar(Ocupable casilla) {
		if (casilla.ocupar(this))
			this.posicion = casilla;
	}

	@Override
	public void recibirDanio(int cantidadDanio) {
		vida = vida - cantidadDanio;
	}

	@Override
	public int vidaRestante() {
		return vida;
	}

	@Override
	public boolean estaDestruido() {
		return (vida <= 0);
	}

	@Override
	public Ocupable posicion() {
		return posicion;
	}

	public abstract boolean edificar();

}
