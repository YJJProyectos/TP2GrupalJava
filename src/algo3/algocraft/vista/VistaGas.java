package algo3.algocraft.vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class VistaGas extends JLabel{
	
	public VistaGas(){
		super();
		String url = "/algo3/algocraft/imagenes/Gas.png";
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		Image imagen = imagenAdentro.getImage();
		ImageIcon imagenEscalada = new ImageIcon(imagen.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		this.setSize(20,20);
		this.setIcon(imagenEscalada);
	}

}