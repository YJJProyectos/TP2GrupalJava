package algo3.algocraft.modelo.unidades.unidadesMoviles;

import java.util.ArrayList;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public abstract class UnidadTransporte extends UnidadMovil {

	protected ArrayList<UnidadSoldado> soldadosCargados;
	protected int capacidadMaxima;

	public UnidadTransporte(Jugador jugador, PlanoAccion plano, int capacidad,
			int vida, int costoMineral, int costoGas, int suministro)
			throws RecursosInsuficientesError, PoblacionLimiteAlcanzadaError {
		super(jugador, vida, plano, costoMineral, costoGas, suministro);
		soldadosCargados = new ArrayList<UnidadSoldado>();
		this.capacidadMaxima = capacidad;
	}

	public void cargarSoldado(UnidadSoldado soldado, Jugador unJugador)
			throws PerteneceAOtroJugadorError, LimiteDeCapacidadError,
			SoldadoYaCargadoError, JugadorIncorrectoError {
		if (this.jugador != unJugador) {
			throw new JugadorIncorrectoError();
		}
		if (!this.esAliado(soldado))
			throw new PerteneceAOtroJugadorError();
		if (this.soldadosCargados.size() + 1 > this.capacidadMaxima) {
			throw new LimiteDeCapacidadError();
		}
		if (this.soldadosCargados.contains(soldado)) {
			throw new SoldadoYaCargadoError();
		}
		soldadosCargados.add(soldado);
		soldado.nuevaPosicion(null);
	}

	public UnidadSoldado descargarSoldado(Jugador unJugador)
			throws UnidadTransporteVaciaError, JugadorIncorrectoError {
		if (this.jugador != unJugador) {
			throw new JugadorIncorrectoError();
		}
		try {
			return this.soldadosCargados.remove(0);
		} catch (IndexOutOfBoundsException e) {
			throw new UnidadTransporteVaciaError();
		}
	}

	public void pasarTurno() {
		return;
	}

}
