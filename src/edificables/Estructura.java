package edificables;

import interfaces.Edificable;
import interfaces.Ocupable;
import accionables.Unidad;

public abstract class Estructura extends Unidad implements Edificable {

	protected Ocupable posicion;
	protected int vida;

	public abstract boolean edificar();

}
