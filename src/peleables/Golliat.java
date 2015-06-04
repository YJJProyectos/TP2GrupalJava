package peleables;

import ocupables.Casilla;


public class Golliat extends UnidadSoldado {

	public Golliat() {
		this.danioAereo = 10;
		this.danioTerrestre = 12;
		this.vida = 125;
		this.rangoAereo = 5;
		this.rangoTerrestre = 6;
		this.suministro = 2;
		this.vision = 8;
		this.transporte = 2;
	}

	@Override
	public boolean mover(Casilla casilla) {
		if ( !casilla.estaOcupada() ){
			casilla.ocupar(this);
			return true;
		}
		return false;
	}
}