package tests;

import ocupables.CasillaTerrestre;

import org.junit.Assert;
import org.junit.Test;

import accionables.Unidad;


import peleables.Marine;
import interfaces.Ocupable;

public class UnidadTest {

	@Test
	public void deberiaEstarDetruido() {

		Unidad soldado = new Marine();
		soldado.recibirDanio(1000);

		Assert.assertTrue(soldado.estaDestruido());
	}

	@Test
	public void deberiaRecibirDanio() {

		Unidad soldado = new Marine();
		int vidaInicial = soldado.vidaRestante();
		soldado.recibirDanio(1);
		int vidaFinal = soldado.vidaRestante();

		Assert.assertEquals(1, vidaInicial - vidaFinal);
	}

	@Test
	public void deberiaGuardarSuPosicion() {

		Ocupable posicion = new CasillaTerrestre();
		Unidad soldado = new Marine();

		soldado.posicionar(posicion);

		Assert.assertEquals(soldado.posicion(), posicion);
	}

}
