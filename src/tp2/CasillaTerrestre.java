package tp2;

import interfaces.Edificable;
import recolectables.Recolectable;

public class CasillaTerrestre extends Casilla {
	
	Edificable edificio;
	Recolectable recurso;

	public boolean esTerrestre() {
		return true;
	}

}
