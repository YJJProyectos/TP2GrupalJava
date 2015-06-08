package algo3.algocraft.modelo.edificables;

import algo3.algocraft.modelo.accionables.Unidad;

public class EdificioEnConstruccion extends Unidad {
	private int turnosRestantes;
	private Unidad edificioTerminado;

	public EdificioEnConstruccion(Unidad edificio, int turnosNecesarios) {
		this.vida = 1;
		this.edificioTerminado = edificio;
		this.turnosRestantes = turnosNecesarios;
	}

	public boolean esTerrestre() {
		return true;
	}

	public int verTurnosRestantes() {
		return turnosRestantes;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			posicion.desocuparTierra();
			edificioTerminado.posicionar(posicion);
		}
	}

}
