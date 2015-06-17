package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesSoldados.comportamientos.ComportamientoTransporte;

public class UnidadTransporte extends UnidadMovil{

	protected ComportamientoTransporte comportamiento;
	protected UnidadSoldado[] soldadosCargados; 
	
	public UnidadTransporte(Jugador jugador, ComportamientoTransporte comportamiento) {
		super(jugador, comportamiento.getVida());
		soldadosCargados = new UnidadSoldado[comportamiento.capacidad()];
		this.comportamiento = comportamiento;
	}

	public boolean esTerrestre() {
		return false;
	}
	
	public boolean cargarSoldado(UnidadSoldado soldado) {
		for (int i = 0; i<comportamiento.capacidad(); i++) {
			if (soldadosCargados[i] == soldado) return false;
		}
		for (int i = 0; i<comportamiento.capacidad(); i++) {
			if (soldadosCargados[i] == null) {
				soldadosCargados[i] = soldado;
				return true;
			}
		}
		return false;
	}

	public UnidadSoldado descargarSoldado(int pos) {
		return null;		
	}
	
	public void pasarTurno() {
		return;	
	}

}
