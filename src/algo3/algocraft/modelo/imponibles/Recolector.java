package algo3.algocraft.modelo.imponibles;

import algo3.algocraft.modelo.edificables.Edificable;

public interface Recolector extends Edificable {

	public boolean recolectar();

	public int getCantidadRecursoRecolectado();

}
