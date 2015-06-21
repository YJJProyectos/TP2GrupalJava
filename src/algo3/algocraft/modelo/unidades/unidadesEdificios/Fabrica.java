package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;

public class Fabrica extends UnidadEdificio {

	private Barraca barraca;
	private boolean enConstruccion;
	private int turnosRestantes;
	private Golliat golliatEnEntrenamiento;
	private int turnosRestantesParaTerminarGolliat;
	private int costoMineral;
	private int costoGas;

	public Fabrica(Jugador unJugador, Casilla casilla, Barraca unaBarraca)
			throws PerteneceAOtroJugadorError, RecursosInsuficientesError,
			BarracaNoConstruidaError, CasillaOcupadaError {
		super(unJugador, 1);
		if (!this.esAliado(unaBarraca)) {
			throw new PerteneceAOtroJugadorError();
		}
		if (unaBarraca.enConstruccion()) {
			throw new BarracaNoConstruidaError();
		}
		this.barraca = unaBarraca;
		this.enConstruccion = true;
		this.turnosRestantes = 12;
		this.golliatEnEntrenamiento = null;
		this.turnosRestantesParaTerminarGolliat = 6;
		this.costoMineral = 200;
		this.costoGas = 100;
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.posicionar(casilla);
		unJugador.agregarUnidad(this);
	}

	public boolean entrenarGolliat(Jugador unJugador) throws JugadorIncorrectoError {
		if (this.jugador != unJugador) {
			throw new JugadorIncorrectoError();
		}
		if (this.enConstruccion || barraca.estaDestruido()
				|| this.golliatEnEntrenamiento != null) {
			return false;
		}
		this.golliatEnEntrenamiento = new Golliat(this.jugador);
		return true;
	}

	public int tiempoDeConstruccion() {
		return turnosRestantes;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 1250;
			this.enConstruccion = false;
		}
	}

	public void continuarEntrenamientoDeGolliat() {
		if (this.golliatEnEntrenamiento != null)
			this.turnosRestantesParaTerminarGolliat -= 1;
		if (this.turnosRestantesParaTerminarGolliat == 0) {
			this.jugador
					.agregarSoldadoParaPosicionar(this.golliatEnEntrenamiento);
			this.golliatEnEntrenamiento = null;
			this.turnosRestantesParaTerminarGolliat = 6;
		}
	}

	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		}
		this.continuarEntrenamientoDeGolliat();
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}

}
