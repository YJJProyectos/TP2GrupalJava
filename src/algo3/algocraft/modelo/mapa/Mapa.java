package algo3.algocraft.modelo.mapa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.Unidad;

public class Mapa {

	HashMap<Coordenada, Casilla> tablero = new HashMap<Coordenada, Casilla>();
	private int minFila = 1;
	private int minColumna = 1;
	private int maxFila;
	private int maxColumna;
	private CoordenadasParaPosicionar coordenadas;
	private ArrayList<Integer> numerosSacados;

	public Mapa(int bases) {
		this.maxFila = (bases * 5);
		this.maxColumna = (bases * 5);

		for (int fila = this.minFila; fila <= this.maxFila; fila++) {
			for (int columna = this.minColumna; columna <= this.maxColumna; columna++) {

				Coordenada coordenada = new Coordenada(fila, columna);
				Casilla casilla = new Casilla(coordenada);
				tablero.put(coordenada, casilla);
			}

		}
		this.coordenadas = new CoordenadasParaPosicionar(minFila, minColumna,
				maxFila, maxColumna);
		this.numerosSacados = new ArrayList<Integer>();
	}

	public int tamanio() {
		return tablero.size();
	}

	private void validarCoordenada(Coordenada coordenada)
			throws CoordenadaInvalidaError {
		int fila = coordenada.getFila();
		int columna = coordenada.getColumna();

		if ((fila < this.minFila || columna < this.minColumna)
				|| (fila > this.maxFila || columna > this.maxColumna)) {

			throw new CoordenadaInvalidaError();
		}
	}

	public boolean agregarElementoEnPosicion(Unidad elemento,
			Coordenada coordenada) throws CasillaOcupadaError {
		try {
			validarCoordenada(coordenada);
		} catch (CoordenadaInvalidaError error) {
			return false;
		}
		Casilla casillero = tablero.get(coordenada);
		elemento.posicionar(casillero);
		return true;
	}

	public Unidad obtenerElementoTerrestreEnPosicion(Coordenada coordenada)
			throws CoordenadaInvalidaError {
		this.validarCoordenada(coordenada);
		Casilla casillero = tablero.get(coordenada);
		return casillero.getOcupanteTerrestre();
	}

	public void setCoordenadaMineralYVolcanDeGas() throws CasillaOcupadaError {
		while (coordenadas.tieneCoordenadaMineral()) {
			MinaDeMinerales mina = new MinaDeMinerales(2000);
			Coordenada coordenadaDeMina = coordenadas
					.sacarCoordenadaDeMineral();
			Casilla casilla = tablero.get(coordenadaDeMina);
			mina.posicionar(casilla);
		}
		while (coordenadas.tieneCoordenadaGas()) {
			VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(2000);
			Coordenada coordenadaDeGas = coordenadas.sacarCoordenadaDeGas();
			Casilla casilla = tablero.get(coordenadaDeGas);
			volcan.posicionar(casilla);
		}
	}

	public Casilla getCasilla(Coordenada coordenada)
			throws CoordenadaInvalidaError {
		this.validarCoordenada(coordenada);
		return tablero.get(coordenada);
	}

	public Casilla posicionDeBase() {
		Casilla casillaDeBase = null;
		if (coordenadas.tieneCoordenadaDeBase()) {
			Random aleatorio = new Random();
			// genero numero aleatorio entre 0 y 3
			int numeroAleatorio = aleatorio.nextInt(4);
			while (this.numerosSacados.contains(numeroAleatorio)) {
				// si ya obtuve un numero anterior busco otro aleatoriamente
				numeroAleatorio = aleatorio.nextInt(4);
			}
			// cuando sale del ciclo ya no esta contenido en la lista
			Coordenada coordenadaBase = coordenadas
					.sacarCoordenadaDeBase(numeroAleatorio);
			casillaDeBase = this.tablero.get(coordenadaBase);
			this.numerosSacados.add(numeroAleatorio);
		}
		return casillaDeBase;
	}

	public Recurso obtenerRecursoEnPosicion(Coordenada coordenada)
			throws CoordenadaInvalidaError {
		this.validarCoordenada(coordenada);
		Casilla casillero = tablero.get(coordenada);
		return casillero.getRecurso();
	}

}
