package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.modelo.unidades.unidadesMoviles.DistanciaFueraDeRangoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class RefineriaTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadorNoTieneLosRecursosParaCrearUnaRefineria()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		jugador.pagar(400, 0);
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);
		refineria.pasarTurno();
	}

	@Test
	public void elTiempoDeConstruccionDeUnaRefineriaEsde6Turnos()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertEquals(6, refineria.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaRefineriaLuegoDePasarUnTurnoEsde5Turnos()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);
		refineria.pasarTurno();

		Assert.assertEquals(5, refineria.tiempoDeConstruccion());
	}

	@Test
	public void LaRefineriaSeEncuentraInicialmenteEnConstruccion()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertTrue(refineria.enConstruccion());
	}

	@Test
	public void luegoDe4TurnosLaRefineriaEstaConstuido()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}

		Assert.assertFalse(refineria.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnaRefineriaEnConstruccionLoDestruye()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError, RecolectorInvalidoError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			DistanciaFueraDeRangoError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaRefineria = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaRefineria = new Casilla(coordenadaRefineria);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casillaRefineria);
		Refineria refineria = new Refineria(volcan, jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		marine.posicionar(casillaMarine);
		marine.atacarEnemigo(refineria, jugadorEnemigo);

		Assert.assertTrue(refineria.estaDestruido());
	}

	@Test
	public void siUnMarineAtacaUnaRefineriaYaConstruidaNoLaDestruye()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError, RecolectorInvalidoError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			DistanciaFueraDeRangoError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaRefineria = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaRefineria = new Casilla(coordenadaRefineria);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casillaRefineria);
		Refineria refineria = new Refineria(volcan, jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		marine.posicionar(casillaMarine);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}
		marine.atacarEnemigo(refineria, jugadorEnemigo);

		Assert.assertFalse(refineria.estaDestruido());
	}

	@Test
	public void LaRefineriaConstruidaDeberiaRecibirDanio1()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}
		int vidaInicial = refineria.vidaRestante();
		refineria.recibirDanio(1);
		int vidaFinal = refineria.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaALaRefineriaConstruidaEs749()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}
		refineria.recibirDanio(1);

		Assert.assertEquals(749, refineria.vidaRestante());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaNoPoderPosicionarseUnaRefineriaEnUnaCasillaOcupadaPorUnaunidad()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		@SuppressWarnings("unused")
		Barraca barraca = new Barraca(jugador, casilla);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		// no encta aca porque el posicionar del mineral ya lanzo la excepcion
		Refineria refineria = new Refineria(volcan, jugador);
		refineria.pasarTurno();
	}

	@Test
	public void deberiaPoderPosicionarseUnaRefineriaEnUnaCasillaOcupadaPorUnVolcanATravesDelVolcan()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertEquals(casilla, refineria.posicion());
	}

	@Test(expected = RecolectorInvalidoError.class)
	public void deberiaLanzarUnaExcepcionAlQuererCrearUnCentroEnUnVolcan()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(volcan, jugador);
		centro.pasarTurno();
	}

	@Test
	public void unRefineriadeberiaGuardarSuPosicion()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertEquals(casilla, refineria.posicion());
	}

	@Test
	public void unRefineriaEsInicialmenteTerrestre()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertTrue(refineria.esTerrestre());
	}

	@Test
	public void deberiaDesocuparLaCasillaUnaVezYaDestruido()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);
		refineria.recibirDanio(2000);

		Assert.assertTrue(refineria.estaDestruido());
		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test
	public void deberiaRecolectarMineralLaRefineria()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Jugador jugador = new Jugador();
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}
		int cantidadInicial = jugador.getCcantidadGas();
		refineria.pasarTurno();
		int cantidadFinal = jugador.getCcantidadGas();

		Assert.assertEquals(10, cantidadFinal - cantidadInicial);
	}

	@Test
	public void deberiaRecolectar50MineralEn5TurnosLaRefineria()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Jugador jugador = new Jugador();
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}
		int cantidadInicial = jugador.getCcantidadGas();
		for (int i = 1; i <= 5; i++) {
			refineria.pasarTurno();
		}
		int cantidadFinal = jugador.getCcantidadGas();

		Assert.assertEquals(50, cantidadFinal - cantidadInicial);
	}

	@Test
	public void deberiaRecolectarSiElMineralTiene7()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(7);
		volcan.posicionar(casilla);
		Jugador jugador = new Jugador();
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}
		int cantidadInicial = jugador.getCcantidadGas();
		refineria.pasarTurno();
		int cantidadFinal = jugador.getCcantidadGas();

		Assert.assertEquals(7, cantidadFinal - cantidadInicial);
	}

	@Test
	public void deberiaDecrementarEn10ElMineralAlSerRecolectado()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		volcan.posicionar(casilla);
		Jugador jugador = new Jugador();
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}
		refineria.pasarTurno();

		Assert.assertEquals(90, volcan.getCantidad());
	}

}