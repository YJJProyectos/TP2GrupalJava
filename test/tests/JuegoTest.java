package tests;

import juego.Juego;
import juego.Jugador;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {
	
	@Test
	public void deberiaEmpezarConTurnoJugador1(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Juego juego = new Juego(jugador1,jugador2);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

	@Test
	public void deberiaPasarTurnosDeJugador1AJugador2YViceversa() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Juego juego = new Juego(jugador1,jugador2);
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

}
