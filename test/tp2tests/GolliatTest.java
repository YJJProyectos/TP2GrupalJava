package tp2tests;

import interfaces.Peleable;

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
}
