package interfaces;

import tp2.Coordenada;

public interface Ocupable {

	public abstract boolean estaOcupada();

	public abstract boolean esTerrestre();
	
	public abstract Accionable ocupante();

	public abstract boolean ocupar(Accionable unidad);
	
	public abstract void situar(Coordenada coordenada);
	
	public abstract Coordenada posicion();
	
}
