package algo3.algocraft.controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;

public class MouseTocarCasillaVacia implements MouseListener {
	
	private Casilla casilla;
	
	private PanelJuego panelJuego;

	public MouseTocarCasillaVacia(Casilla casilla, PanelJuego panelJuego) {
		this.casilla = casilla;
		this.panelJuego = panelJuego;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.panelJuego.setCasillaActual(this.casilla);
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
