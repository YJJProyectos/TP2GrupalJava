package algo3.algocraft.modelo.mapa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CoordenadasParaPosicionar {

	private Collection<Coordenada> coordenadasDeMinerales;
	private Collection<Coordenada> coordenadasDeGas;
	private ArrayList<Coordenada> coordenadasBases;
	private Iterator<Coordenada> iteradorMinerales;
	private Iterator<Coordenada> iteradorGas;
	private int cantidadCoordenadasBasesSacadas;

	public CoordenadasParaPosicionar(int minFila, int minColumna, int maxFila,
			int maxColumna) {
		this.coordenadasDeMinerales = new ArrayList<Coordenada>();
		this.coordenadasDeGas = new ArrayList<Coordenada>();
		this.coordenadasBases = new ArrayList<Coordenada>();
		this.cantidadCoordenadasBasesSacadas = 0;

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

		this.agregarCoordenadasBases(minFila + 1, minColumna + 1);
		this.agregarCoordenadasBases(minFila + 1, maxColumna - 1);
		this.agregarCoordenadasBases(maxFila - 1, minColumna + 1);
		this.agregarCoordenadasBases(maxFila - 1, maxColumna - 1);

	}

	public Coordenada sacarCoordenadaDeMineral() {
		return this.iteradorMinerales.next();
	}

	public Coordenada sacarCoordenadaDeGas() {
		return this.iteradorGas.next();
	}

	private void agregarCoordenadasMineral(int fila, int columna) {
		Coordenada coordenadaMineral = new Coordenada(fila, columna);
		this.coordenadasDeMinerales.add(coordenadaMineral);
	}

	private void agregarCoordenadasGas(int fila, int columna) {
		Coordenada coordenadaGas = new Coordenada(fila, columna);
		this.coordenadasDeGas.add(coordenadaGas);
	}

	private void agregarCoordenadasBases(int fila, int columna) {
		Coordenada coordenada = new Coordenada(fila, columna);
		coordenadasBases.add(coordenada);
	}

	public boolean tieneCoordenadaMineral() {
		return this.iteradorMinerales.hasNext();
	}

	public boolean tieneCoordenadaGas() {
		return this.iteradorGas.hasNext();
	}

	public Coordenada sacarCoordenadaDeBase(int numeroBase) {
		this.cantidadCoordenadasBasesSacadas++;
		return this.coordenadasBases.get(numeroBase);
	}

	public boolean tieneCoordenadaDeBase() {
		return (this.cantidadCoordenadasBasesSacadas < 4);
	}

}
