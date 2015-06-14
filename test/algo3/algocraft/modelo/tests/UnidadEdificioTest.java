package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recolectables.MinaDeMinerales;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.EdificioEnConstruccionError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Marine;
import algo3.algocraft.modelo.unidades.unidadesSoldados.PerteneceAlMismoJugadorError;

public class UnidadEdificioTest {

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoMarinePorqueNoTerminoDeConstruirse()
			throws EdificioEnConstruccionError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);

		Assert.assertFalse(barraca.entrenarMarine());
	}

	@Test
	public void deberiaEntrenarUnSoldadoMarine()
			throws EdificioEnConstruccionError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}

		Assert.assertTrue(barraca.entrenarMarine());
	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoGolliaPorqueNoTerminoDeConstruirse()
			throws EdificioEnConstruccionError, PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertFalse(fabrica.entrenarGolliat());
	}

	@Test
	public void deberiaEntrenarUnSoldadoGolliat()
			throws EdificioEnConstruccionError, PerteneceAOtroJugadorError {
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
	public void siUnMarineAtacaUnaBarracaEnConstruccionLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError {

		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Barraca barraca = new Barraca(jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaCasillaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaCasillaMarine = new Coordenada(1, 2);
		Casilla casillaBarraca = new Casilla(coordenadaCasillaBarraca);
		Casilla casillaMarine = new Casilla(coordenadaCasillaMarine);
		marine.posicionar(casillaMarine);
		barraca.posicionar(casillaBarraca);
		marine.atacarEnemigo(barraca);
		Assert.assertTrue(barraca.estaDestruido());

	}

	@Test
	public void siUnMarineAtacaUnaBarracaYaConstruidaNoLaDestruye()
			throws YaEstaDestruidoError, PerteneceAlMismoJugadorError {

		JugadorTerran jugadorAliado = new JugadorTerran();
		JugadorTerran jugadorEnemigo = new JugadorTerran();
		Barraca barraca = new Barraca(jugadorAliado);
		Marine marine = new Marine(jugadorEnemigo);
		Coordenada coordenadaCasillaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaCasillaMarine = new Coordenada(1, 2);
		Casilla casillaBarraca = new Casilla(coordenadaCasillaBarraca);
		Casilla casillaMarine = new Casilla(coordenadaCasillaMarine);
		marine.posicionar(casillaMarine);
		barraca.posicionar(casillaBarraca);

		for (int i = 0; i < 13; i++) {
			barraca.pasarTurno();
		}

		marine.atacarEnemigo(barraca);
		Assert.assertFalse(barraca.estaDestruido());

	}

	@Test
	public void elTiempoDeConstruccionDeUnaFabricaEsde12Turnos()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertEquals(12, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnDepositoDeSuministrosEsde12Turnos() {
		JugadorTerran jugador = new JugadorTerran();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);

		Assert.assertEquals(6, deposito.tiempoDeConstruccion());
	}

	@Test
	public void inicialmenteUnaBarracaEsTerrestre() {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);

		Assert.assertTrue(barraca.esTerrestre());
	}

	@Test
	public void inicialmenteUnaFabricaEsTerrestre()
			throws PerteneceAOtroJugadorError {
		JugadorTerran jugador = new JugadorTerran();
		Barraca barraca = new Barraca(jugador);
		Fabrica fabrica = new Fabrica(jugador, barraca);

		Assert.assertTrue(fabrica.esTerrestre());
	}

	@Test
	public void inicialmenteUnDepositoDeSuministroEsTerrestre() {
		JugadorTerran jugador = new JugadorTerran();
		DepositoDeSuministros deposito = new DepositoDeSuministros(jugador);

		Assert.assertTrue(deposito.esTerrestre());
	}

	@Test
	public void deberiaPoderPosicionarUnaEstructura() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador);

		Assert.assertTrue(barraca.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarSobreUnaCasillaOcupadaPorUnaUnidad() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador);
		Marine marine = new Marine(jugador);
		marine.posicionar(casilla);
		Assert.assertFalse(barraca.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarSobreUnaCasillaOcupadaPorUnRecurso() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca(jugador);
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);
		Assert.assertFalse(barraca.posicionar(casilla));
	}

}
