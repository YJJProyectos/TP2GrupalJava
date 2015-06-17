package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;

public class Refineria extends UnidadEdificio implements Recolector {
	
	protected Recurso volcanDeGas;
	protected int cantidadGasRecolectado;
	protected boolean enConstruccion;
	protected int turnosRestantes;

	public Refineria(Recurso recurso, JugadorTerran jugador) {
		super(jugador,1);
		this.volcanDeGas = recurso;
		this.cantidadGasRecolectado = 0;
		this.turnosRestantes = 6;
		this.enConstruccion = true;
	}

	@Override
	public boolean recolectar() {
		int cantidadGasSacado = this.volcanDeGas.extraerRecurso(10);
		if (cantidadGasSacado > 0) {
			this.cantidadGasRecolectado += cantidadGasSacado;
			return true;
		}
		return false;
	}

	@Override
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
}
