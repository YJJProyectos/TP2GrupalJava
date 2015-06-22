package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public abstract class UnidadMovil extends Unidad {

	protected UnidadMovil(Jugador jugador, int vida, PlanoAccion plano,
			int costoMineral, int costoGas) throws RecursosInsuficientesError {
		super(jugador, vida, plano, costoMineral, costoGas);
		this.jugador.pagar(this.costoMineral, this.costoGas);
	}

}
