package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public class ComportamientoTransporteTerran extends ComportamientoTransporte{

	private static final ComportamientoTransporteTerran INSTANCIA= new ComportamientoTransporteTerran();
	
	private ComportamientoTransporteTerran() {}
	
	public static ComportamientoTransporteTerran getInstancia () {
		return INSTANCIA;
	}
	public int capacidad() {
		return 8;
	}

	public int getVida() {
		return 150;
	}

	public boolean mover(Unidad unidad, Casilla casilla) {
		return casilla.ocuparAereo(unidad);
	}

}
