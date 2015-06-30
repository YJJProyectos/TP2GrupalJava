package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.NoHaySoldadosParaPosicionarError;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;
import algo3.algocraft.modelo.mapa.Mapa;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.BarracaNoConstruidaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.YaHayUnidadEnEntrenamiento;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.modelo.unidades.unidadesMoviles.DistanciaMayorQueElRangoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class JugadorTest {

	@Test
	public void elJugadorDeberiaEmpezarCon400DeMineral() {

		Jugador jugador = new Jugador();

		Assert.assertEquals(400, jugador.getCantidadMineral());
	}

	@Test
	public void despuesDeCrearseUnCentroDeMineralAlTomarEnCuentaSuCostoYPasar2TurnosAumentaEn20LosMinerales()
			throws RecursosInsuficientesError, CasillaOcupadaError,
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

		Assert.assertEquals(370, jugador.getCantidadMineral());
	}

	@Test
	public void elJugadorDeberiaEmpezarCon0DePoblacionDebidoQueNoEmpiezaConUnDeposito() {

		Jugador jugador = new Jugador();

		Assert.assertEquals(0, jugador.getCantidadPoblacionPosible());
	}

	@Test
	public void alPasarUnTurnoDesdeQueEmpezoDeberiaSeguirCon10DePoblacion() {

		Jugador jugador = new Jugador();
		jugador.pasarTurno();

		Assert.assertEquals(0, jugador.getCantidadPoblacionPosible());
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

		Assert.assertEquals(10, jugador.getCantidadPoblacionPosible());
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

		Assert.assertEquals(20, jugador.getCantidadPoblacionPosible());
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

		Assert.assertEquals(200, jugador.getCantidadPoblacionPosible());
	}

	@Test
	public void elJugadorDeberiaEmpezarCon100DeGas() {

		Jugador jugador = new Jugador();

		Assert.assertEquals(100, jugador.getCcantidadGas());
	}

	@Test
	public void despuesDeCrearseLaRefineriaYPasar6TurnosAumentaEn20LaCantidadDeGas()
			throws RecursosInsuficientesError, CasillaOcupadaError,
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

		Assert.assertEquals(120, jugador.getCcantidadGas());
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
			RecolectorInvalidoError, NoHaySoldadosParaPosicionarError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {

		Jugador jugador = new Jugador();

		Assert.assertEquals(0, jugador.cantidadSoldadosParaPosicionar());

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

		Assert.assertEquals(0, jugador.cantidadSoldadosParaPosicionar());

		for (int i = 0; i < 3; i++) {
			jugador.pasarTurno();
		}// Termina de crearse el marine

		Assert.assertEquals(1, jugador.cantidadSoldadosParaPosicionar());

		Coordenada coordenadaMarine = new Coordenada(1, 4);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		jugador.posicionarSoldadoEnColaDeEspera(casillaMarine);

		Assert.assertTrue(casillaMarine.estaOcupadaLaTierra());

		Assert.assertEquals(0, jugador.cantidadSoldadosParaPosicionar());
	}

	@Test
	public void siSeDestruyeLaUnicaUnidadDelJugadorEstaDestruido()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
		deposito.recibirDanio(600);
		jugador.pasarTurno();

		Assert.assertTrue(jugador.estaDestruido());
	}

	@Test
	public void siSeDestruyeUnaUnidadDeDosDelJugadorNoEstaDestruido()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Coordenada otroCoordenada = new Coordenada(1, 1);
		Casilla otraCasilla = new Casilla(otroCoordenada);
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
		@SuppressWarnings("unused")
		DepositoDeSuministros otroDeposito = new DepositoDeSuministros(jugador,
				otraCasilla);
		deposito.recibirDanio(600);
		jugador.pasarTurno();

		Assert.assertFalse(jugador.estaDestruido());
	}

	@Test
	public void seInicializaElJugadorConDepositoYSigueConLaMismaCantidadDeMinerales()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(2, 2);
		Casilla casilla = new Casilla(coordenada);
		jugador.iniciarConDeposito(casilla);

		Assert.assertEquals(10, jugador.getCantidadPoblacionPosible());

		Assert.assertEquals(400, jugador.getCantidadMineral());
	}
	
	@Test
	public void alIniciarrElJugadorConMarineDebeTener1SoldadoParaPosicionarYMismoMineral()
			throws RecursosInsuficientesError, CasillaOcupadaError{
		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(2, 2);
		Casilla casilla = new Casilla(coordenada);
		jugador.iniciarConDeposito(casilla);
		jugador.iniciarConMarineParaPosicionar();
		
		Assert.assertEquals(1, jugador.cantidadSoldadosParaPosicionar());
		Assert.assertEquals(400, jugador.getCantidadMineral());
		
	}

	@Test
	public void elMarineDeberiaPoderAtacarDeNuevoAlPasarUnTurno()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, NoHaySoldadosParaPosicionarError,
			CoordenadaInvalidaError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento,
			DistanciaMayorQueElRangoError {
		Mapa mapa = new Mapa(4);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();

		Coordenada coordenadaBarraca1 = new Coordenada(1, 3);
		Coordenada coordenadaBarraca2 = new Coordenada(2, 5);
		Casilla casillaBarraca1 = mapa.getCasilla(coordenadaBarraca1);
		Casilla casillaBarraca2 = mapa.getCasilla(coordenadaBarraca2);
		Barraca barraca1 = new Barraca(jugador1, casillaBarraca1);
		Barraca barraca2 = new Barraca(jugador2, casillaBarraca2);
		for (int i = 0; i < 12; i++) {
			jugador1.pasarTurno();
			jugador2.pasarTurno();
		}// Termina de crearse la barraca
			// se aumental la poblacion para no cenecitar crear un deposito
		jugador1.aumentarPoblacion();
		jugador2.aumentarPoblacion();
		barraca1.entrenarMarine(jugador1);
		barraca2.entrenarMarine(jugador2);
		for (int i = 0; i < 3; i++) {
			jugador1.pasarTurno();
			jugador2.pasarTurno();
		}// Termina de crearse el marine
		Coordenada coordenadaMarine1 = new Coordenada(1, 4);
		Coordenada coordenadaMarine2 = new Coordenada(2, 4);
		Casilla casillaMarine1 = mapa.getCasilla(coordenadaMarine1);
		Casilla casillaMarine2 = mapa.getCasilla(coordenadaMarine2);
		jugador1.posicionarSoldadoEnColaDeEspera(casillaMarine1);
		jugador2.posicionarSoldadoEnColaDeEspera(casillaMarine2);
		UnidadSoldado marine1 = (UnidadSoldado) mapa
				.obtenerElementoTerrestreEnPosicion(coordenadaMarine1);
		UnidadSoldado marine2 = (UnidadSoldado) mapa
				.obtenerElementoTerrestreEnPosicion(coordenadaMarine2);
		marine1.atacarEnemigo(marine2, jugador1);
		jugador1.pasarTurno();
		marine1.atacarEnemigo(marine2, jugador1);
		Assert.assertEquals(28, marine2.vidaRestante());
	}

	@Test
	public void deberiaTener2DePoblacionAlCrearse2Marine()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError, NoHaySoldadosParaPosicionarError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {

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

		Assert.assertEquals(1, jugador.getCantidadPoblacionOcupada());

		barraca.entrenarMarine(jugador);
		for (int i = 0; i < 3; i++) {
			jugador.pasarTurno();
		}// Termina de crearse el marine
		Coordenada coordenadaMarine2 = new Coordenada(2, 4);
		Casilla casillaMarine2 = new Casilla(coordenadaMarine2);
		jugador.posicionarSoldadoEnColaDeEspera(casillaMarine2);

		Assert.assertEquals(2, jugador.getCantidadPoblacionOcupada());

	}

	@Test
	public void deberiaVolverATener0DePoblacionSiLeMatanElMarine()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError, NoHaySoldadosParaPosicionarError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {

		Jugador jugador = new Jugador();
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
		Assert.assertEquals(1, jugador.getCantidadPoblacionOcupada());
		Unidad marine = casillaMarine.getOcupanteTerrestre();
		marine.recibirDanio(1000);
		Assert.assertTrue(marine.estaDestruido());
		jugador.pasarTurno();
		Assert.assertEquals(0, jugador.getCantidadPoblacionOcupada());
	}

	@Test
	public void siEstaOcupadaLaCasillaLaCantidadDeUnidadesAPosicionarEsIgual()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {
		Jugador jugador = new Jugador();
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
		Marine marine = new Marine(jugador);
		marine.posicionar(casillaMarine);
		Assert.assertEquals(1, jugador.cantidadSoldadosParaPosicionar());
		try {
			jugador.posicionarSoldadoEnColaDeEspera(casillaMarine);
			Assert.fail();
		} catch (NoHaySoldadosParaPosicionarError | CasillaOcupadaError error) {

		}
		Assert.assertEquals(1, jugador.cantidadSoldadosParaPosicionar());
	}

	@Test(expected = PoblacionLimiteAlcanzadaError.class)
	public void deberiaNoPoderEntrenarMarineSinLosDepositosRequeridos()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError, NoHaySoldadosParaPosicionarError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 3);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}// Termina de crearse la barraca
		barraca.entrenarMarine(jugador);
		Assert.fail();

	}

}
