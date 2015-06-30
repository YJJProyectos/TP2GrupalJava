package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonCrearRefineria implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonCrearRefineria(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		Casilla casilla = this.panelJuego.getCasillaActual();

		Recurso recurso = casilla.getRecurso();
		try {
			new Refineria(recurso, this.juego.turnoDeJugador());
		} catch (RecursosInsuficientesError e) {
			JLabel textoError = new JLabel(
					"<html>Recursos insuficientes <html>",
					SwingConstants.CENTER);
			new VentanaError(textoError);
		} catch (RecolectorInvalidoError e) {
			JLabel textoError = new JLabel("<html>Recolector invalido <html>",
					SwingConstants.CENTER);
			new VentanaError(textoError);
		} catch (CasillaOcupadaError e) {
			JLabel textoError = new JLabel("<html>Casilla ocupada <html>",
					SwingConstants.CENTER);
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
