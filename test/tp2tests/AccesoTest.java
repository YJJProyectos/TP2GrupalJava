package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import edificables.Acceso;

public class AccesoTest {

	@Test
	public void deberiaTransportarUnZealot() {
		Acceso acceso = new Acceso();

		Assert.assertTrue(acceso.transportarZealot());
	}

}
