package algo3.algocraft.modelo.tests;


import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.JugadorTerran;

public class JuegoTest {
	
	@Test
	public void deberiaEmpezarConTurnoJugador1(){
		JugadorTerran jugador1 = new JugadorTerran();
		JugadorTerran jugador2 = new JugadorTerran();
		Juego juego = new Juego(jugador1,jugador2);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

	@Test
	public void deberiaPasarTurnosDeJugador1AJugador2YViceversa() {
		JugadorTerran jugador1 = new JugadorTerran();
		JugadorTerran jugador2 = new JugadorTerran();
		Juego juego = new Juego(jugador1,jugador2);
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

}
