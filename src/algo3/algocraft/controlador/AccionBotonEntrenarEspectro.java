package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PuertoEstelar;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonEntrenarEspectro implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonEntrenarEspectro(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		Casilla casilla = this.panelJuego.getCasillaActual();
		PuertoEstelar puerto = (PuertoEstelar) casilla.getOcupanteTerrestre();

		try {
			puerto.entrenarEspectro(juego.turnoDeJugador());
		} catch (JugadorIncorrectoError e) {
			String textoError = "<html>Recolector invalido <html>";
			new VentanaError(textoError);
		} catch (RecursosInsuficientesError e) {
			String textoError = "<html>Recursos insuficientes <html>";
			new VentanaError(textoError);
		} catch (PoblacionLimiteAlcanzadaError e) {
			String textoError = "<html>Poblacion limite alcanzada <html>";
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
