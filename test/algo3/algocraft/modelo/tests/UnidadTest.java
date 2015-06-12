package algo3.algocraft.modelo.tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Marine;

public class UnidadTest {

	@Test
	public void deberiaEstarDetruidaLaUnidad() throws YaEstaDestruidoError {

		Unidad soldado = new Marine();
		soldado.recibirDanio(1000);

		Assert.assertTrue(soldado.estaDestruido());
	}

	@Test
	public void deberiaNoEstarDetruidaLaUnidad() throws YaEstaDestruidoError {

		Unidad soldado = new Marine();
		soldado.recibirDanio(5);

		Assert.assertFalse(soldado.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio1() throws YaEstaDestruidoError {

		Unidad soldado = new Marine();
		int vidaInicial = soldado.vidaRestante();
		soldado.recibirDanio(1);
		int vidaFinal = soldado.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void laVidaRestanteLuegoDeQuitarle1UnidadDevidaALaUnidadMarineEs39() throws YaEstaDestruidoError {

		Unidad soldado = new Marine();
		soldado.recibirDanio(1);

		Assert.assertEquals(39, soldado.vidaRestante());
	}

	@Test
	public void deberiaPoderPosicionarseUnaUnidadEnUnaCasillaDesocupada() {

		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad soldado = new Marine();

		Assert.assertTrue(soldado.posicionar(casilla));
	}
	
	@Test
	public void deberiaNoPoderPosicionarseUnaUnidadEnUnaCasillaOcupada() {

		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad primerSoldado = new Marine();
		Unidad segundoSoldado = new Marine();
		primerSoldado.posicionar(casilla);
		
		Assert.assertFalse(segundoSoldado.posicionar(casilla));
	}
	
	@Test
	public void deberiaGuardarSuPosicion() {

		Coordenada coordenada = new Coordenada(1,1);
		Casilla casilla = new Casilla(coordenada);
		Unidad soldado = new Marine();

		soldado.posicionar(casilla);

		Assert.assertEquals(casilla, soldado.posicion());
	}
	
	@Test
	public void unaUnidadTerrestreComoElMarineDeberiaSerTerrestre(){
		Unidad soldado = new Marine();
		
		Assert.assertTrue(soldado.esTerrestre());
	}
	
	@Test (expected = YaEstaDestruidoError.class)
	public void deberiaLanzarYaEstaDestruidoCuandoSeQuiereAtacarUnaVezYaDestruido() throws YaEstaDestruidoError{
		
		Unidad soldado = new Marine();
		soldado.recibirDanio(100);
		Assert.assertTrue(soldado.estaDestruido());
		soldado.recibirDanio(2);
		
	}
	

}
