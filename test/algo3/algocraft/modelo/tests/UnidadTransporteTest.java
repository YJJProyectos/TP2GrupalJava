package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadTransporte;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.ComportamientoMarine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.ComportamientoTransporteTerran;

public class UnidadTransporteTest {
	
	@Test
	public void deberiaCargarUnSoldado() {
		UnidadTransporte nave = new UnidadTransporte(null, ComportamientoTransporteTerran.getInstancia());
		UnidadSoldado soldado = new UnidadSoldado(ComportamientoMarine.getInstancia(), null);
	
		Assert.assertTrue(nave.cargarSoldado(soldado));
	}
	
	@Test
	public void deberiaNoCargarAlMismoSoldadoDosVeces() {
		UnidadTransporte nave = new UnidadTransporte(null,ComportamientoTransporteTerran.getInstancia());
		UnidadSoldado soldado = new UnidadSoldado(ComportamientoMarine.getInstancia(), null);
		nave.cargarSoldado(soldado);
		
		Assert.assertFalse(nave.cargarSoldado(soldado));
	}
	
	@Test
	public void deberiaDescargarUnSoldado () {
		UnidadTransporte nave = new UnidadTransporte(null, ComportamientoTransporteTerran.getInstancia());
		UnidadSoldado soldado = new UnidadSoldado(ComportamientoMarine.getInstancia(), null);
		nave.cargarSoldado(soldado);
		
		Assert.assertEquals(nave.descargarSoldado(), soldado);
	}
	
	@Test
	public void deberiaNoDescargarAlMismoSoldadoDosVeces() {
		UnidadTransporte nave = new UnidadTransporte(null, ComportamientoTransporteTerran.getInstancia());
		UnidadSoldado soldado = new UnidadSoldado(ComportamientoMarine.getInstancia(), null);
		nave.cargarSoldado(soldado);
		nave.descargarSoldado();
		
		Assert.assertNotEquals(nave.descargarSoldado(), soldado);
	}
	
	@Test
	public void deberiaActualizarLaPosicionDelSoldado() {
		UnidadSoldado soldado = new UnidadSoldado(ComportamientoMarine.getInstancia(), null);
		soldado.posicionar(new Casilla(new Coordenada(1,1)));
		UnidadTransporte nave = new UnidadTransporte(null, ComportamientoTransporteTerran.getInstancia());
		
		nave.cargarSoldado(soldado);
		
		Assert.assertEquals(null, soldado.posicion());
	}
}
