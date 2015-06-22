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
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class CentroDeMineralTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadorNoTieneLosRecursosParaCrearUnCentro()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		jugador.pagar(400, 0);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		centro.pasarTurno();
	}

	@Test
	public void elTiempoDeConstruccionDeUnCentroDeMineralEsde4Turnos()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertEquals(4, centro.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnCentroDeMineralLuegoDePasarUnTurnoEsde3Turnos()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		centro.pasarTurno();

		Assert.assertEquals(3, centro.tiempoDeConstruccion());
	}

	@Test
	public void elCentroDeMineralSeEncuentraInicialmenteEnConstruccion()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertTrue(centro.enConstruccion());
	}

	@Test
	public void luegoDe4TurnosELCentroDeMineralEstaConstuido()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
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
			CasillaOcupadaError, RecolectorInvalidoError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaCentroDeMineral = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaCentroDeMineral = new Casilla(coordenadaCentroDeMineral);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casillaCentroDeMineral);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		marine.posicionar(casillaMarine);
		marine.atacarEnemigo(centro, jugadorEnemigo);

		Assert.assertTrue(centro.estaDestruido());
	}

	@Test
	public void siUnMarineAtacaUnCentroDeMineralYaConstruidoNoLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError, RecolectorInvalidoError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaCentroDeMineral = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaCentroDeMineral = new Casilla(coordenadaCentroDeMineral);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casillaCentroDeMineral);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		marine.posicionar(casillaMarine);
		for (int i = 0; i < 4; i++) {
			centro.pasarTurno();
		}
		marine.atacarEnemigo(centro, jugadorEnemigo);

		Assert.assertFalse(centro.estaDestruido());
	}

	@Test
	public void elCentroDeMineralConstruidoDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, RecursosInsuficientesError,
			RecolectorInvalidoError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centro.pasarTurno();
		}
		int vidaInicial = centro.vidaRestante();
		centro.recibirDanio(1);
		int vidaFinal = centro.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaAlCentroDeMineralConstruidoEs499()
			throws YaEstaDestruidoError, RecursosInsuficientesError,
			RecolectorInvalidoError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centro.pasarTurno();
		}
		centro.recibirDanio(1);

		Assert.assertEquals(499, centro.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaBarracaEnUnaCasillaOcupadaPorUnaMinaATravesDeLaMina()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertEquals(casilla, centro.posicion());
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
	public void unCentroDeMineraldeberiaGuardarSuPosicion()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			RecolectorInvalidoError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertEquals(casilla, centro.posicion());
	}

	@Test
	public void unCentroDeMineralEsInicialmenteTerrestre()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertTrue(centro.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError, RecursosInsuficientesError,
			RecolectorInvalidoError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		centro.recibirDanio(2000);

		Assert.assertTrue(centro.estaDestruido());

		centro.recibirDanio(2);
	}

	@Test
	public void deberiaRecolectarMineralElCentroDeMineral()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centroDeMineral.pasarTurno();
		}
		int cantidadInicial = jugador.cantidadMineral();
		centroDeMineral.pasarTurno();
		int cantidadFinal = jugador.cantidadMineral();

		Assert.assertEquals(10, cantidadFinal - cantidadInicial);
	}

	@Test
	public void deberiaRecolectar50MineralEn5TurnosElCentroDeMineral()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centroDeMineral.pasarTurno();
		}
		int cantidadInicial = jugador.cantidadMineral();
		for (int i = 1; i <= 5; i++) {
			centroDeMineral.pasarTurno();
		}
		int cantidadFinal = jugador.cantidadMineral();

		Assert.assertEquals(50, cantidadFinal - cantidadInicial);
	}

	@Test
	public void deberiaRecolectarSiElMineralTiene7()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(7);
		mineral.posicionar(casilla);
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centroDeMineral.pasarTurno();
		}
		int cantidadInicial = jugador.cantidadMineral();
		centroDeMineral.pasarTurno();
		int cantidadFinal = jugador.cantidadMineral();

		Assert.assertEquals(7, cantidadFinal - cantidadInicial);
	}

	@Test
	public void deberiaDecrementarEn10ElMineralAlSerRecolectado()
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		mineral.posicionar(casilla);
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centroDeMineral.pasarTurno();
		}
		centroDeMineral.pasarTurno();

		Assert.assertEquals(90, mineral.getCantidad());
	}

}