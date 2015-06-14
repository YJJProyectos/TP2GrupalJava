package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;

public class Barraca extends UnidadEdificio {

	private boolean enConstruccion;
	private int turnosRestantes;

	public Barraca(Jugador unJugador) {
		this.jugador = unJugador;
		this.vida = 1;
		this.enConstruccion = true;
		this.turnosRestantes = 12;
	}

	public boolean entrenarMarine() {
		if (this.enConstruccion) {
			return false;
		}
		return true;
	}

	public boolean esTerrestre() {
		return true;
	}

	public int tiempoDeConstruccion() {
		return turnosRestantes;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 1000;
			this.enConstruccion = false;
		}
	}

	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		}
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}
}
