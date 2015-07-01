package algo3.algocraft.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.UnidadEdificio;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.vistas.Vistas;

public class MouseTocarBarraca implements MouseListener {

	private Casilla casilla;
	private PanelJuego panelJuego;
	private Vistas vista;

	public MouseTocarBarraca(Casilla casilla, PanelJuego panelJuego,
			Vistas vista) {
		this.casilla = casilla;
		this.panelJuego = panelJuego;
		this.vista = vista;
	}

	@Override
	public void mouseClicked(MouseEvent click) {
		if (click.getButton() == MouseEvent.BUTTON1) {
			this.panelJuego.setCasillaActual(this.casilla);
			this.panelJuego.getPanelBotones().visibilidadCasillasEspeciales(
					false);
			this.panelJuego.sacarBordes();
			this.vista.setBorder(BorderFactory.createLineBorder(Color.blue));
			this.panelJuego.setSinInformacionAdicional();
			this.panelJuego
					.vistaInformacionEdificio((UnidadEdificio) this.casilla
							.getOcupanteTerrestre());
			this.panelJuego.setUnidadIzquierdo(this.casilla
					.getOcupanteTerrestre());
			Barraca barraca = (Barraca) this.casilla.getOcupanteTerrestre();
			if (!barraca.enConstruccion()) {
				this.panelJuego.getPanelBotones()
						.visibilidadBotonEntrenarMarine(true);
				if (barraca.unidadEnConstruccion()) {
					int turnosFaltantes = barraca.tiempoFaltanteEntrenarMarine();
					String datos = "Marine a crear(" + turnosFaltantes
							+ "turnos)";
					this.panelJuego.setInformacionUnidadEnEntrenamiento(datos);
				}
			}
		} else if (click.getButton() == MouseEvent.BUTTON3) {
			this.panelJuego.setCasillaDestino(this.casilla);
			this.panelJuego.setUnidadDerecho(this.casilla
					.getOcupanteTerrestre());
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
