package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaInicio;

public class AccionEmpezarMapaJuego implements ActionListener {
	
	private VentanaInicio ventanaJFrame;

	public AccionEmpezarMapaJuego(VentanaInicio ventanaJFrame) {
		this.ventanaJFrame = ventanaJFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ventanaJFrame.muestraPanelJuego();
	}

}
