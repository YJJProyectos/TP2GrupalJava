package algo3.algocraft.controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class MouseTocarAereo implements MouseListener {

	private JLabel vistaAerea;

	public MouseTocarAereo(JLabel vistaNave) {
		this.vistaAerea = vistaNave;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("aereo");
		if (this.vistaAerea.getBorder() == null) {
			this.vistaAerea.setBorder(BorderFactory
					.createLineBorder(Color.green));
		} else {
			this.vistaAerea.setBorder(null);
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
