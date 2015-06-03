package tests;

import interfaces.Ocupable;
import interfaces.Peleable;

import ocupables.CasillaTerrestre;

import org.junit.Assert;
import org.junit.Test;


import peleables.Golliat;
import peleables.Marine;

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
		Ocupable casilleroLibre = new CasillaTerrestre();
		Ocupable casillero = new CasillaTerrestre();
		Peleable golliat = new Golliat();
		golliat.posicionar(casillero);
		Assert.assertTrue(golliat.mover(casilleroLibre));
	}
	@Test
	public void noDeberiaPoderMoverseSiEstaOcupadoElCasillero(){
		Ocupable casillero = new CasillaTerrestre();
		Peleable golliat = new Golliat();
		Peleable otroGolliat = new Golliat();
		otroGolliat.posicionar(casillero);
		Assert.assertFalse(golliat.mover(casillero));
	}
}
