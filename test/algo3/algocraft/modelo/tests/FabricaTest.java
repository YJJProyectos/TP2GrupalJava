package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class FabricaTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosMineralesParaCrearUnaFabrica()
			throws RecursosInsuficientesError, PerteneceAOtroJugadorError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		jugador.pagar(250, 0);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		fabrica.pasarTurno();
	}

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneElGasesParaCrearUnaFabrica()
			throws RecursosInsuficientesError, PerteneceAOtroJugadorError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		jugador.pagar(0, 100);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		fabrica.pasarTurno();
	}

	@Test
	public void elTiempoDeConstruccionDeUnaFabricaEsde12Turnos()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertEquals(12, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaFabricaLuegoDePasarUnTUrnoEsde11Turnos()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		fabrica.pasarTurno();

		Assert.assertEquals(11, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void laFabricaSeEncuentraInicialmenteEnConstruccion()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertTrue(fabrica.enConstruccion());
	}

	@Test
	public void luegoDe12TurnosLaFabricaEstaConstuida()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}

		Assert.assertFalse(fabrica.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnaFabricaEnConstruccionLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Barraca barraca = new Barraca(jugadorAliado);
		Fabrica fabrica = new Fabrica(jugadorAliado, barraca);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		fabrica.posicionar(casillaFabrica);
		marine.atacarEnemigo(fabrica);
		Assert.assertTrue(fabrica.estaDestruido());

	}

	@Test
	public void siUnMarineAtacaUnaFabricaYaConstruidaNoLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Barraca barraca = new Barraca(jugadorAliado);
		Fabrica fabrica = new Fabrica(jugadorAliado, barraca);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		fabrica.posicionar(casillaFabrica);

		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}

		marine.atacarEnemigo(fabrica);
		Assert.assertFalse(fabrica.estaDestruido());

	}

	@Test
	public void laFabricaConstruidaDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
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
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}
		fabrica.recibirDanio(1);

		Assert.assertEquals(1249, fabrica.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaFabricaEnUnaCasillaDesocupada()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		fabrica.posicionar(casilla);
		Assert.assertEquals(casilla, fabrica.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererPosicionarUnaFabricaEnUnaCasillaOcupadaPorUnaunidad()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		barraca.posicionar(casilla);
		fabrica.posicionar(casilla);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererPosicionarUnaFabricaEnUnaCasillaOcupadaPorUnRecurso()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);
		fabrica.posicionar(casilla);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		fabrica.posicionar(casilla);

		Assert.assertEquals(casilla, fabrica.posicion());
	}

	@Test
	public void unaFabricaEsInicialmenteTerrestre()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertTrue(fabrica.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		fabrica.recibirDanio(2000);
		Assert.assertTrue(fabrica.estaDestruido());
		fabrica.recibirDanio(2);

	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoGolliaPorqueNoTerminoDeConstruirse()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertFalse(fabrica.entrenarGolliat());
	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoGolliaPorqueLaBarracaEstaDestruida()
			throws PerteneceAOtroJugadorError, YaEstaDestruidoError,
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}
		barraca.recibirDanio(2000);

		Assert.assertFalse(fabrica.entrenarGolliat());
	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoGolliaPorqueLaBarracaEstaEnCOnstruccion()
			throws PerteneceAOtroJugadorError, YaEstaDestruidoError,
			RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}

		Assert.assertFalse(fabrica.entrenarGolliat());
	}

	@Test
	public void deberiaEntrenarUnSoldadoGolliat()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int j = 0; j < 12; j++) {
			fabrica.pasarTurno();
		}

		Assert.assertTrue(fabrica.entrenarGolliat());

	}

	@Test
	public void noDeberiaPoderComenzarAEntrenarAUnGolliatMientrasEsteEntrenandoAOtroGolliat()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int j = 0; j < 12; j++) {
			fabrica.pasarTurno();
		}
		fabrica.entrenarGolliat();
		Assert.assertFalse(fabrica.entrenarGolliat());

	}

	@Test
	public void deberiaPoderEntrenarAUnGolliatLuegoDeFinalizarElEntrenamientoDeOtroGolliat()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int j = 0; j < 12; j++) {
			fabrica.pasarTurno();
		}
		fabrica.entrenarGolliat();
		for (int j = 0; j < 6; j++) {
			fabrica.pasarTurno();
		}
		Assert.assertTrue(fabrica.entrenarGolliat());

	}

	@Test(expected = PerteneceAOtroJugadorError.class)
	public void deberiaLanzarLaExcepcionPerteneceAOtroJugadorErrorSiLaBarracaPerteneceAOtroJugador()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError {
		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		Barraca barraca = new Barraca(jugadorEnemigo);
		Fabrica fabrica = new Fabrica(jugadorAliado, barraca);
		fabrica.pasarTurno();
	}

}
