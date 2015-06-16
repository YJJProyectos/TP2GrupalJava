package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;

public class VolcanDeGasVespenoTest {
	@Test
	public void sePuedeExtraer10DeGasDelVolcanCon100DeGas() {
		Recurso volcan = new VolcanDeGasVespeno(100);
		Assert.assertEquals(10, volcan.extraerRecurso(10));
	}

	@Test
	public void siElVolcanTiene4DeGasYSeQuierenExtraer6SeExtraen4DelGas() {
		Recurso volcan = new VolcanDeGasVespeno(4);
		Assert.assertEquals(4, volcan.extraerRecurso(6));
	}

	@Test
	public void unVolcanQueSeInicializaCon10DeGasTiene10Gases() {
		Recurso volcan = new VolcanDeGasVespeno(10);
		Assert.assertEquals(10, volcan.getCantidad());
	}

	@Test
	public void unVolcanQueSeInicializaCon10DeGasYSeLeQuitan2LeQueda8DeGas() {
		Recurso volcan = new VolcanDeGasVespeno(10);
		volcan.extraerRecurso(2);
		Assert.assertEquals(8, volcan.getCantidad());
	}
}
