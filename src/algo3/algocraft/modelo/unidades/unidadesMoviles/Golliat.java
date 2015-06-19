package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoTerrestre;

public class Golliat extends UnidadSoldado {

	public Golliat(Jugador unJugador) {
		super(125, unJugador, PlanoTerrestre.getInstancia());
		this.inicializar(10,12,5,6);
	}

}