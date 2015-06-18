package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.CoordenadaRecurso;

public class CoordenadaRecursoTest {

	@Test
	public void deberiaDarCoordenadaDeLosMineralesEnLos4Puntos() {
		CoordenadaRecurso coordenadaRecurso = new CoordenadaRecurso(1,1,10,10);
		Coordenada coordenada = new Coordenada(1, 1);
		Assert.assertEquals(coordenada,coordenadaRecurso.sacarCoordenadaDeMineral());
		coordenada = new Coordenada(1, 10);
		Assert.assertEquals(coordenada, coordenadaRecurso.sacarCoordenadaDeMineral());
		coordenada = new Coordenada(10,1);
		Assert.assertEquals(coordenada, coordenadaRecurso.sacarCoordenadaDeMineral());
		coordenada = new Coordenada(10,10);
		Assert.assertEquals(coordenada, coordenadaRecurso.sacarCoordenadaDeMineral());
	}
	@Test
	public void deberiaDarCoordenadasDeLosGasesAlLadoDeLosMineralesPuestos(){
		CoordenadaRecurso coordenadaRecurso = new CoordenadaRecurso(1,1,10,10);
		Coordenada coordenada = new Coordenada(1, 2);
		Assert.assertEquals(coordenada, coordenadaRecurso.sacarCoordenadaDeGas());
		coordenada = new Coordenada(1, 9);
		Assert.assertEquals(coordenada, coordenadaRecurso.sacarCoordenadaDeGas());
		coordenada = new Coordenada(10, 2);
		Assert.assertEquals(coordenada, coordenadaRecurso.sacarCoordenadaDeGas());
		coordenada = new Coordenada(10, 9);
		Assert.assertEquals(coordenada, coordenadaRecurso.sacarCoordenadaDeGas());
	}

}
