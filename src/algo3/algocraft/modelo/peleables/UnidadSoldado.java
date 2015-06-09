package algo3.algocraft.modelo.peleables;

import algo3.algocraft.modelo.accionables.Unidad;
import algo3.algocraft.modelo.mapa.Casilla;

public abstract class UnidadSoldado extends Unidad {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public void atacarEnemigo(Unidad enemigo) {

		if (this.posicion == null
				|| this.posicion.distanciaA(enemigo.posicion()) <= this.rangoTerrestre) {
			enemigo.recibirDanio(this.danioTerrestre);
		}
	}
	public abstract boolean mover(Casilla casilla);

}
