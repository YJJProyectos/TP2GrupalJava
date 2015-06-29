package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.vista.PanelJuego;

public class AccionBotonPasarTurno implements ActionListener {

	private PanelJuego panelJuego;

	public AccionBotonPasarTurno(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.panelJuego.pasarTurno();
	}

}
