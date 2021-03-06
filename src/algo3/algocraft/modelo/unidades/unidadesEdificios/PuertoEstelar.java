package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Espectro;

public class PuertoEstelar extends UnidadEdificio {

	private Fabrica fabrica;
	private Espectro espectroEnEntrenamiento;
	private int turnosRestantesParaTerminarEspectro;

	public PuertoEstelar(Jugador unJugador, Casilla casilla, Fabrica unaFabrica)
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			FabricaNoConstruidaError, CasillaOcupadaError {
		super(unJugador, 1, 150, 100, "PuertoEstelar");
		if (!this.esAliado(unaFabrica)) {
			throw new PerteneceAOtroJugadorError();
		}
		if (unaFabrica.enConstruccion()) {
			throw new FabricaNoConstruidaError();
		}
		this.fabrica = unaFabrica;
		this.enConstruccion = true;
		this.turnosRestantes = 10;
		this.espectroEnEntrenamiento = null;
		this.turnosRestantesParaTerminarEspectro = 8;
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		this.posicionar(casilla);
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.jugador.agregarUnidad(this);
	}

	public boolean entrenarEspectro(Jugador unJugador)
			throws JugadorIncorrectoError, RecursosInsuficientesError,
			PoblacionLimiteAlcanzadaError, PuertoEstelarNoConstruidoError,
			FabricaDestruidaError, YaHayUnidadEnEntrenamiento {
		if (this.jugador != unJugador) {
			throw new JugadorIncorrectoError();
		}
		if (this.enConstruccion) {
			throw new PuertoEstelarNoConstruidoError();
		}
		if (fabrica.estaDestruido()) {
			throw new FabricaDestruidaError();
		}
		if (this.espectroEnEntrenamiento != null) {
			throw new YaHayUnidadEnEntrenamiento();
		}
		this.espectroEnEntrenamiento = new Espectro(this.jugador);
		return true;
	}

	public int tiempoDeConstruccion() {
		return turnosRestantes;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 1300;
			this.enConstruccion = false;
		}
	}

	public void continuarEntrenamientoDeUnidad() {
		if (this.espectroEnEntrenamiento == null) {
			return;
		}
		this.turnosRestantesParaTerminarEspectro -= 1;
		if (this.turnosRestantesParaTerminarEspectro == 0) {
			this.jugador
					.agregarSoldadoParaPosicionar(this.espectroEnEntrenamiento);
			this.espectroEnEntrenamiento = null;
			this.turnosRestantesParaTerminarEspectro = 8;
		}
	}

	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		}
		this.continuarEntrenamientoDeUnidad();
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}

	public boolean unidadEnConstruccion() {
		return this.espectroEnEntrenamiento != null;
	}

	public int tiempoFaltanteEntrenarEspectro() {
		return this.turnosRestantesParaTerminarEspectro;
	}

}
