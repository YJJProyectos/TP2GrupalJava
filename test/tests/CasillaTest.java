package tests;


import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.accionables.Unidad;
import algo3.algocraft.modelo.imponibles.CentroDeMineral;
import algo3.algocraft.modelo.imponibles.Recolector;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.peleables.Marine;
import algo3.algocraft.modelo.recolectables.Mineral;
import algo3.algocraft.modelo.recolectables.Recolectable;



public class CasillaTest {

	@Test
	public void deberiaNoEstarOcupadaLaTierra() {
		Casilla casilla = new Casilla();

		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaNoEstarOcupadoElAire() {
		Casilla casilla = new Casilla();

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecurso() {
		Casilla casilla = new Casilla();

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaEstarOcupadaLaTierraAlAgregarUnMarineEnTierra() {
		Casilla casilla = new Casilla();
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertTrue(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaGuardarALaUnidad() {
		Casilla casilla = new Casilla();
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertEquals(marine, casilla.getOcupanteTerrestre());
	}

	@Test
	public void deberiaGuardarSoloLaPrimeraUnidadEntreDosUnidadesTerrestres() {
		Casilla casilla = new Casilla();
		Unidad primerMarine = new Marine();
		Unidad segundoMarine = new Marine();
		casilla.ocuparTerrestre(primerMarine);
		casilla.ocuparTerrestre(segundoMarine);

		Assert.assertEquals(primerMarine, casilla.getOcupanteTerrestre());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnMarineEnTierra() {
		Casilla casilla = new Casilla();
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaNoEstarOcupadoElRecursoAlAgregarUnMarineEnTierra() {
		Casilla casilla = new Casilla();
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.estaOcupadoElRecurso());
	}

	@Test
	public void deberiaNoEstarOcupadaLaTierraAlAgregarUnRecurso() {
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaNoEstarOcupadoElAireAlAgregarUnRecurso() {
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.estaOcupadoElAire());
	}

	@Test
	public void deberiaEstarOcupadoElRecursoAlAgregarUnRecurso() {
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertTrue(casilla.estaOcupadoElRecurso());
	}
	
	@Test
	public void deberiaGuardarSoloElPrimerRecursoEntreDosRecursosAgregados() {
		Casilla casilla = new Casilla();
		Recolectable primerMineral = new Mineral(100);
		Recolectable segundoMineral = new Mineral(200);
		casilla.agregarRecurso(primerMineral);
		casilla.agregarRecurso(segundoMineral);

		Assert.assertEquals(primerMineral, casilla.getRecurso());
	}

	@Test
	public void deberiaNoPoderDesocuparLaTierraSiNoHayUnaUnidad() {
		Casilla casilla = new Casilla();

		Assert.assertFalse(casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiNoHayUnaUnidad() {
		Casilla casilla = new Casilla();

		Assert.assertFalse(casilla.desocuparAire());
	}

	@Test
	public void deberiaPoderDesocuparLaTierraSiSoloHayUnMarineEnTierra() {
		Casilla casilla = new Casilla();
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertTrue(casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnMarineEnTierra() {
		Casilla casilla = new Casilla();
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);

		Assert.assertFalse(casilla.desocuparAire());
	}

	@Test
	public void deberiaNoPoderDesocuparLaTierraSiSoloHayUnRecurso() {
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.desocuparTierra());
	}

	@Test
	public void deberiaNoPoderDesocuparElAireSiSoloHayUnRecurso() {
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(casilla.desocuparAire());
	}
	
	@Test
	public void  deberiaNoPoderAgregarUnCentroMineralPorqueNoHayMineral(){
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		Recolector centroMineral = new CentroDeMineral(mineral);
		Assert.assertFalse(casilla.ocupar(centroMineral));
	}
	
	@Test
	public void  debieriaPoderAgregarUnCentroMineralPorqueHayMineral(){
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		casilla.agregarRecurso(mineral);
		Recolector centroMineral = new CentroDeMineral(mineral);
		Assert.assertTrue(casilla.ocupar(centroMineral));
	}
	
	@Test
	public void deberiaNoPoderAgregarUnSoldadoPorqueYaHayUnMineral(){
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		Unidad marine = new Marine();
		casilla.agregarRecurso(mineral);
		Assert.assertFalse(casilla.ocuparTerrestre(marine));
		
	}
	
	public void deberianNoPoderAgregarUnMineralCuandoYaHayUnMarineEnLaCasilla(){
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		Unidad marine = new Marine();
		casilla.ocuparTerrestre(marine);
		Assert.assertFalse(casilla.agregarRecurso(mineral));
		
	}
	
	public void deberianNoPoderAgregarUnMarineCuandoYaHayUnCentroDeMineralEnLaCasilla(){
		Casilla casilla = new Casilla();
		Recolectable mineral = new Mineral(100);
		Recolector centroMineral = new CentroDeMineral(mineral);
		Unidad marine = new Marine();
		casilla.agregarRecurso(mineral);
		casilla.ocupar(centroMineral);
		Assert.assertFalse(casilla.ocuparTerrestre(marine));
		
	}

	// Cuando tengamos implementado algun
	// accionable aereo, vamos a tener que agregar mas
	// tests de este estilo.

}
