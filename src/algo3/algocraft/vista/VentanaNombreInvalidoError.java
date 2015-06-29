package algo3.algocraft.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VentanaNombreInvalidoError extends JFrame {

	JLabel informacion;
	JPanel panel = new JPanel();
	JButton botonAceptar = new JButton("Aceptar");

	public VentanaNombreInvalidoError() {
		setTitle("Error");
		setVisible(true);
		this.setSize(250, 100);
		this.setLocationRelativeTo(null);

		informacion = new JLabel("<html>Nombres Invalidos <html>",
				SwingConstants.CENTER);

		panel.add(informacion);

		botonAceptar.addActionListener(new BotonAceptar());

		panel.add(botonAceptar);

		add(panel);

	}

	private class BotonAceptar implements ActionListener {

		public void actionPerformed(ActionEvent click) {
			setVisible(false);

		}

	}
}