package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;

public class VolcanDeGasVespenoTest {
	@Test
	public void sePuedeExtraer10DeGasDelVolcanCon100DeGas() {

		Recurso volcan = new VolcanDeGasVespeno(100);

		Assert.assertEquals(10, volcan.extraerRecurso(10));
	}

	@Test
	public void siElVolcanTiene4DeGasYSeQuierenExtraer6SeExtraen4DelGas() {

		Recurso volcan = new VolcanDeGasVespeno(4);

		Assert.assertEquals(4, volcan.extraerRecurso(6));
	}

	@Test
	public void unVolcanQueSeInicializaCon10DeGasTiene10Gases() {

		Recurso volcan = new VolcanDeGasVespeno(10);

		Assert.assertEquals(10, volcan.getCantidad());
	}

	@Test
	public void unVolcanQueSeInicializaCon10DeGasYSeLeQuitan2LeQueda8DeGas() {

		Recurso volcan = new VolcanDeGasVespeno(10);
		volcan.extraerRecurso(2);

		Assert.assertEquals(8, volcan.getCantidad());
	}

	@Test
	public void sePuedePosicionarUnVolcanEnUnaCasillaVacia()
			throws CasillaOcupadaError {

		Coordenada coordeanda = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordeanda);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(10);
		volcan.posicionar(casilla);

		Assert.assertEquals(casilla, volcan.posicion());
	}

	@Test(expected = CasillaOcupadaError.class)
	public void noSePuedePosicionarUnVolcanEnUnaCasillaConUnRecurso()
			throws CasillaOcupadaError {

		Coordenada coordeanda = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordeanda);
		VolcanDeGasVespeno primerVolcan = new VolcanDeGasVespeno(10);
		VolcanDeGasVespeno segundoVolcan = new VolcanDeGasVespeno(10);
		primerVolcan.posicionar(casilla);
		segundoVolcan.posicionar(casilla);
	}

	@Test(expected = CasillaOcupadaError.class)
	public void noSePuedePosicionarUnaMinaDeMineralesEnUnaCasillaConUnMarie()
			throws CasillaOcupadaError {

		Jugador jugador = new Jugador();
		Coordenada coordeanda = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordeanda);
		Marine marine = new Marine(jugador);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(10);
		marine.posicionar(casilla);
		volcan.posicionar(casilla);
	}

	@Test(expected = RecolectorInvalidoError.class)
	public void unVolcanNoPuedeAgregarUnCentroDeMineralEnSuPosicion()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			RecolectorInvalidoError {

		Jugador jugador = new Jugador();
		Coordenada coordeanda = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordeanda);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(10);
		volcan.posicionar(casilla);
		CentroDeMineral centro = new CentroDeMineral(volcan, jugador);
		centro.pasarTurno();
	}

	@Test
	public void unVolcanPuedeAgregarUnaRefineriaEnSuPosicion()
			throws CasillaOcupadaError, RecursosInsuficientesError,
			RecolectorInvalidoError {

		Jugador jugador = new Jugador();
		Coordenada coordeanda = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordeanda);
		VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(10);
		volcan.posicionar(casilla);
		Refineria refineria = new Refineria(volcan, jugador);

		Assert.assertEquals(casilla, refineria.posicion());
	}

}
