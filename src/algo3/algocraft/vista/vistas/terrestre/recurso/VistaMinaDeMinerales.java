package algo3.algocraft.vista.vistas.terrestre.recurso;

import algo3.algocraft.controlador.mouseRecurso.MouseTocarMinaDeMineral;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

@SuppressWarnings("serial")
public class VistaMinaDeMinerales extends Vistas {

	public VistaMinaDeMinerales(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/MinaMineral.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarMinaDeMineral(casilla, panelJuego, this));
	}

}
