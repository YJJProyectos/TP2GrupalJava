package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.ComportamientoTransporte;

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
				soldado.posicionar(null);
				return true;
			}
		}
		return false;
	}

	public UnidadSoldado descargarSoldado() {
		for (int i = 0; i<comportamiento.capacidad(); i++) {
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
