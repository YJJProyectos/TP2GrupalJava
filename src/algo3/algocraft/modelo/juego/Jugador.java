package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class Jugador {

	private ArrayList<Unidad> unidades;
	private int cantidadMineral;
	private int cantidadGas;
	private int poblacion;
	private ArrayList<UnidadSoldado> soldadosParaPosicionar;

	public Jugador() {
		unidades = new ArrayList<Unidad>();
		cantidadMineral = 400;
		cantidadGas = 100;
		poblacion = 0;
		this.soldadosParaPosicionar = new ArrayList<UnidadSoldado>();
	}

	public int cantidadMineral() {
		return this.cantidadMineral;
	}

	public int cantidadGas() {
		return this.cantidadGas;
	}

	public void aumentarMineral(int cantidadMineralRecolectado) {
		this.cantidadMineral += cantidadMineralRecolectado;
	}

	public void aumentarGas(int cantidadGasRecolectado) {
		this.cantidadGas += cantidadGasRecolectado;
	}

	public int cantidadPoblacion() {
		return this.poblacion;
	}

	public void aumentarPoblacion() {
		this.poblacion += 10;
		if (this.poblacion > 200) {
			this.poblacion = 200;
		}
	}

	public void agregarSoldadoParaPosicionar(UnidadSoldado soldado) {
		this.soldadosParaPosicionar.add(soldado);

	}

	public void posicionarSoldadoEnColaDeEspera(Casilla casilla)
			throws CasillaOcupadaError, NoHaySoldadosParaPosicionarError {
		if (this.soldadosParaPosicionar.isEmpty()) {
			throw new NoHaySoldadosParaPosicionarError();
		}
		UnidadSoldado soldado = this.soldadosParaPosicionar.remove(0);
		soldado.posicionar(casilla);
		this.agregarUnidad(soldado);

	}

	public void agregarUnidad(Unidad unidad) {
		this.unidades.add(unidad);
	}

	public void removerUnidad(Unidad unidad) {
		this.unidades.remove(unidad);
	}

	public void pasarTurno() {
		this.poblacion = 0;
		this.removerUnidadesDestruidas();
		for (int i = 0; i < this.unidades.size(); i++) {
			Unidad unidad = this.unidades.get(i);
			unidad.pasarTurno();
		}

	}

	public void pagar(int costoMineral, int costoGas)
			throws RecursosInsuficientesError {
		if (costoMineral > this.cantidadMineral || costoGas > this.cantidadGas) {
			throw new RecursosInsuficientesError();
		}
		this.cantidadMineral -= costoMineral;
		this.cantidadGas -= costoGas;
	}

	public void iniciarConDeposito(Casilla posicionDeBase)
			throws RecursosInsuficientesError, CasillaOcupadaError {
		this.aumentarMineral(100); // le agrego lo necesario para crear el
									// deposito
		DepositoDeSuministros deposito = new DepositoDeSuministros(this,
				posicionDeBase);
		for (int i = 0; i < 7; i++) {
			deposito.pasarTurno();
		}
	}

	public boolean estaDestruido() {
		this.removerUnidadesDestruidas();
		return this.unidades.isEmpty();
	}

	private void removerUnidadesDestruidas() {
		for (int i = 0; i < this.unidades.size(); i++) {
			Unidad unidad = this.unidades.get(i);
			if (unidad.estaDestruido()) {
				this.removerUnidad(unidad);
			}
		}
	}

	public int cantidadUnidades() {
		return this.unidades.size();
	}

}
