package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;

public class Barraca extends UnidadEdificio {

	private Marine marineEnEntrenamiento;
	private int turnosRestantesParaTerminarMarine;

	public Barraca(Jugador unJugador, Casilla casilla)
			throws RecursosInsuficientesError, CasillaOcupadaError {
		super(unJugador, 1, 150, 0, "Barraca");
		this.enConstruccion = true;
		this.turnosRestantes = 12;
		this.marineEnEntrenamiento = null;
		this.turnosRestantesParaTerminarMarine = 3;
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		this.posicionar(casilla);
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.jugador.agregarUnidad(this);
	}

	public void entrenarMarine(Jugador unJugador)
			throws JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError, BarracaNoConstruidaError,
			YaHayUnidadEnEntrenamiento {
		if (this.jugador != unJugador) {
			throw new JugadorIncorrectoError();
		}
		if (this.enConstruccion) {
			throw new BarracaNoConstruidaError();
		}
		if (this.marineEnEntrenamiento != null) {
			throw new YaHayUnidadEnEntrenamiento();
		}
		this.marineEnEntrenamiento = new Marine(this.jugador);
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

	public void continuarEntrenamientoDeMarine() {
		if (this.marineEnEntrenamiento == null) {
			return;
		}
		this.turnosRestantesParaTerminarMarine -= 1;
		if (this.turnosRestantesParaTerminarMarine == 0) {
			this.jugador
					.agregarSoldadoParaPosicionar(this.marineEnEntrenamiento);
			this.marineEnEntrenamiento = null;
			this.turnosRestantesParaTerminarMarine = 3;
		}
	}

	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		}
		this.continuarEntrenamientoDeMarine();
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}

	public boolean unidadEnConstruccion() {
		return this.marineEnEntrenamiento != null;
	}

	public int tiempoFaltanteCrearMarine() {
		return this.turnosRestantesParaTerminarMarine;
	}

}
