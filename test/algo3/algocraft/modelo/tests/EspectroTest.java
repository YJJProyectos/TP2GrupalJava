package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.ComportamientoEspectro;

public class EspectroTest {
	
	@Test
	public void deberiaEstarDetruido() throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);
		espectro.recibirDanio(1000);

		Assert.assertTrue(espectro.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruido() throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);
		espectro.recibirDanio(5);

		Assert.assertFalse(espectro.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio() throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);
		int vidaInicial = espectro.vidaRestante();
		espectro.recibirDanio(1);
		int vidaFinal = espectro.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void deberiaQuedarle119DeVida()
			throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);
		espectro.recibirDanio(1);

		Assert.assertEquals(119, espectro.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseEnUnaCasillaDesocupada() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);

		Assert.assertTrue(espectro.posicionar(casilla));
	}

	@Test
	public void deberiaPoderPosicionarseEnUnaCasillaConAireDesocupado() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		JugadorTerran jugador = new JugadorTerran();
		Golliat golliat = new Golliat(jugador);
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);
		golliat.posicionar(casilla);

		Assert.assertTrue(espectro.posicionar(casilla));
	}
	
	@Test
	public void deberiaNoPoderPosicionarseEnUnaCasillaConAireOcupado() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado espectro1 = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);
		UnidadSoldado espectro2 = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);
		espectro1.posicionar(casilla);

		Assert.assertFalse(espectro2.posicionar(casilla));
	}

	@Test
	public void deberiaGuardarSuPosicion() {
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);

		espectro.posicionar(casilla);

		Assert.assertEquals(casilla, espectro.posicion());
	}

	@Test
	public void deberiaNoSerUnaUnidadTerrestre() {
		JugadorTerran jugador = new JugadorTerran();
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugador);

		Assert.assertFalse(espectro.esTerrestre());
	}

	@Test
	public void deberiaNoDaniarFueraDeRango()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugadorAliado);
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
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Unidad soldadoEnemigo = new Marine(jugadorEnemigo);
		UnidadSoldado espectro = new UnidadSoldado(ComportamientoEspectro.getInstancia(),jugadorAliado);
		espectro.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla (new Coordenada(2, 1)));
		espectro.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(32, soldadoEnemigo.vidaRestante());

	}

}
