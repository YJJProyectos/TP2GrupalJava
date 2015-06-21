package algo3.algocraft.modelo.juego;

import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Mapa;

public class Juego {

	private ListaDeJugadores jugadores;
	private Mapa mapa;

	public Juego(Jugador jugador1, Jugador jugador2)
			throws RecursosInsuficientesError, CasillaOcupadaError {
		this.jugadores = new ListaDeJugadores();
		this.jugadores.agregarJugador(jugador1);
		this.jugadores.agregarJugador(jugador2);
		this.mapa = new Mapa(4);
		jugador1.iniciarConDeposito(this.mapa.posicionDeBase());
		jugador2.iniciarConDeposito(this.mapa.posicionDeBase());
	}

	public boolean agregarJugador(Jugador jugador) {
		boolean seAgregoJugador = false;
		if (jugadores.cantidad() < 4) {
			this.jugadores.agregarJugador(jugador);
			seAgregoJugador = true;
		}
		return seAgregoJugador;
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
