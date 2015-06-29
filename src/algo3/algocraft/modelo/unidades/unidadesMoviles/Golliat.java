package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoTerrestre;

public class Golliat extends UnidadSoldado {

	public Golliat(Jugador unJugador) throws RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {
		super(125, unJugador, PlanoTerrestre.getInstancia(), 100, 50, 2,
				"Golliat");
		this.inicializar(10, 12, 5, 6);
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		this.jugador.validarSuministro(this.suministro);
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.jugador.aumentarSuministro(this.suministro);
	}

}