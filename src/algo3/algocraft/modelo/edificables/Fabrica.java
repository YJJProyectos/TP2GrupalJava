package algo3.algocraft.modelo.edificables;

import algo3.algocraft.modelo.edificables.Barraca;


public class Fabrica extends Estructura {
	
	protected Barraca barraca;
	
	public Fabrica(Barraca barraca){
		this.barraca = barraca;
	}
	
	public boolean entrenarGolliat() {
		if (barraca == null) return false;
		return true;
	}

	public boolean edificar() {
		return true;
	}

	public boolean esTerrestre() {
		return true;
	}

}
