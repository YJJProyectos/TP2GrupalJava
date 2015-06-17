package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public class ComportamientoEspectro extends ComportamientoSoldado {

	private static final ComportamientoEspectro INSTANCIA= new ComportamientoEspectro();
	
	public static ComportamientoEspectro getInstancia () {
		return INSTANCIA;
	}
	
	public int getDanioAereo() {
		return 20;
	}

	public int getDanioTerrestre() {
		return 8;
	}

	public int getRangoAereo() {
		return 5;
	}

	public int getRangoTerrestre() {
		return 5;
	}

	public int getVida() {
		return 120;
	}

	public boolean esTerrestre() {
		return false;
	}

	public boolean mover(Unidad espectro, Casilla casilla) {
		return casilla.ocuparAereo(espectro);
	}

}
