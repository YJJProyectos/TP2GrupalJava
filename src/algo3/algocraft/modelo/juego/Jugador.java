package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class Jugador {

	private ArrayList<Unidad> unidades;
	private int cantidadMineral;
	private int cantidadGas;
	private int poblacionPosible;
	private int poblacionOcupada;
	private ArrayList<UnidadSoldado> soldadosParaPosicionar;
	private String nombre;

	public Jugador() {
		this.unidades = new ArrayList<Unidad>();
		this.cantidadMineral = 400;
		this.cantidadGas = 100;
		this.poblacionPosible = 0;
		this.poblacionOcupada = 0;
		this.soldadosParaPosicionar = new ArrayList<UnidadSoldado>();
		this.nombre = "";
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

	public int cantidadPoblacionOcupada() {
		return this.poblacionOcupada;
	}

	public int cantidadPoblacionPosible() {
		return this.poblacionPosible;
	}

	public void aumentarPoblacion() {
		this.poblacionPosible += 10;
		if (this.poblacionPosible > 200) {
			this.poblacionPosible = 200;
		}
	}

	public void agregarSoldadoParaPosicionar(UnidadSoldado unidadEnEntrenamiento) {
		this.soldadosParaPosicionar.add(unidadEnEntrenamiento);
	}

	public void posicionarSoldadoEnColaDeEspera(Casilla casilla)
			throws CasillaOcupadaError, NoHaySoldadosParaPosicionarError {
		if (this.soldadosParaPosicionar.isEmpty()) {
			throw new NoHaySoldadosParaPosicionarError();
		}
		UnidadSoldado soldado = this.soldadosParaPosicionar.get(0);
		soldado.posicionar(casilla);
		this.soldadosParaPosicionar.remove(0);
		this.agregarUnidad(soldado);
	}

	public int cantidadSoldadosParaPosicionar() {
		return this.soldadosParaPosicionar.size();
	}

	public void agregarUnidad(Unidad unidad) {
		this.unidades.add(unidad);
	}

	public void removerUnidad(Unidad unidad) {
		this.unidades.remove(unidad);
		this.aumentarSuministro(-unidad.getSuministro());
	}

	public void pasarTurno() {
		this.poblacionPosible = 0;
		this.removerUnidadesDestruidas();
		for (int i = 0; i < this.unidades.size(); i++) {
			Unidad unidad = this.unidades.get(i);
			unidad.pasarTurno();
		}

	}

	public void validarCosto(int costoMineral, int costoGas)
			throws RecursosInsuficientesError {
		if (costoMineral > this.cantidadMineral || costoGas > this.cantidadGas) {
			throw new RecursosInsuficientesError();
		}
	}

	public void validarSuministro(int suministro)
			throws PoblacionLimiteAlcanzadaError {
		if ((this.poblacionOcupada + suministro) > this.poblacionPosible) {
			throw new PoblacionLimiteAlcanzadaError();
		}
	}

	public void pagar(int costoMineral, int costoGas) {
		this.cantidadMineral -= costoMineral;
		this.cantidadGas -= costoGas;
	}

	public void aumentarSuministro(int suministro) {
		this.poblacionOcupada += suministro;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void iniciarConMarineParaPosicionar() {

		this.aumentarMineral(30); // la cantidad necesaria para un marine
		try {
			Marine marine = new Marine(this);
			this.agregarSoldadoParaPosicionar(marine);
		} catch (RecursosInsuficientesError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PoblacionLimiteAlcanzadaError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
