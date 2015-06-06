package tests;


import mapa.Casilla;

import org.junit.Assert;
import org.junit.Test;

import peleables.Golliat;
import peleables.Marine;
import peleables.Peleable;

public class GolliatTest {

	@Test
	public void deberiaDaniarEnemigo() {

		Golliat soldadoAliado = new Golliat();
		Peleable soldadoEnemigo = new Marine();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(28, soldadoEnemigo.vidaRestante());
	}
	@Test
	public void deberiaPoderMoverseSiNoHayNadieEnEseCasillero(){
		Casilla casilleroLibre = new Casilla();
		Casilla casillero = new Casilla();
		Peleable golliat = new Golliat();
		golliat.posicionar(casillero);
		Assert.assertTrue(golliat.mover(casilleroLibre));
	}
	@Test
	public void noDeberiaPoderMoverseSiEstaOcupadoElCasillero(){
		Casilla casillero = new Casilla();
		Peleable golliat = new Golliat();
		Peleable otroGolliat = new Golliat();
		otroGolliat.posicionar(casillero);
		Assert.assertFalse(golliat.mover(casillero));
	}
}
