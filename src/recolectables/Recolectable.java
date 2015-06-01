package recolectables;

import edificables.Edificable;

public interface Recolectable extends Edificable{

	public abstract boolean recolectar();

	public abstract int getCantidadRecursoRecolectado();
	
	

}
