package algo3.algocraft.vista.vistas.terrestre.edificios;

import algo3.algocraft.controlador.MouseTocarEdificio;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.terrestre.VistaTerrestre;

@SuppressWarnings("serial")
public class VistaFabrica extends VistaTerrestre {

	public VistaFabrica(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/Fabrica.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarEdificio(this.casilla,this.panelJuego,this));
	}


}
