package tests;



import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.peleables.Golliat;
import algo3.algocraft.modelo.peleables.Marine;
import algo3.algocraft.modelo.peleables.UnidadSoldado;


public class GolliatTest {

	@Test
	public void deberiaDaniarEnemigo() {

		Golliat soldadoAliado = new Golliat();
		UnidadSoldado soldadoEnemigo = new Marine();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(28, soldadoEnemigo.vidaRestante());
	}
	@Test
	public void deberiaPoderMoverseSiNoHayNadieEnEseCasillero(){
		Casilla casilleroLibre = new Casilla();
		Casilla casillero = new Casilla();
		UnidadSoldado golliat = new Golliat();
		golliat.posicionar(casillero);
		Assert.assertTrue(golliat.mover(casilleroLibre));
	}
	@Test
	public void noDeberiaPoderMoverseSiEstaOcupadoElCasillero(){
		Casilla casillero = new Casilla();
		UnidadSoldado golliat = new Golliat();
		UnidadSoldado otroGolliat = new Golliat();
		otroGolliat.posicionar(casillero);
		Assert.assertFalse(golliat.mover(casillero));
	}
}
