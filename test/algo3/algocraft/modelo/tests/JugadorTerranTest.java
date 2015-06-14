package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.BarracaNoConstruidaError;
import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;

public class JugadorTerranTest {

	@Test
	public void deberiaPoderConstruirUnaBarraca() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = jugador.crearBarraca(casilla);

		Assert.assertEquals(casilla.getOcupanteTerrestre(), barraca);
	}

	@Test
	public void laBarracaSeEncuentraInicialmenteEnconstruccion() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = jugador.crearBarraca(casilla);

		Assert.assertTrue(barraca.enConstruccion());

	}

	@Test
	public void luegoDe12TurnoslaBarracaEstaConstruida() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = jugador.crearBarraca(casilla);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}

		Assert.assertFalse(barraca.enConstruccion());

	}

	@Test(expected = BarracaNoConstruidaError.class)
	public void siSeEmpezoACrearUnaBarracaPeroSigueEnConstruccionNoSePuedeConstruirUnaFabrica()
			throws BarracaNoConstruidaError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		jugador.crearFabrica(casillaFabrica, barraca);
	}

	@Test
	public void siSePudoCrearUnaBarraSePuedeConstruirUnaFabrica()
			throws BarracaNoConstruidaError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = jugador.crearFabrica(casillaFabrica, barraca);

		Assert.assertEquals(casillaFabrica.getOcupanteTerrestre(), fabrica);
	}

	@Test
	public void laFabricaSeEncuentraInicialmenteEnconstruccion()
			throws BarracaNoConstruidaError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = jugador.crearFabrica(casillaFabrica, barraca);

		Assert.assertTrue(fabrica.enConstruccion());

	}

	@Test
	public void luegoDe12TurnoslaFabricaEstaConstruida()
			throws BarracaNoConstruidaError {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaFabrica = new Coordenada(2, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Barraca barraca = jugador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			barraca.pasarTurno();
		}
		Fabrica fabrica = jugador.crearFabrica(casillaFabrica, barraca);
		for (int i = 0; i < 12; i++) {
			fabrica.pasarTurno();
		}

		Assert.assertFalse(fabrica.enConstruccion());

	}

	@Test
	public void deberiaPoderConstruirUnDepositoDeSuministro() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);

		Assert.assertEquals(casilla.getOcupanteTerrestre(), deposito);
	}

	@Test
	public void elDepositoSeEncuentraInicialmenteEnconstruccion() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);

		Assert.assertTrue(deposito.enConstruccion());

	}

	@Test
	public void luegoDe6TurnoselDepositoEstaConstruido() {
		JugadorTerran jugador = new JugadorTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		DepositoDeSuministros deposito = jugador
				.crearDepositoDeSuministros(casilla);
		for (int i = 0; i < 12; i++) {
			deposito.pasarTurno();
		}

		Assert.assertFalse(deposito.enConstruccion());

	}
	@Test
	public void elJugadorDeberiaEmpezarCon400DeMineral(){
		JugadorTerran jugador = new JugadorTerran();
		Assert.assertEquals(400,jugador.cantidadMineral());
	}

}
