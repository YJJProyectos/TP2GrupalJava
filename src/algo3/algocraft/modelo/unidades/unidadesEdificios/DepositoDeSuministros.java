package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;

public class DepositoDeSuministros extends UnidadEdificio {

	public DepositoDeSuministros(Jugador unJugador, Casilla casilla)
			throws RecursosInsuficientesError, CasillaOcupadaError {
		super(unJugador, 1, 100, 0, "Deposito de Suministros");
		this.enConstruccion = true;
		this.turnosRestantes = 6;
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		this.posicionar(casilla);
		this.jugador.pagar(this.costoMineral, this.costoGas);
		unJugador.agregarUnidad(this);
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
