package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.Unidad;

public abstract class PlanoAccion {

	public abstract void mover(Unidad unidad, Casilla casilla)
			throws CasillaOcupadaError;

	public abstract int recibirDanio(int danioAereo, int danioTerrestre);

	public abstract int entraEnElRango(int rangoAereo, int rangoTerrestre);

	public abstract void remover(Casilla posicion);

}
