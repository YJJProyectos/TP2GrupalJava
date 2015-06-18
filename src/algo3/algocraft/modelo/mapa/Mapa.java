package algo3.algocraft.modelo.mapa;

import java.util.HashMap;

import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.Unidad;

public class Mapa {

	HashMap<Coordenada, Casilla> tablero = new HashMap<Coordenada, Casilla>();
	private int minFila = 1;
	private int minColumna = 1;
	private int maxFila;
	private int maxColumna;

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
			Coordenada coordenada) {

		try {
			validarCoordenada(coordenada);
		} catch (CoordenadaInvalidaError error) {
			return false;
		}
		Casilla casillero = tablero.get(coordenada);
		elemento.posicionar(casillero);
		return true;
	}

	public Unidad obtenerElementoTerrestreEnPosicion(Coordenada coordenada) {

		Casilla casillero = tablero.get(coordenada);
		return casillero.getOcupanteTerrestre();
	}

	public void setCoordenadaMineralYVolcanDeGas(){
		CoordenadaRecurso coordenadaRecurso = new CoordenadaRecurso(minFila,minColumna,maxFila,maxColumna);
		while (coordenadaRecurso.tieneCoordenadaMineral()){
			MinaDeMinerales mina = new MinaDeMinerales(1000);
			Coordenada coordenadaDeMina = coordenadaRecurso.sacarCoordenadaDeMineral();
			Casilla casilla = tablero.get(coordenadaDeMina);
			casilla.agregarRecurso(mina);
		}
		while (coordenadaRecurso.tieneCoordenadaGas()){
			VolcanDeGasVespeno volcan = new VolcanDeGasVespeno(1000);
			Coordenada coordenadaDeGas = coordenadaRecurso.sacarCoordenadaDeGas();
			Casilla casilla = tablero.get(coordenadaDeGas);
			casilla.agregarRecurso(volcan);
		}
	}

	public Casilla getCasilla(Coordenada coordenada) throws CoordenadaInvalidaError {
		this.validarCoordenada(coordenada);
		return tablero.get(coordenada);
	}
}
