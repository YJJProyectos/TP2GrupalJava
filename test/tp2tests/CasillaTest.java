package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import recolectables.CentroDeMineral;
import recolectables.Recolectable;
import recolectables.Recolectante;
import tp2.CasillaDeRecurso;
import tp2.CasillaTerrestre;
import tp2.Mineral;
import peleables.Marine;
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
		casilla.agregarElemento(soldado);

		Assert.assertTrue(casilla.estaOcupada());
	}

	public void unaCasillaDeRecursodeberiaEstarOcupada() {
		Recolectable recurso = new Mineral(1000);
		CasillaDeRecurso casilla = new CasillaDeRecurso(recurso);

		Assert.assertTrue(casilla.estaOcupada());
	}

	public void unaCasillaDeRecursosNoEstaOcupadaPorUnEdificio() {
		Recolectable recurso = new Mineral(1000);
		CasillaDeRecurso casilla = new CasillaDeRecurso(recurso);

		Assert.assertFalse(casilla.estaOcupadaPorUnEdificio());
	}

	public void unaCasillaDeRecursosEstaOcupadaPorUnEdificio() {
		Recolectable recurso = new Mineral(1000);
		Recolectante edificio = new CentroDeMineral(recurso);
		CasillaDeRecurso casilla = new CasillaDeRecurso(recurso);
		casilla.agregarRecolectante(edificio);
		Assert.assertTrue(casilla.estaOcupadaPorUnEdificio());
	}

}
