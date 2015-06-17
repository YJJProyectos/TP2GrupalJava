package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.ListaDeJugadores;

public class ListaDeJugadoresTest {

	@Test
	public void elJugadorActualDeberiaSerElJugador1() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		Assert.assertEquals(jugador1, lista.jugadorActual());
	}

	@Test
	public void deberiaPasarTurnosDeJugador1AJugador2YViceversa() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());
	}

	@Test
	public void deberiaGenerarseUnCicloAlPasarTurnosEmpezandoPorElJugador1() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.agregarJugador(jugador3);
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador3, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());
	}

	@Test
	public void deberiaPoderSacarAUnJugadorYSeguirConLosRestantes() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.agregarJugador(jugador3);
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador3, lista.jugadorActual());
		lista.sacarJugador(jugador2);
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador3, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());

	}

	@Test
	public void deberiaSacarseElJugador1YTendriaQueJugarElJugadorAgregado() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.agregarJugador(jugador3);
		lista.sacarJugador(jugador1);
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador3, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
	}

	@Test
	public void deberiaPoderSacarAlJugadorQueSeAgregoEntre2Jugadores() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.agregarJugador(jugador3);
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.sacarJugador(jugador3);
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
	}

	@Test
	public void deberiaPoderSacarAlJugadorQueSeAgregoEntre3Jugadores() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.agregarJugador(jugador3);
		lista.agregarJugador(jugador4);
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador3, lista.jugadorActual());
		lista.sacarJugador(jugador4);
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());
	}

	@Test
	public void alQuedarUnUnicoJugadorAlSiquienteTurnoLeTocaAEl() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.agregarJugador(jugador3);
		lista.agregarJugador(jugador4);
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador3, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador4, lista.jugadorActual());
		lista.sacarJugador(jugador1);
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.sacarJugador(jugador3);
		lista.pasarTurno();
		Assert.assertEquals(jugador4, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.sacarJugador(jugador4);
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
	}

	@Test
	public void deberiaSacarAlJugadorQuePerdioYSeguirConLosOtrosJugadores() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.agregarJugador(jugador3);
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador3, lista.jugadorActual());
		lista.sacarJugador(jugador3);
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
	}

	@Test
	public void deberiaVolverAlJugador1SiSeSacaronALosOtrosJugadores() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		ListaDeJugadores lista = new ListaDeJugadores();
		lista.agregarJugador(jugador1);
		lista.agregarJugador(jugador2);
		lista.agregarJugador(jugador3);
		lista.agregarJugador(jugador4);
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador2, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador3, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador4, lista.jugadorActual());
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());
		lista.sacarJugador(jugador2);
		lista.sacarJugador(jugador3);
		lista.sacarJugador(jugador4);
		lista.pasarTurno();
		Assert.assertEquals(jugador1, lista.jugadorActual());
	}
}
