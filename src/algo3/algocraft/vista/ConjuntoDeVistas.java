package algo3.algocraft.vista;

import java.util.HashMap;

import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.vista.terrestre.VistaDeposito;
import algo3.algocraft.vista.terrestre.VistaGolliat;
import algo3.algocraft.vista.terrestre.VistaMarine;
import algo3.algocraft.vista.terrestre.VistaMinaDeMinerales;
import algo3.algocraft.vista.terrestre.VistaTerrestre;
import algo3.algocraft.vista.terrestre.VistaVolcanDeGas;

@SuppressWarnings("rawtypes")
public class ConjuntoDeVistas {
	
	private HashMap<Class,VistaTerrestre> vistas;
	
	public ConjuntoDeVistas(){
		this.vistas = new HashMap<Class,VistaTerrestre>();
		this.vistas.put(Marine.class, new VistaMarine());
		this.vistas.put(Golliat.class, new VistaGolliat());
		this.vistas.put(MinaDeMinerales.class, new VistaMinaDeMinerales());
		this.vistas.put(VolcanDeGasVespeno.class, new VistaVolcanDeGas());
		this.vistas.put(DepositoDeSuministros.class, new VistaDeposito());
	}
	
	public VistaTerrestre getVista(Class clase){
		return this.vistas.get(clase);
	}

}
