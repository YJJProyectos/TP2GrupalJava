package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Barraca;
import algo3.algocraft.modelo.unidades.unidadesEdificios.BarracaNoConstruidaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonCrearFabrica implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonCrearFabrica(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		Barraca barraca = (Barraca) this.panelJuego.getUnidad();
		Casilla casilla = this.panelJuego.getCasillaActual();

		try {
			new Fabrica(this.juego.turnoDeJugador(), casilla, barraca);
		} catch (PerteneceAOtroJugadorError e) {
			JLabel textoError = new JLabel(
					"<html>La Barraca pertenede a otro Jugador <html>",
					SwingConstants.CENTER);
			new VentanaError(textoError);
		} catch (RecursosInsuficientesError e) {
			JLabel textoError = new JLabel(
					"<html>Recursos insuficientes <html>",
					SwingConstants.CENTER);
			new VentanaError(textoError);
		} catch (BarracaNoConstruidaError e) {
			JLabel textoError = new JLabel(
					"<html>Barraca no construida <html>", SwingConstants.CENTER);
			new VentanaError(textoError);
		} catch (CasillaOcupadaError e) {
			JLabel textoError = new JLabel("<html>Casilla ocupada <html>",
					SwingConstants.CENTER);
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
