package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel {
	
	public PanelInformacion(){
		super();
		this.setLayout(null);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = this.getSize();
		String url = "/algo3/algocraft/imagenes/fondoInformacion.jpg";
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		ImageIcon imagen = new ImageIcon(imagenAdentro.getImage());
		g.drawImage(imagen.getImage(), 0, 0, (int)tam.getWidth(), (int)tam.getHeight(), null);
		this.setOpaque(false);
	}
	
	@Override
	public void setSize(int ancho , int alto){
		super.setSize(ancho, alto);
		int porcentajeAncho = ancho - ( (int) ( ancho * 0.7 ) );
		int porcentajeAlto = alto - ( (int) ( alto * 0.6));
		this.setPreferredSize(new Dimension(porcentajeAncho , porcentajeAlto));
	}
}
