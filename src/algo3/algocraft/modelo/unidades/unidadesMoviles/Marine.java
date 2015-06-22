package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoTerrestre;

public class Marine extends UnidadSoldado {

	public Marine(Jugador jugador) throws RecursosInsuficientesError {
		super(40, jugador, PlanoTerrestre.getInstancia(), 30, 0);
		this.inicializar(6, 6, 4, 4);
	}

}