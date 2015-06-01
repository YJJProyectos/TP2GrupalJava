package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import peleables.Golliat;

public class GolliatTest {

	@Test
	public void deberiaRecibirDanio() {

		Golliat soldado = new Golliat();
		int vidaInicial = soldado.vidaRestante();
		soldado.recibirDanio(1);
		int vidaFinal = soldado.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}
	
}
