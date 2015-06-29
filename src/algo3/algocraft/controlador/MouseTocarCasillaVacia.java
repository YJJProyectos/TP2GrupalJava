package algo3.algocraft.controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import algo3.algocraft.vista.PanelJuego;

public class MouseTocarCasillaVacia implements MouseListener {
	
	private PanelJuego panelJuego;

	public MouseTocarCasillaVacia(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.panelJuego.setSinInformacionAdicional();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
