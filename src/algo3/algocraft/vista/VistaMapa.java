package algo3.algocraft.vista;

import algo3.algocraft.controlador.ControladorMapa;

import javax.swing.JFrame;
import java.awt.Canvas;

@SuppressWarnings("serial")
public class VistaMapa extends JFrame {
		
	VistaTierra[][] grilla;
	
	public VistaMapa(ControladorMapa control){
		Canvas canvas = new Canvas();
		add(canvas);
	}
	
}
