package algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algo3.algocraft.vista.terrestre.VistaGolliat;
import algo3.algocraft.vista.terrestre.VistaMarine;
import algo3.algocraft.vista.terrestre.VistaMinaDeMineral;
import algo3.algocraft.vista.terrestre.VistaVolcanDeGas;

@SuppressWarnings("serial")
public class VistaTierra extends JPanel {
	
	private boolean yaPusoLaTierra = false;
	private int numero;
	
	public VistaTierra(){
		super();
		//this.setLayout(null);
		this.setLayout(new BorderLayout());
		// todo lo de abajo es para meter las vistas aleatorias
		int numero = (int) Math.round(Math.random()*3);
		JLabel labelTerrestre = null;
		switch (numero){
		 case 0: labelTerrestre = new VistaMarine(); this.add(labelTerrestre,BorderLayout.WEST);  break;
		 case 1: labelTerrestre = new VistaGolliat(); this.add(labelTerrestre,BorderLayout.WEST); break;
		 case 2: labelTerrestre = new VistaMinaDeMineral(); this.add(labelTerrestre,BorderLayout.WEST); break;
		 case 3: labelTerrestre = new VistaVolcanDeGas(); this.add(labelTerrestre,BorderLayout.WEST); break;
		 default: break;
		}
		numero = (int) Math.round(Math.random());
		JLabel labelAereo = null;
		if (numero == 0) {
			labelAereo = new VistaNave();
			this.add(labelAereo, BorderLayout.NORTH);
		}
	}
	
    public void paintComponent(Graphics grafico) {

       // super.paintComponent(grafico);
        Dimension dimension = getSize();
        if ( ! this.yaPusoLaTierra ) {
        	this.numero = (int) Math.round(Math.random()*4);
        }
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
        this.yaPusoLaTierra = true;
    }
}
