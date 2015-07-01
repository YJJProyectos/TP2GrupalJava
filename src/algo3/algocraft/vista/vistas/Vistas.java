package algo3.algocraft.vista.vistas;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;

@SuppressWarnings("serial")
public abstract class Vistas extends JLabel {

	protected Casilla casilla;
	protected PanelJuego panelJuego;

	public Vistas(Casilla casilla, PanelJuego panelJuego) {
		this.casilla = casilla;
		this.panelJuego = panelJuego;
	}

	public void setImagen(String url) {
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		Image imagen = imagenAdentro.getImage();
		ImageIcon imagenEscalada = new ImageIcon(imagen.getScaledInstance(20,
				20, Image.SCALE_SMOOTH));
		this.setSize(20, 20);
		this.setIcon(imagenEscalada);
	}

}
