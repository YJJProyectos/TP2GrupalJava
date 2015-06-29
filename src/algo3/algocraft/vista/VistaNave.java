package algo3.algocraft.vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import algo3.algocraft.controlador.MouseTocarAereo;

@SuppressWarnings("serial")
public class VistaNave extends JLabel {

	public VistaNave() {
		super();
		String url = "/algo3/algocraft/imagenes/nave.png";
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		Image imagen = imagenAdentro.getImage();
		ImageIcon imagenEscalada = new ImageIcon(imagen.getScaledInstance(15,
				15, Image.SCALE_SMOOTH));
		this.setSize(15, 15);
		this.setIcon(imagenEscalada);
		this.addMouseListener(new MouseTocarAereo(this));
	}
}
