package algo3.algocraft.modelo.recursos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;

public abstract class Recurso {

	protected int cantidadRecurso;
	protected Casilla posicion;

	public int extraerRecurso(int cantidadDeRecurso) {
		int cantidadRecursoSacado = 0;

		if (this.cantidadRecurso > 0) {
			cantidadRecursoSacado = cantidadDeRecurso;
			if (this.cantidadRecurso < cantidadDeRecurso) {
				cantidadRecursoSacado = this.cantidadRecurso;
			}
			this.cantidadRecurso -= cantidadRecursoSacado;
		}

		return cantidadRecursoSacado;
	}

	public int getCantidad() {
		return this.cantidadRecurso;
	}

	public void posicionar(Casilla casilla) throws CasillaOcupadaError {
		casilla.agregarRecurso(this);
		this.posicion = casilla;
	}

	public Casilla posicion() {
		return this.posicion;
	}

}
