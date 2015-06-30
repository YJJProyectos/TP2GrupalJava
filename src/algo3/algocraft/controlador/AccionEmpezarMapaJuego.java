package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.NombresInvalidosError;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;
import algo3.algocraft.vista.VentanaError;
import algo3.algocraft.vista.VentanaInicio;

public class AccionEmpezarMapaJuego implements ActionListener {

	private VentanaInicio ventanaJFrame;

	public AccionEmpezarMapaJuego(VentanaInicio ventanaJFrame) {
		this.ventanaJFrame = ventanaJFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.ventanaJFrame.muestraPanelJuego();
		} catch (NombresInvalidosError | CoordenadaInvalidaError error) {
			// aca deberia lanzar una ventana diciendo error
			String textoError = "<html>Nombres Invalidos <html>";
			new VentanaError(textoError);
		}
	}

}
