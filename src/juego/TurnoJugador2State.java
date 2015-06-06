package juego;


public class TurnoJugador2State extends TurnoState {

	@Override
	public TurnoState pasarTurno() {
		return new TurnoJugador1State();
	}

	@Override
	public EstadoTurno turnoDe() {
		return EstadoTurno.JUGADOR2;
	}

}
