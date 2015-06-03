package tp2;

import interfaces.Edificable;
import interfaces.Accionable;

public class CasillaTerrestre extends Casilla {

	Edificable edificio;

	public boolean esTerrestre() {
		return true;
	}

	public boolean ocupar(Accionable unidad) {
		if (ocupante == null) {
			ocupante = unidad;
			return true;
		}
		return false;
	}

}
