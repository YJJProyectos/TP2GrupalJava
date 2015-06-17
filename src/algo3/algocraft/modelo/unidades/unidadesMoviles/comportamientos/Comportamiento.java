package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public abstract class Comportamiento {
	
	public abstract boolean mover(Unidad unidad, Casilla casilla);
	public abstract int getVida();
	
}
