package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public abstract class UnidadMovil extends Unidad {

	protected UnidadMovil(Jugador jugador, int vida, PlanoAccion plano) {
		super(jugador, vida, plano);
	}
	
}
