package tests;


import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.peleables.Marine;


public class MapaTest {

	@Test
	public void deberiaTenerTamanio400ElMapaDe4Bases() {
		Mapa mapa = new Mapa(4);
		Assert.assertEquals(mapa.tamanio(), 400);
	}

	@Test
	public void noDeberiaAgregarUnMarineSiPasanCoordenadaInvalida(){
		Mapa mapa = new Mapa(4);
		Marine marine = new Marine();
		Coordenada coordenada = new Coordenada(-1, 3);
		Assert.assertFalse(mapa.agregarElementoEnPosicion(marine, coordenada));
	}

	@Test
	public void deberiaAgregarUnMarineEnLaPosicionDada() {
		Mapa mapa = new Mapa(4);
		Marine marine = new Marine();
		Coordenada coordenadaMarine = new Coordenada(1, 1);
		mapa.agregarElementoEnPosicion(marine, coordenadaMarine);

		Assert.assertEquals(marine,
				mapa.obtenerElementoTerrestreEnPosicion(coordenadaMarine));

	}
}
