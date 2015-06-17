package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.recursos.Recurso;

public class Refineria extends Recolector {
	
	protected Recurso volcanDeGas;
	protected int cantidadGasRecolectado;
	protected boolean enConstruccion;
	protected int turnosRestantes;

	public Refineria(Recurso recurso, Jugador jugador) {
		super(jugador,1);
		this.volcanDeGas = recurso;
		this.cantidadGasRecolectado = 0;
		this.turnosRestantes = 6;
		this.enConstruccion = true;
	}

	public boolean recolectar() {
		int cantidadGasSacado = this.volcanDeGas.extraerRecurso(10);
		if (cantidadGasSacado > 0) {
			this.cantidadGasRecolectado += cantidadGasSacado;
			return true;
		}
		return false;
	}

	public int getCantidadRecursoRecolectado() {
		return this.cantidadGasRecolectado;
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
			this.recolectar();
			jugador.aumentarGas(cantidadGasRecolectado);
			cantidadGasRecolectado = 0;
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
