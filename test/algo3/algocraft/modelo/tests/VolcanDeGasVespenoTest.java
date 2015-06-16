package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;

public class VolcanDeGasVespenoTest {
	@Test
	public void sePuedeExtraer10LitrosDeGasDelVolcanCon100Litros() {
		Recurso volcan = new VolcanDeGasVespeno(100);
		Assert.assertEquals(10, volcan.extraerRecurso(10));
	}

	@Test
	public void siLaMinaTiene4MineralesYSeQuierenExtraer6SeExtraen4Minerales() {
		Recurso volcan = new VolcanDeGasVespeno(4);
		Assert.assertEquals(4, volcan.extraerRecurso(6));
	}

	@Test
	public void unaminaQueSeInicializaCon10MineralesTiene10Minerales() {
		Recurso volcan = new VolcanDeGasVespeno(10);
		Assert.assertEquals(10, volcan.getCantidad());
	}

	@Test
	public void unaminaQueSeInicializaCon10MineralesYSeLeQuitan2Tiene8Minerales() {
		Recurso volcan = new VolcanDeGasVespeno(10);
		volcan.extraerRecurso(2);
		Assert.assertEquals(8, volcan.getCantidad());
	}
}
