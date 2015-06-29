package algo3.algocraft.vista.vistas.aerea;

import algo3.algocraft.controlador.MouseTocarAereo;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;

@SuppressWarnings("serial")
public class VistaTransporteTerran extends VistaAerea {

	public VistaTransporteTerran(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/nave.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarAereo(casilla, panelJuego, this));
	}
}
