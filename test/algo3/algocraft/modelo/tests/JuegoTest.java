package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;

public class JuegoTest {

	@Test
	public void deberiaEmpezarConTurnoJugador1()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

	@Test
	public void deberiaPasarTurnosDeJugador1AJugador2YViceversa()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

	@Test
	public void deberiaGenerarseUnCicloAlPasarTurnosEmpezandoPorElJugador1()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador3, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

	@Test
	public void deberiaPoderSacarAUnJugadorYSeguirConLosRestantes()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador3, juego.turnoDeJugador());
		juego.sacarJugador(jugador2);
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador3, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());

	}

	@Test
	public void deberiaSacarseElJugador1YTendriaQueJugarElJugadorAgregado()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		juego.sacarJugador(jugador1);
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador3, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
	}

	@Test
	public void deberiaPoderSacarAlJugadorQueSeAgregoEntre2Jugadores()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.sacarJugador(jugador3);
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
	}

	@Test
	public void deberiaPoderSacarAlJugadorQueSeAgregoEntre3Jugadores()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		juego.agregarJugador(jugador4);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador3, juego.turnoDeJugador());
		juego.sacarJugador(jugador4);
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

	@Test
	public void alQuedarUnUnicoJugadorAlSiquienteTurnoLeTocaAEl()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		juego.agregarJugador(jugador4);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador3, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador4, juego.turnoDeJugador());
		juego.sacarJugador(jugador1);
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.sacarJugador(jugador3);
		juego.pasarTurno();
		Assert.assertEquals(jugador4, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.sacarJugador(jugador4);
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
	}

	@Test
	public void deberiaSacarAlJugadorQuePerdioYSeguirConLosOtrosJugadores()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador3, juego.turnoDeJugador());
		juego.sacarJugador(jugador3);
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
	}

	// este test deberia ser que gano el jugador1 el juego, algo asi
	@Test
	public void deberiaVolverAlJugador1SiSeSacaronALosOtrosJugadores()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		juego.agregarJugador(jugador4);
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador2, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador3, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador4, juego.turnoDeJugador());
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
		juego.sacarJugador(jugador2);
		juego.sacarJugador(jugador3);
		juego.sacarJugador(jugador4);
		juego.pasarTurno();
		Assert.assertEquals(jugador1, juego.turnoDeJugador());
	}

	@Test
	public void seDeberiaPoderJugarHasta4Jugadores()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		Jugador jugador5 = new Jugador();
		Juego juego = new Juego(jugador1, jugador2);
		juego.agregarJugador(jugador3);
		Assert.assertTrue(juego.agregarJugador(jugador4));
		Assert.assertFalse(juego.agregarJugador(jugador5));
	}

}
