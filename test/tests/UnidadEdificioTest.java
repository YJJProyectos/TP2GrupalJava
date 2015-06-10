package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.edificables.Barraca;
import algo3.algocraft.modelo.edificables.DepositoDeSuministros;
import algo3.algocraft.modelo.edificables.Fabrica;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.peleables.Marine;
import algo3.algocraft.modelo.recolectables.MinaDeMinerales;

public class UnidadEdificioTest {

	@Test
	public void deberiaEntrenarUnSoldadoMarine() {
		Barraca barraca = new Barraca();

		Assert.assertTrue(barraca.entrenarMarine());
	}

	@Test
	public void deberiaEntrenarUnSoldadoGolliat() {
		Fabrica fabrica = new Fabrica();

		Assert.assertTrue(fabrica.entrenarGolliat());
	}
	
	@Test
	public void elTiempoDeConstruccionDeUnaBarracaEsde12Turnos(){
		Barraca barraca = new Barraca();
		
		Assert .assertEquals(12, barraca.tiempoDeConstruccion());
	}
	
	@Test
	public void elTiempoDeConstruccionDeUnaFabricaEsde12Turnos(){
		Fabrica fabrica = new Fabrica();
		
		Assert .assertEquals(12, fabrica.tiempoDeConstruccion());
	}

	@Test
	public void elTiempoDeConstruccionDeUnDepositoDeSuministrosEsde12Turnos(){
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		
		Assert .assertEquals(6, deposito.tiempoDeConstruccion());
	}
	
	@Test
	public void inicialmenteUnaBarracaEsTerrestre(){
		Barraca barraca = new Barraca();
		
		Assert.assertTrue(barraca.esTerrestre());
	}
	@Test
	public void inicialmenteUnaFabricaEsTerrestre(){
		Fabrica fabrica = new Fabrica();
		
		Assert.assertTrue(fabrica.esTerrestre());
	}
	@Test
	public void inicialmenteUnDepositoDeSuministroEsTerrestre(){
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
