package tp2;

import interfaces.Accionable;
import interfaces.Ocupable;

public abstract class Casilla implements Ocupable {

	protected Accionable ocupante;

	public boolean estaOcupada() {
		return (ocupante != null);
	}

	public Accionable obtenerElemento() {
		return ocupante;
	}

	public boolean ocupar(Accionable unidad) {
		if (ocupante == null) {
			ocupante = unidad;
			return true;
		}
		return false;
	}

}