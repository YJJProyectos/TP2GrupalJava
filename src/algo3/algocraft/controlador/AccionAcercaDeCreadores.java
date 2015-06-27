package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import algo3.algocraft.vista.VistaDialogoAcercaDeCreadores;

public class AccionAcercaDeCreadores implements ActionListener {

	private VistaDialogoAcercaDeCreadores informacion;

	public AccionAcercaDeCreadores(JFrame marco) {
		this.informacion = new VistaDialogoAcercaDeCreadores(marco);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.informacion.setVisible(true);
	}

}
