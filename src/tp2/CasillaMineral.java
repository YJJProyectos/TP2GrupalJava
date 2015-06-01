package tp2;

import tp2.CasillaTerrestre;
import tp2.Mineral;

public class CasillaMineral extends CasillaTerrestre {

	private Mineral mineral;
	
	public CasillaMineral(int cantidadDeMineral){
		
		this.mineral = new Mineral(cantidadDeMineral);
	}
}
