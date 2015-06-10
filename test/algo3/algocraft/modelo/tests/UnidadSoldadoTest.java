package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Golliat;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Marine;
import algo3.algocraft.modelo.unidades.unidadesSoldados.UnidadSoldado;

public class UnidadSoldadoTest {
	
	@Test
	public void unMarineEsUnaUnidadTerrestre(){
		Marine soldado = new Marine();
		
		Assert.assertTrue(soldado.esTerrestre());
	}
	
	@Test
	public void unGolliatEsUnaUnidadTerrestre(){
		Golliat soldado = new Golliat();
		
		Assert.assertTrue(soldado.esTerrestre());
	}

	@Test
	public void unMarineDeberiaNoDaniarAUnGoliatPorEstarFueraDelRango() {

		Marine soldadoAliado = new Marine();
		Unidad soldadoEnemigo = new Golliat();
		Coordenada coordenadaCasillaSoldadoAliado = new Coordenada(1, 1);
		Coordenada coordenadaCasillaSoldadoEnemigo = new Coordenada(10, 10);
		Casilla casillaSoldadoAliado = new Casilla(coordenadaCasillaSoldadoAliado);
		Casilla casillaSoldadoEnemigo = new Casilla(coordenadaCasillaSoldadoEnemigo);

		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldadoEnemigo.posicionar(casillaSoldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(125, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void unMarineDeberiaDaniarAUnGoliatPorEstarElElRango() {

		Mapa mapa = new Mapa(2);
		Marine soldadoAliado = new Marine();
		Unidad soldadoEnemigo = new Golliat();
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(119, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void unGolliatNoDeberiaDaniarAUnMarinePorEstarFueraDelRango() {

		Golliat soldadoAliado = new Golliat();
		Unidad soldadoEnemigo = new Marine();
		Coordenada coordenadaCasillaSoldadoAliado = new Coordenada(1, 1);
		Coordenada coordenadaCasillaSoldadoEnemigo = new Coordenada(10, 10);
		Casilla casillaSoldadoAliado = new Casilla(coordenadaCasillaSoldadoAliado);
		Casilla casillaSoldadoEnemigo = new Casilla(coordenadaCasillaSoldadoEnemigo);

		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldadoEnemigo.posicionar(casillaSoldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(40, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void unGolliatDeberiaDaniarAUnMarinePorEstarEnElRango() {

		Golliat soldadoAliado = new Golliat();
		Unidad soldadoEnemigo = new Marine();
		Coordenada coordenadaCasillaSoldadoAliado = new Coordenada(1, 1);
		Coordenada coordenadaCasillaSoldadoEnemigo = new Coordenada(2, 1);
		Casilla casillaSoldadoAliado = new Casilla(coordenadaCasillaSoldadoAliado);
		Casilla casillaSoldadoEnemigo = new Casilla(coordenadaCasillaSoldadoEnemigo);

		soldadoAliado.posicionar(casillaSoldadoAliado);
		soldadoEnemigo.posicionar(casillaSoldadoEnemigo);
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(28, soldadoEnemigo.vidaRestante());

	}

	@Test
	public void deberiaPoderMoverseUnGolliatSiNoHayNadieEnEseCasillero() {
		Coordenada coordenadaCasilleroLibre = new Coordenada(1,2);
		Coordenada coordenadaCasillero = new Coordenada(1,1);		
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		UnidadSoldado golliat = new Golliat();
		golliat.posicionar(casillero);
		Assert.assertTrue(golliat.mover(casilleroLibre));
	}

	@Test
	public void noDeberiaPoderMoverseUnGolliatSiEstaOcupadoElCasillero() {
		
		Coordenada coordenadaCasillero = new Coordenada(1,1);
		Casilla casillero = new Casilla(coordenadaCasillero);
		UnidadSoldado golliat = new Golliat();
		UnidadSoldado otroGolliat = new Golliat();
		otroGolliat.posicionar(casillero);
		Assert.assertFalse(golliat.mover(casillero));
	}
	
	@Test
	public void deberiaPoderMoverseUnMarineSiNoHayNadieEnEseCasillero() {
		Coordenada coordenadaCasilleroLibre = new Coordenada(1,2);
		Coordenada coordenadaCasillero = new Coordenada(1,1);		
		Casilla casilleroLibre = new Casilla(coordenadaCasilleroLibre);
		Casilla casillero = new Casilla(coordenadaCasillero);
		UnidadSoldado marine = new Marine();
		marine.posicionar(casillero);
		Assert.assertTrue(marine.mover(casilleroLibre));
	}

	@Test
	public void noDeberiaPoderMoverseUnMarineSiEstaOcupadoElCasillero() {
		Coordenada coordenadaCasillero = new Coordenada(1,1);
		Casilla casillero = new Casilla(coordenadaCasillero);
		UnidadSoldado marine = new Golliat();
		UnidadSoldado otroMarine = new Marine();
		otroMarine.posicionar(casillero);
		Assert.assertFalse(marine.mover(casillero));
	}

}
