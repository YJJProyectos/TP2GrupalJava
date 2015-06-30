package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.PerteneceAOtroJugadorError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.Fabrica;
import algo3.algocraft.modelo.unidades.unidadesEdificios.FabricaNoConstruidaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PuertoEstelar;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonCrearPuertoEstelar implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonCrearPuertoEstelar(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		Fabrica fabrica = (Fabrica) this.panelJuego.getUnidad();
		Casilla casilla = this.panelJuego.getCasillaActual();

		try {
			new PuertoEstelar(this.juego.turnoDeJugador(), casilla, fabrica);
		} catch (PerteneceAOtroJugadorError e) {
			String textoError = "<html>La Fabrica pertenece a otro Jugador <html>";
			new VentanaError(textoError);
		} catch (RecursosInsuficientesError e) {
			String textoError = "<html>Recursos insuficientes <html>";
			new VentanaError(textoError);
		} catch (FabricaNoConstruidaError e) {
			String textoError = "<html>Fabrica no construida <html>";
			new VentanaError(textoError);
		} catch (CasillaOcupadaError e) {
			String textoError = "<html>Casilla ocupada <html>";
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
