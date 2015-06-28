package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Mapa;

public class Juego {

	private ListaDeJugadores jugadores;
	private Mapa mapa;
	private Jugador ganador;
	private ArrayList<String> nombres;

	public Juego(Jugador jugador1, Jugador jugador2) throws NombresInvalidosError{
		this.ganador = null;
		this.nombres = new ArrayList<String>();
		this.jugadores = new ListaDeJugadores();
		this.agregarJugador(jugador1);
		this.agregarJugador(jugador2);
		this.verificarNombres();
		this.mapa = new Mapa(4);
		try {
			this.mapa.setCoordenadaMineralYVolcanDeGas();
		} catch (CasillaOcupadaError e) {
			e.printStackTrace();
		}
		try {
			jugador1.iniciarConDeposito(this.mapa.posicionDeBase());
			jugador2.iniciarConDeposito(this.mapa.posicionDeBase());
		} catch (RecursosInsuficientesError | CasillaOcupadaError e) {
			e.printStackTrace();
		}
	}

	private void verificarNombres() throws NombresInvalidosError {
		String nombre;
		for (int i = 0; i < nombres.size(); i++){
			nombre = nombres.get(i);
			if ( (nombre == "") || ( nombres.lastIndexOf(nombre) != i) ){
				throw new NombresInvalidosError();
			}
		}
	}

	public boolean agregarJugador(Jugador jugador) {
		if (jugadores.cantidad() < 4) {
			this.jugadores.agregarJugador(jugador);
			nombres.add(jugador.getNombre());
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
