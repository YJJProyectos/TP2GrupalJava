package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;

public class DepositoDeSuministros extends UnidadEdificio {

	private boolean enConstruccion;
	private int turnosRestantes;

	public DepositoDeSuministros(Jugador unJugador) {
		super(unJugador,1);
		this.enConstruccion = true;
		this.turnosRestantes = 6;
	}

	public int tiempoDeConstruccion() {
		return this.turnosRestantes;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 500;
			this.enConstruccion = false;
		}
	}

	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		} else {
			jugador.aumentarPoblacion();
		}
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}

}
