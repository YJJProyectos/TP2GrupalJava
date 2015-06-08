package tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.edificables.Barraca;
import algo3.algocraft.modelo.edificables.EdificioEnConstruccion;
import algo3.algocraft.modelo.edificables.Estructura;
import algo3.algocraft.modelo.peleables.Marine;



public class EdificioEnConstruccionTest {

	@Test
	public void elTiempoDeConstruccionDeberiaSerDe5Turnos() {

		Estructura edificio = new Barraca();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				edificio, 5);
		Assert.assertEquals(5, construccion.verTurnosRestantes());
	}

	@Test
	public void elTiempoDeConstruccionAlPasarUnTurnoDeberiaBajarDe5A4() {

		Estructura edificio = new Barraca();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(edificio, 5);
		construccion.continuarConstruccion();
		Assert.assertEquals(4, construccion.verTurnosRestantes());
	}

	@Test
	public void atacarUnaUnidadDeConstruccionLaDestruye() {
		Estructura edificio = new Barraca();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(edificio, 5);
		Marine marine = new Marine();
		marine.atacarEnemigo(construccion);
		Assert.assertTrue(construccion.estaDestruido());

	}
}
