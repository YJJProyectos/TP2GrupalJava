package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Recolector;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.modelo.unidades.unidadesSoldados.UnidadSoldado;

public class JugadorTerran extends Jugador {

	private ArrayList<Unidad> unidades;

	public JugadorTerran() {
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
		casilla.ocupar((Recolector)refineria);
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
