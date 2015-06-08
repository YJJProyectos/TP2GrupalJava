package tests;

import juego.Turno;

import org.junit.Assert;
import org.junit.Test;

import edificables.Barraca;
import edificables.EdificioEnConstruccion;
import edificables.Estructura;

import peleables.Marine;

public class EdificioEnConstruccionTest {

	@Test
	public void elTiempoDeConstruccionDeberiaSerDe5Turnos() {

		Estructura edificio = new Barraca();
		Turno turnoJuego = new Turno();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				edificio, turnoJuego, 5);
		Assert.assertEquals(5, construccion.verTurnosRestantes());
	}

	@Test
	public void elTiempoDeConstruccionAlPasarUnTurnoDeberiaBajarDe5A4() {

		Estructura edificio = new Barraca();
		Turno turnoJuego = new Turno();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				edificio, turnoJuego, 5);
		turnoJuego.pasarTurno();
		Assert.assertEquals(4, construccion.verTurnosRestantes());
	}

	@Test
	public void atacarUnaUnidadDeConstruccionLaDestruye() {
		Estructura edificio = new Barraca();
		Turno turnoJuego = new Turno();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				edificio, turnoJuego, 5);
		Marine marine = new Marine();
		marine.atacarEnemigo(construccion);
		Assert.assertTrue(construccion.estaDestruido());

	}
}
