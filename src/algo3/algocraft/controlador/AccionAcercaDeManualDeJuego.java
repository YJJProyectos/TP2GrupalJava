package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaManualDeJuego;

public class AccionAcercaDeManualDeJuego implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new VentanaManualDeJuego();
	}

}
