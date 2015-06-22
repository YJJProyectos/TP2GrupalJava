package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Espectro;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class GolliatTest {

	@Test(expected = PoblacionLimiteAlcanzadaError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosSuministrosParaCrearUnGolliat()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		@SuppressWarnings("unused")
		Golliat golliat = new Golliat(jugador);
	}

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnGolliat()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		jugador.pagar(400, 100);
		@SuppressWarnings("unused")
		Golliat golliat = new Golliat(jugador);
	}

	@Test
	public void deberiaEstarDetruidoElGolliat() throws YaEstaDestruidoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		golliat.recibirDanio(1000);

		Assert.assertTrue(golliat.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruidoElGolliat() throws YaEstaDestruidoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		golliat.recibirDanio(5);

		Assert.assertFalse(golliat.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio1() throws YaEstaDestruidoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		int vidaInicial = golliat.vidaRestante();
		golliat.recibirDanio(1);
		int vidaFinal = golliat.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void deberiaQuedarle124DeVida() throws YaEstaDestruidoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		golliat.recibirDanio(1);

		Assert.assertEquals(124, golliat.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarse() throws CasillaOcupadaError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		golliat.posicionar(casilla);
		Assert.assertEquals(casilla, golliat.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzaraUnaExcepcionAlPosicionarUnGolliatEnUnaCasillaOcupada()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat primerGolliat = new Golliat(jugador);
		Golliat segundoGolliat = new Golliat(jugador);
		primerGolliat.posicionar(casilla);
		segundoGolliat.posicionar(casilla);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws CasillaOcupadaError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		golliat.posicionar(casilla);

		Assert.assertEquals(casilla, golliat.posicion());
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
		UnidadSoldado golliat = new Golliat(jugadorAliado);
		golliat.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(2, 1)));
		golliat.atacarEnemigo(soldadoEnemigo, jugadorEnemigo);
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		golliat.recibirDanio(200);

		Assert.assertTrue(golliat.estaDestruido());

		golliat.recibirDanio(2);
	}

	@Test(expected = PerteneceAlMismoJugadorError.class)
	public void unGolliatDeberiaNoDaniarAUnMarinePorPertenecerAlMismoJugador()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat soldado = new Golliat(jugador);
		Unidad soldadoAliado = new Marine(jugador);
		Coordenada coordenadaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaAliado = new Coordenada(1, 2);
		Casilla casillaSoldado = new Casilla(coordenadaSoldado);
		Casilla casillaAliado = new Casilla(coordenadaAliado);
		soldado.posicionar(casillaSoldado);
		soldadoAliado.posicionar(casillaAliado);
		soldado.atacarEnemigo(soldadoAliado, jugador);
	}

	@Test
	public void unGolliatDeberiaNoDaniarAUnMarinePorEstarFueraDelRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaAliado = new Coordenada(10, 10);
		Casilla casillaSoldado = new Casilla(coordenadaSoldado);
		Casilla casillaAliado = new Casilla(coordenadaAliado);
		soldadoAliado.posicionar(casillaSoldado);
		soldadoEnemigo.posicionar(casillaAliado);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(40, soldadoEnemigo.vidaRestante());
	}

	@Test
	public void unGolliatDeberiaDaniarAUnMarinePorEstarElElRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(28, soldadoEnemigo.vidaRestante());
	}

	@Test
	public void deberiaNoDaniarAUnaUnidadVoladoraFueraDeRangoAereo()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Espectro(jugadorEnemigo);
		Casilla casilla1 = new Casilla(new Coordenada(1, 1));
		Casilla casilla2 = new Casilla(new Coordenada(1, 7));
		soldadoAliado.posicionar(casilla1);
		soldadoEnemigo.posicionar(casilla2);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(120, soldadoEnemigo.vidaRestante());
	}

	@Test
	public void deberiaDaniarAUnaUnidadVoladoraEnSuRangoAereo()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Espectro(jugadorEnemigo);
		Casilla casilla1 = new Casilla(new Coordenada(1, 1));
		Casilla casilla2 = new Casilla(new Coordenada(1, 6));
		soldadoAliado.posicionar(casilla1);
		soldadoEnemigo.posicionar(casilla2);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(110, soldadoEnemigo.vidaRestante());
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExcepcionAlMoverseUnGolliatSiElParametroEsOtroJugador()
			throws CasillaOcupadaError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Coordenada coordenadaCasilleroLibre = new Coordenada(1, 2);
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Jugador otroJugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		golliat.posicionar(casillero);
		golliat.mover(casilleroLibre, otroJugador);
	}

	@Test
	public void deberiaPoderMoverseUnGolliatSiNoHayNadieEnEseCasillero()
			throws CasillaOcupadaError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Coordenada coordenadaCasilleroLibre = new Coordenada(1, 2);
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		golliat.posicionar(casillero);
		golliat.mover(casilleroLibre, jugador);

		Assert.assertEquals(casilleroLibre, golliat.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void noDeberiaPoderMoverseUnGolliatSiEstaOcupadoElCasillero()
			throws CasillaOcupadaError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Golliat golliat = new Golliat(jugador);
		Unidad otroGolliat = new Golliat(jugador);
		otroGolliat.posicionar(casillero);
		golliat.mover(casillero, jugador);
	}

	@Test(expected = NoPuedeAtacarMultiplesVecesError.class)
	public void unGolliatNoDeberiaPoderAtacarMasDeUnaVez()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);
	}

	@Test
	public void unGolliatPuedeVolverAAtacarLuegoDePasarUnTurno()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);
		soldadoAliado.pasarTurno();
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(16, soldadoEnemigo.vidaRestante());
	}

}
