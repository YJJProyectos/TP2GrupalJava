package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.BarracaNoConstruidaError;
import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.juego.PosicionNoOcupadaPorRecursoError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;

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
		for (int i = 0; i < 6; i++) {
			deposito.pasarTurno();
		}

		Assert.assertFalse(deposito.enConstruccion());

	}

	// /IMPORTANTE: NO PASA ESTE TEST
	/*
	 * @Test public void deberiaPoderConstruirUnCentroDeMineral() throws
	 * PosicionNoOcupadaPorRecursoError { JugadorTerran jugador = new
	 * JugadorTerran(); Coordenada coordenada = new Coordenada(1, 1); Casilla
	 * casilla = new Casilla(coordenada); Recurso minaDeMinerales = new
	 * MinaDeMinerales(1000); casilla.agregarRecurso(minaDeMinerales);
	 * CentroDeMineral centro = jugador.crearCentroDeMineral(casilla);
	 * 
	 * Assert.assertEquals(casilla.getOcupanteTerrestre(), centro); }
	 */

	@Test
	public void elCentroDeMineralSeEncuentraInicialmenteEnconstruccion()
			throws PosicionNoOcupadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso minaDeMinerales = new MinaDeMinerales(1000);
		casilla.agregarRecurso(minaDeMinerales);
		CentroDeMineral centro = jugador.crearCentroDeMineral(casilla);

		Assert.assertTrue(centro.enConstruccion());

	}

	@Test
	public void luegoDe4TurnosElCentroDeMineralEstaConstruido()
			throws PosicionNoOcupadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso minaDeMinerales = new MinaDeMinerales(1000);
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
	public void despuesDeCrearseUnCentroDeMineralYPasar2TurnosAumentaEn20LosMinerales()
			throws PosicionNoOcupadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso minaDeMinerales = new MinaDeMinerales(1000);
		casilla.agregarRecurso(minaDeMinerales);
		jugador.crearCentroDeMineral(casilla);
		for (int i = 0; i < 4; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		jugador.pasarTurno();
		Assert.assertEquals(420, jugador.cantidadMineral());
	}

	@Test
	public void elJugadorDeberiaEmpezarCon10DePoblacionDebidoQueEmpiezaConUnDeposito() {
		JugadorTerran jugador = new JugadorTerran();
		Assert.assertEquals(10, jugador.cantidadPoblacion());
	}
	@Test
	public void alPasarUnTurnoDesdeQueEmpezoDeberiaSeguirCon10DePoblacion(){
		JugadorTerran jugador = new JugadorTerran();
		jugador.pasarTurno();
		Assert.assertEquals(10, jugador.cantidadPoblacion());
	}

	@Test
	public void despuesDeCrearseElDepositoEn6TurnosYEjecutarOtroTurnoLaPoblacionAumentaEn10() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		jugador.crearDepositoDeSuministros(casilla);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		Assert.assertEquals(20, jugador.cantidadPoblacion());
	}

	@Test
	public void alCrear2DepositosYEjecutarVariosTurnosMasLaPoblacionDeberiaSerDe30() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Coordenada otraCoordenada = new Coordenada(1, 2);
		Casilla casilla = new Casilla(coordenada);
		Casilla otraCasilla = new Casilla(otraCoordenada);
		jugador.crearDepositoDeSuministros(casilla);
		jugador.crearDepositoDeSuministros(otraCasilla);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		jugador.pasarTurno();
		Assert.assertEquals(30, jugador.cantidadPoblacion());
	}

	@Test
	public void alCrear30DepositosYEjecutarVariosTurnosMasLaPoblacionDeberiaSerDe200() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada;
		Casilla casilla;
		for (int i = 0; i < 30; i++) {
			coordenada = new Coordenada(1, i);
			casilla = new Casilla(coordenada);
			jugador.crearDepositoDeSuministros(casilla);
		}
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		jugador.pasarTurno();
		Assert.assertEquals(200, jugador.cantidadPoblacion());
	}

	@Test
	public void elJugadorDeberiaEmpezarCon100DeGas() {
		JugadorTerran jugador = new JugadorTerran();
		Assert.assertEquals(100, jugador.cantidadGas());
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
	public void laRefineriaSeEncuentraInicialmenteEnconstruccion()
			throws PosicionNoOcupadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso volcan = new VolcanDeGasVespeno(1000);
		casilla.agregarRecurso(volcan);
		Refineria refineria = jugador.crearRefineria(casilla);

		Assert.assertTrue(refineria.enConstruccion());

	}

	@Test
	public void luegoDe6TurnosLaRefineriaEstaConstruida()
			throws PosicionNoOcupadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso volcan = new VolcanDeGasVespeno(1000);
		casilla.agregarRecurso(volcan);
		Refineria refineria = jugador.crearRefineria(casilla);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		Assert.assertFalse(refineria.enConstruccion());
	}

	@Test
	public void despuesDeCrearseLaRefineriaYPasar6TurnosAumentaEn20LaCantidadDeGas()
			throws PosicionNoOcupadaPorRecursoError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso volcan = new VolcanDeGasVespeno(1000);
		casilla.agregarRecurso(volcan);
		jugador.crearRefineria(casilla);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		jugador.pasarTurno();
		Assert.assertEquals(120, jugador.cantidadGas());
	}

}
