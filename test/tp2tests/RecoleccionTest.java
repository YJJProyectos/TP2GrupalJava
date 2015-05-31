package tp2tests;


import org.junit.Assert;
import org.junit.Test;

import recolectables.Asimilador;
import recolectables.CentroDeMineral;
import recolectables.NexoMineral;
import recolectables.Recolectable;
import recolectables.Refineria;
import tp2.Gas;
import tp2.Mineral;

public class RecoleccionTest {

	@Test
	public void deberiaRecolectarGasLaRefineria() {
		Gas gas = new Gas();
		Recolectable refineria = new Refineria();
		Assert.assertTrue(refineria.Recolectar(gas));
	}

	@Test
	public void deberiaRecolectarMineralElCentroDeMineral() {

		Mineral mineral = new Mineral();
		Recolectable centroDeMineral = new CentroDeMineral();
		Assert.assertTrue(centroDeMineral.Recolectar(mineral));

	}

	@Test
	public void deberiaRecolectarGasElAsimilador() {
		Gas gas = new Gas();
		Recolectable asimilador = new Asimilador();
		Assert.assertTrue(asimilador.Recolectar(gas));
	}

	@Test
	public void deberiaRecolectarMineralElNexoMineral() {
		Mineral mineral = new Mineral();
		Recolectable nexoMineral = new NexoMineral();
		Assert.assertTrue(nexoMineral.Recolectar(mineral));
	}
}