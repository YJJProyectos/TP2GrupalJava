package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;

public class CentroDeMineral extends UnidadEdificio implements Recolector {

	private int cantidadMineralRecolectado;
	private Recurso mineral;
	private int turnosRestantes;
	private boolean enConstruccion;

	public CentroDeMineral(Recurso unMineral, Jugador jugador) {
		super(jugador,1);
		this.mineral = unMineral;
		this.cantidadMineralRecolectado = 0;
		this.turnosRestantes = 4;
		this.enConstruccion = true;
	}

	public boolean recolectar() {
		int cantidadMineralSacado = this.mineral.extraerRecurso(10);
		if (cantidadMineralSacado > 0) {
			this.cantidadMineralRecolectado += cantidadMineralSacado;
			return true;
		}
		return false;
	}

	public int getCantidadRecursoRecolectado() {
		return this.cantidadMineralRecolectado;
	}

	public boolean esTerrestre() {
		return true;
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
			this.recolectar();
			jugador.aumentarMineral(this.cantidadMineralRecolectado);
			this.cantidadMineralRecolectado = 0;
		}
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}

}
