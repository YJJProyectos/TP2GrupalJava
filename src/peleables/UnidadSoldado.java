package peleables;

import tp2.Unidad;

public class UnidadSoldado extends Unidad implements Peleable {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int transporte;
	protected int vision;
	protected int suministro;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public void atacarEnemigo(Peleable enemigo) {
		return;
	}

	public void recibirDanio(int danio) {
		this.vida = (this.vida - danio);
	}

	@Override
	public int vidaRestante() {
		return this.vida;
	}

}
