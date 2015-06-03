package peleables;

import interfaces.Ocupable;

public class Marine extends UnidadSoldado {

	public Marine() {
		this.danioAereo = 6;
		this.danioTerrestre = 6;
		this.vida = 40;
		this.rangoAereo = 4;
		this.rangoTerrestre = 4;
		this.suministro = 1;
		this.vision = 7;
		this.transporte = 1;
	}

	@Override
	public boolean mover(Ocupable casilla) {
		if ( !casilla.estaOcupada() ){
			casilla.ocupar(this);
			return true;
		}
		return false;
	}
}