package tp2;

import interfaces.Accionable;
import interfaces.Ocupable;

public abstract class Casilla implements Ocupable {

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
	
	

}