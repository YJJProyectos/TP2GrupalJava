package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;

public class CentroDeMineral extends Recolector {

	private Recurso minaDeMineral;

	public CentroDeMineral(Recurso recurso, Jugador unJugador)
			throws RecursosInsuficientesError, RecolectorInvalidoError,
			CasillaOcupadaError {
		super(unJugador, 1, 50, 0, "Centro de Mineral");
		this.enConstruccion = true;
		this.turnosRestantes = 4;
		this.jugador.validarCosto(this.costoMineral, this.costoGas);
		recurso.agregarCentroDeMineral(this);
		this.minaDeMineral = recurso;
		this.jugador.pagar(this.costoMineral, this.costoGas);
		unJugador.agregarUnidad(this);
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
			jugador.aumentarMineral(this.minaDeMineral.extraerRecurso(10));
		}
	}

}
