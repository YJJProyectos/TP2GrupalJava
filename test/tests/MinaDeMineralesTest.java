package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.recolectables.MinaDeMinerales;

public class MinaDeMineralesTest {

	@Test
	public void sePuedeExtraer10MineralesDeLaMinaCon100Minerales() {
		MinaDeMinerales mina = new MinaDeMinerales(100);
		Assert.assertEquals(10, mina.extraerRecurso(10));
	}
	@Test
	public void siLaMinaTiene4MineralesYSeQuierenExtraer6SeExtraen4Minerales() {
		MinaDeMinerales mina = new MinaDeMinerales(4);
		Assert.assertEquals(4, mina.extraerRecurso(6));
	}
	
	@Test
	public void unaminaQueSeInicializaCon10MineralesTiene10Minerales(){
		MinaDeMinerales mina = new MinaDeMinerales(10);
		Assert.assertEquals(10, mina.getCantidadMineral());
	}
	
	@Test
	public void unaminaQueSeInicializaCon10MineralesYSeLeQuitan2Tiene8Minerales(){
		MinaDeMinerales mina = new MinaDeMinerales(10);
		mina.extraerRecurso(2);
		Assert.assertEquals(8, mina.getCantidadMineral());
	}
}
