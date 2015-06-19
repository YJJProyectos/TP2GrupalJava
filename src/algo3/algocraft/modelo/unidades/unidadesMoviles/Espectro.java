package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAereo;

public class Espectro extends UnidadSoldado {

	public Espectro(Jugador unJugador) {
		super(120, unJugador, PlanoAereo.getInstancia());
		this.inicializar(20,8,5,5);
	}

}
