package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.recursos.Recurso;

public class CentroDeMineral extends Recolector {

	private int cantidadMineralRecolectado;
	private Recurso mineral;
	private int turnosRestantes;
	private boolean enConstruccion;
	private int costoMineral;
	private int costoGas;

	public CentroDeMineral(Recurso unMineral, Jugador jugador)
			throws RecursosInsuficientesError {
		super(jugador, 1);
		this.mineral = unMineral;
		this.cantidadMineralRecolectado = 0;
		this.turnosRestantes = 4;
		this.enConstruccion = true;
		this.costoMineral = 50;
		this.costoGas = 0;
		this.jugador.pagar(this.costoMineral, this.costoGas);
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

	@Override
	public boolean posicionar(Casilla casilla) {
		if (casilla.ocupar(this)) {
			this.posicion = casilla;
			return true;
		}
		return false;
	}

}
