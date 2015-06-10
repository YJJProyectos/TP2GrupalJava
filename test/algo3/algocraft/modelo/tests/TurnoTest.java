package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Turno;

public class TurnoTest {

	@Test
	public void deberiaComenzarEnElTurno0() {

		Turno turnoJuego = new Turno();
		Assert.assertEquals(0, turnoJuego.getTurno());
	}

	@Test
	public void alPasarSoloUnTurnoElTurnoEsEl1() {

		Turno turnoJuego = new Turno();
		turnoJuego.pasarTurno();
		Assert.assertEquals(1, turnoJuego.getTurno());
	}
}
