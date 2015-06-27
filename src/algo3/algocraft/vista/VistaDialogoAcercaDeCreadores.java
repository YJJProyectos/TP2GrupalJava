package algo3.algocraft.vista;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VistaDialogoAcercaDeCreadores extends JDialog {
	private static final long serialVersionUID = 1L;

	public VistaDialogoAcercaDeCreadores(JFrame owner) {
		super(owner, "Creadores", true);
		add(new JLabel(
				"<html>Alumnos:<br>- Gandolfo, SantiagoVladimir<br>- Yang, Jia Jun<br>- von Brudersdorff, Federico<html>",
				SwingConstants.CENTER));
		this.setLocationRelativeTo(null);
		this.setSize(300, 100);
	}
}
