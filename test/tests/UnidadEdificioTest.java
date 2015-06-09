package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.edificables.Acceso;
import algo3.algocraft.modelo.edificables.Barraca;
import algo3.algocraft.modelo.edificables.Fabrica;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.peleables.Marine;
import algo3.algocraft.modelo.recolectables.Mineral;

public class UnidadEdificioTest {

	@Test
	public void deberiaTransportarUnZealot() {
		Acceso acceso = new Acceso();

		Assert.assertTrue(acceso.transportarZealot());
	}

	@Test
	public void deberiaEntrenarUnSoldadoMarine() {
		Barraca barraca = new Barraca();

		Assert.assertTrue(barraca.entrenarMarine());
	}

	@Test
	public void deberiaPoderEdificarUnaEstructura() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();

		Assert.assertTrue(barraca.edificar(casilla));
	}

	@Test
	public void deberiaNoPoderEdificarSobreUnaCasillaOcupadaPorUnaUnidad() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();
		Marine marine = new Marine();
		marine.posicionar(casilla);
		Assert.assertFalse(barraca.edificar(casilla));
	}

	@Test
	public void deberiaNoPoderEdificarSobreUnaCasillaOcupadaPorUnRecurso() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();
		Mineral mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);
		Assert.assertFalse(barraca.edificar(casilla));
	}

	@Test
	public void deberiaNoEntrenarUnGolliat() {
		Fabrica fabrica = new Fabrica(null);
		Assert.assertFalse(fabrica.entrenarGolliat());
	}

	@Test
	public void deberiaEntrenarUnGolliat() {
		Barraca barraca = new Barraca();

		Fabrica fabrica = new Fabrica(barraca);

		Assert.assertTrue(fabrica.entrenarGolliat());
	}
}
