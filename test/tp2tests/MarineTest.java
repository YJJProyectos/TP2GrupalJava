package tp2tests;

import interfaces.Peleable;

import org.junit.Assert;
import org.junit.Test;
import peleables.Marine;
import peleables.Golliat;

public class MarineTest {

	@Test
	public void deberiaRecibirDanio() {

		Marine soldado = new Marine();
		int vidaInicial = soldado.vidaRestante();
		soldado.recibirDanio(1);
		int vidaFinal = soldado.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}
	
	@Test
	public void atacarEnemigo() {
		
		Marine soldadoAliado = new Marine();
		Peleable soldadoEnemigo = new Golliat();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);
		
		Assert.assertEquals(119, soldadoEnemigo.vidaRestante());
	}
	
	@Test
	public void deberiaEstarDetruido(){
		
		Marine soldado = new Marine();
		soldado.recibirDanio(1000);
		
		Assert.assertTrue(soldado.estaDestruido());
	}

}
