package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;

public abstract class Recolector extends UnidadEdificio{

	protected Recolector(Jugador jugador, int vida) {
		super(jugador, vida);
	}

	public abstract boolean recolectar();

	public abstract int getCantidadRecursoRecolectado();

}
