package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public abstract class ComportamientoMagico extends Comportamiento{

	public abstract int energiaPorTurno();
	public abstract boolean magiaHaciaCasilla(int energia, Casilla casilla);
	public abstract boolean magiaHaciaUnidad(int energia, Unidad unidad);
	public abstract boolean esTerrestre();
	public int energiaLimite() {
		return 200;
	}
}
