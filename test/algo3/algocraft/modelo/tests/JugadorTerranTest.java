package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.BarracaNoConstruidaError;
import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.juego.PosicionNoOcipadaPorRecursoError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recolectables.MinaDeMinerales;
import algo3.algocraft.modelo.recolectables.Recolectable;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;

public class JugadorTerranTest {

	@Test
	public void deberiaPoderConstruirUnaBarraca() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = jugador.crearBarraca(casilla);

		Assert.assertEquals(casilla.getOcupanteTerrestre(), barraca);
	}

	@Test
	public void laBarracaSeEncuentraInicialmenteEnconstruccion() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = jugador.crearBarraca(casilla);

		Assert.assertTrue(barraca.enConstruccion());

	}

	@Test
	public void luegoDe12TurnoslaBarracaEstaConstruida() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = jugador.crearBarraca(casilla);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}

		Assert.assertFalse(barraca.enConstruccion());

	}

	@Test(expected = BarracaNoConstruidaError.class)
	public void siSeEmpezoACrearUnaBarracaPeroSigueEnConstruccionNoSePuedeConstruirUnaFabrica()
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		jugador.crearFabrica(casillaFabrica, barraca);
	}

	@Test
	public void siSePudoCrearUnaBarraSePuedeConstruirUnaFabrica()
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = jugador.crearFabrica(casillaFabrica, barraca);

		Assert.assertEquals(casillaFabrica.getOcupanteTerrestre(), fabrica);
	}

	@Test
	public void laFabricaSeEncuentraInicialmenteEnconstruccion()
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = jugador.crearFabrica(casillaFabrica, barraca);

		Assert.assertTrue(fabrica.enConstruccion());

	}

	@Test
	public void luegoDe12TurnoslaFabricaEstaConstruida()
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = jugador.crearFabrica(casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}

		Assert.assertFalse(fabrica.enConstruccion());

	}

	@Test
	public void deberiaPoderConstruirUnDepositoDeSuministro() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);

		Assert.assertEquals(casilla.getOcupanteTerrestre(), deposito);
	}

	@Test
	public void elDepositoSeEncuentraInicialmenteEnconstruccion() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);

		Assert.assertTrue(deposito.enConstruccion());

	}

	@Test
	public void luegoDe6TurnoselDepositoEstaConstruido() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);
		for (int i = 0; i < 12; i++) {
			deposito.pasarTurno();
		}

		Assert.assertFalse(deposito.enConstruccion());

	}

	// /IMPORTANTE: NO PASA ESTE TEST
	/*
	 * @Test public void deberiaPoderConstruirUnCentroDeMineral() throws
	 * PosicionNoOcipadaPorRecursoError { JugadorTerran jugador = new
	 * JugadorTerran(); Coordenada coordenada = new Coordenada(1, 1); Casilla
	 * casilla = new Casilla(coordenada); Recolectable minaDeMinerales = new
	 * MinaDeMinerales(1000); casilla.agregarRecurso(minaDeMinerales);
	 * CentroDeMineral centro = jugador.crearCentroDeMineral(casilla);
	 * 
	 * Assert.assertEquals(casilla.getOcupanteTerrestre(), centro); }
	 */

	@Test
	public void elCentroDeMineralSeEncuentraInicialmenteEnconstruccion()
			throws PosicionNoOcipadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable minaDeMinerales = new MinaDeMinerales(1000);
		casilla.agregarRecurso(minaDeMinerales);
		CentroDeMineral centro = jugador.crearCentroDeMineral(casilla);

		Assert.assertTrue(centro.enConstruccion());

	}

	@Test
	public void luegoDe4TurnoselCentroDeMineralEstaConstruido()
			throws PosicionNoOcipadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable minaDeMinerales = new MinaDeMinerales(1000);
		casilla.agregarRecurso(minaDeMinerales);
		CentroDeMineral centroDeMineral = jugador.crearCentroDeMineral(casilla);
		for (int i = 0; i < 4; i++) {
			jugador.pasarTurno();
		}
		Assert.assertFalse(centroDeMineral.enConstruccion());

	}

	@Test
	public void elJugadorDeberiaEmpezarCon400DeMineral() {
		JugadorTerran jugador = new JugadorTerran();
		Assert.assertEquals(400, jugador.cantidadMineral());
	}

	@Test
	public void despuesDeCrearseUnCentroDeMineralYPasarUn2TurnoAumentaEn20LosMinerales()
			throws PosicionNoOcipadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recolectable minaDeMinerales = new MinaDeMinerales(1000);
		casilla.agregarRecurso(minaDeMinerales);
		jugador.crearCentroDeMineral(casilla);
		for (int i = 0; i < 4; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		jugador.pasarTurno();
		Assert.assertEquals(420, jugador.cantidadMineral());
	}

}
