package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;

public abstract class Recolector extends UnidadEdificio {

	protected Recolector(Jugador jugador, int vida) {
		super(jugador, vida);
	}

	@Override
	public void posicionar(Casilla casilla) throws CasillaOcupadaError {
		casilla.ocuparRecurso(this);
		this.posicion = casilla;
	}

}
