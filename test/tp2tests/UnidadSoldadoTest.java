package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import peleables.UnidadSoldado;

public class UnidadSoldadoTest {

	@Test
	public void deberiaRecibirDanio() {

		UnidadSoldado soldado = new UnidadSoldado();
		int vidaInicial = soldado.getVida();
		soldado.recibir_danio(1);
		int vidaFinal = soldado.getVida();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

}
