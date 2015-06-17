package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Marine;
import algo3.algocraft.modelo.unidades.unidadesSoldados.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.PerteneceAlMismoJugadorError;

public class FabricaTest {

	@Test
	public void elTiempoDeConstruccionDeUnaFabricaEsde12Turnos()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertEquals(12, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaFabricaLuegoDePasarUnTUrnoEsde11Turnos()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		fabrica.pasarTurno();

		Assert.assertEquals(11, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void laFabricaSeEncuentraInicialmenteEnConstruccion()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertTrue(fabrica.enConstruccion());
	}

	@Test
	public void luegoDe12TurnosLaFabricaEstaConstuida()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int i = 0; i < 13; i++) {
			fabrica.pasarTurno();
		}

		Assert.assertFalse(fabrica.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnaFabricaEnConstruccionLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, PerteneceAOtroJugadorError {

		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
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
			NoPuedeAtacarMultiplesVecesError, PerteneceAOtroJugadorError {

		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Barraca barraca = new Barraca(jugadorAliado);
		Fabrica fabrica = new Fabrica(jugadorAliado, barraca);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaFabrica = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		fabrica.posicionar(casillaFabrica);

		for (int i = 0; i < 13; i++) {
			fabrica.pasarTurno();
		}

		marine.atacarEnemigo(fabrica);
		Assert.assertFalse(fabrica.estaDestruido());

	}

	@Test
	public void laFabricaConstruidaDeberiaRecibirDanio1()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int i = 0; i < 13; i++) {
			fabrica.pasarTurno();
		}
		int vidaInicial = fabrica.vidaRestante();
		fabrica.recibirDanio(1);
		int vidaFinal = fabrica.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaALaFabricaConstruidaEs1249()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int i = 0; i < 13; i++) {
			fabrica.pasarTurno();
		}
		fabrica.recibirDanio(1);

		Assert.assertEquals(1249, fabrica.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaFabricaEnUnaCasillaDesocupada()
			throws PerteneceAOtroJugadorError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertTrue(fabrica.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnaFabricaEnUnaCasillaOcupadaPorUnaunidad()
			throws PerteneceAOtroJugadorError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		barraca.posicionar(casilla);

		Assert.assertFalse(fabrica.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnaFabricaEnUnaCasillaOcupadaPorUnRecurso()
			throws PerteneceAOtroJugadorError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(fabrica.posicionar(casilla));
	}

	@Test
	public void deberiaGuardarSuPosicion() throws PerteneceAOtroJugadorError {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		fabrica.posicionar(casilla);

		Assert.assertEquals(casilla, fabrica.posicion());
	}

	@Test
	public void unaFabricaEsInicialmenteTerrestre()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertTrue(fabrica.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError, PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);
		fabrica.recibirDanio(2000);
		Assert.assertTrue(fabrica.estaDestruido());
		fabrica.recibirDanio(2);

	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoGolliaPorqueNoTerminoDeConstruirse()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertFalse(fabrica.entrenarGolliat());
	}

	@Test
	public void deberiaEntrenarUnSoldadoGolliat()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(jugador, barraca);
		for (int j = 0; j < 13; j++) {
			fabrica.pasarTurno();
		}

		Assert.assertTrue(fabrica.entrenarGolliat());

	}

}
