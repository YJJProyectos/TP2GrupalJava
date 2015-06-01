package tp2tests;


import org.junit.Assert;
import org.junit.Test;

import recolectables.Asimilador;
import recolectables.CentroDeMineral;
import recolectables.NexoMineral;
import recolectables.Recolectable;
import recolectables.Refineria;
import tp2.GasVespeno;
import tp2.Mineral;

public class RecoleccionTest {

	@Test
	public void deberiaRecolectarGasLaRefineria() {
		GasVespeno gas = new GasVespeno();
		Recolectable refineria = new Refineria(gas);
		Assert.assertTrue(refineria.Recolectar());
	}

	@Test
	public void deberiaRecolectarMineralElCentroDeMineral() {

		Mineral mineral = new Mineral();
		Recolectable centroDeMineral = new CentroDeMineral(mineral);
		Assert.assertTrue(centroDeMineral.Recolectar());

	}

	@Test
	public void deberiaRecolectarGasElAsimilador() {
		GasVespeno gas = new GasVespeno();
		Recolectable asimilador = new Asimilador(gas);
		Assert.assertTrue(asimilador.Recolectar());
	}

	@Test
	public void deberiaRecolectarMineralElNexoMineral() {
		Mineral mineral = new Mineral();
		Recolectable nexoMineral = new NexoMineral(mineral);
		Assert.assertTrue(nexoMineral.Recolectar());
	}
	@Test
	public void noDeberiaPoderRecolectarElCentroDeMineralSiSeAcabaElMineral(){
		Mineral mineral = new Mineral();
		Recolectable centroDeMineral = new CentroDeMineral(mineral);
		for (int i = 1; i <= 100; i++ ){  // 100 turnos , se saca todo el mineral
			centroDeMineral.Recolectar();
		}
		Assert.assertFalse(centroDeMineral.Recolectar());
	}
	@Test
	public void deberiaRecolectar50MineralEn5TurnosElCentroDeMineral(){
		Mineral mineral = new Mineral();
		Recolectable centroDeMineral = new CentroDeMineral(mineral);
		for (int i = 1; i <= 5; i++ ){  
			centroDeMineral.Recolectar();
		}	
		Assert.assertEquals(50, centroDeMineral.getCantidadRecursoRecolectado());
	}
}