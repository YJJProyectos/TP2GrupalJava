package algo3.algocraft.vista.vistas.terrestre.edificios;

import algo3.algocraft.controlador.MouseTocarPuertoEstelar;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

@SuppressWarnings("serial")
public class VistaPuertoEstelar extends Vistas {

	public VistaPuertoEstelar(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/PuertoEstelar.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarPuertoEstelar(this.casilla,
				this.panelJuego, this));
	}

}
