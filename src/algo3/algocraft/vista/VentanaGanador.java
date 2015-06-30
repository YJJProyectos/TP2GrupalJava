package algo3.algocraft.vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.juego.NombresInvalidosError;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;

@SuppressWarnings("serial")
public class VentanaGanador extends JFrame {

	public VentanaGanador(Jugador ganador, VentanaInicio ventanaInicio) {
		Object[] opciones = { "Continuar", "Salir" };

		int n = JOptionPane.showOptionDialog(this, ganador.getNombre()
				+ "ha ganado!", "Ganador", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

		if (n == JOptionPane.YES_OPTION) {
			try {
				ventanaInicio.muestraPanelJuego();
			} catch (NombresInvalidosError | CoordenadaInvalidaError error) {
				String textoError = "<html>Nombres Invalidos <html>";
				new VentanaError(textoError);
			}
		} else if (n == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
	}
}