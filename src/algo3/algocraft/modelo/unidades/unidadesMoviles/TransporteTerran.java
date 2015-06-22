package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAereo;

public class TransporteTerran extends UnidadTransporte {

	public TransporteTerran(Jugador jugador) throws RecursosInsuficientesError {
		super(jugador, PlanoAereo.getInstancia(), 8, 150, 100, 100);
	}

}
