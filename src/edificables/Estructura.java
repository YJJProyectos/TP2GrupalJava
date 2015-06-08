package edificables;

import mapa.Casilla;
import accionables.Unidad;

public abstract class Estructura extends Unidad implements Edificable {

	protected int tiempoDeConstruccion;

	public boolean edificar(Casilla casilla) {

		EdificioEnConstruccion construccion = new EdificioEnConstruccion(this,
				this.tiempoDeConstruccion);
		return construccion.posicionar(casilla);
	}
}
