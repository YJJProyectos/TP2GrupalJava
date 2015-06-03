package interfaces;

import tp2.Coordenada;
import interfaces.Navegable;

public interface Ocupable {

	public abstract boolean estaOcupada();

	public abstract boolean esTerrestre();
	
	public abstract Accionable ocupante();

	public abstract boolean ocupar(Accionable unidad);
	
	public abstract void situar(Coordenada coordenada, Navegable escenario);
	
	public abstract Coordenada posicion();
	
	public abstract int distanciaA(Ocupable otroLugar);
	
}
