package imponibles;

import edificables.Edificable;

public interface Imponible extends Edificable {

	public boolean recolectar();

	public int getCantidadRecursoRecolectado();

}
