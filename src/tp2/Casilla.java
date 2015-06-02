package tp2;

import interfaces.Accionable;
import interfaces.Ocupable;

public abstract class Casilla implements Ocupable {

	protected Coordenada ubicacion;
	protected Accionable ocupante;

	public boolean estaOcupada() {
		return (ocupante != null);
	}

	public Accionable ocupante() {
		return ocupante;
	}

	public abstract boolean ocupar(Accionable unidad);
	
	public void desocupar() {
		ocupante = null;
	}
	
	public void situar(Coordenada posicion) {
		ubicacion = posicion;
	}
	
	public Coordenada posicion(){
		return ubicacion;
	}
}