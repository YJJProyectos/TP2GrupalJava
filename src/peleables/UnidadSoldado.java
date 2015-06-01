package peleables;

import tp2.Unidad;

public class UnidadSoldado extends Unidad implements Peleable {

	int danioAereo;
	int danioTerrestre;
	int vida;

	public UnidadSoldado() {

		this.danioAereo = 6;
		this.danioTerrestre = 6;
		this.vida = 4;
	}

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
