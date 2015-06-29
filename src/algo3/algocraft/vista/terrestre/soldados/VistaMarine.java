package algo3.algocraft.vista.terrestre.soldados;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.terrestre.VistaTerrestre;

@SuppressWarnings("serial")
public class VistaMarine extends VistaTerrestre {

	public VistaMarine(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/marine.png";
		this.setImagen(url);
	}

}
