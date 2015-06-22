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
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class DepositoDeSuministrosTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnDeposito()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		jugador.pagar(400, 0);
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
		deposito.pasarTurno();
	}

	@Test
	public void elTiempoDeConstruccionDeUnDepositoEsde6Turnos()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);

		Assert.assertEquals(6, deposito.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnDepositoLuegoDePasarUnTUrnoEsde5Turnos()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
		deposito.pasarTurno();

		Assert.assertEquals(5, deposito.tiempoDeConstruccion());
	}

	@Test
	public void elDepositoDeSuministrosSeEncuentraInicialmenteEnConstruccion()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);

		Assert.assertTrue(deposito.enConstruccion());
	}

	@Test
	public void luegoDe6TurnosElDepositoDeSuministrosEstaConstuido()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
		for (int i = 0; i < 6; i++) {
			deposito.pasarTurno();
		}

		Assert.assertFalse(deposito.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnDepositoEnConstruccionLoDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaDeposito = new Coordenada(1, 1);
		Casilla casillaDeposito = new Casilla(coordenadaDeposito);
		DepositoDeSuministros deposito = new DepositoDeSuministros(
				jugadorAliado, casillaDeposito);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		marine.atacarEnemigo(deposito, jugadorEnemigo);

		Assert.assertTrue(deposito.estaDestruido());
	}

	@Test
	public void siUnMarineAtacaUnDepositoYaConstruidoNoLoDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError, JugadorIncorrectoError, PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaDeposito = new Coordenada(1, 1);
		Casilla casillaDeposito = new Casilla(coordenadaDeposito);
		DepositoDeSuministros deposito = new DepositoDeSuministros(
				jugadorAliado, casillaDeposito);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		for (int i = 0; i < 6; i++) {
			deposito.pasarTurno();
		}
		marine.atacarEnemigo(deposito, jugadorEnemigo);

		Assert.assertFalse(deposito.estaDestruido());
	}

	@Test
	public void elDepositoDeSuministrosConstruidoDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
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
			throws YaEstaDestruidoError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
		for (int i = 0; i < 13; i++) {
			deposito.pasarTurno();
		}
		deposito.recibirDanio(1);

		Assert.assertEquals(499, deposito.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnDepositoEnUnaCasillaDesocupada()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casillaInicial = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casillaInicial);
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casillaNueva = new Casilla(coordenada);
		deposito.posicionar(casillaNueva);

		Assert.assertEquals(casillaNueva, deposito.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQUererPosicionarUnDepositoEnUnaCasillaOcupadaPorUnaunidad()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casillaInicial = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros primerDeposito = new DepositoDeSuministros(
				jugador, casillaInicial);
		Coordenada coordenada = new Coordenada(1, 2);
		Casilla casilla = new Casilla(coordenada);
		@SuppressWarnings("unused")
		DepositoDeSuministros segundoDeposito = new DepositoDeSuministros(
				jugador, casilla);
		primerDeposito.posicionar(casilla);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaLanzarUnaExcepcionAlQUererPosicionarUnDepositoEnUnaCasillaOcupadaPorUnRecurso()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casillaInicial = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casillaInicial);
		Coordenada coordenada = new Coordenada(1, 2);
		Casilla casilla = new Casilla(coordenada);
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
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);

		Assert.assertEquals(casilla, deposito.posicion());
	}

	@Test
	public void unaDepositoDeSuministrosEsInicialmenteTerrestre()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);

		Assert.assertTrue(deposito.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError, RecursosInsuficientesError,
			CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador,
				casilla);
		deposito.recibirDanio(2000);

		Assert.assertTrue(deposito.estaDestruido());

		deposito.recibirDanio(2);
	}

}
