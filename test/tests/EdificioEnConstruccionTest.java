package tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import algo3.algocraft.modelo.accionables.Unidad;
import algo3.algocraft.modelo.edificables.Barraca;
import algo3.algocraft.modelo.edificables.EdificioEnConstruccion;
import algo3.algocraft.modelo.edificables.UnidadEdificio;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.peleables.Marine;

public class EdificioEnConstruccionTest {

	@Test
	public void elTiempoDeConstruccionDeUnaBarracaDeberiaSerDe5Turnos() {

		UnidadEdificio edificio = new Barraca();
		ArrayList<UnidadEdificio> listaBarracasTerminadas = new ArrayList<UnidadEdificio>();
		ArrayList<Unidad> listaBarracasEnConstruccion = new ArrayList<Unidad>();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				edificio, listaBarracasTerminadas, listaBarracasEnConstruccion);
		Assert.assertEquals(12, construccion.verTurnosRestantes());
	}

	@Test
	public void elTiempoDeConstruccionAlPasarUnTurnoDeberiaBajarDe5A4() {
		UnidadEdificio edificio = new Barraca();
		ArrayList<UnidadEdificio> listaBarracasTerminadas = new ArrayList<UnidadEdificio>();
		ArrayList<Unidad> listaBarracasEnConstruccion = new ArrayList<Unidad>();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				edificio, listaBarracasTerminadas, listaBarracasEnConstruccion);
		construccion.continuarConstruccion();
		Assert.assertEquals(11, construccion.verTurnosRestantes());
	}

	@Test
	public void atacarUnaUnidadDeConstruccionLaDestruye() {

		UnidadEdificio edificio = new Barraca();
		Marine marine = new Marine();
		Coordenada coordenadaCasillaEdificio = new Coordenada(1, 1);
		Coordenada coordenadaCasillaMarine = new Coordenada(1, 2);
		Casilla casillaEdificio = new Casilla(coordenadaCasillaEdificio);
		Casilla casillaMarine = new Casilla(coordenadaCasillaMarine);
		ArrayList<UnidadEdificio> listaBarracasTerminadas = new ArrayList<UnidadEdificio>();
		ArrayList<Unidad> listaBarracasEnConstruccion = new ArrayList<Unidad>();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				edificio, listaBarracasTerminadas, listaBarracasEnConstruccion);
		marine.posicionar(casillaMarine);
		construccion.posicionar(casillaEdificio);
		marine.atacarEnemigo(construccion);
		Assert.assertTrue(construccion.estaDestruido());

	}
}
