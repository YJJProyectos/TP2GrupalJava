package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class GolliatTest {

	@Test
	public void deberiaEstarDetruidoElGolliat() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		golliat.recibirDanio(1000,1000);

		Assert.assertTrue(golliat.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruidoElGolliat() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		golliat.recibirDanio(5,5);

		Assert.assertFalse(golliat.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio1() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		int vidaInicial = golliat.vidaRestante();
		golliat.recibirDanio(1,1);
		int vidaFinal = golliat.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void deberiaQuedarle124DeVida()
			throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		golliat.recibirDanio(1,1);

		Assert.assertEquals(124, golliat.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarse() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);

		Assert.assertTrue(golliat.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnGolliatEnUnaCasillaOcupada() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		Golliat primerGolliat = new Golliat(jugador);
		Golliat segundoGolliat = new Golliat(jugador);
		primerGolliat.posicionar(casilla);

		Assert.assertFalse(segundoGolliat.posicionar(casilla));
	}

	@Test
	public void deberiaGuardarSuPosicion() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);

		golliat.posicionar(casilla);

		Assert.assertEquals(casilla, golliat.posicion());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		golliat.recibirDanio(200,200);
		Assert.assertTrue(golliat.estaDestruido());
		golliat.recibirDanio(2,2);

	}

	@Test(expected = PerteneceAlMismoJugadorError.class)
	public void unGolliatDeberiaNoDaniarAUnMarinePorPertenecerAlMismoJugador()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Jugador jugador = new Jugador();
		Golliat soldado = new Golliat(jugador);
		Unidad soldadoAliado = new Marine(jugador);
		Coordenada coordenadaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaAliado = new Coordenada(1, 2);
		Casilla casillaSoldado = new Casilla(coordenadaSoldado);
		Casilla casillaAliado = new Casilla(coordenadaAliado);
		soldado.posicionar(casillaSoldado);
		soldadoAliado.posicionar(casillaAliado);
		soldado.atacarEnemigo(soldadoAliado);

	}

	@Test
	public void unGolliatDeberiaNoDaniarAUnMarinePorEstarFueraDelRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaAliado = new Coordenada(10, 10);
		Casilla casillaSoldado = new Casilla(coordenadaSoldado);
		Casilla casillaAliado = new Casilla(coordenadaAliado);

		soldadoAliado.posicionar(casillaSoldado);
		soldadoEnemigo.posicionar(casillaAliado);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(40, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void unGolliatDeberiaDaniarAUnMarinePorEstarElElRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Golliat soldadoAliado = new Golliat(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(28, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void deberiaPoderMoverseUnGolliatSiNoHayNadieEnEseCasillero() {
		Coordenada coordenadaCasilleroLibre = new Coordenada(1, 2);
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		golliat.posicionar(casillero);
		Assert.assertTrue(golliat.mover(casilleroLibre));
	}

	@Test
	public void noDeberiaPoderMoverseUnGolliatSiEstaOcupadoElCasillero() {
		Coordenada coordenadaCasillero = new Coordenada(1, 1);
		Casilla casillero = new Casilla(coordenadaCasillero);
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		Unidad otroGolliat = new Golliat(jugador);
		otroGolliat.posicionar(casillero);
		Assert.assertFalse(golliat.mover(casillero));
	}

	@Test(expected = NoPuedeAtacarMultiplesVecesError.class)
	public void unGolliatNoDeberiaPoderAtacarMasDeUnaVez()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Mapa mapa = new Mapa(2);
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
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
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
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
