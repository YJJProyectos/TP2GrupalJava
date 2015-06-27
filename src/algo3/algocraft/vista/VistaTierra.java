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
	
	public VistaTierra(){
		super();
		//this.setLayout(null);
		this.setLayout(new BorderLayout());
		// todo lo de abajo es para meter las vistas aleatorias
		int numero = (int) Math.round(Math.random()*5);
		JLabel label = null;
		switch (numero){
		 case 0: label = new VistaMarine(); this.add(label,BorderLayout.SOUTH);  break;
		 case 1: label = new VistaGolliat(); this.add(label,BorderLayout.SOUTH); break;
		 case 2: label = new VistaMinaDeMineral(); this.add(label,BorderLayout.SOUTH); break;
		 case 3: label = new VistaVolcanDeGas(); this.add(label,BorderLayout.SOUTH); break;
		 default: break;
		}
		/*
		ImageIcon imagenAdentro = new ImageIcon(getClass().getResource("/algo3/algocraft/imagenes/nave.png"));
		Image imagen = imagenAdentro.getImage();
		ImageIcon imagenEscalada = new ImageIcon(imagen.getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		JLabel label2 = new JLabel();
		label2.setSize(15, 15);
		label2.setIcon(imagenEscalada);
		this.add(label2, BorderLayout.NORTH);  */
	}
	
    public void paintComponent(Graphics grafico) {

       // super.paintComponent(grafico);
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
