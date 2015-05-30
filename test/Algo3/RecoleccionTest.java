package Algo3;

import org.junit.Assert;
import org.junit.Test;

public class RecoleccionTest {

	@Test
	public void deberiaRecolectarGas() {
		Gas gas = new Gas();
		Recolectable refineria = new Refineria();
		Assert.assertTrue(refineria.recolectar(gas));
	}

	@Test
	public void deberiaRecolectarMineral() {

		Mineral mineral = new Mineral();
		Recolectable centroDeMineral = new CentroDeMineral();
		Assert.assertTrue(centroDeMineral.recolectar(mineral));

	}
}