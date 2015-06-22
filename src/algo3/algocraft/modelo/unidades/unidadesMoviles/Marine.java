package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoTerrestre;

public class Marine extends UnidadSoldado {

	public Marine(Jugador jugador) throws RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {
		super(40, jugador, PlanoTerrestre.getInstancia(), 30, 0, 1);
		this.inicializar(6, 6, 4, 4);
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		this.jugador.validarSuministro(this.suministro);
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.jugador.aumentarSuministro(this.suministro);
	}

}