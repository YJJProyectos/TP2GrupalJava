package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class MarineTest {

	@Test
	public void deberiaEstarDetruidoElMarine() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);
		marine.recibirDanio(1000);

		Assert.assertTrue(marine.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruidoElMarine() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);
		marine.recibirDanio(5);

		Assert.assertFalse(marine.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio1() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);
		int vidaInicial = marine.vidaRestante();
		marine.recibirDanio(1);
		int vidaFinal = marine.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void deberiaQuedarle39DeVida() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);
		marine.recibirDanio(1);

		Assert.assertEquals(39, marine.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaUnidadEnUnaCasillaDesocupada()
			throws CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);
		marine.posicionar(casilla);
		Assert.assertEquals(casilla, marine.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlPosicionarUnMarineEnUnaCasillaOcupada()
			throws CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Marine primerMarine = new Marine(jugador);
		Marine segundoMarine = new Marine(jugador);
		primerMarine.posicionar(casilla);
		segundoMarine.posicionar(casilla);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);

		marine.posicionar(casilla);

		Assert.assertEquals(casilla, marine.posicion());
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExcepcionAlAtacarUnEnemigoPorqueNoRecibeComoParametroAlJugadorPropio()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError {
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		UnidadSoldado marine = new Marine(jugadorAliado);
		marine.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(2, 1)));
		marine.atacarEnemigo(soldadoEnemigo, jugadorEnemigo);

	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);
		marine.recibirDanio(100);
		Assert.assertTrue(marine.estaDestruido());
		marine.recibirDanio(2);

	}

	@Test(expected = PerteneceAlMismoJugadorError.class)
	public void unMarineDeberiaNoDaniarAUnGoliatPorPertenecerAlMismoJugador()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError {
		Jugador jugador = new Jugador();
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

	@Test
	public void unMarineDeberiaNoDaniarAUnGoliatPorEstarFueraDelRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError {
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaSoldadoAliado = new Coordenada(1, 1);
		Coordenada coordenadaSoldadoEnemigo = new Coordenada(10, 10);
		Casilla casillaSoldadoAliado = new Casilla(coordenadaSoldadoAliado);
		Casilla casillaSoldadoEnemigo = new Casilla(coordenadaSoldadoEnemigo);

		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldadoEnemigo.posicionar(casillaSoldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo, jugadorAliado);

		Assert.assertEquals(125, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void unMarineDeberiaDaniarAUnGoliatPorEstarElElRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError {
		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
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
			throws CasillaOcupadaError, JugadorIncorrectoError {
		Coordenada coordenadaCasilleroLibre = new Coordenada(1, 2);
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Marine marine = new Marine(jugador);
		marine.posicionar(casillero);
		marine.mover(casilleroLibre, otroJugador);
	}

	@Test
	public void deberiaPoderMoverseUnMarineSiNoHayNadieEnEseCasillero()
			throws CasillaOcupadaError, JugadorIncorrectoError {
		Coordenada coordenadaCasilleroLibre = new Coordenada(1, 2);
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);
		marine.posicionar(casillero);
		marine.mover(casilleroLibre, jugador);
		Assert.assertEquals(casilleroLibre, marine.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererMoverseUnMarineSiEstaOcupadoElCasillero()
			throws CasillaOcupadaError, JugadorIncorrectoError {
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		Marine marine = new Marine(jugador);
		Unidad otroMarine = new Marine(jugador);
		otroMarine.posicionar(casillero);
		marine.mover(casillero, jugador);
	}

	@Test(expected = NoPuedeAtacarMultiplesVecesError.class)
	public void unMarineNoDeberiaPoderAtacarMasDeUnaVez()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError {
		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
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
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, CasillaOcupadaError,
			JugadorIncorrectoError {
		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
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
