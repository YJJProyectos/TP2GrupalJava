package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

public class ListaDeJugadores {

	private ArrayList<Jugador> jugadores;
	private int posicionActual;

	public ListaDeJugadores() {
		this.jugadores = new ArrayList<Jugador>();
		this.posicionActual = 0;
	}

	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	public void sacarJugador(Jugador jugador) {
		int posicionJugadorASacar = jugadores.indexOf(jugador);
		if ((posicionJugadorASacar == this.jugadores.size() - 1)) {

			this.posicionActual = (this.jugadores.size() - 1) - 1;

		} else if (this.posicionActual != 0) {
			this.posicionActual--;
		}
		jugadores.remove(jugador);
	}

	public void pasarTurno() {
		this.posicionActual = (this.posicionActual + 1) % this.jugadores.size();
	}

	public Jugador jugadorActual() {
		return this.jugadores.get(this.posicionActual);
	}

	public int cantidad() {
		return this.jugadores.size();
	}

	public void comprobarEstadoDeJugadores() {
		for (int i = 0; i < this.jugadores.size(); i++) {
			Jugador jugador = this.jugadores.get(i);
			if (jugador.estaDestruido()) {
				this.sacarJugador(jugador);
			}
		}
	}

}
