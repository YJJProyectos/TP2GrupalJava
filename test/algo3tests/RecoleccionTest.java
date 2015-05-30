package algo3tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.CentroDeMineral;
import algo3.Gas;
import algo3.Mineral;
import algo3.Recolectable;
import algo3.Refineria;

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