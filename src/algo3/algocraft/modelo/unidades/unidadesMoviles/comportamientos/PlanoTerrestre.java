package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public class PlanoTerrestre extends PlanoAccion{

	private static final PlanoTerrestre INSTANCIA= new PlanoTerrestre();
	
	private PlanoTerrestre() {}
	
	public static PlanoTerrestre getInstancia () {
		return INSTANCIA;
	}
	
	public boolean mover(Unidad marine, Casilla casilla) {
		return casilla.ocuparTerrestre(marine);
	}

	public int recibirDanio(int danioAereo, int danioTerrestre) {
		return danioTerrestre;
	}

	public int entraEnElRango(int rangoAereo, int rangoTerrestre) {
		return rangoTerrestre;
	}

}
