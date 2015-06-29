package algo3.algocraft.vista.vistas.terrestre.recurso;

import algo3.algocraft.controlador.MouseTocarRecurso;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.terrestre.VistaTerrestre;


@SuppressWarnings("serial")
public class VistaVolcanDeGas extends VistaTerrestre {

	public VistaVolcanDeGas(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/Volcan.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarRecurso(casilla, panelJuego, this));
	}

}
