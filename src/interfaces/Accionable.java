package interfaces;

import interfaces.Ocupable;


public interface Accionable {

	public abstract void posicionar(Ocupable casilla);
	
	public abstract void recibirDanio(int cantidadDanio);

	public abstract int vidaRestante();
	
	public abstract boolean estaDestruido();
	
	public abstract Ocupable posicion();

}
