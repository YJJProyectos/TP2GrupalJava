package algo3.algocraft.modelo.recursos;

import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;

public class MinaDeMinerales extends Recurso {

	public MinaDeMinerales(int cantidadDeMineral) {
		this.cantidadRecurso = cantidadDeMineral;
	}

	public void agregarCentroDeMineral(CentroDeMineral centro)
			throws RecolectorInvalidoError, CasillaOcupadaError {
		centro.posicionar(this.posicion);
	}

	public void agregarRefineria(Refineria refineria)
			throws RecolectorInvalidoError, CasillaOcupadaError {
		throw new RecolectorInvalidoError();
	}

}
