package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.LimiteDeCapacidadError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.SoldadoYaCargadoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.modelo.unidades.unidadesMoviles.TransporteTerran;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadTransporteVaciaError;

public class TransporteTerranTest {

	@Test(expected = PoblacionLimiteAlcanzadaError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosSuministrosParaCrearUnaNaveTransporte()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		@SuppressWarnings("unused")
		TransporteTerran nave = new TransporteTerran(jugador);
	}

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnaNaveTransporte()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		jugador.pagar(400, 100);
		@SuppressWarnings("unused")
		TransporteTerran nave = new TransporteTerran(jugador);
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExcepcionAlCargarUnSoldadoAliadoCuandoRecibeComoParametrootroJugador()
			throws UnidadTransporteVaciaError, PerteneceAOtroJugadorError,
			LimiteDeCapacidadError, SoldadoYaCargadoError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Jugador otroJugador = new Jugador();
		TransporteTerran nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado, otroJugador);
	}

	@Test
	public void deberiaCargarUnSoldadoAliado()
			throws UnidadTransporteVaciaError, PerteneceAOtroJugadorError,
			LimiteDeCapacidadError, SoldadoYaCargadoError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		TransporteTerran nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado, jugador);

		Assert.assertEquals(soldado, nave.descargarSoldado(jugador));
	}

	@Test(expected = PerteneceAOtroJugadorError.class)
	public void deberiaLanzarUnaExcepcionAlCargarUnSoldadoEnemigo()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		TransporteTerran nave = new TransporteTerran(jugadorAliado);
		UnidadSoldado soldado = new Marine(jugadorEnemigo);
		nave.cargarSoldado(soldado, jugadorAliado);
	}

	@Test(expected = SoldadoYaCargadoError.class)
	public void deberiaLanzarUnaExcepcionAlCargarAlMismoSoldadoDosVeces()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		TransporteTerran nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado, jugador);
		nave.cargarSoldado(soldado, jugador);
	}

	@Test(expected = LimiteDeCapacidadError.class)
	public void deberiaLanzarUnaExcepcionAlCargarMasSoldadosQueLaCapacidadPermitida()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		jugador.aumentarPoblacion();
		TransporteTerran nave = new TransporteTerran(jugador);
		for (int i = 0; i < 8; i++) {
			nave.cargarSoldado(new Marine(jugador), jugador);
		}
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado, jugador);
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExcepcionAlDescargarUnSoldadoAliadoCuandoRecibeComoParametrootroJugador()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError, UnidadTransporteVaciaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Jugador otroJugador = new Jugador();
		TransporteTerran nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado, jugador);
		nave.descargarSoldado(otroJugador);
	}

	@Test
	public void deberiaDescargarUnSoldado() throws PerteneceAOtroJugadorError,
			LimiteDeCapacidadError, SoldadoYaCargadoError,
			UnidadTransporteVaciaError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		TransporteTerran nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado, jugador);

		Assert.assertEquals(soldado, nave.descargarSoldado(jugador));
	}

	@Test(expected = UnidadTransporteVaciaError.class)
	public void deberiaLanzarUnaExcepcionAlIntentarDescargarUnsSoldadoEnUnTransporteVacio()
			throws UnidadTransporteVaciaError, PerteneceAOtroJugadorError,
			LimiteDeCapacidadError, SoldadoYaCargadoError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		TransporteTerran nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado, jugador);
		nave.descargarSoldado(jugador);
		nave.descargarSoldado(jugador);
	}

	@Test
	public void deberiaActualizarLaPosicionDelSoldado()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		TransporteTerran nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);

		nave.cargarSoldado(soldado, jugador);

		Assert.assertEquals(null, soldado.posicion());
	}

}
