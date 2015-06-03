package tp2tests;

import org.junit.Assert;
import org.junit.Test;

import excepciones.CoordenadaInvalidaError;

import peleables.Marine;
import interfaces.Ubicable;

import tp2.Coordenada;
import tp2.Mapa;

public class MapaTest {

	@Test
	public void deberiaTenerTamanio400ElMapaDe4Bases() {
		Mapa mapa = new Mapa(4);
		Assert.assertEquals(mapa.tamanio(), 400);
	}

	@Test
	public void deberiaCalcularLasDistanciasDeLasCoordenadas()
			throws CoordenadaInvalidaError {

		Mapa mapa = new Mapa(4);
		int distancia;
		Ubicable coordenadaA = new Coordenada(1, 1);
		Ubicable coordenadaB = new Coordenada(2, 3);
		distancia = mapa.distanciaEntre(coordenadaA, coordenadaB);
		Assert.assertEquals(2, distancia);
		coordenadaA = new Coordenada(1, 1);
		coordenadaB = new Coordenada(4, 1);
		distancia = mapa.distanciaEntre(coordenadaA, coordenadaB);
		Assert.assertEquals(3, distancia);
		coordenadaA = new Coordenada(1, 1);
		coordenadaB = new Coordenada(3, 3);
		distancia = mapa.distanciaEntre(coordenadaA, coordenadaB);
		Assert.assertEquals(3, distancia);
		coordenadaA.setFila(1);
		coordenadaA.setColumna(2);
		coordenadaB.setFila(3);
		coordenadaB.setColumna(3);
		distancia = mapa.distanciaEntre(coordenadaA, coordenadaB);
		Assert.assertEquals(2, distancia);
	}

	@Test(expected = CoordenadaInvalidaError.class)
	public void deberiaLanzarErrorDeCoordenadaSiPasanCoordenadaInvalida()
			throws CoordenadaInvalidaError {
		Mapa mapa = new Mapa(4);
		Ubicable coordenadaA = new Coordenada(1, 1);
		Ubicable coordenadaB = new Coordenada(500, 3);
		mapa.distanciaEntre(coordenadaA, coordenadaB);
		coordenadaA = new Coordenada(1, 1);
		coordenadaB = new Coordenada(-1, 3);
		mapa.distanciaEntre(coordenadaA, coordenadaB);
	}

	@Test
	public void deberiaAgregarUnMarineEnLaPosicionDada() {
		Mapa mapa = new Mapa(4);
		Marine marine = new Marine();
		Ubicable coordenadaMarine = new Coordenada(1, 1);
		mapa.agregarElementoEnPosicion(marine, coordenadaMarine);

		Assert.assertEquals(marine,
				mapa.obtenerElementoEnPosicion(coordenadaMarine));

	}
}
