package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import peleables.UnidadSoldado;

public class UnidadSoldadoTest {

	@Test
	public void deberiaRecibirDanio() {

		UnidadSoldado soldado = new UnidadSoldado();
		int vidaInicial = soldado.vidaRestante();
		soldado.recibirDanio(1);
		int vidaFinal = soldado.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

}
