package edificables;

import interfaces.Edificable;
import accionables.Unidad;

public abstract class Estructura extends Unidad implements Edificable {

	public abstract boolean edificar();

}
