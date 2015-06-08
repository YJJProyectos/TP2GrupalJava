package tests;

import juego.Turno;
import org.junit.Assert;
import org.junit.Test;

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
