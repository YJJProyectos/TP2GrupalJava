package algo3.algocraft.modelo.juego;

import algo3.algocraft.modelo.edificables.Barraca;
import algo3.algocraft.modelo.edificables.Fabrica;

public class JugadorTerran {
	
	AlmacenadorEstructurasTerran almacenadorEstructuras;
	
	public JugadorTerran(){
		almacenadorEstructuras = new AlmacenadorEstructurasTerran();
	}

	public Fabrica construirFabrica() {
		// despues agregar sobre la validacion de coste
		Fabrica fabrica = null;
		if (almacenadorEstructuras.cantidadBarracas() >= 1 ){
			// esto es para que sigan andando los otros test
			// como fabrica requiere una barraca en su constructor
			// tuve que "crear un metodo" obtenerUnaBarraca
			Barraca barraca = almacenadorEstructuras.obtenerUnaBarraca(); 
			fabrica = new Fabrica(barraca);
		}
		return fabrica;
	}

	public Barraca construirBarraca() {
		// despues agregar sobre la validacion de coste
		Barraca barraca = new Barraca();
		almacenadorEstructuras.agregarBarraca(barraca);
		return barraca;		
	}

}
