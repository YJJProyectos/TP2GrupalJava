package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.LimiteDeCapacidadError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.SoldadoYaCargadoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.TransporteTerran;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadTransporte;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadTransporteVaciaError;

public class TransporteTerranTest {

	@Test
	public void deberiaCargarUnSoldadoAliado()
			throws UnidadTransporteVaciaError, PerteneceAOtroJugadorError,
			LimiteDeCapacidadError, SoldadoYaCargadoError {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado);
		Assert.assertEquals(soldado, nave.descargarSoldado());
	}

	@Test(expected = PerteneceAOtroJugadorError.class)
	public void deberiaLanzarUnaExcepcionAlCargarUnSoldadoEnemigo()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador1);
		UnidadSoldado soldado = new Marine(jugador2);
		nave.cargarSoldado(soldado);
	}

	@Test(expected = SoldadoYaCargadoError.class)
	public void deberiaLanzarUnaExcepcionAlCargarAlMismoSoldadoDosVeces()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado);
		nave.cargarSoldado(soldado);
	}

	@Test(expected = LimiteDeCapacidadError.class)
	public void deberiaLanzarUnaExcepcionAlCargarMasSoldadosQueLaCapacidadPermitida()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		for (int i = 0; i < 8; i++) {
			nave.cargarSoldado(new Marine(jugador));
		}
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado);
	}

	@Test
	public void deberiaDescargarUnSoldado() throws PerteneceAOtroJugadorError,
			LimiteDeCapacidadError, SoldadoYaCargadoError,
			UnidadTransporteVaciaError {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado);

		Assert.assertEquals(nave.descargarSoldado(), soldado);
	}

	@Test(expected = UnidadTransporteVaciaError.class)
	public void deberiaLanzarUnaExcepcionAlIntentarDescargarUnsSoldadoEnUnTransporteVacio()
			throws UnidadTransporteVaciaError, PerteneceAOtroJugadorError,
			LimiteDeCapacidadError, SoldadoYaCargadoError {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado);
		nave.descargarSoldado();
		nave.descargarSoldado();
	}

	@Test
	public void deberiaActualizarLaPosicionDelSoldado()
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);

		nave.cargarSoldado(soldado);

		Assert.assertEquals(null, soldado.posicion());
	}
}
