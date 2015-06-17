package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
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
		poblacion = 10;
		this.soldadosParaPosicionar = new ArrayList<UnidadSoldado>();
		// agrego que jugador empieza con un deposito
		// despues ver si en donde posicionarla en el mapa
		// y tambien deberia empezar con un marine (despues se agregaria)
		DepositoDeSuministros deposito = new DepositoDeSuministros(this);
		for (int i = 0; i < 6; i++) {
			deposito.continuarConstruccion();
		}
		unidades.add(deposito);
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

	public Barraca crearBarraca(Casilla casilla) {
		Barraca barraca = new Barraca(this);
		barraca.posicionar(casilla);
		this.unidades.add(barraca);
		return barraca;
	}

	public Fabrica crearFabrica(Casilla casilla, Barraca barraca)
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError {
		if (barraca.enConstruccion()) {
			throw new BarracaNoConstruidaError();
		}
		Fabrica fabrica = new Fabrica(this, barraca);
		fabrica.posicionar(casilla);
		this.unidades.add(fabrica);
		return fabrica;
	}

	public DepositoDeSuministros crearDepositoDeSuministros(Casilla casilla) {
		DepositoDeSuministros deposito = new DepositoDeSuministros(this);
		deposito.posicionar(casilla);
		this.unidades.add(deposito);
		return deposito;
	}

	public CentroDeMineral crearCentroDeMineral(Casilla casilla)
			throws PosicionNoOcupadaPorRecursoError {

		if (!casilla.estaOcupadoElRecurso()) {
			throw new PosicionNoOcupadaPorRecursoError();
		}
		CentroDeMineral centroDeMineral = new CentroDeMineral(
				casilla.getRecurso(), this);
		centroDeMineral.posicionar(casilla);
		this.unidades.add(centroDeMineral);
		return centroDeMineral;
	}

	public Refineria crearRefineria(Casilla casilla)
			throws PosicionNoOcupadaPorRecursoError {

		if (!casilla.estaOcupadoElRecurso()) {
			throw new PosicionNoOcupadaPorRecursoError();
		}
		Refineria refineria = new Refineria(casilla.getRecurso(), this);
		refineria.posicionar(casilla);
		this.unidades.add(refineria);
		return refineria;

	}

	public void pasarTurno() {
		this.poblacion = 0;
		for (int i = 0; i < this.unidades.size(); i++) {
			Unidad unidad = this.unidades.get(i);
			unidad.pasarTurno();
		}

	}

}
