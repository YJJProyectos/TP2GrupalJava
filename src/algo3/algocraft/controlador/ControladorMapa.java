package algo3.algocraft.controlador;

import algo3.algocraft.modelo.mapa.Mapa;
//import algo3.algocraft.vista.VistaMapa;

public class ControladorMapa {

	private Mapa mapa;
	//private VistaMapa vista;
	
	public ControladorMapa() {
		mapa = new Mapa(5);
		//vista = new VistaMapa(this);
	}
	
	public int largo() {
		return mapa.largo();
	}
	
}
