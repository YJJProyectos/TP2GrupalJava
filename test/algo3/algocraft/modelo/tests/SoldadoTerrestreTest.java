package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.SoldadoTerrestre;

public class SoldadoTerrestreTest {
	
	@Test
	public void deberiaEstarDetruido() throws YaEstaDestruidoError {
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat", null);
		golliat.recibirDanio(1000);

		Assert.assertTrue(golliat.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruidoElGolliat() throws YaEstaDestruidoError {
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat", null);
		golliat.recibirDanio(5);

		Assert.assertFalse(golliat.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio() throws YaEstaDestruidoError {
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat", null);
		int vidaInicial = golliat.vidaRestante();
		golliat.recibirDanio(1);
		int vidaFinal = golliat.vidaRestante();

		Assert.assertNotEquals(vidaInicial, vidaFinal);
	}

	@Test
	public void deberiaQuedarle124DeVida()
			throws YaEstaDestruidoError {
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat", null);
		golliat.recibirDanio(1);

		Assert.assertEquals(124, golliat.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnGollatEnUnaCasillaDesocupada() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat", null);

		Assert.assertTrue(golliat.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnGolliatEnUnaCasillaOcupada() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		SoldadoTerrestre golliat1 = new SoldadoTerrestre("Golliat", null);
		SoldadoTerrestre golliat2 = new SoldadoTerrestre("Golliat", null);
		
		golliat1.posicionar(casilla);

		Assert.assertFalse(golliat2.posicionar(casilla));
	}

	@Test
	public void deberiaGuardarSuPosicion() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat",null);

		golliat.posicionar(casilla);

		Assert.assertEquals(casilla, golliat.posicion());
	}

	@Test
	public void deberiaSerUnaUnidadTerrestre() {
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat", null);

		Assert.assertTrue(golliat.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError {
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat",null);
		
		golliat.recibirDanio(200);
		Assert.assertTrue(golliat.estaDestruido());
		
		golliat.recibirDanio(2);
	}

	@Test(expected = PerteneceAlMismoJugadorError.class)
	public void deberiaNoDaniarAliados()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError, NoPuedeAtacarMultiplesVecesError {
		
		JugadorTerran jugador = new JugadorTerran();
		SoldadoTerrestre soldado = new SoldadoTerrestre("Golliat",jugador);
		Unidad soldadoAliado = new SoldadoTerrestre("Marine",jugador);
		Coordenada coordenadaSoldado = new Coordenada(1, 1);
		Coordenada coordenadaAliado = new Coordenada(1, 2);
		Casilla casillaSoldado = new Casilla(coordenadaSoldado);
		Casilla casillaAliado = new Casilla(coordenadaAliado);
		soldado.posicionar(casillaSoldado);
		soldadoAliado.posicionar(casillaAliado);
		
		soldado.atacarEnemigo(soldadoAliado);

	}

	@Test
	public void deberiaNoDaniarAfueraDeSuRangoUnGolliat()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		SoldadoTerrestre soldadoAliado = new SoldadoTerrestre("Golliat",jugadorAliado);
		Unidad soldadoEnemigo = new SoldadoTerrestre("Marine", jugadorEnemigo);
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
	public void deberiaNoDaniarAfueraDeSuRangoUnMarine()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		SoldadoTerrestre soldadoAliado = new SoldadoTerrestre("Marine",jugadorAliado);
		Unidad soldadoEnemigo = new SoldadoTerrestre("Marine", jugadorEnemigo);
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
	public void deberiaDaniarDentroDelRangoUnGolliat()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		SoldadoTerrestre soldadoAliado = new SoldadoTerrestre("Golliat",jugadorAliado);
		Unidad soldadoEnemigo = new SoldadoTerrestre("Marine", jugadorEnemigo);
		
		soldadoAliado.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(2, 1)));

		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(28, soldadoEnemigo.vidaRestante());

	}
	
	@Test
	public void deberiaDaniarDentroDelRangoUnMarine()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		SoldadoTerrestre soldadoAliado = new SoldadoTerrestre("Marine",jugadorAliado);
		Unidad soldadoEnemigo = new SoldadoTerrestre("Marine", jugadorEnemigo);
		
		soldadoAliado.posicionar(new Casilla(new Coordenada(1, 1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(2, 1)));

		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(34, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void deberiaPoderMoverseAUnCasilleroLibre() {
		
		Casilla casilleroLibre = new Casilla(new Coordenada(1, 2));
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat", null);
		golliat.posicionar(new Casilla(new Coordenada(1, 1)));
	
		Assert.assertTrue(golliat.mover(casilleroLibre));
	}

	@Test
	public void deberiaNoPoderMoverseAUnCasilleroOcupado() {
		
		Casilla casillero = new Casilla(new Coordenada(1, 1));
		SoldadoTerrestre golliat = new SoldadoTerrestre("Golliat",null);
		Unidad otroGolliat = new SoldadoTerrestre("Golliat",null);
		otroGolliat.posicionar(casillero);
		
		Assert.assertFalse(golliat.mover(casillero));
	}

	@Test(expected = NoPuedeAtacarMultiplesVecesError.class)
	public void deberiaNoPoderAtacarMasDeUnaVez() throws 
		YaEstaDestruidoError, PerteneceAlMismoJugadorError,NoPuedeAtacarMultiplesVecesError {
		
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		SoldadoTerrestre soldadoAliado = new SoldadoTerrestre("Golliat",jugadorAliado);
		SoldadoTerrestre soldadoEnemigo = new SoldadoTerrestre("Marine",jugadorEnemigo);
		soldadoAliado.posicionar(new Casilla(new Coordenada(1,1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(1,1)));
		
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
	}

	public void deberiaPoderVolverAAtacarLuegoDePasarUnTurno()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {
		
		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		SoldadoTerrestre soldadoAliado = new SoldadoTerrestre("Golliat",jugadorAliado);
		Unidad soldadoEnemigo = new SoldadoTerrestre("Marine",jugadorEnemigo);
		soldadoAliado.posicionar(new Casilla(new Coordenada(1,1)));
		soldadoEnemigo.posicionar(new Casilla(new Coordenada(2,1)));
				
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		soldadoAliado.pasarTurno();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(16, soldadoEnemigo.vidaRestante());
	}

}
