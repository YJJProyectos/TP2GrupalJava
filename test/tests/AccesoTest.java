package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.edificables.Acceso;


public class AccesoTest {

	@Test
	public void deberiaTransportarUnZealot() {
		Acceso acceso = new Acceso();

		Assert.assertTrue(acceso.transportarZealot());
	}

}
