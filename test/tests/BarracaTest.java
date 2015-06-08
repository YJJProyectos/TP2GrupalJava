package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.edificables.Barraca;


public class BarracaTest {

	@Test
	public void deberiaEntrenarUnSoldadoMarine() {
		Barraca barraca = new Barraca();

		Assert.assertTrue(barraca.entrenarMarine());
	}

}
