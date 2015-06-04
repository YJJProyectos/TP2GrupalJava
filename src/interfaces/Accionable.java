package interfaces;

import ocupables.Casilla;


public interface Accionable {

	public abstract void posicionar(Casilla casilla);

	public abstract void recibirDanio(int cantidadDanio);

	public abstract int vidaRestante();

	public abstract boolean estaDestruido();

	public abstract Casilla posicion();

}
