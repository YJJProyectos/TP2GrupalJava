package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.accionables.Unidad;
import algo3.algocraft.modelo.imponibles.CentroDeMineral;
import algo3.algocraft.modelo.imponibles.Recolector;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.peleables.Marine;
import algo3.algocraft.modelo.recolectables.Mineral;
import algo3.algocraft.modelo.recolectables.Recolectable;

public class CasillaTest {

	@Test
	public void deberiaNoEstarOcupadaLaTierra() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaNoEstarOcupadoElAire() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecurso() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaEstarOcupadaLaTierraAlAgregarUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertTrue(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaEstarOcupadaLaTierraAlAgregarUnMarine() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocupar(marine);

		Assert.assertTrue(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaGuardarALaUnidad() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(marine, casilla.getOcupanteTerrestre());
	}

	@Test
	public void deberiaGuardarSoloLaPrimeraUnidadEntreDosUnidadesTerrestres() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad primerMarine = new Marine();
		Unidad segundoMarine = new Marine();
		casilla.ocuparTerrestre(primerMarine);
		casilla.ocuparTerrestre(segundoMarine);

		Assert.assertEquals(primerMarine, casilla.getOcupanteTerrestre());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnMarine() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocupar(marine);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecursoAlAgregarUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecursoAlAgregarUnMarine() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocupar(marine);

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaNoEstarOcupadaLaTierraAlAgregarUnRecurso() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnRecurso() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaEstarOcupadoElRecursoAlAgregarUnRecurso() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertTrue(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaGuardarSoloElPrimerRecursoEntreDosRecursosAgregados() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable primerMineral = new Mineral(100);
		Recolectable segundoMineral = new Mineral(200);
		casilla.agregarRecurso(primerMineral);
		casilla.agregarRecurso(segundoMineral);

		Assert.assertEquals(primerMineral, casilla.getRecurso());
	}

	@Test
	public void deberiaNoPoderDesocuparLaTierraSiNoHayUnaUnidad() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertFalse(casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiNoHayUnaUnidad() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);

		Assert.assertFalse(casilla.desocuparAire());
	}

	@Test
	public void deberiaPoderDesocuparLaTierraSiSoloHayUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertTrue(casilla.desocuparTierra());
	}
	
	@Test
	public void deberiaPoderDesocuparLaTierraSiSoloHayUnMarine() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocupar(marine);

		Assert.assertTrue(casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnMarineEnTierra() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.desocuparAire());
	}
	
	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnMarine() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad marine = new Marine();
		casilla.ocupar(marine);

		Assert.assertFalse(casilla.desocuparAire());
	}

	@Test
	public void deberiaNoPoderDesocuparLaTierraSiSoloHayUnRecurso() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnRecurso() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.desocuparAire());
	}

	@Test
	public void deberiaNoPoderAgregarUnCentroMineralPorqueNoHayMineral() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		Recolector centroMineral = new CentroDeMineral(mineral);
		Assert.assertFalse(casilla.ocupar(centroMineral));
	}

	@Test
	public void debieriaPoderAgregarUnCentroMineralPorqueHayMineral() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);
		Recolector centroMineral = new CentroDeMineral(mineral);
		Assert.assertTrue(casilla.ocupar(centroMineral));
	}

	@Test
	public void deberiaNoPoderAgregarUnSoldadoPorqueYaHayUnMineral() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		Unidad marine = new Marine();
		casilla.agregarRecurso(mineral);
		Assert.assertFalse(casilla.ocupar(marine));

	}

	public void deberianNoPoderAgregarUnMineralCuandoYaHayUnMarineEnLaCasilla() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		Unidad marine = new Marine();
		casilla.ocupar(marine);
		Assert.assertFalse(casilla.agregarRecurso(mineral));

	}

	public void deberianNoPoderAgregarUnMarineCuandoYaHayUnCentroDeMineralEnLaCasilla() {
		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable mineral = new Mineral(100);
		Recolector centroMineral = new CentroDeMineral(mineral);
		Unidad marine = new Marine();
		casilla.agregarRecurso(mineral);
		casilla.ocupar(centroMineral);
		Assert.assertFalse(casilla.ocupar(marine));

	}

	// Cuando tengamos implementado algun
	// accionable aereo, vamos a tener que agregar mas
	// tests de este estilo.

}
