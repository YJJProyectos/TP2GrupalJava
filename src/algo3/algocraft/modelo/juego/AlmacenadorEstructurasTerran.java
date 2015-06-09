package algo3.algocraft.modelo.juego;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import algo3.algocraft.modelo.edificables.Barraca;

public class AlmacenadorEstructurasTerran {
	
	Collection<Barraca> listaDeBarracas = new ArrayList<Barraca>();

	public void agregarBarraca(Barraca barraca) {
		listaDeBarracas.add(barraca);
	}

	public int cantidadBarracas() {
		
		return listaDeBarracas.size();
	}

	public Barraca obtenerUnaBarraca() {
		Barraca barraca = null;
		int cero = 0 ; // esto es solo para que agarre la primera barraca ya alcanza
		Iterator<Barraca> iterador = listaDeBarracas.iterator();
		while ( iterador.hasNext() && cero == 0 ){
			barraca = iterador.next();
			cero ++;
		}
		return barraca;
	}

}
