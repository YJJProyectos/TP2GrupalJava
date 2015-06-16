package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.Recurso;

public class MinaDeMineralesTest {

	@Test
	public void sePuedeExtraer10MineralesDeLaMinaCon100Minerales() {
		Recurso mina = new MinaDeMinerales(100);
		Assert.assertEquals(10, mina.extraerRecurso(10));
	}

	@Test
	public void siLaMinaTiene4MineralesYSeQuierenExtraer6SeExtraen4Minerales() {
		Recurso mina = new MinaDeMinerales(4);
		Assert.assertEquals(4, mina.extraerRecurso(6));
	}

	@Test
	public void unaminaQueSeInicializaCon10MineralesTiene10Minerales() {
		Recurso mina = new MinaDeMinerales(10);
		Assert.assertEquals(10, mina.getCantidad());
	}

	@Test
	public void unaminaQueSeInicializaCon10MineralesYSeLeQuitan2Tiene8Minerales() {
		Recurso mina = new MinaDeMinerales(10);
		mina.extraerRecurso(2);
		Assert.assertEquals(8, mina.getCantidad());
	}

}
