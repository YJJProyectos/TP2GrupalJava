package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAereo;

public class Espectro extends UnidadSoldado {

	public Espectro(Jugador unJugador) throws RecursosInsuficientesError {
		super(120, unJugador, PlanoAereo.getInstancia(), 150, 100);
		this.inicializar(20, 8, 5, 5);
	}

}
