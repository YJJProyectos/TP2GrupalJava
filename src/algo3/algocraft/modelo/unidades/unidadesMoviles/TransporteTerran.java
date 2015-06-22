package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAereo;

public class TransporteTerran extends UnidadTransporte {

	public TransporteTerran(Jugador jugador) throws RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {
		super(jugador, PlanoAereo.getInstancia(), 8, 150, 100, 100, 2);
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		this.jugador.validarSuministro(this.suministro);
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.jugador.aumentarSuministro(this.suministro);
	}

}
