package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.juego.AlmacenadorEstructurasTerran;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;

public class AlmacenadorEstructurasTerranTest {

	@Test
	public void deberiaPoderConstruirUnaBarraca() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Assert.assertTrue(almacenador.crearBarraca(casilla));
	}

	@Test
	public void alConstruirUnaBarracaPrimeroSeConstruyeunEdificioDeConstruccion() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		almacenador.crearBarraca(casilla);
		Assert.assertEquals(1, almacenador.cantidadEdificiosEnConstruccion());

	}

	@Test
	public void luegoDe12TurnosSeAgregaLaBarracaALosEdificiosConstruidos() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		almacenador.crearBarraca(casilla);
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}

		Assert.assertEquals(1, almacenador.cantidadBarracas());

	}

	@Test
	public void luegoDeConstruirLaBarracaNoHayMasEdificiosEnConstruccion() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		almacenador.crearBarraca(casilla);
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}

		Assert.assertEquals(0, almacenador.cantidadEdificiosEnConstruccion());

	}

	@Test
	public void siNoHayBarracasConstruidasNoSePuedeConstruirUnaFabrica() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Assert.assertFalse(almacenador.crearFabrica(casilla));
	}

	@Test
	public void siSeEmpezoACrearUnaBarracaPeroSigueEnConstruccionNoSePuedeConstruirUnaFabrica() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		almacenador.crearBarraca(casilla);
		Assert.assertFalse(almacenador.crearFabrica(casilla));
	}

	@Test
	public void siSePudoCrearUnaBarraSePuedeConstruirUnaFabrica() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		almacenador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}
		Coordenada coordenadaFabrica = new Coordenada(1, 2);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		Assert.assertTrue(almacenador.crearFabrica(casillaFabrica));
	}
	
	@Test
	public void alConstruirUnaFabricaComoSeEstaConstruyendoNoHayFabricas() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		almacenador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}
		Coordenada coordenadaFabrica = new Coordenada(1, 2);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		almacenador.crearFabrica(casillaFabrica);
		Assert.assertEquals(0, almacenador.cantidadFabricas());
	}
	
	@Test
	public void alConstruirUnaFabricaPrimeroSeConstruyeunEdificioDeConstruccion() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		almacenador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}
		Coordenada coordenadaFabrica = new Coordenada(1, 2);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		almacenador.crearFabrica(casillaFabrica);
		Assert.assertEquals(1, almacenador.cantidadEdificiosEnConstruccion());
	}
	@Test
	public void luegoDe12TurnosSeAgregaLafabricaALosEdificiosConstruidos() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		almacenador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}
		Coordenada coordenadaFabrica = new Coordenada(1, 2);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		almacenador.crearFabrica(casillaFabrica);
		
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}

		Assert.assertEquals(1, almacenador.cantidadFabricas());

	}

	@Test
	public void luegoDeConstruirLaFabricaNoHayMasEdificiosEnConstruccion() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenadaBarraca = new Coordenada(1, 1);
		Casilla casillaBarraca = new Casilla(coordenadaBarraca);
		almacenador.crearBarraca(casillaBarraca);
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}
		Coordenada coordenadaFabrica = new Coordenada(1, 2);
		Casilla casillaFabrica = new Casilla(coordenadaFabrica);
		almacenador.crearFabrica(casillaFabrica);
		
		for (int i = 0; i < 12; i++) {
			almacenador.continuarConConstrucciones();
		}

		Assert.assertEquals(0, almacenador.cantidadEdificiosEnConstruccion());

	}
/////
	
	@Test
	public void deberiaPoderConstruirUnDepositoDeSuministro() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		Assert.assertTrue(almacenador.crearDepositoDeSuministros(casilla));
	}

	@Test
	public void alConstruirUnDepositoPrimeroSeConstruyeunEdificioDeConstruccion() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		almacenador.crearDepositoDeSuministros(casilla);
		Assert.assertEquals(1, almacenador.cantidadEdificiosEnConstruccion());

	}

	@Test
	public void luegoDe6TurnosSeAgregaElDepositoALosEdificiosConstruidos() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		almacenador.crearDepositoDeSuministros(casilla);
		for (int i = 0; i < 6; i++) {
			almacenador.continuarConConstrucciones();
		}

		Assert.assertEquals(1, almacenador.cantidadDepositos());

	}

	@Test
	public void luegoDeDeConstruirElDepositoNoHayMasEdificiosEnConstruccion() {
		AlmacenadorEstructurasTerran almacenador = new AlmacenadorEstructurasTerran();
		Coordenada coordenada = new Coordenada(1, 1);
		Casilla casilla = new Casilla(coordenada);
		almacenador.crearDepositoDeSuministros(casilla);
		for (int i = 0; i < 6; i++) {
			almacenador.continuarConConstrucciones();
		}

		Assert.assertEquals(0, almacenador.cantidadEdificiosEnConstruccion());

	}

}
