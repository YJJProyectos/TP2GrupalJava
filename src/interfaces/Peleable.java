package interfaces;

import ocupables.Casilla;

public interface Peleable extends Accionable {

	public void atacarEnemigo(Accionable enemigo);
	
	public boolean mover(Casilla casilla);

}
