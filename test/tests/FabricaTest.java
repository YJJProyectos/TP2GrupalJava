package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.edificables.Barraca;
import algo3.algocraft.modelo.edificables.Fabrica;


public class FabricaTest {

	@Test
	public void deberiaNoEntrenarUnGolliat(){
		Fabrica fabrica = new Fabrica(null);
		Assert.assertFalse(fabrica.entrenarGolliat());
	}
	
	@Test
	public void deberiaEntrenarUnGolliat(){
		Barraca barraca = new Barraca();
		
		Fabrica fabrica = new Fabrica(barraca);
		
		Assert.assertTrue(fabrica.entrenarGolliat());
	}
	
}
