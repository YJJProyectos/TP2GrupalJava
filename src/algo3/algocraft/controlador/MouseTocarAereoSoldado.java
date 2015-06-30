package algo3.algocraft.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

public class MouseTocarAereoSoldado implements MouseListener {

	private Casilla casilla;
	private PanelJuego panelJuego;
	private Vistas vista;

	public MouseTocarAereoSoldado(Casilla casilla, PanelJuego panelJuego, Vistas vista) {
		this.casilla = casilla;
		this.panelJuego = panelJuego;
		this.vista = vista;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("aereo");
		this.panelJuego.setCasillaActual(this.casilla);
		this.panelJuego.sacarBordes();
		this.vista.setBorder(BorderFactory
				.createLineBorder(Color.green));
		this.panelJuego.setSinInformacionAdicional();
		this.panelJuego.setUnidad(this.casilla.getOcupanteAereo());
		this.panelJuego.vistaInformacionSoldado
		((UnidadSoldado)this.casilla.getOcupanteAereo());
		this.panelJuego.getPanelBotones().visibilidadCasillasEspeciales(false);
		this.panelJuego.getPanelBotones().visibilidadBotonesUnidadSoldado(true);
		// aca deberia pasar unidad al panel juego y setear la info
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