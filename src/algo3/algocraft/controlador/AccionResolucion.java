package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaInicio;

public class AccionResolucion implements ActionListener {

	private VentanaInicio frame;
	private int ancho;
	private int alto;

	public AccionResolucion(VentanaInicio frameImagen, int ancho, int alto) {
		this.frame = frameImagen;
		this.ancho = ancho;
		this.alto = alto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setDimension(ancho, alto);
	}

}