package recolectables;

import edificables.Edificable;

public interface Recolectante extends Edificable {

	public abstract boolean recolectar();

	public abstract int getCantidadRecursoRecolectado();

}
