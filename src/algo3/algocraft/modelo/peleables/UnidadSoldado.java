package algo3.algocraft.modelo.peleables;

import algo3.algocraft.modelo.accionables.Accionable;
import algo3.algocraft.modelo.accionables.Unidad;

public abstract class UnidadSoldado extends Unidad implements Peleable {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public void atacarEnemigo(Accionable enemigo) {

		if (this.posicion == null
				|| this.posicion.distanciaA(enemigo.posicion()) <= this.rangoTerrestre) {
			enemigo.recibirDanio(this.danioTerrestre);
		}
	}

}
