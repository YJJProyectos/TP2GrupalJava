package tests;

import imponibles.CentroDeMineral;
import imponibles.Imponible;
import mapa.CasillaDeRecurso;
import mapa.CasillaTerrestre;

import org.junit.Assert;
import org.junit.Test;

import accionables.Accionable;
import recolectables.Mineral;
import recolectables.Recolectable;
import peleables.Marine;
import peleables.Golliat;
import peleables.Peleable;

public class CasillaTest {

	@Test
	public void deberiaNoEstarOcupada() {
		CasillaTerrestre casilla = new CasillaTerrestre();

		Assert.assertFalse(casilla.estaOcupada());
	}

	@Test
	public void deberiaEstarOcupada() {
		CasillaTerrestre casilla = new CasillaTerrestre();

		Peleable soldado = new Marine();
		casilla.ocupar(soldado);

		Assert.assertTrue(casilla.estaOcupada());
	}

	@Test
	public void deberiaEstarOcupadaUnaCasillaDeRecurso() {
		Recolectable recurso = new Mineral(1000);
		CasillaDeRecurso casilla = new CasillaDeRecurso(recurso);

		Assert.assertTrue(casilla.estaOcupada());
	}

	@Test
	public void deberiaNoEstarOcupadaPorUnEdificioUnaCasillaDeRecursos() {
		Recolectable recurso = new Mineral(1000);
		CasillaDeRecurso casilla = new CasillaDeRecurso(recurso);

		Assert.assertFalse(casilla.estaOcupadaPorUnEdificio());
	}

	@Test
	public void deberiaEstarOcupadaPorUnEdificioUnaCasillaDeRecursos() {
		Recolectable recurso = new Mineral(1000);
		Imponible edificio = new CentroDeMineral(recurso);
		CasillaDeRecurso casilla = new CasillaDeRecurso(recurso);
		casilla.agregarRecolectante(edificio);
		Assert.assertTrue(casilla.estaOcupadaPorUnEdificio());
	}

	@Test
	public void deberiaGuardarALaUnidad() {

		CasillaTerrestre casilla = new CasillaTerrestre();
		Accionable soldado = new Marine();

		casilla.ocupar(soldado);

		Assert.assertEquals(casilla.ocupante(), soldado);

	}

	@Test
	public void deberiaGuardarSoloLaPrimeraUnidad() {

		CasillaTerrestre casilla = new CasillaTerrestre();
		Accionable soldado1 = new Marine();
		Accionable soldado2 = new Golliat();

		casilla.ocupar(soldado1);
		casilla.ocupar(soldado2);

		Assert.assertEquals(casilla.ocupante(), soldado1);
	}

	@Test
	public void deberiaDesocuparse() {
		CasillaTerrestre casilla = new CasillaTerrestre();
		Accionable soldado = new Marine();

		casilla.ocupar(soldado);
		casilla.desocupar();

		Assert.assertFalse(casilla.estaOcupada());
	}

}
