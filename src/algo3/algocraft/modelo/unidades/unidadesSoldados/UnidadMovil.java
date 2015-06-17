package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.Unidad;

public abstract class UnidadMovil extends Unidad {

	protected UnidadMovil(Jugador jugador, int vida) {
		super(jugador, vida);
	}
	
}
