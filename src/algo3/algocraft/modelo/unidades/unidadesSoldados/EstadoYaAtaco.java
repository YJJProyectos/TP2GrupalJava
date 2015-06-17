package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.unidades.Unidad;

public class EstadoYaAtaco extends EstadoDeAtaque {

	public void atacarEnemigo(UnidadSoldado atacnte, Unidad enemigo) throws NoPuedeAtacarMultiplesVecesError {
		throw new NoPuedeAtacarMultiplesVecesError();
	}

}
