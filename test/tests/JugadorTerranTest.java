package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;

public class JugadorTerranTest {

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

}
