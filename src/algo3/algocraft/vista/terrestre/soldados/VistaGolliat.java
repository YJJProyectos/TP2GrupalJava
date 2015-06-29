package algo3.algocraft.vista.terrestre.soldados;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.terrestre.VistaTerrestre;

@SuppressWarnings("serial")
public class VistaGolliat extends VistaTerrestre {

	public VistaGolliat(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/golliat.png";
		this.setImagen(url);
		//this.addMouseListener(l);
	}

}
