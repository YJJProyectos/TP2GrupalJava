package edificables;

import tp2.Estructura;

public class Fabrica extends Estructura{

	public boolean entrenarGolliat() {
		return true;
	}

	@Override
	public boolean edificar() {
		return true;
	}

}
