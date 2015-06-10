package tests;


import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.imponibles.CentroDeMineral;
import algo3.algocraft.modelo.imponibles.Recolector;
import algo3.algocraft.modelo.recolectables.MinaDeMinerales;


public class RecoleccionTest {
	@Test
	public void deberiaRecolectarMineralElCentroDeMineral() {
		MinaDeMinerales mineral = new MinaDeMinerales(30);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		Assert.assertTrue(centroDeMineral.recolectar());
	}

	// @Test
	// public void deberiaRecolectarGasLaRefineria() {
	// GasVespeno gas = new GasVespeno();
	// Recolectante refineria = new Refineria(gas);
	// Assert.assertTrue(refineria.recolectar());
	// }

	// @Test
	// public void deberiaRecolectarGasElAsimilador() {
	// GasVespeno gas = new GasVespeno();
	// Recolectante asimilador = new Asimilador(gas);
	// Assert.assertTrue(asimilador.recolectar());
	// }

	// @Test
	// public void deberiaRecolectarMineralElNexoMineral() {
	// Mineral mineral = new Mineral(10);
	// Recolectante nexoMineral = new NexoMineral(mineral);
	// Assert.assertTrue(nexoMineral.recolectar());
	// }

	@Test
	public void deberiaNoPoderRecolectarElCentroDeMineralSiSeAcabaElMineral() {
		MinaDeMinerales mineral = new MinaDeMinerales(1000);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		for (int i = 1; i <= 100; i++) { // 100 turnos , se saca todo el mineral
			centroDeMineral.recolectar();
		}
		Assert.assertFalse(centroDeMineral.recolectar());
	}

	@Test
	public void deberiaRecolectar50MineralEn5TurnosElCentroDeMineral() {
		MinaDeMinerales mineral = new MinaDeMinerales(1000);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		for (int i = 1; i <= 5; i++) {
			centroDeMineral.recolectar();
		}
		Assert.assertEquals(50, centroDeMineral.getCantidadRecursoRecolectado());
	}

	@Test
	public void deberiaRecolectarSiElMineralTiene7() {
		MinaDeMinerales mineral = new MinaDeMinerales(7);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		centroDeMineral.recolectar();
		Assert.assertEquals(7, centroDeMineral.getCantidadRecursoRecolectado());
	}
	@Test
	public void deberiaDecrementarEn10ElMineralAlSerRecolectado(){
		MinaDeMinerales mineral = new MinaDeMinerales(30);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		centroDeMineral.recolectar();
		Assert.assertEquals(20, mineral.getCantidadMineral());
	}
}