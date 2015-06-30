package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.NombresInvalidosError;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;
import algo3.algocraft.vista.VentanaError;
import algo3.algocraft.vista.VentanaInicio;

public class AccionEmpezarMapaJuego implements ActionListener {

	private VentanaInicio ventanaInicio;

	public AccionEmpezarMapaJuego(VentanaInicio ventanaInicio) {
		this.ventanaInicio = ventanaInicio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.ventanaInicio.muestraPanelJuego();
		} catch (NombresInvalidosError | CoordenadaInvalidaError error) {
			String textoError = "<html>Nombres Invalidos <html>";
			new VentanaError(textoError);
		}
	}

}
