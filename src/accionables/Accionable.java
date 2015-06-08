package accionables;

import mapa.Casilla;


public interface Accionable {

	public abstract boolean posicionar(Casilla casilla);

	public abstract void recibirDanio(int cantidadDanio);

	public abstract int vidaRestante();

	public abstract boolean estaDestruido();

	public abstract Casilla posicion();

	public abstract boolean esTerrestre();

}
