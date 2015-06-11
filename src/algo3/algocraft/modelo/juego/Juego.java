package algo3.algocraft.modelo.juego;

public class Juego {

	private ListaDeJugadores jugadores;

	public Juego(Jugador jugador1, Jugador jugador2) {
		this.jugadores = new ListaDeJugadores();
		this.jugadores.agregarJugador(jugador1);
		this.jugadores.agregarJugador(jugador2);
	}

	public void agregarJugador(Jugador jugador){
		this.jugadores.agregarJugador(jugador);
	}

	public void pasarTurno() {
		jugadores.pasarTurno();
	}

	public Jugador turnoDeJugador() {
		return jugadores.jugadorActual();
	}

	public void sacarJugador(Jugador jugador) {
		jugadores.sacarJugador(jugador);
	}

}
