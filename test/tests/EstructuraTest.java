package tests;

import mapa.Casilla;

import org.junit.Assert;
import org.junit.Test;

import peleables.Marine;
import recolectables.Mineral;

import edificables.Barraca;

public class EstructuraTest {
	
	@Test
	public void deberiaPoderEdificarUnaEstructura(){
		Casilla casilla = new Casilla();
		Barraca barraca = new Barraca();
		
		Assert.assertTrue(barraca.edificar(casilla));
	}
	
	@Test
	public void deberiaNoPoderEdificarSobreUnaCasillaOcupadaPorUnaUnidad(){
		Casilla casilla = new Casilla();
		Barraca barraca = new Barraca();
		Marine marine = new Marine();
		marine.posicionar(casilla);
		Assert.assertFalse(barraca.edificar(casilla));
	}
	
	@Test
	public void deberiaNoPoderEdificarSobreUnaCasillaOcupadaPorUnRecurso(){
		Casilla casilla = new Casilla();
		Barraca barraca = new Barraca();
		Mineral mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);
		Assert.assertFalse(barraca.edificar(casilla));
	}	
	

}
