package algo3.algocraft.vista;

import java.util.HashMap;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.vista.terrestre.VistaTerrestre;
import algo3.algocraft.vista.terrestre.edificios.VistaDeposito;
import algo3.algocraft.vista.terrestre.recurso.VistaMinaDeMinerales;
import algo3.algocraft.vista.terrestre.recurso.VistaVolcanDeGas;
import algo3.algocraft.vista.terrestre.soldados.VistaGolliat;
import algo3.algocraft.vista.terrestre.soldados.VistaMarine;

@SuppressWarnings("rawtypes")
public class ConjuntoDeVistas {
	
	private HashMap<Class,VistaTerrestre> vistas;
	
	public ConjuntoDeVistas(Casilla casilla, PanelJuego panelJuego){
		this.vistas = new HashMap<Class,VistaTerrestre>();
		this.vistas.put(Marine.class, new VistaMarine(casilla,panelJuego));
		this.vistas.put(Golliat.class, new VistaGolliat(casilla,panelJuego));
		this.vistas.put(MinaDeMinerales.class, new VistaMinaDeMinerales(casilla,panelJuego));
		this.vistas.put(VolcanDeGasVespeno.class, new VistaVolcanDeGas(casilla,panelJuego));
		this.vistas.put(DepositoDeSuministros.class, new VistaDeposito(casilla,panelJuego));
	}
	
	public VistaTerrestre getVista(Class clase){
		return this.vistas.get(clase);
	}

}
