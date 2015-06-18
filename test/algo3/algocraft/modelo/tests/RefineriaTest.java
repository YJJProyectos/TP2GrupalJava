package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class RefineriaTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnaRefineria()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		jugador.pagar(400, 0);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		refineria.pasarTurno();
	}

	@Test
	public void elTiempoDeConstruccionDeUnaRefineriaEsde6Turnos()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertEquals(6, refineria.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaRefineriaLuegoDePasarUnTurnoEsde5Turnos()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		refineria.pasarTurno();

		Assert.assertEquals(5, refineria.tiempoDeConstruccion());
	}

	@Test
	public void LaRefineriaSeEncuentraInicialmenteEnConstruccion()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertTrue(refineria.enConstruccion());
	}

	@Test
	public void luegoDe4TurnosLaRefineriaEstaConstuido()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}

		Assert.assertFalse(refineria.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnaRefineriaEnConstruccionLoDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaRefineria = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaRefineria = new Casilla(coordenadaRefineria);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		casillaRefineria.agregarRecurso(volcan);
		refineria.posicionar(casillaRefineria);
		marine.atacarEnemigo(refineria);
		Assert.assertTrue(refineria.estaDestruido());

	}

	@Test
	public void siUnMarineAtacaUnaRefineriaYaConstruidaNoLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaRefineria = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaRefineria = new Casilla(coordenadaRefineria);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		casillaRefineria.agregarRecurso(volcan);
		refineria.posicionar(casillaRefineria);

		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}

		marine.atacarEnemigo(refineria);
		Assert.assertFalse(refineria.estaDestruido());

	}

	@Test
	public void LaRefineriaConstruidaDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
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
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		for (int i = 0; i < 6; i++) {
			refineria.pasarTurno();
		}
		refineria.recibirDanio(1);

		Assert.assertEquals(749, refineria.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaRefineriaEnUnaCasillaDesocupada()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		casilla.agregarRecurso(volcan);
		Assert.assertTrue(refineria.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnaRefineriaEnUnaCasillaOcupadaPorUnaunidad()
			throws RecursosInsuficientesError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		Barraca barraca = new Barraca(jugador);
		barraca.posicionar(casilla);

		Assert.assertFalse(refineria.posicionar(casilla));
	}

	@Test
	public void deberiaPoderPosicionarseUnaRefineriaEnUnaCasillaOcupadaPorUnRecurso()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		casilla.agregarRecurso(volcan);

		Assert.assertTrue(refineria.posicionar(casilla));
	}

	@Test
	public void unRefineriadeberiaGuardarSuPosicion()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		casilla.agregarRecurso(volcan);
		refineria.posicionar(casilla);

		Assert.assertEquals(casilla, refineria.posicion());
	}

	@Test
	public void unRefineriaEsInicialmenteTerrestre()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertTrue(refineria.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruida()
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(100);
		Refineria refineria = new Refineria(volcan, jugador);
		refineria.recibirDanio(2000);
		Assert.assertTrue(refineria.estaDestruido());
		refineria.recibirDanio(2);

	}

	@Test
	public void deberiaRecolectarMineralLaRefineria()
			throws RecursosInsuficientesError {
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(30);
		Jugador jugador = new Jugador();
		Refineria centroDeMineral = new Refineria(volcan, jugador);
		Assert.assertTrue(centroDeMineral.recolectar());
	}

	@Test
	public void deberiaNoPoderRecolectarLaRefineriaSiSeAcabaElMineral()
			throws RecursosInsuficientesError {
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(1000);
		Jugador jugador = new Jugador();
		Refineria centroDeMineral = new Refineria(volcan, jugador);
		for (int i = 1; i <= 100; i++) { // 100 turnos , se saca todo el volcan
			centroDeMineral.recolectar();
		}
		Assert.assertFalse(centroDeMineral.recolectar());
	}

	@Test
	public void deberiaRecolectar50MineralEn5TurnosLaRefineria()
			throws RecursosInsuficientesError {
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(1000);
		Jugador jugador = new Jugador();
		Refineria centroDeMineral = new Refineria(volcan, jugador);
		for (int i = 1; i <= 5; i++) {
			centroDeMineral.recolectar();
		}
		Assert.assertEquals(50, centroDeMineral.getCantidadRecursoRecolectado());
	}

	@Test
	public void deberiaRecolectarSiElMineralTiene7()
			throws RecursosInsuficientesError {
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(7);
		Jugador jugador = new Jugador();
		Refineria centroDeMineral = new Refineria(volcan, jugador);
		centroDeMineral.recolectar();
		Assert.assertEquals(7, centroDeMineral.getCantidadRecursoRecolectado());
	}

	@Test
	public void deberiaDecrementarEn10ElMineralAlSerRecolectado()
			throws RecursosInsuficientesError {
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(30);
		Jugador jugador = new Jugador();
		Refineria centroDeMineral = new Refineria(volcan, jugador);
		centroDeMineral.recolectar();
		Assert.assertEquals(20, volcan.getCantidad());
	}

}