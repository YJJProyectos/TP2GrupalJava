package tests;


import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.accionables.Unidad;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.peleables.Marine;

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

		Casilla posicion = new Casilla();
		Unidad soldado = new Marine();

		soldado.posicionar(posicion);

		Assert.assertEquals(soldado.posicion(), posicion);
	}

}
