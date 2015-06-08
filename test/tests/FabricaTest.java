package tests;

import org.junit.Assert;
import org.junit.Test;

import edificables.Fabrica;
import edificables.Barraca;

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
