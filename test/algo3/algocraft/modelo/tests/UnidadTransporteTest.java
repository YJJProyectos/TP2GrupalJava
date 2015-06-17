package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.unidades.unidadesSoldados.UnidadSoldado;
import algo3.algocraft.modelo.unidades.unidadesSoldados.UnidadTransporte;
import algo3.algocraft.modelo.unidades.unidadesSoldados.comportamientos.ComportamientoMarine;
import algo3.algocraft.modelo.unidades.unidadesSoldados.comportamientos.ComportamientoTransporteTerran;

public class UnidadTransporteTest {
	
	@Test
	public void deberiaCargarUnSoldado() {
		UnidadTransporte nave = new UnidadTransporte(null, new ComportamientoTransporteTerran());
		UnidadSoldado soldado = new UnidadSoldado(ComportamientoMarine.getInstancia(), null);
	
		Assert.assertTrue(nave.cargarSoldado(soldado));
	}
	
	@Test
	public void deberiaNoCargarAlMismoSoldadoDosVeces() {
		UnidadTransporte nave = new UnidadTransporte(null, new ComportamientoTransporteTerran());
		UnidadSoldado soldado = new UnidadSoldado(ComportamientoMarine.getInstancia(), null);
		nave.cargarSoldado(soldado);
		
		Assert.assertFalse(nave.cargarSoldado(soldado));
	}
}
