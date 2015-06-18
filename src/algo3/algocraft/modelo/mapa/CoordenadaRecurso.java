package algo3.algocraft.modelo.mapa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CoordenadaRecurso {

	private Collection<Coordenada> coordenadasDeMinerales;
	private Collection<Coordenada> coordenadasDeGas;
	private Iterator<Coordenada> iteradorMinerales;
	private Iterator<Coordenada> iteradorGas;

	public CoordenadaRecurso(int minFila,int minColumna,int maxFila,int maxColumna){

		this.coordenadasDeMinerales = new ArrayList<Coordenada>();
		this.coordenadasDeGas = new ArrayList<Coordenada>();

		this.agregarCoordenadasMineral(minFila, minColumna);
		this.agregarCoordenadasMineral(minFila, maxColumna);
		this.agregarCoordenadasMineral(maxFila, minFila);
		this.agregarCoordenadasMineral(maxFila, maxColumna);

		this.iteradorMinerales = this.coordenadasDeMinerales.iterator();

		this.agregarCoordenadasGas(minFila, minColumna + 1);
		this.agregarCoordenadasGas(minFila, maxColumna - 1);
		this.agregarCoordenadasGas(maxFila, minColumna + 1);
		this.agregarCoordenadasGas(maxFila, maxColumna - 1);

		this.iteradorGas = this.coordenadasDeGas.iterator();

	}

	public Coordenada sacarCoordenadaDeMineral() {
		
		return this.iteradorMinerales.next();
	}

	public Coordenada sacarCoordenadaDeGas() {

		return this.iteradorGas.next();
	}
	
	private void agregarCoordenadasMineral(int fila, int columna){
		Coordenada coordenadaMineral = new Coordenada(fila,columna);
		this.coordenadasDeMinerales.add(coordenadaMineral);
	}
	
	private void agregarCoordenadasGas(int fila, int columna){
		Coordenada coordenadaGas = new Coordenada(fila, columna);
		this.coordenadasDeGas.add(coordenadaGas);
	}

	public boolean tieneCoordenadaMineral() {
		return this.iteradorMinerales.hasNext();
	}

	public boolean tieneCoordenadaGas() {
		return this.iteradorGas.hasNext();
	}

}
