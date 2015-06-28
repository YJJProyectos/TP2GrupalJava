package algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelMapa extends JPanel {
	
	public PanelMapa(int fila, int columna){
		super();
		this.setLayout(new GridLayout(fila, columna));
	}
	
	public void setTamanio(int ancho, int alto){
		super.setSize(ancho, alto);
		int porcentajeAncho = ancho - ( (int) (ancho * 0.3) ) ;
		int porcentajeAlto = alto - ( (int) (alto * 0.4));
		this.setPreferredSize(new Dimension(porcentajeAncho, porcentajeAlto));
	}
}
