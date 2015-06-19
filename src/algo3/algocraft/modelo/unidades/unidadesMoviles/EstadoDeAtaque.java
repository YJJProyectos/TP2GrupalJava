package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public abstract class EstadoDeAtaque {
	
	UnidadSoldado unidad;

	public abstract void atacar(UnidadSoldado atacante, Unidad enemigo)
			throws NoPuedeAtacarMultiplesVecesError, YaEstaDestruidoError;
}
