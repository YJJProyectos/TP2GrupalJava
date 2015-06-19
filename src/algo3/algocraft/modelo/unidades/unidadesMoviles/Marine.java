package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoTerrestre;

public class Marine extends UnidadSoldado {

	public Marine(Jugador jugador) {
		super(40, jugador, PlanoTerrestre.getInstancia());
		this.inicializar(6, 6, 4, 4);
	}

}