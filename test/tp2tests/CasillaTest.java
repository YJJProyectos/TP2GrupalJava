package tp2tests;


import org.junit.Assert;
import org.junit.Test;

import tp2.CasillaTerrestre;


public class CasillaTest {

	@Test
	public void deberiaNoEstarOcupada() {
		CasillaTerrestre casilla = new CasillaTerrestre();

		Assert.assertFalse(casilla.esta_ocupada());
	}

}
