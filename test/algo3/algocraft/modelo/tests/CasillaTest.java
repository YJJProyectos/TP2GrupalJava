package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Recolector;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Espectro;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;

public class CasillaTest {

	@Test
	public void deberiaNoEstarOcupadaLaTierra() {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaNoEstarOcupadoElAire() {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecurso() {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaEstarOcupadaLaTierraAlAgregarUnMarineEnTierra()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertTrue(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaEstarOcupadaLaTierraAlAgregarUnMarine()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertTrue(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaGuardarALaUnidad() throws CasillaOcupadaError,
			RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(marine, casilla.getOcupanteTerrestre());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererPosicionar2UnidadesTerrestresEnUnaMismaCasilla()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad primerMarine = new Marine(jugador);
		Unidad segundoMarine = new Marine(jugador);
		casilla.ocuparTerrestre(primerMarine);
		casilla.ocuparTerrestre(segundoMarine);
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnMarineEnTierra()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnMarine()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecursoAlAgregarUnMarineEnTierra()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecursoAlAgregarUnMarine()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaNoEstarOcupadaLaTierraAlAgregarUnRecurso()
			throws CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnRecurso()
			throws CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaEstarOcupadoElRecursoAlAgregarUnRecurso()
			throws CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);

		Assert.assertTrue(casilla.estaOcupadoElRecurso());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaGuardarSoloElPrimerRecursoEntreDosRecursosAgregados()
			throws CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso primerMineral = new MinaDeMinerales(100);
		Recurso segundoMineral = new MinaDeMinerales(200);
		casilla.agregarRecurso(primerMineral);
		casilla.agregarRecurso(segundoMineral);
	}

	@Test
	public void deberiaNoPoderDesocuparLaTierraSiNoHayUnaUnidad() {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertEquals(null, casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiNoHayUnaUnidad() {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertEquals(null, casilla.desocuparAire());
	}

	@Test
	public void deberiaPoderDesocuparLaTierraSiSoloHayUnMarineEnTierra()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(marine, casilla.desocuparTierra());
	}

	@Test
	public void deberiaPoderDesocuparLaTierraSiSoloHayUnMarine()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(marine, casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnMarineEnTierra()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(null, casilla.desocuparAire());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnMarine()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(null, casilla.desocuparAire());
	}

	@Test
	public void deberiaNoPoderDesocuparLaTierraSiSoloHayUnRecurso()
			throws CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);

		Assert.assertEquals(null, casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnRecurso()
			throws CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);

		Assert.assertEquals(null, casilla.desocuparAire());
	}

	@Test
	public void deberiaPoderAgregarUnCentroMineralPorqueHayMineral()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		Jugador jugador = new Jugador();
		Recolector centroMineral = new CentroDeMineral(mineral, jugador);

		Assert.assertEquals(casilla, centroMineral.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlIntentarAgregarUnSoldadoSiYaHayUnMineral()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.agregarRecurso(mineral);
		casilla.ocuparTerrestre(marine);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlAgregarUnMineralSiYaHayUnMarineEnLaCasilla()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);
		casilla.agregarRecurso(mineral);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlintentarAgregarUnMarineCuandoYaHayUnCentroDeMineralEnLaCasilla()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		Recolector centroMineral = new CentroDeMineral(mineral, jugador);
		centroMineral.pasarTurno();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);
	}

	@Test
	public void deberiaPoderOcuparElAireConUnaUnidad()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Espectro espectro = new Espectro(jugador);
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		casilla.ocuparAereo(espectro);

		Assert.assertEquals(casilla, espectro.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererAgregarDosUnidadesEnElAire()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		jugador.aumentarGas(100);
		Espectro espectro1 = new Espectro(jugador);
		Espectro espectro2 = new Espectro(jugador);
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		casilla.ocuparAereo(espectro1);
		casilla.ocuparAereo(espectro2);
	}

	@Test
	public void deberiaPoderOcuparTierraYAireALaVez()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Espectro espectro = new Espectro(jugador);
		Marine marine = new Marine(jugador);
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		casilla.ocuparAereo(espectro);

		Assert.assertEquals(casilla, espectro.posicion());

		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(casilla, marine.posicion());
	}
}
