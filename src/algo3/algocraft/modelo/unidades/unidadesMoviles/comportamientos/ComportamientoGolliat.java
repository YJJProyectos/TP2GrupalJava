package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public class ComportamientoGolliat extends ComportamientoSoldado{

	private static final ComportamientoGolliat INSTANCIA= new ComportamientoGolliat();
	
	private ComportamientoGolliat() {}
	
	public static ComportamientoGolliat getInstancia () {
		return INSTANCIA;
	}
	
	public int getDanioAereo() {
		return 10;
	}

	public int getDanioTerrestre() {
		return 12;
	}

	public int getRangoAereo() {
		return 5;
	}

	public int getRangoTerrestre() {
		return 6;
	}

	public int getVida() {
		return 125;
	}

	public boolean esTerrestre() {
		return true;
	}
	
	public boolean mover(Unidad marine, Casilla casilla) {
		return casilla.ocuparTerrestre(marine);
	}

}
