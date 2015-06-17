package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public abstract class ComportamientoSoldado extends Comportamiento {
	public abstract int getDanioAereo();
	public abstract int getDanioTerrestre();
	public abstract int getRangoAereo();
	public abstract int getRangoTerrestre();
	public abstract int getVida();
	public abstract boolean esTerrestre();
	public abstract boolean mover(Unidad unidad, Casilla casilla);

}
