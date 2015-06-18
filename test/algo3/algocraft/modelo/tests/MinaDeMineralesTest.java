package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;

public class MinaDeMineralesTest {

	@Test
	public void sePuedeExtraer10MineralesDeLaMinaCon100Minerales() {
		Recurso mina = new MinaDeMinerales(100);
		Assert.assertEquals(10, mina.extraerRecurso(10));
	}

	@Test
	public void siLaMinaTiene4MineralesYSeQuierenExtraer6SeExtraen4Minerales() {
		Recurso mina = new MinaDeMinerales(4);
		Assert.assertEquals(4, mina.extraerRecurso(6));
	}

	@Test
	public void unaminaQueSeInicializaCon10MineralesTiene10Minerales() {
		Recurso mina = new MinaDeMinerales(10);
		Assert.assertEquals(10, mina.getCantidad());
	}

	@Test
	public void unaminaQueSeInicializaCon10MineralesYSeLeQuitan2Tiene8Minerales() {
		Recurso mina = new MinaDeMinerales(10);
		mina.extraerRecurso(2);
		Assert.assertEquals(8, mina.getCantidad());
	}

	@Test
	public void sePuedePosicionarUnaMinaDeMineralesEnUnaCasillaVacia()
			throws CasillaOcupadaError {
		Coordenada coordeanda = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordeanda);
		MinaDeMinerales mina = new MinaDeMinerales(10);
		mina.posicionar(casilla);
		Assert.assertEquals(casilla, mina.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void noSePuedePosicionarUnaMinaDeMineralesEnUnaCasillaConUnRecurso()
			throws CasillaOcupadaError {
		Coordenada coordeanda = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordeanda);
		MinaDeMinerales primerMina = new MinaDeMinerales(10);
		MinaDeMinerales segundaMina = new MinaDeMinerales(10);
		primerMina.posicionar(casilla);
		segundaMina.posicionar(casilla);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void noSePuedePosicionarUnaMinaDeMineralesEnUnaCasillaConUnMarie()
			throws CasillaOcupadaError {
		Jugador jugador = new Jugador();
		Coordenada coordeanda = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordeanda);
		Marine marine = new Marine(jugador);
		MinaDeMinerales mina = new MinaDeMinerales(10);
		marine.posicionar(casilla);
		mina.posicionar(casilla);
	}

}
