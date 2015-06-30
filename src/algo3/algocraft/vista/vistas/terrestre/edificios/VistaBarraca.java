package algo3.algocraft.vista.vistas.terrestre.edificios;

import algo3.algocraft.controlador.MouseTocarBarraca;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.terrestre.VistaTerrestre;

@SuppressWarnings("serial")
public class VistaBarraca extends VistaTerrestre {

	public VistaBarraca(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/Barraca.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarBarraca(this.casilla,
				this.panelJuego, this));
	}

}
