package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.CoordenadasParaPosicionar;

public class CoordenadasParaPosicionarTest {
	
	@Test
	public void deberiaTener4CoordenadasMinerales(){
		CoordenadasParaPosicionar coordenadas = new CoordenadasParaPosicionar(1,1,10,10);
		for ( int i = 0; i < 4; i++){
			Assert.assertTrue(coordenadas.tieneCoordenadaMineral());
			coordenadas.sacarCoordenadaDeMineral();
		}
		Assert.assertFalse(coordenadas.tieneCoordenadaMineral());
	}
	
	@Test
	public void deberiaDarCoordenadaDeLosMineralesEnLos4Puntos() {
		CoordenadasParaPosicionar coordenadas = new CoordenadasParaPosicionar(1,1,10,10);
		Coordenada coordenada = new Coordenada(1, 1);
		Assert.assertEquals(coordenada,coordenadas.sacarCoordenadaDeMineral());
		coordenada = new Coordenada(1, 10);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeMineral());
		coordenada = new Coordenada(10,1);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeMineral());
		coordenada = new Coordenada(10,10);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeMineral());
	}
	
	@Test
	public void deberiaTener4CoordenadasDeGas(){
		CoordenadasParaPosicionar coordenadas = new CoordenadasParaPosicionar(1,1,10,10);
		for ( int i = 0; i < 4; i++){
			Assert.assertTrue(coordenadas.tieneCoordenadaGas());
			coordenadas.sacarCoordenadaDeGas();
		}
		Assert.assertFalse(coordenadas.tieneCoordenadaGas());
	}
	
	@Test
	public void deberiaDarCoordenadasDeLosGasesAlLadoDeLosMineralesPuestos(){
		CoordenadasParaPosicionar coordenadas = new CoordenadasParaPosicionar(1,1,10,10);
		Coordenada coordenada = new Coordenada(1, 2);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeGas());
		coordenada = new Coordenada(1, 9);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeGas());
		coordenada = new Coordenada(10, 2);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeGas());
		coordenada = new Coordenada(10, 9);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeGas());
	}
	
	@Test
	public void deberiaDarCoordenadasAbajoDeLasDeGases(){
		CoordenadasParaPosicionar coordenadas = new CoordenadasParaPosicionar(1,1,10,10);
		Coordenada coordenada = new Coordenada(2, 2);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeBase(0));
		coordenada = new Coordenada(2, 9);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeBase(1));
		coordenada = new Coordenada(9, 2);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeBase(2));
		coordenada = new Coordenada(9, 9);
		Assert.assertEquals(coordenada, coordenadas.sacarCoordenadaDeBase(3));
	}

}
