package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.TransporteTerran;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadTransporte;

public class TransporteTerranTest {
	
	@Test
	public void deberiaCargarUnSoldadoAliado() {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
	
		Assert.assertTrue(nave.cargarSoldado(soldado));
	}
	
	@Test public void deberiaNoCargarUnSoldadoEnemigo(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador1);
		UnidadSoldado soldado = new Marine(jugador2);
	
		Assert.assertFalse(nave.cargarSoldado(soldado));
	}
	
	@Test
	public void deberiaNoCargarAlMismoSoldadoDosVeces() {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado);
		
		Assert.assertFalse(nave.cargarSoldado(soldado));
	}
	
	@Test
	public void deberiaDescargarUnSoldado () {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.cargarSoldado(soldado);
		
		Assert.assertEquals(nave.descargarSoldado(), soldado);
	}
	
	@Test
	public void deberiaNoDescargarAlMismoSoldadoDosVeces() {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
		nave.descargarSoldado();
		
		Assert.assertNotEquals(nave.descargarSoldado(), soldado);
	}
	
	@Test
	public void deberiaActualizarLaPosicionDelSoldado() {
		Jugador jugador = new Jugador();
		UnidadTransporte nave = new TransporteTerran(jugador);
		UnidadSoldado soldado = new Marine(jugador);
				
		nave.cargarSoldado(soldado);
		
		Assert.assertEquals(null, soldado.posicion());
	}
}
