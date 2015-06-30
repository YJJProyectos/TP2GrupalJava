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
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.BarracaNoConstruidaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.YaHayUnidadEnEntrenamiento;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class BarracaTest {

	@Test(expected = RecursosInsuficientesError.class)
	public void deberiaLanzarUnErrorSiElJugadornoTieneLosRecursosParaCrearUnaBarraca()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		jugador.pagar(400, 0);
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casilla);
		barraca.pasarTurno();
	}

	@Test
	public void elTiempoDeConstruccionDeUnaBarracaEsde12Turnos()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casilla);

		Assert.assertEquals(12, barraca.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaBarracaLuegoDePasarUnTUrnoEsde11Turnos()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casilla);
		barraca.pasarTurno();

		Assert.assertEquals(11, barraca.tiempoDeConstruccion());
	}

	@Test
	public void laBarracaSeEncuentraInicialmenteEnConstruccion()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casilla);

		Assert.assertTrue(barraca.enConstruccion());
	}

	@Test
	public void luegoDe12TurnosLaBarracaEstaConstuida()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casilla);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}

		Assert.assertFalse(barraca.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnaBarracaEnConstruccionLaDestruye()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Barraca barraca = new Barraca(jugadorAliado, casillaBarraca);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		marine.atacarEnemigo(barraca, jugadorEnemigo);

		Assert.assertTrue(barraca.estaDestruido());
	}

	@Test
	public void siUnMarineAtacaUnaBarracaYaConstruidaNoLaDestruye()
			throws PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError, RecursosInsuficientesError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError {

		Jugador jugadorAliado = new Jugador();
		Jugador jugadorEnemigo = new Jugador();
		jugadorAliado.aumentarPoblacion();
		jugadorEnemigo.aumentarPoblacion();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Barraca barraca = new Barraca(jugadorAliado, casillaBarraca);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}
		marine.atacarEnemigo(barraca, jugadorEnemigo);

		Assert.assertFalse(barraca.estaDestruido());
	}

	@Test
	public void laBarracaConstruidaDeberiaRecibirDanio1()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casilla);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}
		int vidaInicial = barraca.vidaRestante();
		barraca.recibirDanio(1);
		int vidaFinal = barraca.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaALaBarracaConstruidaEs999()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casilla);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}
		barraca.recibirDanio(1);

		Assert.assertEquals(999, barraca.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaBarracaEnUnaCasillaDesocupada()
			throws RecursosInsuficientesError, CasillaOcupadaError {
		Coordenada coordenada = new Coordenada(1, 1);

		Jugador jugador = new Jugador();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casilla);
		Casilla casillaNueva = new Casilla(coordenada);
		barraca.posicionar(casillaNueva);

		Assert.assertEquals(casillaNueva, barraca.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaNoPoderPosicionarseUnaBarracaEnUnaCasillaOcupadaPorUnaunidad()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casillaInicial = new Casilla(new Coordenada(1, 1));
		Barraca primeraBarraca = new Barraca(jugador, casillaInicial);
		Coordenada coordenada = new Coordenada(1, 2);
		Casilla casilla = new Casilla(coordenada);
		@SuppressWarnings("unused")
		Barraca segundaBarraca = new Barraca(jugador, casilla);
		primeraBarraca.posicionar(casilla);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void deberiaNoPoderPosicionarseUnaBarracaEnUnaCasillaOcupadaPorUnRecurso()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Casilla casillaInicial = new Casilla(new Coordenada(1, 1));
		Barraca barraca = new Barraca(jugador, casillaInicial);
		Coordenada coordenada = new Coordenada(1, 2);
		Casilla casilla = new Casilla(coordenada);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);
		barraca.posicionar(casilla);
	}

	@Test
	public void deberiaGuardarSuPosicion() throws RecursosInsuficientesError,
			CasillaOcupadaError {

		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Jugador jugador = new Jugador();
		Barraca barraca = new Barraca(jugador, casilla);

		Assert.assertEquals(casilla, barraca.posicion());
	}

	@Test
	public void unaBarracaEsInicialmenteTerrestre()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador, casilla);

		Assert.assertTrue(barraca.esTerrestre());
	}

	@Test
	public void deberiaDesocuparLaCasillaUnaVezYaDestruido()
			throws RecursosInsuficientesError, CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador, casilla);
		barraca.recibirDanio(2000);

		Assert.assertTrue(barraca.estaDestruido());
		Assert.assertFalse(casilla.estaOcupadaLaTierra());
	}

	@Test(expected = JugadorIncorrectoError.class)
	public void deberiaLanzarUnaExexpcionAlEntrenarUnSoldadoMarinePorqueRecibioComoParametroASuMismoJugador()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {

		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador, casilla);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}
		barraca.entrenarMarine(otroJugador);
	}

	@Test(expected = BarracaNoConstruidaError.class)
	public void deberiaNoPoderEntrenarUnSoldadoMarinePorqueNoTerminoDeConstruirse()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {

		Jugador jugador = new Jugador();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador, casilla);
		barraca.entrenarMarine(jugador);
	}

	@Test
	public void deberiaEntrenarUnSoldadoMarine()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador, casilla);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}
		barraca.entrenarMarine(jugador);
	}

	@Test(expected = YaHayUnidadEnEntrenamiento.class)
	public void noDeberiaPoderComenzarAEntrenarAUnMarineMientrasEsteEntrenandoAOtroMarine()
			throws RecursosInsuficientesError, CasillaOcupadaError,
			JugadorIncorrectoError, PoblacionLimiteAlcanzadaError,
			BarracaNoConstruidaError, YaHayUnidadEnEntrenamiento {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador, casilla);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		barraca.entrenarMarine(jugador);
		barraca.entrenarMarine(jugador);
	}

	@Test
	public void deberiaPoderEntrenarAUnMarineLuegoDeFinalizarElEntrenamientoDeOtroMarine()
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			CasillaOcupadaError, JugadorIncorrectoError,
			PoblacionLimiteAlcanzadaError, BarracaNoConstruidaError,
			YaHayUnidadEnEntrenamiento {

		Jugador jugador = new Jugador();
		jugador.aumentarPoblacion();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador, casilla);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		barraca.entrenarMarine(jugador);
		for (int j = 0; j < 3; j++) {
			barraca.pasarTurno();
		}
		barraca.entrenarMarine(jugador);
	}

}
