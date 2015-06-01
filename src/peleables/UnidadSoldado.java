package peleables;

import tp2.Accionable;
import tp2.Unidad;

public abstract class UnidadSoldado extends Unidad implements Peleable {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int transporte;
	protected int vision;
	protected int suministro;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public void atacarEnemigo(Accionable enemigo) {
		enemigo.recibirDanio(this.danioTerrestre);
	}

}
