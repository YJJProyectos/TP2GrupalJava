package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonMover implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonMover(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		try {
			UnidadSoldado unidad = (UnidadSoldado) this.panelJuego
					.getUnidadIzquierdo();
			Casilla casilla = this.panelJuego.getCasillaDestino();
			unidad.mover(casilla, this.juego.turnoDeJugador());
		} catch (CasillaOcupadaError e) {
			String textoError = "<html>Casilla ocupada <html>";
			new VentanaError(textoError);
		} catch (JugadorIncorrectoError e) {
			String textoError = "<html>La unidad pertenece a otro jugador <html>";
			new VentanaError(textoError);
		} catch (Exception e) {
			String textoError = "<html>Casilla sin seleccionar <html>";
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
