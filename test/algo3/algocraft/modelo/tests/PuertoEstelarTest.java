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
import algo3.algocraft.modelo.unidades.unidadesEdificios.FabricaNoConstruidaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PuertoEstelar;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class PuertoEstelarTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosMineralesParaCrearUnPuertoEstelar()
			throws RecursosInsuficientesError, PerteneceAOtroJugadorError,
			CasillaOcupadaError, FabricaNoConstruidaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}

		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		puerto.pasarTurno();
	}

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneElGasParaCrearUnPuertoEstelar()
			throws RecursosInsuficientesError, PerteneceAOtroJugadorError,
			CasillaOcupadaError, FabricaNoConstruidaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}

		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		puerto.pasarTurno();
	}

	@Test(expected = FabricaNoConstruidaError.class)
	public void siSeEmpezoACrearUnaFabricaPeroSigueEnConstruccionNoSePuedeConstruirUnPuertoEstelar()
			throws FabricaNoConstruidaError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		new PuertoEstelar(jugador, casillaPuertoEstelar, fabrica);
	}

	@Test
	public void siSePudoCrearUnaFabricaEstelarSePuedeConstruirUnPuertoEstelar()
			throws FabricaNoConstruidaError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);

		Assert.assertEquals(casillaPuertoEstelar.getOcupanteTerrestre(), puerto);
	}

	@Test
	public void elTiempoDeConstruccionDeUnPuertoEstelarEsde10Turnos()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, FabricaNoConstruidaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);

		Assert.assertEquals(10, puerto.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnPuertoEstelarLuegoDePasarUnTUrnoEsde9Turnos()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, FabricaNoConstruidaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		puerto.pasarTurno();

		Assert.assertEquals(9, puerto.tiempoDeConstruccion());
	}

	@Test
	public void elPuertoEstelarSeEncuentraInicialmenteEnConstruccion()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);

		Assert.assertTrue(puerto.enConstruccion());
	}

	@Test
	public void luegoDe10TurnosELPuertoEstelarEstaConstuida()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}

		Assert.assertFalse(puerto.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnPuertoEstelarEnConstruccionLoDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError,
			FabricaNoConstruidaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError, BarracaNoConstruidaError {

		Jugador jugadorAliado = new Jugador();
		jugadorAliado.aumentarMineral(1000);
		jugadorAliado.aumentarGas(1000);
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugadorAliado, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugadorAliado.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugadorAliado, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugadorAliado.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugadorAliado,
				casillaPuertoEstelar, fabrica);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaMarine = new Coordenada(1, 3);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		marine.atacarEnemigo(puerto, jugadorEnemigo);

		Assert.assertTrue(puerto.estaDestruido());
	}

	@Test
	public void siUnMarineAtacaUnPuertoEstelaraYaConstruidoNoLoDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError,
			FabricaNoConstruidaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError, BarracaNoConstruidaError {

		Jugador jugadorAliado = new Jugador();
		jugadorAliado.aumentarMineral(1000);
		jugadorAliado.aumentarGas(1000);
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugadorAliado, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugadorAliado.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugadorAliado, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugadorAliado.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugadorAliado,
				casillaPuertoEstelar, fabrica);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaMarine = new Coordenada(1, 3);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		for (int i = 0; i < 10; i++) {
			jugadorAliado.pasarTurno();
		}
		marine.atacarEnemigo(puerto, jugadorEnemigo);

		Assert.assertFalse(puerto.estaDestruido());
	}

	@Test
	public void elPuertoEstelarConstruidaDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, FabricaNoConstruidaError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		puerto.pasarTurno();
		int vidaInicial = puerto.vidaRestante();
		puerto.recibirDanio(1);
		int vidaFinal = puerto.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaAUnPuertoEstelarConstruid0Es1299()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, FabricaNoConstruidaError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		puerto.recibirDanio(1);

		Assert.assertEquals(1299, puerto.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnPuertoEstelarEnUnaCasillaDesocupada()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, FabricaNoConstruidaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		Coordenada coordenadaNueva = new Coordenada(1, 1);
		Casilla casillaNueva = new Casilla(coordenadaNueva);
		puerto.posicionar(casillaNueva);

		Assert.assertEquals(casillaNueva, puerto.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererPosicionarUnPuertoEstelarEnUnaCasillaOcupadaPorUnaunidad()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, FabricaNoConstruidaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		puerto.posicionar(casillaFabrica);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQuererPosicionarUnPuertoEstelarEnUnaCasillaOcupadaPorUnRecurso()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, FabricaNoConstruidaError,
			BarracaNoConstruidaError {

		Coordenada coordenadaMineral = new Coordenada(1, 1);
		Casilla casillaMineral = new Casilla(coordenadaMineral);
		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casillaMineral.agregarRecurso(mineral);
		puerto.posicionar(casillaMineral);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws PerteneceAOtroJugadorError,
			RecursosInsuficientesError, CasillaOcupadaError,
			FabricaNoConstruidaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		Coordenada coordenadaFinal = new Coordenada(1, 3);
		Casilla casillaFinal = new Casilla(coordenadaFinal);
		puerto.posicionar(casillaFinal);

		Assert.assertEquals(casillaFinal, puerto.posicion());
	}

	@Test
	public void unPuertoEstelarEsInicialmenteTerrestre()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);

		Assert.assertTrue(puerto.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError,
			RecursosInsuficientesError, FabricaNoConstruidaError,
			CasillaOcupadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		puerto.recibirDanio(2000);

		Assert.assertTrue(puerto.estaDestruido());

		puerto.recibirDanio(2);
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExexpcionAlEntrenarUnSoldadoEspectroPorqueRecibioComoParametroASuMismoJugador()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, PerteneceAOtroJugadorError,
			FabricaNoConstruidaError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Jugador otroJugador = new Jugador();
		otroJugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		puerto.entrenarEspectro(otroJugador);
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExexpcionAlEntrenarUnaNavePorqueRecibioComoParametroASuMismoJugador()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, PerteneceAOtroJugadorError,
			FabricaNoConstruidaError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Jugador otroJugador = new Jugador();
		otroJugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		puerto.entrenarNaveTransporte(otroJugador);
	}

	@Test
	public void deberiaNoPoderEntrenarUnEspectroPorqueNoTerminoDeConstruirse()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);

		Assert.assertFalse(puerto.entrenarEspectro(jugador));
	}

	@Test
	public void deberiaNoPoderEntrenarUnNavePorqueNoTerminoDeConstruirse()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);

		Assert.assertFalse(puerto.entrenarNaveTransporte(jugador));
	}

	@Test
	public void deberiaNoPoderEntrenarUnEspectroPorqueLaFabricaEstaDestruida()
			throws PerteneceAOtroJugadorError, YaEstaDestruidoError,
			RecursosInsuficientesError, FabricaNoConstruidaError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		fabrica.recibirDanio(2000);

		Assert.assertFalse(puerto.entrenarEspectro(jugador));
	}

	@Test
	public void deberiaNoPoderEntrenarUnaNavePorqueLaPuertoEstelarEstaDestruida()
			throws PerteneceAOtroJugadorError, YaEstaDestruidoError,
			RecursosInsuficientesError, FabricaNoConstruidaError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		fabrica.recibirDanio(2000);

		Assert.assertFalse(puerto.entrenarNaveTransporte(jugador));
	}

	@Test
	public void deberiaEntrenarUnEspectro() throws PerteneceAOtroJugadorError,
			RecursosInsuficientesError, FabricaNoConstruidaError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		jugador.aumentarPoblacion();
		Assert.assertTrue(puerto.entrenarEspectro(jugador));
	}

	@Test
	public void deberiaEntrenarUnaNave() throws PerteneceAOtroJugadorError,
			RecursosInsuficientesError, FabricaNoConstruidaError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError, BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		jugador.aumentarPoblacion();
		Assert.assertTrue(puerto.entrenarNaveTransporte(jugador));
	}

	@Test
	public void noDeberiaPoderComenzarAEntrenarAUnEspectroMientrasEsteEntrenandoAOtraUnidad()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}		
		jugador.aumentarPoblacion();
		puerto.entrenarEspectro(jugador);

		Assert.assertFalse(puerto.entrenarEspectro(jugador));
	}

	@Test
	public void noDeberiaPoderComenzarAEntrenarAUnaNaveMientrasEsteEntrenandoAOtraUnidad()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		jugador.aumentarPoblacion();
		puerto.entrenarNaveTransporte(jugador);

		Assert.assertFalse(puerto.entrenarNaveTransporte(jugador));
	}

	@Test
	public void deberiaPoderEntrenarAUnEspectroLuegoDeFinalizarElEntrenamientoDeOtraUnidad()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		jugador.aumentarPoblacion();
		puerto.entrenarEspectro(jugador);
		for (int j = 0; j < 8; j++) {
			puerto.pasarTurno();
		}
		jugador.aumentarPoblacion();
		Assert.assertTrue(puerto.entrenarEspectro(jugador));
	}

	@Test
	public void deberiaPoderEntrenarAUnaNaveLuegoDeFinalizarElEntrenamientoDeOtraUnidad()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError {

		Jugador jugador = new Jugador();
		jugador.aumentarMineral(1000);
		jugador.aumentarGas(1000);
		jugador.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugador, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugador, casillaPuertoEstelar,
				fabrica);
		for (int i = 0; i < 10; i++) {
			puerto.pasarTurno();
		}
		jugador.aumentarPoblacion();
		puerto.entrenarNaveTransporte(jugador);
		for (int j = 0; j < 7; j++) {
			puerto.pasarTurno();
		}
		jugador.aumentarPoblacion();
		Assert.assertTrue(puerto.entrenarNaveTransporte(jugador));
	}

	@Test(expected = PerteneceAOtroJugadorError.class)
	public void deberiaLanzarLaExcepcionPerteneceAOtroJugadorErrorSiElPuertoEstelarPerteneceAOtroJugador()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError,
			BarracaNoConstruidaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarMineral(1000);
		jugadorEnemigo.aumentarGas(1000);
		jugadorAliado.aumentarMineral(1000);
		jugadorAliado.aumentarGas(1000);
		Coordenada coordenadaBarraca = new Coordenada(1, 2);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaPuertoEstelar = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaPuertoEstelar = new Casilla(coordenadaPuertoEstelar);
		Barraca barraca = new Barraca(jugadorEnemigo, casillaBarraca);
		for (int i = 0; i < 12; i++) {
			jugadorEnemigo.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugadorEnemigo, casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			jugadorEnemigo.pasarTurno();
		}
		PuertoEstelar puerto = new PuertoEstelar(jugadorAliado,
				casillaPuertoEstelar, fabrica);
		puerto.pasarTurno();
	}

}
