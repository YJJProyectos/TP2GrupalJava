package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public abstract class UnidadMovil extends Unidad {

	protected UnidadMovil(Jugador jugador, int vida, PlanoAccion plano,
			int costoMineral, int costoGas, int suministro)
			throws RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {
		super(jugador, vida, plano, costoMineral, costoGas, suministro);
	}

}
