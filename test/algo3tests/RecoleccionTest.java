package algo3tests;

import org.junit.Assert;
import org.junit.Test;

import Recolectables.Asimilador;
import Recolectables.CentroDeMineral;
import Recolectables.NexoMineral;
import Recolectables.Recolectable;
import Recolectables.Refineria;
import algo3.Gas;
import algo3.Mineral;

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
	public void deberiaRecolectarGasElAsimilador(){
		Gas gas = new Gas();
		Recolectable asimilador = new Asimilador();
		Assert.assertTrue(asimilador.Recolectar(gas));
	}
	
	@Test
	public void deberiaRecolectarMineralElNexoMineral(){
		Mineral mineral = new Mineral();
		Recolectable nexoMineral = new NexoMineral();
		Assert.assertTrue(nexoMineral.Recolectar(mineral));		
	}
}