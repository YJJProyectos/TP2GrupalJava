package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaInicio;

public class AccionEmpezar implements ActionListener {

	private VentanaInicio ventanaInicio;

	public AccionEmpezar(VentanaInicio ventanaInicio) {
		this.ventanaInicio = ventanaInicio;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.ventanaInicio.cambiarPanelCargaDatos();
	}

}
