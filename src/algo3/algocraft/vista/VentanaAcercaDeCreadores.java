package algo3.algocraft.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class VentanaAcercaDeCreadores extends JFrame {

	public VentanaAcercaDeCreadores() {
		JOptionPane
				.showMessageDialog(
						null,
						"<html>          FIUBA <br>"
								+ " Algoritmos y Programacion 3<br>"
								+ " Primer Cuatrimestre 2015<br>"
								+ " Alumnos:<br>"
								+ "- Gandolfo, SantiagoVladimir<br>- Yang, Jia Jun<br>"
								+ "- von Brudersdorff, Federico <html>",
						"Creadores", JOptionPane.INFORMATION_MESSAGE);

	}
}
