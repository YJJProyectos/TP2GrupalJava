package algo3.algocraft.vista.vistas.terrestre.edificios;

import algo3.algocraft.controlador.MouseTocarFabrica;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

@SuppressWarnings("serial")
public class VistaFabrica extends Vistas {

	public VistaFabrica(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/Fabrica.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarFabrica(this.casilla,
				this.panelJuego, this));
	}

}
