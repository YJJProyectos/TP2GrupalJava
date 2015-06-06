package juego;


public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador turnoActual;
	private TurnoState estadoTurno;

	public Juego(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		estadoTurno = new TurnoJugador1State();
	}

	public void pasarTurno() {
		estadoTurno = estadoTurno.pasarTurno();
	}

	public Jugador turnoDeJugador() {
		switch ( estadoTurno.turnoDe() ){
		case JUGADOR1: turnoActual = jugador1; break;
		case JUGADOR2: turnoActual = jugador2; break;
		}
		return turnoActual;
	}

}
