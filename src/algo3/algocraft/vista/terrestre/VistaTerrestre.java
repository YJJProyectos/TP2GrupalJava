package algo3.algocraft.vista.terrestre;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import algo3.algocraft.controlador.MouseTocarTerrestre;

@SuppressWarnings("serial")
public class VistaTerrestre extends JLabel{
	
	public VistaTerrestre(){
		super();
	}
	
	public void setImagen(String url){
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		Image imagen = imagenAdentro.getImage();
		ImageIcon imagenEscalada = new ImageIcon(imagen.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		this.setSize(20,20);
		this.setIcon(imagenEscalada);
		this.addMouseListener(new MouseTocarTerrestre(this));
	}

}
