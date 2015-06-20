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
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class DepositoDeSuministrosTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnDeposito()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		jugador.pagar(400, 0);
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);
		deposito.pasarTurno();
	}

	@Test
	public void elTiempoDeConstruccionDeUnDepositoEsde6Turnos()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);

		Assert.assertEquals(6, deposito.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnDepositoLuegoDePasarUnTUrnoEsde5Turnos()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);
		deposito.pasarTurno();

		Assert.assertEquals(5, deposito.tiempoDeConstruccion());
	}

	@Test
	public void elDepositoDeSuministrosSeEncuentraInicialmenteEnConstruccion()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);

		Assert.assertTrue(deposito.enConstruccion());
	}

	@Test
	public void luegoDe6TurnosElDepositoDeSuministrosEstaConstuido()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);
		for (int i = 0; i < 6; i++) {
			deposito.pasarTurno();
		}

		Assert.assertFalse(deposito.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnDepositoEnConstruccionLoDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(
				jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaDeposito = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaDeposito = new Casilla(coordenadaDeposito);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		deposito.posicionar(casillaDeposito);
		marine.atacarEnemigo(deposito);
		Assert.assertTrue(deposito.estaDestruido());

	}

	@Test
	public void siUnMarineAtacaUnDepositoYaConstruidoNoLoDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(
				jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaDeposito = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaDeposito = new Casilla(coordenadaDeposito);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		deposito.posicionar(casillaDeposito);

		for (int i = 0; i < 6; i++) {
			deposito.pasarTurno();
		}

		marine.atacarEnemigo(deposito);
		Assert.assertFalse(deposito.estaDestruido());

	}

	@Test
	public void elDepositoDeSuministrosConstruidoDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);
		for (int i = 0; i < 6; i++) {
			deposito.pasarTurno();
		}
		int vidaInicial = deposito.vidaRestante();
		deposito.recibirDanio(1);
		int vidaFinal = deposito.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaALaDepositoDeSuministrosConstruidoEs499()
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);
		for (int i = 0; i < 13; i++) {
			deposito.pasarTurno();
		}
		deposito.recibirDanio(1);

		Assert.assertEquals(499, deposito.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnDepositoEnUnaCasillaDesocupada()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);
		deposito.posicionar(casilla);
		Assert.assertEquals(casilla, deposito.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQUererPosicionarUnDepositoEnUnaCasillaOcupadaPorUnaunidad()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		DepositoDeSuministros primerDeposito = new DepositoDeSuministros(
				jugador);
		DepositoDeSuministros segundoDeposito = new DepositoDeSuministros(
				jugador);
		primerDeposito.posicionar(casilla);
		segundoDeposito.posicionar(casilla);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQUererPosicionarUnDepositoEnUnaCasillaOcupadaPorUnRecurso()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);
		deposito.posicionar(casilla);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws RecursosInsuficientesError,
			CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);

		deposito.posicionar(casilla);

		Assert.assertEquals(casilla, deposito.posicion());
	}

	@Test
	public void unaDepositoDeSuministrosEsInicialmenteTerrestre()
			throws RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);

		Assert.assertTrue(deposito.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError, RecursosInsuficientesError {
		Jugador jugador = new Jugador();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);
		deposito.recibirDanio(2000);
		Assert.assertTrue(deposito.estaDestruido());
		deposito.recibirDanio(2);

	}

}
