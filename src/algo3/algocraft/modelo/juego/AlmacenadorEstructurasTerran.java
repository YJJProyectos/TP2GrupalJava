package algo3.algocraft.modelo.juego;

import java.util.ArrayList;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.EdificioEnConstruccion;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;

public class AlmacenadorEstructurasTerran {

	private ArrayList<UnidadEdificio> listaDeBarracas;
	private ArrayList<UnidadEdificio> listaDeDepositos;
	private ArrayList<UnidadEdificio> listaDeFabricas;
	private ArrayList<Unidad> listaDeEdificiosEnConstruccion;

	public AlmacenadorEstructurasTerran() {
		this.listaDeBarracas = new ArrayList<UnidadEdificio>();
		this.listaDeDepositos = new ArrayList<UnidadEdificio>();
		this.listaDeFabricas = new ArrayList<UnidadEdificio>();
		this.listaDeEdificiosEnConstruccion = new ArrayList<Unidad>();

	}
	
	public int cantidadFabricas(){
		return listaDeFabricas.size();
	}

	public int cantidadBarracas() {

		return listaDeBarracas.size();
	}

	public int cantidadDepositos() {
		return listaDeDepositos.size();
	}
	
	public int cantidadEdificiosEnConstruccion(){
		return listaDeEdificiosEnConstruccion.size();
	}

	public boolean crearBarraca(Casilla casilla) {
		Barraca barraca = new Barraca();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				barraca, this.listaDeBarracas, listaDeEdificiosEnConstruccion);
		if (construccion.posicionar(casilla)) {
			listaDeEdificiosEnConstruccion.add(construccion);
			return true;
		}
		return false;
	}

	public boolean crearFabrica(Casilla casilla) {
		if (listaDeBarracas.isEmpty()) {
			return false;
		}
		Fabrica fabrica = new Fabrica();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				fabrica, this.listaDeFabricas, listaDeEdificiosEnConstruccion);
		if (construccion.posicionar(casilla)) {
			listaDeEdificiosEnConstruccion.add(construccion);
			return true;
		}
		return false;
	}

	public boolean crearDepositoDeSuministros(Casilla casilla) {
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		EdificioEnConstruccion construccion = new EdificioEnConstruccion(
				deposito, this.listaDeDepositos,
				this.listaDeEdificiosEnConstruccion);
		if (construccion.posicionar(casilla)) {
			listaDeEdificiosEnConstruccion.add(construccion);
			return true;
		}
		return false;
	}
	
	public void continuarConConstrucciones(){
		for(int i = 0; i < listaDeEdificiosEnConstruccion.size(); i++){
			EdificioEnConstruccion construccion = (EdificioEnConstruccion) listaDeEdificiosEnConstruccion.get(i);
			construccion.continuarConstruccion();
		}
		
	}

}
