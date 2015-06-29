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
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.BarracaNoConstruidaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class FabricaTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosMineralesParaCrearUnaFabrica()
			throws RecursosInsuficientesError, PerteneceAOtroJugadorError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		jugador.pagar(250, 0);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		fabrica.pasarTurno();
	}

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneElGasesParaCrearUnaFabrica()
			throws RecursosInsuficientesError, PerteneceAOtroJugadorError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		jugador.pagar(0, 100);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		fabrica.pasarTurno();
	}

	@Test(expected = BarracaNoConstruidaError.class)
	public void siSeEmpezoACrearUnaBarracaPeroSigueEnConstruccionNoSePuedeConstruirUnaFabrica()
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		new Fabrica(jugador, casillaFabrica, barraca);
	}

	@Test
	public void siSePudoCrearUnaBarraSePuedeConstruirUnaFabrica()
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);

		Assert.assertEquals(casillaFabrica.getOcupanteTerrestre(), fabrica);
	}

	@Test
	public void elTiempoDeConstruccionDeUnaFabricaEsde12Turnos()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, BarracaNoConstruidaError {
		Jugador jugador = new Jugador();

		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);

		Assert.assertEquals(12, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaFabricaLuegoDePasarUnTUrnoEsde11Turnos()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		fabrica.pasarTurno();

		Assert.assertEquals(11, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void laFabricaSeEncuentraInicialmenteEnConstruccion()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);

		Assert.assertTrue(fabrica.enConstruccion());
	}

	@Test
	public void luegoDe12TurnosLaFabricaEstaConstuida()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}

		Assert.assertFalse(fabrica.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnaFabricaEnConstruccionLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError,
			BarracaNoConstruidaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugadorAliado, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugadorAliado, casillaFabrica, barraca);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		marine.atacarEnemigo(fabrica, jugadorEnemigo);

		Assert.assertTrue(fabrica.estaDestruido());
	}

	@Test
	public void siUnMarineAtacaUnaFabricaYaConstruidaNoLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError,
			BarracaNoConstruidaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugadorAliado, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugadorAliado, casillaFabrica, barraca);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}
		marine.atacarEnemigo(fabrica, jugadorEnemigo);

		Assert.assertFalse(fabrica.estaDestruido());
	}

	@Test
	public void laFabricaConstruidaDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, BarracaNoConstruidaError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}
		int vidaInicial = fabrica.vidaRestante();
		fabrica.recibirDanio(1);
		int vidaFinal = fabrica.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaALaFabricaConstruidaEs1249()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, BarracaNoConstruidaError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}
		fabrica.recibirDanio(1);

		Assert.assertEquals(1249, fabrica.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaFabricaEnUnaCasillaDesocupada()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		Coordenada coordenadaNueva = new Coordenada(1, 1);
		Casilla casillaNueva = new Casilla(coordenadaNueva);
		fabrica.posicionar(casillaNueva);

		Assert.assertEquals(casillaNueva, fabrica.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererPosicionarUnaFabricaEnUnaCasillaOcupadaPorUnaunidad()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		fabrica.posicionar(casillaBarraca);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererPosicionarUnaFabricaEnUnaCasillaOcupadaPorUnRecurso()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Coordenada coordenadaMineral = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaMineral = new Casilla(coordenadaMineral);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador, casillaMineral);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casillaMineral.agregarRecurso(mineral);
		fabrica.posicionar(casillaMineral);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabricaInicial = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabricaInicial);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		Coordenada coordenadaFinal = new Coordenada(1, 3);
		Casilla casillaFinal = new Casilla(coordenadaFinal);
		fabrica.posicionar(casillaFinal);

		Assert.assertEquals(casillaFinal, fabrica.posicion());
	}

	@Test
	public void unaFabricaEsInicialmenteTerrestre()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);

		Assert.assertTrue(fabrica.esTerrestre());
	}

	@Test
	public void deberiaDesocuparLaCasillaUnaVezYaDestruido()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, BarracaNoConstruidaError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		fabrica.recibirDanio(2000);

		Assert.assertTrue(fabrica.estaDestruido());
		Assert.assertFalse(casillaFabrica.estaOcupadaLaTierra());
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExexpcionAlEntrenarUnSoldadoMarinePorqueRecibioComoParametroASuMismoJugador()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, PerteneceAOtroJugadorError,
			BarracaNoConstruidaError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		otroJugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int j = 0; j < 12; j++) {
			fabrica.pasarTurno();
		}
		barraca.entrenarMarine(otroJugador);
	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoGolliaPorqueNoTerminoDeConstruirse()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);

		Assert.assertFalse(fabrica.entrenarGolliat(jugador));
	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoGolliaPorqueLaBarracaEstaDestruida()
			throws PerteneceAOtroJugadorError, YaEstaDestruidoError,
			RecursosInsuficientesError, BarracaNoConstruidaError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}
		barraca.recibirDanio(2000);

		Assert.assertFalse(fabrica.entrenarGolliat(jugador));
	}

	@Test
	public void deberiaEntrenarUnSoldadoGolliat()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		// agrego recursos para poder pagar todas las unidades
		jugador.aumentarMineral(50);
		jugador.aumentarGas(50);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int j = 0; j < 12; j++) {
			fabrica.pasarTurno();
		}

		Assert.assertTrue(fabrica.entrenarGolliat(jugador));
	}

	@Test
	public void noDeberiaPoderComenzarAEntrenarAUnGolliatMientrasEsteEntrenandoAOtroGolliat()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(50);
		jugador.aumentarGas(50);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int j = 0; j < 12; j++) {
			fabrica.pasarTurno();
		}
		fabrica.entrenarGolliat(jugador);

		Assert.assertFalse(fabrica.entrenarGolliat(jugador));
	}

	@Test
	public void deberiaPoderEntrenarAUnGolliatLuegoDeFinalizarElEntrenamientoDeOtroGolliat()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(150);
		jugador.aumentarGas(100);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int j = 0; j < 12; j++) {
			fabrica.pasarTurno();
		}
		fabrica.entrenarGolliat(jugador);
		for (int j = 0; j < 6; j++) {
			fabrica.pasarTurno();
		}

		Assert.assertTrue(fabrica.entrenarGolliat(jugador));
	}

	@Test(expected = PerteneceAOtroJugadorError.class)
	public void deberiaLanzarLaExcepcionPerteneceAOtroJugadorErrorSiLaBarracaPerteneceAOtroJugador()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = new Barraca(jugadorEnemigo, casillaBarraca);
		Fabrica fabrica = new Fabrica(jugadorAliado, casillaFabrica, barraca);
		fabrica.pasarTurno();
	}

}
