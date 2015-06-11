package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

public class ListaDeJugadores {

	private ArrayList<Jugador> jugadores;
	private int posicionActual;

	public ListaDeJugadores(){
		this.jugadores = new ArrayList<Jugador>();
		this.posicionActual = 0;
	}

	public void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	public void pasarTurno() {
		this.posicionActual = (this.posicionActual + 1)% this.jugadores.size();
	}

	public Jugador jugadorActual() {
		return this.jugadores.get(this.posicionActual);
	}
}
