package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public abstract class EstadoDeAtaque {
	
	UnidadSoldado unidad;

	public abstract void atacarEnemigo(Unidad enemigo) 
			throws NoPuedeAtacarMultiplesVecesError, YaEstaDestruidoError;
}
