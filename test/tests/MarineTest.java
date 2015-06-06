package tests;

import mapa.Coordenada;
import mapa.Mapa;

import org.junit.Assert;
import org.junit.Test;

import accionables.Accionable;
import peleables.Marine;
import peleables.Golliat;

public class MarineTest {

	@Test
	public void deberiaDaniarEnemigo() {

		Marine soldadoAliado = new Marine();
		Accionable soldadoEnemigo = new Golliat();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(119, soldadoEnemigo.vidaRestante());
	}

	/*
	@Test
	public void deberiaNoDaniarPorEstarFueraDelRango() {

		Mapa mapa = new Mapa(2);
		Marine soldadoAliado = new Marine();
		Accionable soldadoEnemigo = new Golliat();
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(10, 10);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);

		int vidaInicial = soldadoEnemigo.vidaRestante();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertEquals(vidaInicial, soldadoEnemigo.vidaRestante());

	}
	*/

	@Test
	public void deberiaDaniarPorEstarEnElRango() {

		Mapa mapa = new Mapa(2);
		Marine soldadoAliado = new Marine();
		Accionable soldadoEnemigo = new Golliat();
		Coordenada coordenadaAliado = new Coordenada(1, 1);
		Coordenada coordenadaEnemigo = new Coordenada(2, 1);
		mapa.agregarElementoEnPosicion(soldadoAliado, coordenadaAliado);
		mapa.agregarElementoEnPosicion(soldadoEnemigo, coordenadaEnemigo);

		int vidaInicial = soldadoEnemigo.vidaRestante();
		soldadoAliado.atacarEnemigo(soldadoEnemigo);

		Assert.assertNotEquals(vidaInicial, soldadoEnemigo.vidaRestante());

	}

}
