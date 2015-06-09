package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.edificables.Barraca;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.peleables.Marine;
import algo3.algocraft.modelo.recolectables.Mineral;

public class UnidadEdificioTest {

	@Test
	public void deberiaEntrenarUnSoldadoMarine() {
		Barraca barraca = new Barraca();

		Assert.assertTrue(barraca.entrenarMarine());
	}

	@Test
	public void deberiaPoderPosicionarUnaEstructura() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();

		Assert.assertTrue(barraca.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarSobreUnaCasillaOcupadaPorUnaUnidad() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();
		Marine marine = new Marine();
		marine.posicionar(casilla);
		Assert.assertFalse(barraca.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarSobreUnaCasillaOcupadaPorUnRecurso() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();
		Mineral mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);
		Assert.assertFalse(barraca.posicionar(casilla));
	}

}
