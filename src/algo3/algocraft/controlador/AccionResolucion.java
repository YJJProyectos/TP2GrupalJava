package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaInicio;

public class AccionResolucion implements ActionListener {

	private VentanaInicio ventanaInicio;
	private int ancho;
	private int alto;

	public AccionResolucion(VentanaInicio ventanaInicio, int ancho, int alto) {
		this.ventanaInicio = ventanaInicio;
		this.ancho = ancho;
		this.alto = alto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ventanaInicio.setDimension(ancho, alto);
	}

}