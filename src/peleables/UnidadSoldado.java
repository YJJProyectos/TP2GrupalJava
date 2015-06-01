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

	public void atacar_enemigo(Peleable enemigo) {
		return;
	}

	public void recibir_danio(int danio) {
		this.vida = (this.vida - danio);
	}

	public int getVida() {

		return this.vida;
	}

}
