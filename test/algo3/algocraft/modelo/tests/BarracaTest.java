package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;

public class BarracaTest {

	@Test
	public void elTiempoDeConstruccionDeUnaBarracaEsde12Turnos() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);

		Assert.assertEquals(12, barraca.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaBarracaLuegoDePasarUnTUrnoEsde11Turnos() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		barraca.pasarTurno();

		Assert.assertEquals(11, barraca.tiempoDeConstruccion());
	}

	@Test
	public void laBarracaSeEncuentraInicialmenteEnConstruccion() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);

		Assert.assertTrue(barraca.enConstruccion());
	}

	@Test
	public void luegoDe12TurnosLaBarracaEstaConstuida() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}

		Assert.assertFalse(barraca.enConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnaBarracaEnConstruccionLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {

		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Barraca barraca = new Barraca(jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		barraca.posicionar(casillaBarraca);
		marine.atacarEnemigo(barraca);
		Assert.assertTrue(barraca.estaDestruido());

	}

	@Test
	public void siUnMarineAtacaUnaBarracaYaConstruidaNoLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError,
			NoPuedeAtacarMultiplesVecesError {

		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Barraca barraca = new Barraca(jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaMarine = new Coordenada(1, 2);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaMarine = new Casilla(coordenadaMarine);
		marine.posicionar(casillaMarine);
		barraca.posicionar(casillaBarraca);

		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}

		marine.atacarEnemigo(barraca);
		Assert.assertFalse(barraca.estaDestruido());

	}

	@Test
	public void laBarracaConstruidaDeberiaRecibirDanio1()
			throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
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
			throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}
		barraca.recibirDanio(1);

		Assert.assertEquals(999, barraca.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaBarracaEnUnaCasillaDesocupada() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);

		Assert.assertTrue(barraca.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnaBarracaEnUnaCasillaOcupadaPorUnaunidad() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		Barraca primeraBarraca = new Barraca(jugador);
		Barraca segundaBarraca = new Barraca(jugador);
		primeraBarraca.posicionar(casilla);

		Assert.assertFalse(segundaBarraca.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarseUnaBarracaEnUnaCasillaOcupadaPorUnRecurso() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);

		Assert.assertFalse(barraca.posicionar(casilla));
	}

	@Test
	public void deberiaGuardarSuPosicion() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);

		barraca.posicionar(casilla);

		Assert.assertEquals(casilla, barraca.posicion());
	}

	@Test
	public void unaBarracaEsInicialmenteTerrestre() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);

		Assert.assertTrue(barraca.esTerrestre());
	}

	@Test(expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido()
			throws YaEstaDestruidoError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		barraca.recibirDanio(2000);
		Assert.assertTrue(barraca.estaDestruido());
		barraca.recibirDanio(2);

	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoMarinePorqueNoTerminoDeConstruirse() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);

		Assert.assertFalse(barraca.entrenarMarine());
	}

	@Test
	public void deberiaEntrenarUnSoldadoMarine() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}

		Assert.assertTrue(barraca.entrenarMarine());
	}

	@Test
	public void noDeberiaPoderComenzarAEntrenarAUnMarineMientrasEsteEntrenandoAOtroMarine() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}

		barraca.entrenarMarine();
		Assert.assertFalse(barraca.entrenarMarine());

	}

	@Test
	public void deberiaPoderEntrenarAUnGolliatLuegoDeFinalizarElEntrenamientoDeOtroGolliat()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		barraca.entrenarMarine();
		for (int j = 0; j < 3; j++) {
			barraca.pasarTurno();
		}
		Assert.assertTrue(barraca.entrenarMarine());

	}

}
