package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;

public abstract class Recolector extends UnidadEdificio {

	protected Recolector(Jugador jugador, int vida, int cantidadMineral,
			int cantidadGas) {
		super(jugador, vida, cantidadMineral, cantidadGas);
	}

	@Override
	public void posicionar(Casilla casilla) throws CasillaOcupadaError {
		casilla.ocuparRecurso(this);
		this.posicion = casilla;
	}

}
