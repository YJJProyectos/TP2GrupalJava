package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaInicio;

public class AccionReiniciar implements ActionListener {

	private VentanaInicio ventanaInicio;

	public AccionReiniciar(VentanaInicio ventanaInicio) {
		this.ventanaInicio = ventanaInicio;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.ventanaInicio.reiniciar();
	}

}
