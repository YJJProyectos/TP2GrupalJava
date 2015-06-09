package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;

public class JugadorTerranTest {
	
	//faltaria test de "recursos que empieza el jugador" y agregarle costos a la creacion
	// de estructuras

	@Test
	public void noDeberiaPoderConstruirseLaFabricaSinAntesTenerBarraca() {
		JugadorTerran jugadorTerran = new JugadorTerran();
		Assert.assertEquals(null,jugadorTerran.construirFabrica());
	}
	@Test
	public void deberiaPoderConstruirseLaFabricaSiYaCreoUnaBarraca(){
		JugadorTerran jugadorTerran = new JugadorTerran();
		jugadorTerran.construirBarraca();
		Assert.assertNotEquals(null, jugadorTerran.construirFabrica());
	}
	@Test
	public void deberiaEmpezarConPoblacion0(){
		JugadorTerran jugadorTerran = new JugadorTerran();
		Assert.assertEquals(0,jugadorTerran.cantidadPoblacion());
	}
	@Test
	public void deberiaTenerPoblacion5AlCrearseUnDepositoDeSuministros(){
		JugadorTerran jugadorTerran = new JugadorTerran();
		jugadorTerran.construirDepositoDeSuministros();
		Assert.assertEquals(5,jugadorTerran.cantidadPoblacion());
	}

}
