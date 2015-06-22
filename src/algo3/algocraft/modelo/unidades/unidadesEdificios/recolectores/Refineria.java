package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;

public class Refineria extends Recolector {

	protected Recurso volcanDeGas;

	public Refineria(Recurso recurso, Jugador unJugador)
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {
		super(unJugador, 1, 100, 0);
		this.enConstruccion = true;
		this.turnosRestantes = 6;
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		recurso.agregarRefineria(this);
		this.volcanDeGas = recurso;
		this.jugador.pagar(this.costoMineral, this.costoGas);
		unJugador.agregarUnidad(this);
	}

	@Override
	public int tiempoDeConstruccion() {
		return this.turnosRestantes;
	}

	private void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 750;
			this.enConstruccion = false;
		}
	}

	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		} else {
			jugador.aumentarGas(this.volcanDeGas.extraerRecurso(10));
		}
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}

}
