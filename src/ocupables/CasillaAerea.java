package ocupables;

import interfaces.Accionable;

public class CasillaAerea extends Casilla {

	public boolean esTerrestre() {
		return false;
	}

	public boolean ocupar(Accionable unidad) {
		return true;
	}
}
