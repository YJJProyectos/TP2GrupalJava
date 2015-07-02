package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.SonidoFondo;

public class AccionSonidoFondo implements ActionListener {
	
	private SonidoFondo sonidoFondo;

	public AccionSonidoFondo(SonidoFondo sonidoFondo) {
		this.sonidoFondo = sonidoFondo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if ( this.sonidoFondo.estaActivo() ){
			this.sonidoFondo.detener();
		} else {
			this.sonidoFondo.reproducir();
		}
	}

}
