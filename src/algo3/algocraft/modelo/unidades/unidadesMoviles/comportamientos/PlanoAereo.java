package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public class PlanoAereo extends PlanoAccion {

	private static final PlanoAereo INSTANCIA= new PlanoAereo();
	
	private PlanoAereo() {}
	
	public static PlanoAereo getInstancia () {
		return INSTANCIA;
	}
	
	public boolean mover(Unidad unidad, Casilla casilla) {
		return casilla.ocuparAereo(unidad);
	}

	public int recibirDanio(int danioAereo, int danioTerrestre) {
		return danioAereo;
	}

	public int entraEnElRango(int rangoAereo, int rangoTerrestre) {
		return rangoAereo;
	}

}
