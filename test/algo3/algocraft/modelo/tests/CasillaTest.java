package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Recolector;
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
	public void deberiaEstarOcupadaLaTierraAlAgregarUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertTrue(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaEstarOcupadaLaTierraAlAgregarUnMarine() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocupar(marine);

		Assert.assertTrue(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaGuardarALaUnidad() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(marine, casilla.getOcupanteTerrestre());
	}

	@Test
	public void deberiaGuardarSoloLaPrimeraUnidadEntreDosUnidadesTerrestres() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad primerMarine = new Marine(jugador);
		Unidad segundoMarine = new Marine(jugador);
		casilla.ocuparTerrestre(primerMarine);
		casilla.ocuparTerrestre(segundoMarine);

		Assert.assertEquals(primerMarine, casilla.getOcupanteTerrestre());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnMarine() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocupar(marine);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecursoAlAgregarUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecursoAlAgregarUnMarine() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocupar(marine);

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
	public void deberiaPoderDesocuparLaTierraSiSoloHayUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine(null);

		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(marine, casilla.desocuparTierra());
	}

	@Test
	public void deberiaPoderDesocuparLaTierraSiSoloHayUnMarine() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine(null);

		casilla.ocupar(marine);

		Assert.assertEquals(marine, casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(null, casilla.desocuparAire());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnMarine() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocupar(marine);

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
	public void deberiaNoPoderAgregarUnCentroMineralPorqueNoHayMineral()
			throws RecursosInsuficientesError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		Jugador jugador = new Jugador();
		Recolector centroMineral = new CentroDeMineral(mineral, jugador);
		Assert.assertFalse(casilla.ocupar(centroMineral));
	}

	@Test
	public void debieriaPoderAgregarUnCentroMineralPorqueHayMineral()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);
		Jugador jugador = new Jugador();
		Recolector centroMineral = new CentroDeMineral(mineral, jugador);
		Assert.assertTrue(casilla.ocupar(centroMineral));
	}

	@Test
	public void deberiaNoPoderAgregarUnSoldadoPorqueYaHayUnMineral()
			throws CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.agregarRecurso(mineral);
		Assert.assertFalse(casilla.ocupar(marine));

	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberianLanzarUnaExcepcionAlAgregarUnMineralSiYaHayUnMarineEnLaCasilla()
			throws CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		Jugador jugador = new Jugador();
		Unidad marine = new Marine(jugador);
		casilla.ocupar(marine);
		casilla.agregarRecurso(mineral);

	}

	@Test
	public void deberianNoPoderAgregarUnMarineCuandoYaHayUnCentroDeMineralEnLaCasilla()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso mineral = new MinaDeMinerales(100);
		Jugador jugador = new Jugador();
		Recolector centroMineral = new CentroDeMineral(mineral, jugador);
		Unidad marine = new Marine(jugador);
		casilla.agregarRecurso(mineral);
		casilla.ocupar(centroMineral);
		Assert.assertFalse(casilla.ocupar(marine));

	}

	// Cuando tengamos implementado algun
	// accionable aereo, vamos a tener que agregar mas
	// tests de este estilo.

}
