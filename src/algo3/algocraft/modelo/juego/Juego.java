package algo3.algocraft.modelo.juego;

import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Mapa;

public class Juego {

	private ListaDeJugadores jugadores;
	private Mapa mapa;
	private Jugador ganador;

	public Juego(Jugador jugador1, Jugador jugador2)
			throws RecursosInsuficientesError, CasillaOcupadaError {
		this.ganador = null;
		this.jugadores = new ListaDeJugadores();
		this.jugadores.agregarJugador(jugador1);
		this.jugadores.agregarJugador(jugador2);
		this.mapa = new Mapa(4);
		jugador1.iniciarConDeposito(this.mapa.posicionDeBase());
		jugador2.iniciarConDeposito(this.mapa.posicionDeBase());
	}

	public boolean agregarJugador(Jugador jugador) {
		if (jugadores.cantidad() < 4) {
			this.jugadores.agregarJugador(jugador);
			return true;
		}
		return false;
	}

	public void pasarTurno() {
		this.jugadores.pasarTurno();
		this.jugadores.comprobarEstadoDeJugadores();
		if (this.jugadores.cantidad() == 1) {
			this.ganador = this.jugadores.jugadorActual();
		}
	}

	public Jugador getGanador() {
		return this.ganador;
	}

	public Jugador turnoDeJugador() {
		return jugadores.jugadorActual();
	}

	public void sacarJugador(Jugador jugador) {
		jugadores.sacarJugador(jugador);
	}

	public Mapa getMapa() {
		return this.mapa;
	}

}
