package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.NoHaySoldadosParaPosicionarError;
import algo3.algocraft.modelo.juego.PosicionNoOcupadaPorRecursoError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;

public class JugadorTest {

	@Test
	public void elJugadorDeberiaEmpezarCon400DeMineral() {
		Jugador jugador = new Jugador();
		Assert.assertEquals(400, jugador.cantidadMineral());
	}

	@Test
	public void despuesDeCrearseUnCentroDeMineralAlTomarEnCuentaSuCostoYPasar2TurnosAumentaEn20LosMinerales()
			throws PosicionNoOcupadaPorRecursoError,
			RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso minaDeMinerales = new MinaDeMinerales(1000);
		minaDeMinerales.posicionar(casilla);
		@SuppressWarnings("unused")
		CentroDeMineral centro = new CentroDeMineral(minaDeMinerales, jugador);
		for (int i = 0; i < 4; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		jugador.pasarTurno();
		Assert.assertEquals(370, jugador.cantidadMineral());
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
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		@SuppressWarnings("unused")
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		Assert.assertEquals(10, jugador.cantidadPoblacion());
	}

	@Test
	public void alCrear2DepositosYEjecutarVariosTurnosMasLaPoblacionDeberiaSerDe20()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Coordenada otraCoordenada = new Coordenada(1, 2);
		Casilla casilla = new Casilla(coordenada);
		Casilla otraCasilla = new Casilla(otraCoordenada);
		@SuppressWarnings("unused")
		DepositoDeSuministros deposito1 = new DepositoDeSuministros(jugador,
				casilla);
		@SuppressWarnings("unused")
		DepositoDeSuministros deposito2 = new DepositoDeSuministros(jugador,
				otraCasilla);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		jugador.pasarTurno();
		Assert.assertEquals(20, jugador.cantidadPoblacion());
	}

	@Test
	public void alCrear30DepositosYEjecutarVariosTurnosMasLaPoblacionDeberiaSerDe200()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador = new Jugador();
		jugador.aumentarMineral(30000);
		Coordenada coordenada;
		Casilla casilla;
		for (int i = 0; i < 30; i++) {
			coordenada = new Coordenada(1, i);
			casilla = new Casilla(coordenada);
			@SuppressWarnings("unused")
			DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
					casilla);
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

	@Test
	public void despuesDeCrearseLaRefineriaYPasar6TurnosAumentaEn20LaCantidadDeGas()
			throws PosicionNoOcupadaPorRecursoError,
			RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Recurso volcan = new VolcanDeGasVespeno(1000);
		volcan.posicionar(casilla);
		@SuppressWarnings("unused")
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		jugador.pasarTurno();
		Assert.assertEquals(120, jugador.cantidadGas());
	}

	@Test(expected = NoHaySoldadosParaPosicionarError.class)
	public void deberiaLanzarUnaExcepcionSiSeIntentaPosicionarUnSoldadoDeLaColaDeEsperaVacia()
			throws CasillaOcupadaError, NoHaySoldadosParaPosicionarError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		jugador.posicionarSoldadoEnColaDeEspera(casilla);
	}

	@Test
	public void sePuedePosicionarUnSoldadoDeColaDeEsperaDelJugador()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			PosicionNoOcupadaPorRecursoError, RecolectorInvalidoError,
			NoHaySoldadosParaPosicionarError, JugadorIncorrectoError {
		Jugador jugador = new Jugador();
		Coordenada coordenadaMineral = new Coordenada(1, 1);
		Casilla casillaMineral = new Casilla(coordenadaMineral);
		Recurso minaDeMinerales = new MinaDeMinerales(1000);
		minaDeMinerales.posicionar(casillaMineral);
		@SuppressWarnings("unused")
		CentroDeMineral centroDeMineral = new CentroDeMineral(minaDeMinerales,
				jugador);
		for (int i = 0; i < 4; i++) {
			jugador.pasarTurno();
		} // Termina de crearse el centro
		for (int i = 0; i < 100; i++) {
			jugador.pasarTurno();
		} // Recolecto suficientes recursos para crear las demas unidades
		Coordenada coordenadaDeposito = new Coordenada(1, 2);
		Casilla casillaDeposito = new Casilla(coordenadaDeposito);
		@SuppressWarnings("unused")
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casillaDeposito);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}// Termina de crearse el deposito

		Coordenada coordenadaBarraca = new Coordenada(1, 3);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}// Termina de crearse la barraca

		barraca.entrenarMarine(jugador);
		for (int i = 0; i < 3; i++) {
			jugador.pasarTurno();
		}// Termina de crearse el marine
		Coordenada coordenadaMarine = new Coordenada(1, 4);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		jugador.posicionarSoldadoEnColaDeEspera(casillaMarine);

		Assert.assertTrue(casillaMarine.estaOcupadaLaTierra());
	}

	@Test
	public void seInicializaElJugadorConDepositoYSigueConLaMismaCantidadDeMinerales()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(2, 2);
		Casilla casilla = new Casilla(coordenada);
		jugador.iniciarConDeposito(casilla);
		Assert.assertEquals(10, jugador.cantidadPoblacion());
		Assert.assertEquals(400, jugador.cantidadMineral());
	}

}
