package tp2tests;

import interfaces.Peleable;

import org.junit.Assert;
import org.junit.Test;
import peleables.Marine;
import peleables.Golliat;

public class MarineTest {
	
	@Test
	public void deberiaDaniarEnemigo() {
		
		Marine soldadoAliado = new Marine();
		Peleable soldadoEnemigo = new Golliat();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		
		Assert.assertEquals(119, soldadoEnemigo.vidaRestante());
	}
	
}
