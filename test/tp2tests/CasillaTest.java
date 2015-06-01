package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import tp2.CasillaTerrestre;
import peleables.Peleable;
import peleables.UnidadSoldado;

public class CasillaTest {

	@Test
	public void deberiaNoEstarOcupada() {
		CasillaTerrestre casilla = new CasillaTerrestre();

		Assert.assertFalse(casilla.estaOcupada());
	}

	@Test
	public void deberiaEstarOcupada() {
		CasillaTerrestre casilla = new CasillaTerrestre();

		Peleable soldado = new UnidadSoldado();
		casilla.ocupar(soldado);

		Assert.assertTrue(casilla.estaOcupada());
	}

}
