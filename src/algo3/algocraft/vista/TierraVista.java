package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TierraVista extends JPanel {
	
	public TierraVista(){
		super();
	}
	
    public void paintComponent(Graphics grafico) {

        super.paintComponent(grafico);
        Dimension dimension = getSize();

        int numero = (int) Math.round(Math.random()*4);
        String url;
        switch (numero) {
        case 0: url = "/algo3/algocraft/imagenes/tierra.jpg"; break;
        case 1: url = "/algo3/algocraft/imagenes/tierra1.jpg"; break;
        case 2: url = "/algo3/algocraft/imagenes/tierra2.jpg"; break;
        default: url = "/algo3/algocraft/imagenes/tierra3.jpg"; break;
        }
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource(url));
		ImageIcon imagen = new ImageIcon(imagenAdentro.getImage());
		grafico.drawImage(imagen.getImage(), 0, 0, (int)dimension.getWidth(), (int)dimension.getHeight(), null);
		this.setOpaque(false); 
    }
}
