package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonCrearDepositoDeSuministros implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonCrearDepositoDeSuministros(PanelJuego panelJuego,
			Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		try {
			Casilla casilla = this.panelJuego.getCasillaActual();
			new DepositoDeSuministros(this.juego.turnoDeJugador(), casilla);
		} catch (RecursosInsuficientesError e) {
			String textoError = "<html>Recursos insuficientes <html>";
			new VentanaError(textoError);
		} catch (CasillaOcupadaError e) {
			String textoError = "<html>Casilla ocupada <html>";
			new VentanaError(textoError);
		} catch (Exception e) {
			String textoError = "<html>Casilla sin seleccionar <html>";
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
