package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.BarracaNoConstruidaError;
import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PosicionNoOcupadaPorRecursoError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
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

public class JugadorTest {

	@Test
	public void deberiaPoderConstruirUnaBarraca()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = jugador.crearBarraca(casilla);

		Assert.assertEquals(casilla.getOcupanteTerrestre(), barraca);
	}

	@Test
	public void laBarracaSeEncuentraInicialmenteEnconstruccion()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = jugador.crearBarraca(casilla);

		Assert.assertTrue(barraca.enConstruccion());

	}

	@Test
	public void luegoDe12TurnoslaBarracaEstaConstruida()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		jugador.crearFabrica(casillaFabrica, barraca);
	}

	@Test
	public void siSePudoCrearUnaBarraSePuedeConstruirUnaFabrica()
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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
	public void deberiaPoderConstruirUnDepositoDeSuministro()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);

		Assert.assertEquals(casilla.getOcupanteTerrestre(), deposito);
	}

	@Test
	public void elDepositoSeEncuentraInicialmenteEnconstruccion()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);

		Assert.assertTrue(deposito.enConstruccion());

	}

	@Test
	public void luegoDe6TurnoselDepositoEstaConstruido()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);
		for (int i = 0; i < 6; i++) {
			deposito.pasarTurno();
		}

		Assert.assertFalse(deposito.enConstruccion());

	}

	@Test
	public void deberiaPoderConstruirUnCentroDeMineral()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso minaDeMinerales = new MinaDeMinerales(1000);
		casilla.agregarRecurso(minaDeMinerales);
		CentroDeMineral centro = jugador.crearCentroDeMineral(casilla);
		Assert.assertEquals(casilla.getOcupanteTerrestre(), centro);
	}

	@Test
	public void elCentroDeMineralSeEncuentraInicialmenteEnconstruccion()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso minaDeMinerales = new MinaDeMinerales(1000);
		casilla.agregarRecurso(minaDeMinerales);
		CentroDeMineral centro = jugador.crearCentroDeMineral(casilla);

		Assert.assertTrue(centro.enConstruccion());

	}

	@Test
	public void luegoDe4TurnosElCentroDeMineralEstaConstruido()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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
		Jugador jugador = new Jugador();
		Assert.assertEquals(400, jugador.cantidadMineral());
	}

	@Test
	public void despuesDeCrearseUnCentroDeMineralAlTomarEnCuentaSuCostoYPasar2TurnosAumentaEn20LosMinerales()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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
		Assert.assertEquals(370, jugador.cantidadMineral());
	}

	@Test(expected = PosicionNoOcupadaPorRecursoError.class)
	public void siSeIntentaPosicionarUnCentroDeMineralEnUnaPosicionSinUnaMinaSeLanzaUnaExcepcion()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		jugador.crearCentroDeMineral(casilla);
	}

	@Test
	public void elJugadorDeberiaEmpezarCon0DePoblacionDebidoQueNoEmpiezaConUnDeposito() {
		Jugador jugador = new Jugador();
		Assert.assertEquals(0, jugador.cantidadPoblacion());
	}

	@Test
	public void alPasarUnTurnoDesdeQueEmpezoDeberiaSeguirCon10DePoblacion() {
		Jugador jugador = new Jugador();
		jugador.pasarTurno();
		Assert.assertEquals(0, jugador.cantidadPoblacion());
	}

	@Test
	public void despuesDeCrearseElDepositoEn6TurnosYEjecutarOtroTurnoLaPoblacionAumentaEn10()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		jugador.crearDepositoDeSuministros(casilla);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		Assert.assertEquals(10, jugador.cantidadPoblacion());
	}

	@Test
	public void alCrear2DepositosYEjecutarVariosTurnosMasLaPoblacionDeberiaSerDe20()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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
		Assert.assertEquals(20, jugador.cantidadPoblacion());
	}

	@Test
	public void alCrear30DepositosYEjecutarVariosTurnosMasLaPoblacionDeberiaSerDe200()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		jugador.aumentarMineral(30000);
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
		Jugador jugador = new Jugador();
		Assert.assertEquals(100, jugador.cantidadGas());
	}

	// /IMPORTANTE: NO PASA ESTE TEST
	@Test
	public void deberiaPoderConstruirUnaRefineria()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso volcan = new VolcanDeGasVespeno(1000);
		casilla.agregarRecurso(volcan);
		Refineria refineria = jugador.crearRefineria(casilla);
		Assert.assertEquals(casilla.getOcupanteTerrestre(), refineria);
	}

	@Test
	public void laRefineriaSeEncuentraInicialmenteEnconstruccion()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso volcan = new VolcanDeGasVespeno(1000);
		casilla.agregarRecurso(volcan);
		Refineria refineria = jugador.crearRefineria(casilla);

		Assert.assertTrue(refineria.enConstruccion());

	}

	@Test
	public void luegoDe6TurnosLaRefineriaEstaConstruida()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
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

	@Test(expected = PosicionNoOcupadaPorRecursoError.class)
	public void siSeIntentaPosicionarUnaRefineriaEnUnaPosicionSinUnVolcanSeLanzaUnaExcepcion()
			throws PosicionNoOcupadaPorRecursoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		jugador.crearRefineria(casilla);
	}

}
