package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.NoHaySoldadosParaPosicionarError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonPosicionarSoldado implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonPosicionarSoldado(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		Casilla casilla = this.panelJuego.getCasillaActual();

		try {
			juego.turnoDeJugador().posicionarSoldadoEnColaDeEspera(casilla);
		} catch (CasillaOcupadaError e) {
			String textoError = "<html>Casilla ocupada <html>";
			new VentanaError(textoError);
		} catch (NoHaySoldadosParaPosicionarError e) {
			String textoError = "<html>No hay soldados para posicionar <html>";
			new VentanaError(textoError);
		}
		;

		this.panelJuego.actualizar();
	}
}
