package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public abstract class UnidadSoldado extends Unidad {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public void atacarEnemigo(Unidad enemigo) {

		if (this.posicion.distanciaA(enemigo.posicion()) <= this.rangoTerrestre) {
			enemigo.recibirDanio(this.danioTerrestre);
		}
	}

	public abstract boolean mover(Casilla casilla);

}
