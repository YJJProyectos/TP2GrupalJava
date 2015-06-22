package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaJFrame;

public class AccionEmpezarMapaJuego implements ActionListener {
	
	private VentanaJFrame ventanaJFrame;

	public AccionEmpezarMapaJuego(VentanaJFrame ventanaJFrame) {
		this.ventanaJFrame = ventanaJFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ventanaJFrame.muestraPanelJuego();
	}

}
