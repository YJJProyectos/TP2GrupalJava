package algo3.algocraft.modelo.juego;

public class Juego {

	private JugadorTerran jugador1;
	private JugadorTerran jugador2;
	private TurnoState estadoTurno;

	public Juego(JugadorTerran jugador1, JugadorTerran jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		estadoTurno = new TurnoJugador1State();
	}

	public void pasarTurno() {
		estadoTurno = estadoTurno.pasarTurno();
	}

	public JugadorTerran turnoDeJugador() {
		JugadorTerran turnoActual = null;
		switch (estadoTurno.turnoDe()) {
		case JUGADOR1:
			turnoActual = jugador1;
			break;
		case JUGADOR2:
			turnoActual = jugador2;
			break;
		}
		return turnoActual;
	}

}
