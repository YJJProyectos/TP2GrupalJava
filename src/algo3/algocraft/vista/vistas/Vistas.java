package algo3.algocraft.vista.vistas;

import javax.swing.JLabel;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;

@SuppressWarnings("serial")
public abstract class Vistas extends JLabel{
	
	protected Casilla casilla;
	protected PanelJuego panelJuego;
	
	
	public Vistas(Casilla casilla, PanelJuego panelJuego) {
		this.casilla = casilla;
		this.panelJuego = panelJuego;
	}
	
	public abstract void setImagen(String url);

}
