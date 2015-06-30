package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaInicio;

public class AccionEmpezar implements ActionListener {

	private VentanaInicio ventanaJFrame;

	public AccionEmpezar(VentanaInicio ventanaJFrame) {
		this.ventanaJFrame = ventanaJFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.ventanaJFrame.cambiarPanelCargaDatos();
	}

}
