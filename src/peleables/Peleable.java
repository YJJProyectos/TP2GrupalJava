package peleables;

import accionables.Accionable;
import mapa.Casilla;

public interface Peleable extends Accionable {

	public void atacarEnemigo(Accionable enemigo);
	
	public boolean mover(Casilla casilla);

}
