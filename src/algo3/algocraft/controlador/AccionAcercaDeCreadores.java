package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.VentanaAcercaDeCreadores;

public class AccionAcercaDeCreadores implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		new VentanaAcercaDeCreadores();

	}

}
