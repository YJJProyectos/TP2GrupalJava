package algo3.algocraft.modelo.recursos;

public abstract class Recurso {
	
	protected int cantidadRecurso;
	
	public int extraerRecurso(int cantidadDeRecurso){
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
	

}
