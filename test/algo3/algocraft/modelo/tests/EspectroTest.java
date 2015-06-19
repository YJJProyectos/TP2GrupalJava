package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Espectro;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class EspectroTest {
	
	@Test
	public void deberiaEstarDetruido() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		UnidadSoldado espectro = new Espectro(jugador);
		espectro.recibirDanio(1000,1000);

		Assert.assertTrue(espectro.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruido() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		UnidadSoldado espectro = new Espectro(jugador);
		espectro.recibirDanio(5,5);

		Assert.assertFalse(espectro.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio() throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		UnidadSoldado espectro = new Espectro(jugador);
		int vidaInicial = espectro.vidaRestante();
		espectro.recibirDanio(1,1);
		int vidaFinal = espectro.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void deberiaQuedarle119DeVida()
			throws YaEstaDestruidoError {
		Jugador jugador = new Jugador();
		UnidadSoldado espectro = new Espectro(jugador);
		espectro.recibirDanio(1,1);

		Assert.assertEquals(119, espectro.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseEnUnaCasillaDesocupada() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		UnidadSoldado espectro = new Espectro(jugador);

		Assert.assertTrue(espectro.posicionar(casilla));
	}

	@Test
	public void deberiaPoderPosicionarseEnUnaCasillaConAireDesocupado() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		Golliat golliat = new Golliat(jugador);
		UnidadSoldado espectro = new Espectro(jugador);
		golliat.posicionar(casilla);

		Assert.assertTrue(espectro.posicionar(casilla));
	}
	
	@Test
	public void deberiaNoPoderPosicionarseEnUnaCasillaConAireOcupado() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		UnidadSoldado espectro1 = new Espectro(jugador);
		UnidadSoldado espectro2 = new Espectro(jugador);
		espectro1.posicionar(casilla);

		Assert.assertFalse(espectro2.posicionar(casilla));
	}

	@Test
	public void deberiaGuardarSuPosicion() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Jugador jugador = new Jugador();
		UnidadSoldado espectro = new Espectro(jugador);

		espectro.posicionar(casilla);

		Assert.assertEquals(casilla, espectro.posicion());
	}

	@Test
	public void deberiaNoDaniarFueraDeRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		UnidadSoldado espectro = new Espectro(jugadorAliado);
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		Coordenada coordenadaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaAliado = new Coordenada(10, 10);
		Casilla casillaSoldado = new Casilla(coordenadaSoldado);
		Casilla casillaAliado = new Casilla(coordenadaAliado);

		espectro.posicionar(casillaSoldado);
		soldadoEnemigo.posicionar(casillaAliado);
		espectro.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(40, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void deberiaDaniarEnElRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		UnidadSoldado espectro = new Espectro(jugadorAliado);
		espectro.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla (new Coordenada(2, 1)));
		espectro.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(32, soldadoEnemigo.vidaRestante());

	}

}
