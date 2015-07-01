package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.comportamientos.PlanoAereo;

public class Espectro extends UnidadSoldado {

	public Espectro(Jugador unJugador) throws RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {
		super(120, unJugador, PlanoAereo.getInstancia(), 150, 100, 2,
				"Espectro");
		this.inicializar(20, 8, 5, 5);
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		this.jugador.validarSuministro(this.suministro);
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.jugador.aumentarSuministro(this.suministro);
	}

}
