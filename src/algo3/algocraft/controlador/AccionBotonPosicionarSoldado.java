package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.NoHaySoldadosParaPosicionarError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.vista.PanelJuego;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoHaySoldadosParaPosicionarError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		this.panelJuego.actualizar();
	}
}
