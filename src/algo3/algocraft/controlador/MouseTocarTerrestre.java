package algo3.algocraft.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.mapa.Mapa;

public class MouseTocarTerrestre implements MouseListener {

	private JLabel vistaTerrestre;

	public MouseTocarTerrestre(JLabel vistaTerrestre) {
		this.vistaTerrestre = vistaTerrestre;
	}

	public MouseTocarTerrestre(JLabel vistaTerrestre, Coordenada coordenada,
			Mapa mapa) {
		this.vistaTerrestre = vistaTerrestre;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("terrestre");
		if (this.vistaTerrestre.getBorder() == null) {
			this.vistaTerrestre.setBorder(BorderFactory
					.createLineBorder(Color.blue));
		} else {
			this.vistaTerrestre.setBorder(null);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
