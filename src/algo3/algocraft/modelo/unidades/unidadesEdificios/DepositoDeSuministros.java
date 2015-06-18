package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;

public class DepositoDeSuministros extends UnidadEdificio {

	private boolean enConstruccion;
	private int turnosRestantes;
	private int costoMineral;
	private int costoGas;

	public DepositoDeSuministros(Jugador unJugador) throws RecursosInsuficientesError {
		super(unJugador,1);
		this.enConstruccion = true;
		this.turnosRestantes = 6;
		this.costoMineral = 150;
		this.costoGas = 0;
		this.jugador.pagar(this.costoMineral, this.costoGas);
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
