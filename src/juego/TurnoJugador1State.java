package juego;


public class TurnoJugador1State extends TurnoState {

	public TurnoJugador1State() {
	}

	@Override
	public TurnoState pasarTurno() {
		return new TurnoJugador2State();
	}

	@Override
	public EstadoTurno turnoDe() {
		return EstadoTurno.JUGADOR1;
	}

}
