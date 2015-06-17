package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.unidades.Unidad;

public abstract class UnidadEdificio extends Unidad {

	protected int tiempoDeConstruccion;

	public boolean esTerrestre() {
		return true;
	}
	
	public abstract int tiempoDeConstruccion();
}
