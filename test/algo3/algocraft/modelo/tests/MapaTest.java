package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;

public class MapaTest {

	@Test
	public void deberiaTenerTamanio400ElMapaDe4Bases() {

		Mapa mapa = new Mapa(4);

		Assert.assertEquals(mapa.tamanio(), 400);
	}

	@Test
	public void deberiaTenerUnaCantidadDEFilasMaximasIgualA20() {

		Mapa mapa = new Mapa(4);

		Assert.assertEquals(20, mapa.getFilas());
	}

	@Test
	public void deberiaTenerUnaCantidadDeColumnasMaximasIgualA20() {

		Mapa mapa = new Mapa(4);

		Assert.assertEquals(20, mapa.getColumnas());
	}

	@Test
	public void noDeberiaAgregarUnMarineSiPasanCoordenadaInvalida()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Mapa mapa = new Mapa(4);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		Coordenada coordenada = new Coordenada(-1, 3);

		Assert.assertFalse(mapa.agregarElementoEnPosicion(marine, coordenada));
	}

	@Test(expected = CoordenadaInvalidaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererObtenerUnElementoTerrestreEnUnaCoordenadaInvalida()
			throws CasillaOcupadaError, CoordenadaInvalidaError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Mapa mapa = new Mapa(4);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		@SuppressWarnings("unused")
		Unidad marine = new Marine(jugador);
		Coordenada coordenadaMarine = new Coordenada(1000, 1000);

		mapa.obtenerElementoTerrestreEnPosicion(coordenadaMarine);
	}

	@Test(expected = CoordenadaInvalidaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererObtenerUnRecursotreEnUnaCoordenadaInvalida()
			throws CasillaOcupadaError, CoordenadaInvalidaError {

		Mapa mapa = new Mapa(4);
		@SuppressWarnings("unused")
		Recurso minaDeMineral = new MinaDeMinerales(100);
		Coordenada coordenadaMina = new Coordenada(1000, 1000);
		mapa.obtenerRecursoEnPosicion(coordenadaMina);
	}

	@Test
	public void deberiaAgregarUnMarineEnLaPosicionDada()
			throws CasillaOcupadaError, CoordenadaInvalidaError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Mapa mapa = new Mapa(4);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		Coordenada coordenadaMarine = new Coordenada(1, 1);
		mapa.agregarElementoEnPosicion(marine, coordenadaMarine);

		Assert.assertEquals(marine,
				mapa.obtenerElementoTerrestreEnPosicion(coordenadaMarine));
	}

	@Test
	public void deberiaSetearseLosMineralesEnLaPuntaDelMapa()
			throws CoordenadaInvalidaError, CasillaOcupadaError {

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
	public void deberiaSetearseLosVolcanesAlLadoDeLosMinerales()
			throws CoordenadaInvalidaError, CasillaOcupadaError {

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

	@Test
	public void deberiaDarDiferentesLas4Casillas() {

		Mapa mapa = new Mapa(4);
		Casilla casilla1 = mapa.posicionDeBase();
		Casilla casilla2 = mapa.posicionDeBase();
		Casilla casilla3 = mapa.posicionDeBase();
		Casilla casilla4 = mapa.posicionDeBase();

		Assert.assertNotEquals(casilla1, casilla2);

		Assert.assertNotEquals(casilla1, casilla3);

		Assert.assertNotEquals(casilla1, casilla4);

		Assert.assertNotEquals(casilla2, casilla3);

		Assert.assertNotEquals(casilla2, casilla4);

		Assert.assertNotEquals(casilla3, casilla4);
	}

}
