package algo3.algocraft.modelo.juego;


public class TurnoJugador1State extends TurnoState {

	public TurnoState pasarTurno() {
		return new TurnoJugador2State();
	}

	public EstadoTurno turnoDe() {
		return EstadoTurno.JUGADOR1;
	}

}
