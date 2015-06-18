package algo3.algocraft.modelo.mapa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CoordenadaRecurso {
	
	Collection<Coordenada> coordenadasDeMinerales;
	Collection<Coordenada> coordenadasDeGas;
	private Iterator<Coordenada> iteradorMinerales;
	private Iterator<Coordenada> iteradorGas;
	
	public CoordenadaRecurso(int minFila,int minColumna,int maxFila,int maxColumna){
		
		this.coordenadasDeMinerales = new ArrayList<Coordenada>();
		this.coordenadasDeGas = new ArrayList<Coordenada>();
			
		Coordenada coordenadaMineral = new Coordenada(minFila,minColumna);
		this.coordenadasDeMinerales.add(coordenadaMineral);
		coordenadaMineral = new Coordenada(minFila,maxColumna);
		this.coordenadasDeMinerales.add(coordenadaMineral);
		coordenadaMineral = new Coordenada(maxFila,minColumna);
		this.coordenadasDeMinerales.add(coordenadaMineral);
		coordenadaMineral = new Coordenada(maxFila,maxColumna);
		this.coordenadasDeMinerales.add(coordenadaMineral);
			
		this.iteradorMinerales = this.coordenadasDeMinerales.iterator();
		
		Coordenada coordenadaGas = new Coordenada(minFila, minColumna + 1);
		this.coordenadasDeGas.add(coordenadaGas);
		coordenadaGas = new Coordenada(minFila, maxColumna - 1);
		this.coordenadasDeGas.add(coordenadaGas);
		coordenadaGas = new Coordenada(maxFila, minColumna + 1);
		this.coordenadasDeGas.add(coordenadaGas);
		coordenadaGas = new Coordenada(maxFila, maxColumna - 1);
		this.coordenadasDeGas.add(coordenadaGas);
		
		this.iteradorGas = this.coordenadasDeGas.iterator();
		
	}

	public int cantidadDeCoordenadasMinerales() {
		return this.coordenadasDeMinerales.size();
	}
	
	public int cantidadDeCoordenadasDeGas(){
		return this.coordenadasDeGas.size();
	}

	public Coordenada sacarCoordenadaDeMineral() {
		
		Coordenada coordenadaMineral = null ;
		if ( this.iteradorMinerales.hasNext()){
			coordenadaMineral = this.iteradorMinerales.next();
		}
		return coordenadaMineral;
	}

	public Coordenada sacarCoordenadaDeGas() {
		
		Coordenada coordenadaGas = null;
		if ( this.iteradorGas.hasNext()){
			coordenadaGas = this.iteradorGas.next();
		}
		return coordenadaGas;
	}

}
