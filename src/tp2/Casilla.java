package tp2;

import recolectables.Recolectable;
import edificables.Edificable;
import peleables.Peleable;

public abstract class Casilla implements Ocupable {
	
	Edificable edificio;
	Recolectable recurso;
	Peleable ocupante;
	
	public boolean esta_ocupada() {
		return (ocupante != null);
	}

	
}
