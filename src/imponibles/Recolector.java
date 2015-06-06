package imponibles;

import edificables.Edificable;

public interface Recolector extends Edificable {

	public boolean recolectar();

	public int getCantidadRecursoRecolectado();

}
