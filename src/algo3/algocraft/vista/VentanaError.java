package algo3.algocraft.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class VentanaError extends JFrame {

	public VentanaError(String textoError) {
		JOptionPane.showMessageDialog(null, textoError, "Error",
				JOptionPane.ERROR_MESSAGE);

	}

}