package algo3.algocraft.vista.vistas.terrestre.soldados;

import algo3.algocraft.controlador.MouseTocarUnidadSoldado;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.terrestre.VistaTerrestre;

@SuppressWarnings("serial")
public class VistaMarine extends VistaTerrestre {

	public VistaMarine(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/marine.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarUnidadSoldado(casilla, panelJuego, this));
	}

}
