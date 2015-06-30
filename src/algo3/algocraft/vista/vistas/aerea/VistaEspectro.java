package algo3.algocraft.vista.vistas.aerea;

import algo3.algocraft.controlador.MouseTocarAereoSoldado;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;


@SuppressWarnings("serial")
public class VistaEspectro extends VistaAerea {

	public VistaEspectro(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/Espectro.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarAereoSoldado(casilla, panelJuego, this));
	}


}
