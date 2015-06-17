package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class CentroDeMineralTest {

	@Test
	public void elTiempoDeConstruccionDeUnCentroDeMineralEsde4Turnos() {
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertEquals(4, centro.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnCentroDeMineralLuegoDePasarUnTurnoEsde3Turnos() {
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		centro.pasarTurno();

		Assert.assertEquals(3, centro.tiempoDeConstruccion());
	}

	@Test
	public void elCentroDeMineralSeEncuentraInicialmenteEnConstruccion() {
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertTrue(centro.enConstruccion());
	}

	@Test
	public void luegoDe4TurnosELCentroDeMineralEstaConstuido() {
		JugadorTerran jugador = new JugadorTerran();
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
			NoPuedeAtacarMultiplesVecesError {

		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
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
			NoPuedeAtacarMultiplesVecesError {

		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
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
			throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
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
			throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		for (int i = 0; i < 4; i++) {
			centro.pasarTurno();
		}
		centro.recibirDanio(1);

		Assert.assertEquals(499, centro.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnCentroDeMineralEnUnaCasillaDesocupada() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		casilla.agregarRecurso(mineral);
		Assert.assertTrue(centro.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnCentroDeMineralEnUnaCasillaOcupadaPorUnaunidad() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		Barraca barraca = new Barraca(jugador);
		barraca.posicionar(casilla);

		Assert.assertFalse(centro.posicionar(casilla));
	}

	@Test
	public void deberiaPoderPosicionarseUnaBarracaEnUnaCasillaOcupadaPorUnRecurso() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		casilla.agregarRecurso(mineral);

		Assert.assertTrue(centro.posicionar(casilla));
	}

	@Test
	public void unCentroDeMineraldeberiaGuardarSuPosicion() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		casilla.agregarRecurso(mineral);
		centro.posicionar(casilla);

		Assert.assertEquals(casilla, centro.posicion());
	}

	@Test
	public void unCentroDeMineralEsInicialmenteTerrestre() {
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);

		Assert.assertTrue(centro.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		CentroDeMineral centro = new CentroDeMineral(mineral, jugador);
		centro.recibirDanio(2000);
		Assert.assertTrue(centro.estaDestruido());
		centro.recibirDanio(2);

	}

	@Test
	public void deberiaRecolectarMineralElCentroDeMineral() {
		MinaDeMinerales mineral = new MinaDeMinerales(30);
		JugadorTerran jugador = new JugadorTerran();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		Assert.assertTrue(centroDeMineral.recolectar());
	}

	@Test
	public void deberiaNoPoderRecolectarElCentroDeMineralSiSeAcabaElMineral() {
		MinaDeMinerales mineral = new MinaDeMinerales(1000);
		JugadorTerran jugador = new JugadorTerran();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		for (int i = 1; i <= 100; i++) { // 100 turnos , se saca todo el mineral
			centroDeMineral.recolectar();
		}
		Assert.assertFalse(centroDeMineral.recolectar());
	}

	@Test
	public void deberiaRecolectar50MineralEn5TurnosElCentroDeMineral() {
		MinaDeMinerales mineral = new MinaDeMinerales(1000);
		JugadorTerran jugador = new JugadorTerran();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		for (int i = 1; i <= 5; i++) {
			centroDeMineral.recolectar();
		}
		Assert.assertEquals(50, centroDeMineral.getCantidadRecursoRecolectado());
	}

	@Test
	public void deberiaRecolectarSiElMineralTiene7() {
		MinaDeMinerales mineral = new MinaDeMinerales(7);
		JugadorTerran jugador = new JugadorTerran();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		centroDeMineral.recolectar();
		Assert.assertEquals(7, centroDeMineral.getCantidadRecursoRecolectado());
	}

	@Test
	public void deberiaDecrementarEn10ElMineralAlSerRecolectado() {
		MinaDeMinerales mineral = new MinaDeMinerales(30);
		JugadorTerran jugador = new JugadorTerran();
		CentroDeMineral centroDeMineral = new CentroDeMineral(mineral, jugador);
		centroDeMineral.recolectar();
		Assert.assertEquals(20, mineral.getCantidad());
	}

}