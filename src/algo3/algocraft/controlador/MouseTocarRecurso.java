package algo3.algocraft.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

public class MouseTocarRecurso implements MouseListener {
	
	private Casilla casilla;
	private PanelJuego panelJuego;
	private Vistas vista;

	public MouseTocarRecurso(Casilla casilla, PanelJuego panelJuego,
			Vistas vista) {
		this.casilla = casilla;
		this.panelJuego = panelJuego;
		this.vista = vista;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("recurso");
		this.panelJuego.setCasillaActual(this.casilla);
		this.panelJuego.sacarBordes();
		this.vista.setBorder(BorderFactory
				.createLineBorder(Color.orange));
		this.panelJuego.setSinInformacionAdicional();
		this.panelJuego.setRecurso(this.casilla.getRecurso());

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
