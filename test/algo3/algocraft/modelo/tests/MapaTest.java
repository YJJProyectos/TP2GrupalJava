package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;
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

	@Test
	public void deberiaSetearseLosMineralesEnLaPuntaDelMapa() throws CoordenadaInvalidaError{
		Mapa mapa = new Mapa(4);
		mapa.setCoordenadaMineralYVolcanDeGas();
		Coordenada coordenadaMineral = new Coordenada(1, 1);
		Casilla casillaMineral = mapa.getCasilla(coordenadaMineral);
		Assert.assertTrue(casillaMineral.estaOcupadoElRecurso());
		coordenadaMineral = new Coordenada(1, 20);
		casillaMineral = mapa.getCasilla(coordenadaMineral);
		Assert.assertTrue(casillaMineral.estaOcupadoElRecurso());
		coordenadaMineral = new Coordenada(20, 1);
		casillaMineral = mapa.getCasilla(coordenadaMineral);
		Assert.assertTrue(casillaMineral.estaOcupadoElRecurso());
		coordenadaMineral = new Coordenada(20, 20);
		casillaMineral = mapa.getCasilla(coordenadaMineral);
		Assert.assertTrue(casillaMineral.estaOcupadoElRecurso());

	}

	@Test
	public void deberiaSetearseLosVolcanesAlLadoDeLosMinerales() throws CoordenadaInvalidaError{
		Mapa mapa = new Mapa(4);
		mapa.setCoordenadaMineralYVolcanDeGas();
		Coordenada coordenadaGas = new Coordenada(1, 2);
		Casilla casillaGas = mapa.getCasilla(coordenadaGas);
		Assert.assertTrue(casillaGas.estaOcupadoElRecurso());
		coordenadaGas = new Coordenada(1, 19);
		casillaGas = mapa.getCasilla(coordenadaGas);
		Assert.assertTrue(casillaGas.estaOcupadoElRecurso());
		coordenadaGas = new Coordenada(20, 2);
		casillaGas = mapa.getCasilla(coordenadaGas);
		Assert.assertTrue(casillaGas.estaOcupadoElRecurso());
		coordenadaGas = new Coordenada(20, 19);
		casillaGas = mapa.getCasilla(coordenadaGas);
		Assert.assertTrue(casillaGas.estaOcupadoElRecurso());

	}
}
