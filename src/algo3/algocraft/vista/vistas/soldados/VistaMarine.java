package algo3.algocraft.vista.vistas.soldados;

import algo3.algocraft.controlador.MouseTocarUnidadSoldado;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

@SuppressWarnings("serial")
public class VistaMarine extends Vistas {

	public VistaMarine(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/marine.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarUnidadSoldado(casilla, panelJuego,
				this));
	}

}
