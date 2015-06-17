package algo3.algocraft.modelo.unidades.unidadesSoldados.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public class ComportamientoMarine extends ComportamientoSoldado {
	private static final ComportamientoMarine INSTANCIA = new ComportamientoMarine();
	
	private ComportamientoMarine() {}
	
	public static ComportamientoMarine getInstancia() {
		return INSTANCIA;
	}
	
	public int getDanioAereo() {
		return 6;
	}

	public int getDanioTerrestre() {
		return 6;
	}

	public int getRangoAereo() {
		return 4;
	}

	public int getRangoTerrestre() {
		return 4;
	}

	public int getVida() {
		return 40;
	}

	public boolean esTerrestre() {
		return true;
	}
	
	public boolean mover(Unidad marine, Casilla casilla) {
		return casilla.ocuparTerrestre(marine);
	}
	

}
