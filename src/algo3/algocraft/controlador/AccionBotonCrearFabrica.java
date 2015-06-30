package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			String textoError = "<html>La Barraca pertenede a otro Jugador <html>";
			new VentanaError(textoError);
		} catch (RecursosInsuficientesError e) {
			String textoError = "<html>Recursos insuficientes <html>";
			new VentanaError(textoError);
		} catch (BarracaNoConstruidaError e) {
			String textoError = "<html>Barraca no construida <html>";
			new VentanaError(textoError);
		} catch (CasillaOcupadaError e) {
			String textoError = "<html>Casilla ocupada <html>";
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
