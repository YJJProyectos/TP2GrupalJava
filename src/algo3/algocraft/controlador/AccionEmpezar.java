package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaJFrame;

public class AccionEmpezar implements ActionListener {
	
	private VentanaJFrame ventanaJFrame;
	
	public AccionEmpezar(VentanaJFrame ventanaJFrame) {
		this.ventanaJFrame = ventanaJFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.ventanaJFrame.cambiarPanel();
		System.out.println("lala");
	}

}
