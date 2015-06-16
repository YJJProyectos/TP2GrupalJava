package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.unidades.Unidad;

public class EstadoYaAtaco extends EstadoDeAtaque {

	@Override
	public void atacarEnemigo(Unidad enemigo) throws NoPuedeAtacarMultiplesVecesError {
		throw new NoPuedeAtacarMultiplesVecesError();
	}

}
