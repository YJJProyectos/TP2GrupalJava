package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;

public class Barraca extends UnidadEdificio {

	private boolean enConstruccion;
	private int turnosRestantes;
	private Marine marineEnEntrenamiento;
	private int turnosRestantesParaTerminarMarine;
	private int costoMineral;
	private int costoGas;

	public Barraca(Jugador unJugador, Casilla casilla)
			throws RecursosInsuficientesError, CasillaOcupadaError {
		super(unJugador, 1);
		this.enConstruccion = true;
		this.turnosRestantes = 12;
		this.turnosRestantesParaTerminarMarine = 3;
		this.costoMineral = 150;
		this.costoGas = 0;
		this.jugador.pagar(this.costoMineral, this.costoGas);
		this.posicionar(casilla);
		unJugador.agregarUnidad(this);
	}

	public boolean entrenarMarine(Jugador unJugador)
			throws JugadorIncorrectoError {
		if (this.jugador != unJugador) {
			throw new JugadorIncorrectoError();
		}
		if (this.enConstruccion || this.marineEnEntrenamiento != null) {
			return false;
		}
		this.marineEnEntrenamiento = new Marine(this.jugador);
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

	public void continuarEntrenamientoDeMarine() {
		if (this.marineEnEntrenamiento != null)
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
}
