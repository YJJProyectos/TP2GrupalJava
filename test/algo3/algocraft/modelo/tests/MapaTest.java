package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;

public class MapaTest {

	@Test
	public void deberiaTenerTamanio400ElMapaDe4Bases() {
		Mapa mapa = new Mapa(4);
		Assert.assertEquals(mapa.tamanio(), 400);
	}

	@Test
	public void noDeberiaAgregarUnMarineSiPasanCoordenadaInvalida() {
		Mapa mapa = new Mapa(4);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		Coordenada coordenada = new Coordenada(-1, 3);
		Assert.assertFalse(mapa.agregarElementoEnPosicion(marine, coordenada));
	}

	@Test
	public void deberiaAgregarUnMarineEnLaPosicionDada() {
		Mapa mapa = new Mapa(4);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		Coordenada coordenadaMarine = new Coordenada(1, 1);
		mapa.agregarElementoEnPosicion(marine, coordenadaMarine);

		Assert.assertEquals(marine,
				mapa.obtenerElementoTerrestreEnPosicion(coordenadaMarine));

	}
}
