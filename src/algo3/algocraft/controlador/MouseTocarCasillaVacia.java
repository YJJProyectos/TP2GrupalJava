package algo3.algocraft.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VistaCasilla;

public class MouseTocarCasillaVacia implements MouseListener {

	private Casilla casilla;

	private PanelJuego panelJuego;
	private VistaCasilla vistaCasilla;

	public MouseTocarCasillaVacia(Casilla casilla, PanelJuego panelJuego,
			VistaCasilla vistaCasilla) {
		this.casilla = casilla;
		this.panelJuego = panelJuego;
		this.vistaCasilla = vistaCasilla;
	}

	@Override
	public void mouseClicked(MouseEvent click) {
		if (click.getButton() == MouseEvent.BUTTON1) {
			this.panelJuego.getPanelBotones().visibilidadCasillasEspeciales(
					false);
			this.panelJuego.setCasillaActual(this.casilla);
			this.panelJuego.setSinInformacionAdicional();
			this.panelJuego.sacarBordes();
			this.vistaCasilla.setBorder(BorderFactory
					.createLineBorder(Color.red));
		} else if (click.getButton() == MouseEvent.BUTTON3) {
			this.panelJuego.setCasillaDestino(this.casilla);
			AccionesSoldado.mover(panelJuego);
		}
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
