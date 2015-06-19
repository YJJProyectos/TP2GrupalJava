package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAereo;

public class TransporteTerran extends UnidadTransporte{
	
	public TransporteTerran(Jugador jugador) {
		super(jugador, PlanoAereo.getInstancia(), 8);
	}

}
