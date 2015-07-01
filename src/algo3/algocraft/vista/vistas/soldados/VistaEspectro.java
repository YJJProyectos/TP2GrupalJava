package algo3.algocraft.vista.vistas.soldados;

import java.awt.Image;

import javax.swing.ImageIcon;

import algo3.algocraft.controlador.MouseTocarAereoSoldado;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

@SuppressWarnings("serial")
public class VistaEspectro extends Vistas {

	public VistaEspectro(Casilla casilla, PanelJuego panelJuego) {
		super(casilla, panelJuego);
		String url = "/algo3/algocraft/imagenes/Espectro.png";
		this.setImagen(url);
		this.addMouseListener(new MouseTocarAereoSoldado(casilla, panelJuego,
				this));
	}

	@Override
	public void setImagen(String url) {
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		Image imagen = imagenAdentro.getImage();
		ImageIcon imagenEscalada = new ImageIcon(imagen.getScaledInstance(20,
				20, Image.SCALE_SMOOTH));
		this.setSize(20, 20);
		this.setIcon(imagenEscalada);
	}

}
