package tests;

import imponibles.CentroDeMineral;
import imponibles.Recolector;

import org.junit.Assert;
import org.junit.Test;

import recolectables.Mineral;

public class RecoleccionTest {
	@Test
	public void deberiaRecolectarMineralElCentroDeMineral() {
		Mineral mineral = new Mineral(30);
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
		Mineral mineral = new Mineral(1000);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		for (int i = 1; i <= 100; i++) { // 100 turnos , se saca todo el mineral
			centroDeMineral.recolectar();
		}
		Assert.assertFalse(centroDeMineral.recolectar());
	}

	@Test
	public void deberiaRecolectar50MineralEn5TurnosElCentroDeMineral() {
		Mineral mineral = new Mineral(1000);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		for (int i = 1; i <= 5; i++) {
			centroDeMineral.recolectar();
		}
		Assert.assertEquals(50, centroDeMineral.getCantidadRecursoRecolectado());
	}

	@Test
	public void deberiaRecolectarSiElMineralTiene7() {
		Mineral mineral = new Mineral(7);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		centroDeMineral.recolectar();
		Assert.assertEquals(7, centroDeMineral.getCantidadRecursoRecolectado());
	}
	@Test
	public void deberiaDecrementarEn10ElMineralAlSerRecolectado(){
		Mineral mineral = new Mineral(30);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		centroDeMineral.recolectar();
		Assert.assertEquals(20, mineral.getCantidadMineral());
	}
}