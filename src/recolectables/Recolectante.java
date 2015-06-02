package recolectables;

import interfaces.Edificable;

public interface Recolectante extends Edificable {

	public abstract boolean recolectar();

	public abstract int getCantidadRecursoRecolectado();

}
