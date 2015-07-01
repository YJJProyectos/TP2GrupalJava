package algo3.algocraft.vista;

import java.util.HashMap;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.recursos.MinaDeMinerales;
import algo3.algocraft.modelo.recursos.VolcanDeGasVespeno;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PuertoEstelar;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.CentroDeMineral;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Espectro;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Golliat;
import algo3.algocraft.modelo.unidades.unidadesMoviles.Marine;
import algo3.algocraft.vista.vistas.Vistas;
import algo3.algocraft.vista.vistas.soldados.VistaEspectro;
import algo3.algocraft.vista.vistas.soldados.VistaGolliat;
import algo3.algocraft.vista.vistas.soldados.VistaMarine;
import algo3.algocraft.vista.vistas.terrestre.edificios.VistaBarraca;
import algo3.algocraft.vista.vistas.terrestre.edificios.VistaCentroDeMineral;
import algo3.algocraft.vista.vistas.terrestre.edificios.VistaDeposito;
import algo3.algocraft.vista.vistas.terrestre.edificios.VistaFabrica;
import algo3.algocraft.vista.vistas.terrestre.edificios.VistaPuertoEstelar;
import algo3.algocraft.vista.vistas.terrestre.edificios.VistaRefineria;
import algo3.algocraft.vista.vistas.terrestre.recurso.VistaMinaDeMinerales;
import algo3.algocraft.vista.vistas.terrestre.recurso.VistaVolcanDeGas;

@SuppressWarnings("rawtypes")
public class ConjuntoDeVistas {

	private HashMap<Class, Vistas> vistas;

	public ConjuntoDeVistas(Casilla casilla, PanelJuego panelJuego) {
		this.vistas = new HashMap<Class, Vistas>();
		this.vistas.put(Marine.class, new VistaMarine(casilla, panelJuego));
		this.vistas.put(Golliat.class, new VistaGolliat(casilla, panelJuego));
		this.vistas.put(MinaDeMinerales.class, new VistaMinaDeMinerales(
				casilla, panelJuego));
		this.vistas.put(VolcanDeGasVespeno.class, new VistaVolcanDeGas(casilla,
				panelJuego));
		this.vistas.put(DepositoDeSuministros.class, new VistaDeposito(casilla,
				panelJuego));
		this.vistas.put(Espectro.class, new VistaEspectro(casilla, panelJuego));
		this.vistas.put(Refineria.class,
				new VistaRefineria(casilla, panelJuego));
		this.vistas.put(CentroDeMineral.class, new VistaCentroDeMineral(
				casilla, panelJuego));
		this.vistas.put(PuertoEstelar.class, new VistaPuertoEstelar(casilla,
				panelJuego));
		this.vistas.put(Barraca.class, new VistaBarraca(casilla, panelJuego));
		this.vistas.put(Fabrica.class, new VistaFabrica(casilla, panelJuego));

	}

	public Vistas getVista(Class clase) {
		return this.vistas.get(clase);
	}

}
