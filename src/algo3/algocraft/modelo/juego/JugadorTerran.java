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

public class JugadorTerran extends Jugador {

	private ArrayList<Unidad> unidades;

	public JugadorTerran() {
		unidades = new ArrayList<Unidad>();
		cantidadMineral = 400;
		cantidadGas = 100;
		poblacion = 10;
	}

	public int cantidadUnidades() {
		return this.unidades.size();
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
		this.poblacion = 10;
		for (int i = 0; i < this.unidades.size(); i++) {
			Unidad unidad = this.unidades.get(i);
			unidad.pasarTurno();
		}

	}

}
