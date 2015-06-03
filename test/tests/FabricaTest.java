package tests;

import org.junit.Assert;
import org.junit.Test;

import edificables.Fabrica;

public class FabricaTest {

	@Test
	public void deberiaEntrenarUnGolliat(){
		Fabrica fabrica = new Fabrica();
		Assert.assertTrue(fabrica.entrenarGolliat());
	}

}
