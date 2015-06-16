package algo3.algocraft.modelo.tests;


import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Recolector;


public class RecolectorTest {
	@Test
	public void deberiaRecolectarMineralElCentroDeMineral() {
		MinaDeMinerales mineral = new MinaDeMinerales(30);
		Recolector centroDeMineral = new CentroDeMineral(mineral);
		Assert.assertTrue(centroDeMineral.recolectar());
	}

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
		Assert.assertEquals(20, mineral.getCantidad());
	}
}