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
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.DistanciaMayorQueElRangoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class MarineTest {

	@Test(expected = PoblacionLimiteAlcanzadaError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosSuministrosParaCrearUnMarine()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		@SuppressWarnings("unused")
		Marine marine = new Marine(jugador);
	}

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnMarine()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		jugador.pagar(400, 100);
		@SuppressWarnings("unused")
		Marine marine = new Marine(jugador);
	}

	@Test
	public void deberiaEstarDetruidoElMarine()
			throws RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		marine.recibirDanio(1000);

		Assert.assertTrue(marine.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruidoElMarine()
			throws RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		marine.recibirDanio(5);

		Assert.assertFalse(marine.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio1() throws RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		int vidaInicial = marine.vidaRestante();
		marine.recibirDanio(1);
		int vidaFinal = marine.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void deberiaQuedarle39DeVida() throws RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		marine.recibirDanio(1);

		Assert.assertEquals(39, marine.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaUnidadEnUnaCasillaDesocupada()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		marine.posicionar(casilla);

		Assert.assertEquals(casilla, marine.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlPosicionarUnMarineEnUnaCasillaOcupada()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine primerMarine = new Marine(jugador);
		Marine segundoMarine = new Marine(jugador);
		primerMarine.posicionar(casilla);
		segundoMarine.posicionar(casilla);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws CasillaOcupadaError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		marine.posicionar(casilla);

		Assert.assertEquals(casilla, marine.posicion());
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExcepcionAlAtacarUnEnemigoPorqueNoRecibeComoParametroAlJugadorPropio()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError, DistanciaMayorQueElRangoError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		UnidadSoldado marine = new Marine(jugadorAliado);
		marine.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(2, 1)));
		marine.atacarEnemigo(soldadoEnemigo, jugadorEnemigo);
	}

	@Test
	public void deberiaDesocuparLaCasillaUnaVezYaDestruido()
			throws RecursosInsuficientesError, PoblacionLimiteAlcanzadaError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		Casilla casilla = new Casilla(new Coordenada(2, 3));
		marine.posicionar(casilla);
		marine.recibirDanio(100);
		Assert.assertTrue(marine.estaDestruido());
		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test(expected = PerteneceAlMismoJugadorError.class)
	public void unMarineDeberiaNoDaniarAUnGoliatPorPertenecerAlMismoJugador()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError, DistanciaMayorQueElRangoError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine soldado = new Marine(jugador);
		Unidad soldadoAliado = new Golliat(jugador);
		Coordenada coordenadaCasillaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaCasillaSoldadoAliado = new Coordenada(1, 2);
		Casilla casillaSoldado = new Casilla(coordenadaCasillaSoldado);
		Casilla casillaSoldadoAliado = new Casilla(
				coordenadaCasillaSoldadoAliado);
		soldado.posicionar(casillaSoldado);
		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldado.atacarEnemigo(soldadoAliado, jugador);
	}

	@Test(expected = DistanciaMayorQueElRangoError.class)
	public void unMarineDeberiaNoDaniarAUnGoliatPorEstarFueraDelRango()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError, DistanciaMayorQueElRangoError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaSoldadoAliado = new Coordenada(1, 1);
		Coordenada coordenadaSoldadoEnemigo = new Coordenada(10, 10);
		Casilla casillaSoldadoAliado = new Casilla(coordenadaSoldadoAliado);
		Casilla casillaSoldadoEnemigo = new Casilla(coordenadaSoldadoEnemigo);
		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldadoEnemigo.posicionar(casillaSoldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

	}

	@Test
	public void unMarineDeberiaDaniarAUnGoliatPorEstarElElRango()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError, DistanciaMayorQueElRangoError {

		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(119, soldadoEnemigo.vidaRestante());
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
		Marine marine = new Marine(jugador);
		marine.posicionar(casillero);
		marine.mover(casilleroLibre, otroJugador);
	}

	@Test
	public void deberiaPoderMoverseUnMarineSiNoHayNadieEnEseCasillero()
			throws CasillaOcupadaError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Coordenada coordenadaCasilleroLibre = new Coordenada(1, 2);
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		marine.posicionar(casillero);
		marine.mover(casilleroLibre, jugador);

		Assert.assertEquals(casilleroLibre, marine.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererMoverseUnMarineSiEstaOcupadoElCasillero()
			throws CasillaOcupadaError, JugadorIncorrectoError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Marine marine = new Marine(jugador);
		Unidad otroMarine = new Marine(jugador);
		otroMarine.posicionar(casillero);
		marine.mover(casillero, jugador);
	}

	@Test(expected = NoPuedeAtacarMultiplesVecesError.class)
	public void unMarineNoDeberiaPoderAtacarMasDeUnaVez()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError, DistanciaMayorQueElRangoError {

		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);
	}

	@Test
	public void unMarinePuedeVolverAAtacarLuegoDePasarUnTurno()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError, DistanciaMayorQueElRangoError {

		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);
		soldadoAliado.pasarTurno();
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(113, soldadoEnemigo.vidaRestante());
	}

}
