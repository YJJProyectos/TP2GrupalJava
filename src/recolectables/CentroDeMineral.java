package recolectables;

import tp2.Mineral;

public class CentroDeMineral extends EstructuraRecoleccionMineral implements
		Recolectable {
	
	private int cantidadMineralRecolectado;

	public CentroDeMineral(Mineral mineral) {
		super(mineral);
		this.cantidadMineralRecolectado = 0;
	}

	public boolean Recolectar() {
		
		boolean sePudoRecolectar;
		
		sePudoRecolectar = super.mineral.sacarMineral(10);
		if (sePudoRecolectar){  // ver si hacerlo en una excepcion
			this.cantidadMineralRecolectado += 10;
		}

		return sePudoRecolectar;
	}
	
	public int getCantidadRecursoRecolectado(){
		return this.cantidadMineralRecolectado;
	}
}
