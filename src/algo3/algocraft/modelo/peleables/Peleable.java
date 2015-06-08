package algo3.algocraft.modelo.peleables;

import algo3.algocraft.modelo.accionables.Accionable;
import algo3.algocraft.modelo.mapa.Casilla;

public interface Peleable extends Accionable {

	public void atacarEnemigo(Accionable enemigo);
	
	public boolean mover(Casilla casilla);

}
