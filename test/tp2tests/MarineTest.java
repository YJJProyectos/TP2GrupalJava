package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import peleables.Marine;

public class MarineTest {

	@Test
	public void deberiaRecibirDanio() {

		Marine soldado = new Marine();
		int vidaInicial = soldado.vidaRestante();
		soldado.recibirDanio(1);
		int vidaFinal = soldado.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}
	//@Test
	//public void atacarEnemigo() {
	//	Marine soldadoAliado = new Marine();
	//	Marine soldadoEnemigo = new Marine();
	//	soldadoAliado.atacarEnemigo(soldadoEnemigo);
		
	//	Assert.assertEquals(34, soldadoEnemigo.vidaRestante());
	//}

}
