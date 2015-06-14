package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;

public class JugadorTerran extends Jugador {

	private ArrayList<Unidad> listaDeUnidades;

	public JugadorTerran() {

		listaDeUnidades = new ArrayList<Unidad>();
		cantidadMineral = 400;

	}

	public int cantidadUnidades() {
		return this.listaDeUnidades.size();
	}

	public Barraca crearBarraca(Casilla casilla) {
		Barraca barraca = new Barraca(this);
		barraca.posicionar(casilla);
		this.listaDeUnidades.add(barraca);
		return barraca;
	}

	public Fabrica crearFabrica(Casilla casilla, Barraca barraca)
			throws BarracaNoConstruidaError, PerteneceAOtroJugadorError {
		if (barraca.enConstruccion()) {
			throw new BarracaNoConstruidaError();
		}
		Fabrica fabrica = new Fabrica(this, barraca);
		fabrica.posicionar(casilla);
		this.listaDeUnidades.add(fabrica);
		return fabrica;
	}

	public DepositoDeSuministros crearDepositoDeSuministros(Casilla casilla) {
		DepositoDeSuministros deposito = new DepositoDeSuministros(this);
		deposito.posicionar(casilla);
		this.listaDeUnidades.add(deposito);
		return deposito;
	}

	public void pasarTurno() {
		for (int i = 0; i < this.listaDeUnidades.size(); i++) {
			Unidad unidad = this.listaDeUnidades.get(i);
			unidad.pasarTurno();
		}

	}

	public CentroDeMineral crearCentroDeMineral(Casilla casilla) {
		
		if ( casilla.estaOcupadoElRecurso() ){
		CentroDeMineral centroDeMineral = new CentroDeMineral(casilla.getRecurso());
		centroDeMineral.posicionar(casilla);
		this.listaDeUnidades.add(centroDeMineral);
		return centroDeMineral;
		}
		return null; //por ahora asi , verlo poner una excepcion despues
	}


}
