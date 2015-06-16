package algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores;

import algo3.algocraft.modelo.juego.JugadorTerran;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;

public class Refineria extends UnidadEdificio implements Recolector {
	
	private Recurso volcanDeGas;
	private JugadorTerran jugador;
	private int cantidadGasRecolectado;
	private boolean enConstruccion;
	private int turnosRestantes;

	public Refineria(Recurso recurso, JugadorTerran jugador) {
		this.volcanDeGas = recurso;
		this.jugador = jugador;
		this.cantidadGasRecolectado = 0;
		this.vida = 1;
		this.turnosRestantes = 4;
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
		return 4;
	}
	
	private void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 1000;
			this.enConstruccion = false;
		}
	}
	
	@Override
	public boolean esTerrestre() {
		return true;
	}

	@Override
	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		} else {
			this.recolectar();
			jugador.aumentarGas(this.cantidadGasRecolectado);
			this.cantidadGasRecolectado = 0;
		}
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}
}
