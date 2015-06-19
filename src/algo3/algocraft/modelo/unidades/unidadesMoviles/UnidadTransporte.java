package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public abstract class UnidadTransporte extends UnidadMovil{

	protected UnidadSoldado[] soldadosCargados; 
	
	public UnidadTransporte(Jugador jugador, PlanoAccion plano, int capacidad) {
		super(jugador, 150, plano);
		soldadosCargados = new UnidadSoldado[capacidad];
	}

	public boolean cargarSoldado(UnidadSoldado soldado) {
		if (!this.esAliado(soldado)) return false;
		for (int i = 0; i<soldadosCargados.length; i++) {
			if (soldadosCargados[i] == soldado) return false;
		}
		for (int i = 0; i<soldadosCargados.length; i++) {
			if (soldadosCargados[i] == null) {
				soldadosCargados[i] = soldado;
				soldado.nuevaPosicion(null);
				return true;
			}
		}
		return false;
	}

	public UnidadSoldado descargarSoldado() {
		for (int i = 0; i<soldadosCargados.length; i++) {
			if (soldadosCargados[i] != null) {
				UnidadSoldado descargado = soldadosCargados[i];
				soldadosCargados[i] = null;
				return descargado;
			}
		}
		return null;		
	}
	
	public void pasarTurno() {
		return;	
	}

}
