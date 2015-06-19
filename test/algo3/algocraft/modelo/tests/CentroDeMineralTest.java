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
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class CentroDeMineralTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnCentro()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		jugador.pagar(400, 0);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		centro.pasarTurno();
	}

	@Test
	public void elTiempoDeConstruccionDeUnCentroDeMineralEsde4Turnos()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertEquals(4, centro.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnCentroDeMineralLuegoDePasarUnTurnoEsde3Turnos()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		centro.pasarTurno();

		Assert.assertEquals(3, centro.tiempoDeConstruccion());
	}

	@Test
	public void elCentroDeMineralSeEncuentraInicialmenteEnConstruccion()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertTrue(centro.enConstruccion());
	}

	@Test
	public void luegoDe4TurnosELCentroDeMineralEstaConstuido()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centro.pasarTurno();
		}

		Assert.assertFalse(centro.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnCentroDeMineralEnConstruccionLoDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaCentroDeMineral = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaCentroDeMineral = new Casilla(coordenadaCentroDeMineral);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		casillaCentroDeMineral.agregarRecurso(mineral);
		centro.posicionar(casillaCentroDeMineral);
		marine.atacarEnemigo(centro);
		Assert.assertTrue(centro.estaDestruido());

	}

	@Test
	public void siUnMarineAtacaUnCentroDeMineralYaConstruidoNoLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaCentroDeMineral = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaCentroDeMineral = new Casilla(coordenadaCentroDeMineral);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		casillaCentroDeMineral.agregarRecurso(mineral);
		centro.posicionar(casillaCentroDeMineral);

		for (int i = 0; i < 4; i++) {
			centro.pasarTurno();
		}

		marine.atacarEnemigo(centro);
		Assert.assertFalse(centro.estaDestruido());

	}

	@Test
	public void elCentroDeMineralConstruidoDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centro.pasarTurno();
		}
		int vidaInicial = centro.vidaRestante();
		centro.recibirDanio(1,1);
		int vidaFinal = centro.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaAlCentroDeMineralConstruidoEs499()
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centro.pasarTurno();
		}
		centro.recibirDanio(1,1);

		Assert.assertEquals(499, centro.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnCentroDeMineralEnUnaCasillaDesocupada()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);

		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		casilla.agregarRecurso(mineral);
		Assert.assertTrue(centro.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnCentroDeMineralEnUnaCasillaOcupadaPorUnaunidad()
			throws RecursosInsuficientesError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		Barraca barraca = new Barraca(jugador);
		barraca.posicionar(casilla);

		Assert.assertFalse(centro.posicionar(casilla));
	}

	@Test
	public void deberiaPoderPosicionarseUnaBarracaEnUnaCasillaOcupadaPorUnRecurso()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		casilla.agregarRecurso(mineral);

		Assert.assertTrue(centro.posicionar(casilla));
	}

	@Test
	public void unCentroDeMineraldeberiaGuardarSuPosicion()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		casilla.agregarRecurso(mineral);
		centro.posicionar(casilla);

		Assert.assertEquals(casilla, centro.posicion());
	}

	@Test
	public void unCentroDeMineralEsInicialmenteTerrestre()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertTrue(centro.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		centro.recibirDanio(2000,2000);
		Assert.assertTrue(centro.estaDestruido());
		centro.recibirDanio(2,2);

	}

	@Test
	public void deberiaRecolectarMineralElCentroDeMineral()
			throws RecursosInsuficientesError {
		MinaDeMinerales mineral = new MinaDeMinerales(30);
		Jugador jugador = new Jugador();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		Assert.assertTrue(centroDeMineral.recolectar());
	}

	@Test
	public void deberiaNoPoderRecolectarElCentroDeMineralSiSeAcabaElMineral()
			throws RecursosInsuficientesError {
		MinaDeMinerales mineral = new MinaDeMinerales(1000);
		Jugador jugador = new Jugador();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		for (int i = 1; i <= 100; i++) { // 100 turnos , se saca todo el mineral
			centroDeMineral.recolectar();
		}
		Assert.assertFalse(centroDeMineral.recolectar());
	}

	@Test
	public void deberiaRecolectar50MineralEn5TurnosElCentroDeMineral()
			throws RecursosInsuficientesError {
		MinaDeMinerales mineral = new MinaDeMinerales(1000);
		Jugador jugador = new Jugador();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		for (int i = 1; i <= 5; i++) {
			centroDeMineral.recolectar();
		}
		Assert.assertEquals(50, centroDeMineral.getCantidadRecursoRecolectado());
	}

	@Test
	public void deberiaRecolectarSiElMineralTiene7()
			throws RecursosInsuficientesError {
		MinaDeMinerales mineral = new MinaDeMinerales(7);
		Jugador jugador = new Jugador();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		centroDeMineral.recolectar();
		Assert.assertEquals(7, centroDeMineral.getCantidadRecursoRecolectado());
	}

	@Test
	public void deberiaDecrementarEn10ElMineralAlSerRecolectado()
			throws RecursosInsuficientesError {
		MinaDeMinerales mineral = new MinaDeMinerales(30);
		Jugador jugador = new Jugador();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		centroDeMineral.recolectar();
		Assert.assertEquals(20, mineral.getCantidad());
	}

}