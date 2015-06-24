package algo3.algocraft.vista;

import algo3.algocraft.controlador.ControladorMapa;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Color;

@SuppressWarnings("serial")
public class VistaMapa extends JPanel {
	//private ControladorMapa control;
	private final Panel grilla = new Panel();
		
	public VistaMapa(ControladorMapa control){
		//this.control = control;
		setLayout(new GridLayout(1, 0, 2, 2));
		grilla.setBackground(Color.WHITE);
		grilla.setForeground(Color.CYAN);
		add(grilla);
		for(int i = 0; i<control.largo(); i++){
			grilla.add(new VistaTierra());
		}
		
	}
	
}
