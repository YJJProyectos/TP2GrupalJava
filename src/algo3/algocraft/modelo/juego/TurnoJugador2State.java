package algo3.algocraft.modelo.juego;

public class TurnoJugador2State extends TurnoState {

	public TurnoState pasarTurno() {
		return new TurnoJugador1State();
	}

	public EstadoTurno turnoDe() {
		return EstadoTurno.JUGADOR2;
	}

}
