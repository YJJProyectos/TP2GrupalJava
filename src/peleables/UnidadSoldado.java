package peleables;

import accionables.Unidad;
import interfaces.Accionable;
import interfaces.Peleable;

public abstract class UnidadSoldado extends Unidad implements Peleable {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int transporte;
	protected int vision;
	protected int suministro;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public void atacarEnemigo(Accionable enemigo) {

		if (this.posicion == null
				|| this.posicion.distanciaA(enemigo.posicion()) <= this.rangoTerrestre) {
			enemigo.recibirDanio(this.danioTerrestre);
		}
	}

}
