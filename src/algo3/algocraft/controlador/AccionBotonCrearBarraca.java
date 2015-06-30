package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonCrearBarraca implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonCrearBarraca(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		Casilla casilla = this.panelJuego.getCasillaActual();

		try {
			new Barraca(this.juego.turnoDeJugador(), casilla);
		} catch (RecursosInsuficientesError e) {
			JLabel textoError = new JLabel(
					"<html>Recursos insuficientes <html>",
					SwingConstants.CENTER);
			new VentanaError(textoError);
		} catch (CasillaOcupadaError e) {
			JLabel textoError = new JLabel("<html>Casilla ccupada <html>",
					SwingConstants.CENTER);
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
