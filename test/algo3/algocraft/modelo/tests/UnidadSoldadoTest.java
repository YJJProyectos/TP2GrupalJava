package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Golliat;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Marine;
import algo3.algocraft.modelo.unidades.unidadesSoldados.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.UnidadSoldado;

public class UnidadSoldadoTest {

	@Test
	public void unMarineEsUnaUnidadTerrestre() {
		JugadorTerran jugador = new JugadorTerran();
		Marine soldado = new Marine(jugador);

		Assert.assertTrue(soldado.esTerrestre());
	}

	@Test
	public void unGolliatEsUnaUnidadTerrestre() {
		JugadorTerran jugador = new JugadorTerran();
		Golliat soldado = new Golliat(jugador);

		Assert.assertTrue(soldado.esTerrestre());
	}

	@Test(expected = PerteneceAlMismoJugadorError.class)
	public void unMarineDeberiaNoDaniarAUnGoliatPorPertenecerAlMismoJugador()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugador = new JugadorTerran();
		Marine soldado = new Marine(jugador);
		Unidad soldadoAliado = new Golliat(jugador);
		Coordenada coordenadaCasillaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaCasillaSoldadoAliado = new Coordenada(1, 2);
		Casilla casillaSoldado = new Casilla(coordenadaCasillaSoldado);
		Casilla casillaSoldadoAliado = new Casilla(
				coordenadaCasillaSoldadoAliado);

		soldado.posicionar(casillaSoldado);
		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldado.atacarEnemigo(soldadoAliado);

	}

	@Test
	public void unMarineDeberiaNoDaniarAUnGoliatPorEstarFueraDelRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaSoldadoAliado = new Coordenada(1, 1);
		Coordenada coordenadaSoldadoEnemigo = new Coordenada(10, 10);
		Casilla casillaSoldadoAliado = new Casilla(coordenadaSoldadoAliado);
		Casilla casillaSoldadoEnemigo = new Casilla(coordenadaSoldadoEnemigo);

		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldadoEnemigo.posicionar(casillaSoldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(125, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void unMarineDeberiaDaniarAUnGoliatPorEstarElElRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Mapa mapa = new Mapa(2);
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(119, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void unGolliatNoDeberiaDaniarAUnMarinePorEstarFueraDelRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaCasillaSoldadoAliado = new Coordenada(1, 1);
		Coordenada coordenadaCasillaSoldadoEnemigo = new Coordenada(10, 10);
		Casilla casillaSoldadoAliado = new Casilla(
				coordenadaCasillaSoldadoAliado);
		Casilla casillaSoldadoEnemigo = new Casilla(
				coordenadaCasillaSoldadoEnemigo);

		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldadoEnemigo.posicionar(casillaSoldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(40, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void unGolliatDeberiaDaniarAUnMarinePorEstarEnElRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaCasillaSoldadoAliado = new Coordenada(1, 1);
		Coordenada coordenadaCasillaSoldadoEnemigo = new Coordenada(2, 1);
		Casilla casillaSoldadoAliado = new Casilla(
				coordenadaCasillaSoldadoAliado);
		Casilla casillaSoldadoEnemigo = new Casilla(
				coordenadaCasillaSoldadoEnemigo);

		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldadoEnemigo.posicionar(casillaSoldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(28, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void deberiaPoderMoverseUnGolliatSiNoHayNadieEnEseCasillero() {
		Coordenada coordenadaCasilleroLibre = new Coordenada(1, 2);
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado golliat = new Golliat(jugador);
		golliat.posicionar(casillero);
		Assert.assertTrue(golliat.mover(casilleroLibre));
	}

	@Test
	public void noDeberiaPoderMoverseUnGolliatSiEstaOcupadoElCasillero() {
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casillero = new Casilla(coordenadaCasillero);
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado golliat = new Golliat(jugador);
		UnidadSoldado otroGolliat = new Golliat(jugador);
		otroGolliat.posicionar(casillero);
		Assert.assertFalse(golliat.mover(casillero));
	}

	@Test
	public void deberiaPoderMoverseUnMarineSiNoHayNadieEnEseCasillero() {
		Coordenada coordenadaCasilleroLibre = new Coordenada(1, 2);
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado marine = new Marine(jugador);
		marine.posicionar(casillero);
		Assert.assertTrue(marine.mover(casilleroLibre));
	}

	@Test
	public void noDeberiaPoderMoverseUnMarineSiEstaOcupadoElCasillero() {
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casillero = new Casilla(coordenadaCasillero);
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado marine = new Golliat(jugador);
		UnidadSoldado otroMarine = new Marine(jugador);
		otroMarine.posicionar(casillero);
		Assert.assertFalse(marine.mover(casillero));
	}

	@Test(expected = NoPuedeAtacarMultiplesVecesError.class)
	public void unMarineNoDeberiaPoderAtacarMasDeUnaVez()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Mapa mapa = new Mapa(2);
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
	}
	
	public void unMarinePuedeVolverAAtacarLuegoDePasarUnTurno()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Mapa mapa = new Mapa(2);
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Marine soldadoAliado = new Marine(jugadorAliado);
		Unidad soldadoEnemigo = new Golliat(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		soldadoAliado.pasarTurno();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		
		Assert.assertEquals(115, soldadoEnemigo.vidaRestante());
	}
	
	@Test(expected = NoPuedeAtacarMultiplesVecesError.class)
	public void unGolliatNoDeberiaPoderAtacarMasDeUnaVez()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Mapa mapa = new Mapa(2);
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
	}
	
	public void unGolliatPuedeVolverAAtacarLuegoDePasarUnTurno()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Mapa mapa = new Mapa(2);
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		soldadoAliado.pasarTurno();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		
		Assert.assertEquals(16, soldadoEnemigo.vidaRestante());
	}

}
