package algo3.algocraft.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import algo3.algocraft.modelo.juego.Jugador;

@SuppressWarnings("serial")
public class VentanaGanador extends JFrame {

	public VentanaGanador(Jugador ganador) {

		JOptionPane.showMessageDialog(this, ganador.getNombre() + " ha ganado!",
				"Ganador", JOptionPane.INFORMATION_MESSAGE, null);
		System.exit(0);
	}
}

