package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.unidades.Unidad;

public class EstadoYaAtaco extends EstadoDeAtaque {

	public void atacarEnemigo(UnidadSoldado atacante, Unidad enemigo) throws NoPuedeAtacarMultiplesVecesError {
		throw new NoPuedeAtacarMultiplesVecesError();
	}

}
