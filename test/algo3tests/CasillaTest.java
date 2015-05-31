package algo3tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.CasillaTerrestre;

public class CasillaTest {

	@Test
	public void deberiaNoEstarOcupada() {
		CasillaTerrestre casilla = new CasillaTerrestre();

		Assert.assertFalse(casilla.esta_ocupada());
	}

}
