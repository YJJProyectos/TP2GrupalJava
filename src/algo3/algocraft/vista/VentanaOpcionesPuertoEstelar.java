package algo3.algocraft.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PuertoEstelar;

@SuppressWarnings("serial")
public class VentanaOpcionesPuertoEstelar extends JFrame {

	JLabel informacion;
	JPanel panel = new JPanel();
	JButton botonAceptar = new JButton("Aceptar");

	public VentanaOpcionesPuertoEstelar(PuertoEstelar puerto, Juego juego) {
		setTitle("Barraca");
		setVisible(true);
		this.setSize(150, 150);

		Object stringArray[] = { "Aceptar", "Cancelar" };
		int opcion = JOptionPane
				.showOptionDialog(this, "Entrenar Golliat?",
						"Seleccione una Opcion", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, stringArray,
						stringArray[0]);

		// Hay que modificar para que cree una ventanaError
		if (opcion == JOptionPane.YES_OPTION) {
			try {
				puerto.entrenarEspectro(juego.turnoDeJugador());
			} catch (JugadorIncorrectoError | RecursosInsuficientesError
					| PoblacionLimiteAlcanzadaError e) {
				e.printStackTrace();
			}
		}
		add(panel);

	}

}
