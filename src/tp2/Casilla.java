package tp2;

import peleables.Peleable;

public abstract class Casilla implements Ocupable {

	Peleable ocupante;

	public boolean estaOcupada() {
		return (ocupante != null);
	}

	public void ocupar(Peleable soldado) {
		ocupante = soldado;
	}

}