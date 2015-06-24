package algo3.algocraft.modelo.unidades.unidadesMoviles;

import java.util.ArrayList;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAereo;

public class TransporteTerran extends UnidadMovil {

	private ArrayList<UnidadSoldado> soldadosCargados;
	private int capacidadMaxima;

	public TransporteTerran(Jugador jugador) throws RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError {
		super(jugador, 150, PlanoAereo.getInstancia(), 100, 100, 2);
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		this.jugador.validarSuministro(this.suministro);
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.jugador.aumentarSuministro(this.suministro);
		soldadosCargados = new ArrayList<UnidadSoldado>();
		this.capacidadMaxima = 8;
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
