package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaJFrame;

public class AccionResolucion implements ActionListener {

	private VentanaJFrame frame;
	private int ancho;
	private int alto;

	public AccionResolucion(VentanaJFrame frameImagen, int ancho, int alto) {
		this.frame = frameImagen;
		this.ancho = ancho;
		this.alto = alto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setDimension(ancho, alto);
	}

}