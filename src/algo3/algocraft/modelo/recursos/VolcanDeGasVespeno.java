package algo3.algocraft.modelo.recursos;

import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;

public class VolcanDeGasVespeno extends Recurso {

	public VolcanDeGasVespeno(int cantidadDeGas) {

		this.cantidadRecurso = cantidadDeGas;
	}
	
	public void agregarCentroDeMineral(CentroDeMineral centroDeMineral)
			throws RecolectorInvalidoError {
		throw new RecolectorInvalidoError();
	}

	public void agregarRefineria(Refineria refineria)
			throws RecolectorInvalidoError, CasillaOcupadaError {
		refineria.posicionar(this.posicion);
	}


}
