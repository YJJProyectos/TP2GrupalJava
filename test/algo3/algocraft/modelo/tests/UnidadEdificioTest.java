package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recolectables.MinaDeMinerales;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.EdificioEnConstruccionError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Marine;

public class UnidadEdificioTest {

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoMarinePorqueNoTerminoDeConstruirse()
			throws EdificioEnConstruccionError {
		Barraca barraca = new Barraca();

		Assert.assertFalse(barraca.entrenarMarine());
	}

	@Test
	public void deberiaEntrenarUnSoldadoMarine()
			throws EdificioEnConstruccionError {
		Barraca barraca = new Barraca();
		for(int i = 0; i< 13; i++){
			barraca.pasarTurno();
		}

		Assert.assertTrue(barraca.entrenarMarine());
	}

	@Test
	public void deberiaNoPoderEntrenarUnSoldadoGolliaPorqueNoTerminoDeConstruirse()
			throws EdificioEnConstruccionError {
		Barraca barraca = new Barraca();
		Fabrica fabrica = new Fabrica(barraca);

		Assert.assertFalse(fabrica.entrenarGolliat());
	}

	@Test
	public void deberiaEntrenarUnSoldadoGolliat()
			throws EdificioEnConstruccionError {
		Barraca barraca = new Barraca();
		for(int i = 0; i< 13; i++){
			barraca.pasarTurno();
		}
		Fabrica fabrica = new Fabrica(barraca);
		for(int j = 0; j< 13; j++){
			fabrica.pasarTurno();
		}

		Assert.assertTrue(fabrica.entrenarGolliat());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaBarracaEsde12Turnos() {
		Barraca barraca = new Barraca();

		Assert.assertEquals(12, barraca.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnaBarracaLuegoDePasarUnTUrnoEsde11Turnos() {
		Barraca barraca = new Barraca();
		barraca.pasarTurno();
		Assert.assertEquals(11, barraca.tiempoDeConstruccion());
	}

	@Test
	public void siUnMarineAtacaUnaBarracaEnConstruccionLaDestruye()
			throws YaEstaDestruidoError {

		Barraca barraca = new Barraca();
		Marine marine = new Marine();
		Coordenada coordenadaCasillaBarraca = new Coordenada(1, 1);
		Coordenada coordenadaCasillaMarine = new Coordenada(1, 2);
		Casilla casillaBarraca = new Casilla(coordenadaCasillaBarraca);
		Casilla casillaMarine = new Casilla(coordenadaCasillaMarine);
		marine.posicionar(casillaMarine);
		barraca.posicionar(casillaBarraca);
		marine.atacarEnemigo(barraca);
		Assert.assertTrue(barraca.estaDestruido());

	}

	public void siUnMarineAtacaUnaBarracaYaConstruidaNoLaDestruye()
			throws YaEstaDestruidoError {

		Barraca barraca = new Barraca();
		Marine marine = new Marine();
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
	public void elTiempoDeConstruccionDeUnaFabricaEsde12Turnos() {
		Barraca barraca = new Barraca();
		Fabrica fabrica = new Fabrica(barraca);

		Assert.assertEquals(12, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnDepositoDeSuministrosEsde12Turnos() {
		DepositoDeSuministros deposito = new DepositoDeSuministros();

		Assert.assertEquals(6, deposito.tiempoDeConstruccion());
	}

	@Test
	public void inicialmenteUnaBarracaEsTerrestre() {
		Barraca barraca = new Barraca();

		Assert.assertTrue(barraca.esTerrestre());
	}

	@Test
	public void inicialmenteUnaFabricaEsTerrestre() {
		Barraca barraca = new Barraca();
		Fabrica fabrica = new Fabrica(barraca);

		Assert.assertTrue(fabrica.esTerrestre());
	}

	@Test
	public void inicialmenteUnDepositoDeSuministroEsTerrestre() {
		DepositoDeSuministros deposito = new DepositoDeSuministros();

		Assert.assertTrue(deposito.esTerrestre());
	}

	@Test
	public void deberiaPoderPosicionarUnaEstructura() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();

		Assert.assertTrue(barraca.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarSobreUnaCasillaOcupadaPorUnaUnidad() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();
		Marine marine = new Marine();
		marine.posicionar(casilla);
		Assert.assertFalse(barraca.posicionar(casilla));
	}

	@Test
	public void deberiaNoPoderPosicionarSobreUnaCasillaOcupadaPorUnRecurso() {
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Barraca barraca = new Barraca();
		MinaDeMinerales mineral = new MinaDeMinerales(100);
		casilla.agregarRecurso(mineral);
		Assert.assertFalse(barraca.posicionar(casilla));
	}

}
