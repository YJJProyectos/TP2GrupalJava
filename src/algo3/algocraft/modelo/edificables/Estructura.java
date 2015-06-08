package algo3.algocraft.modelo.edificables;

import algo3.algocraft.modelo.accionables.Unidad;
import algo3.algocraft.modelo.mapa.Casilla;

public abstract class Estructura extends Unidad implements Edificable {

	protected int tiempoDeConstruccion;

	public boolean edificar(Casilla casilla) {

		EdificioEnConstruccion construccion = new EdificioEnConstruccion(this,
				this.tiempoDeConstruccion);
		return construccion.posicionar(casilla);
	}
}
