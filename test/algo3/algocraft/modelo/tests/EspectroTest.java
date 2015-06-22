package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Espectro;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class EspectroTest {

	@Test(expected = PoblacionLimiteAlcanzadaError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosSuministrosParaCrearUnEspectro()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		@SuppressWarnings("unused")
		Espectro espectro = new Espectro(jugador);
	}

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnEspectro()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		jugador.pagar(400, 100);
		@SuppressWarnings("unused")
		Espectro espectro = new Espectro(jugador);
	}

	@Test
	public void deberiaEstarDetruido() throws YaEstaDestruidoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		UnidadSoldado espectro = new Espectro(jugador);
		espectro.recibirDanio(1000);

		Assert.assertTrue(espectro.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruido() throws YaEstaDestruidoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		UnidadSoldado espectro = new Espectro(jugador);
		espectro.recibirDanio(5);

		Assert.assertFalse(espectro.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio() throws YaEstaDestruidoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		UnidadSoldado espectro = new Espectro(jugador);
		int vidaInicial = espectro.vidaRestante();
		espectro.recibirDanio(1);
		int vidaFinal = espectro.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void deberiaQuedarle119DeVida() throws YaEstaDestruidoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		UnidadSoldado espectro = new Espectro(jugador);
		espectro.recibirDanio(1);

		Assert.assertEquals(119, espectro.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseEnUnaCasillaDesocupada()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		UnidadSoldado espectro = new Espectro(jugador);
		espectro.posicionar(casilla);

		Assert.assertEquals(casilla, espectro.posicion());
	}

	@Test
	public void deberiaPoderPosicionarseEnUnaCasillaConAireDesocupado()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		jugador.aumentarGas(50);
		Golliat golliat = new Golliat(jugador);
		UnidadSoldado espectro = new Espectro(jugador);
		golliat.posicionar(casilla);
		espectro.posicionar(casilla);

		Assert.assertEquals(casilla, espectro.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererPosicionarUnEspectroEnUnaCasillaConAireOcupado()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		jugador.aumentarGas(100);
		UnidadSoldado espectro1 = new Espectro(jugador);
		UnidadSoldado espectro2 = new Espectro(jugador);
		espectro1.posicionar(casilla);
		espectro2.posicionar(casilla);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws CasillaOcupadaError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		UnidadSoldado espectro = new Espectro(jugador);
		espectro.posicionar(casilla);

		Assert.assertEquals(casilla, espectro.posicion());
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExcepcionAlAtacarUnEnemigoPorqueNoRecibeComoParametroAlJugadorPropio()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		UnidadSoldado espectro = new Espectro(jugadorAliado);
		espectro.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(2, 1)));
		espectro.atacarEnemigo(soldadoEnemigo, jugadorEnemigo);
	}

	@Test
	public void deberiaNoDaniarFueraDeRango() throws YaEstaDestruidoError,
			PerteneceAlMismoJugadorError, NoPuedeAtacarMultiplesVecesError,
			CasillaOcupadaError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		UnidadSoldado espectro = new Espectro(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaAliado = new Coordenada(10, 10);
		Casilla casillaSoldado = new Casilla(coordenadaSoldado);
		Casilla casillaAliado = new Casilla(coordenadaAliado);
		espectro.posicionar(casillaSoldado);
		soldadoEnemigo.posicionar(casillaAliado);
		espectro.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(40, soldadoEnemigo.vidaRestante());
	}

	@Test
	public void deberiaDaniarEnElRango() throws YaEstaDestruidoError,
			PerteneceAlMismoJugadorError, NoPuedeAtacarMultiplesVecesError,
			CasillaOcupadaError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		UnidadSoldado espectro = new Espectro(jugadorAliado);
		espectro.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(2, 1)));
		espectro.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(32, soldadoEnemigo.vidaRestante());
	}

}
