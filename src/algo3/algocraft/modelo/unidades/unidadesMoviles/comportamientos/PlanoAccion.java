package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public abstract class PlanoAccion {
	
	public abstract boolean mover(Unidad unidad, Casilla casilla);
	public abstract int recibirDanio(int danioAereo, int danioTerrestre);
	public abstract int entraEnElRango(int rangoAereo, int rangoTerrestre);
	
}
