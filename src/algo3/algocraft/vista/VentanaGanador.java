package algo3.algocraft.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import algo3.algocraft.modelo.juego.Jugador;

@SuppressWarnings("serial")
public class VentanaGanador extends JFrame {

	public VentanaGanador(Jugador ganador) {

		JOptionPane.showMessageDialog(this, ganador.getNombre() + "ha ganado!",
				"Ganador", JOptionPane.INFORMATION_MESSAGE, null);
		System.exit(0);
	}
}

// Object[] opciones = { "Continuar", "Salir" };

// int n = JOptionPane.showOptionDialog(this, ganador.getNombre()
// + "ha ganado!", "Ganador", JOptionPane.YES_NO_OPTION,
// JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

// if (n == JOptionPane.YES_OPTION) {
// try {
// ventanaInicio.muestraPanelJuego();
// } catch (NombresInvalidosError | CoordenadaInvalidaError error) {
// String textoError = "<html>Nombres Invalidos <html>";
// new VentanaError(textoError);
// }
// } else if (n == JOptionPane.NO_OPTION) {
// System.exit(0);
// }
// }
