package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.DepositoDeSuministros;
import algo3.algocraft.vista.PanelJuego;

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

		Casilla casilla = this.panelJuego.getCasillaActual();

		try {
			new DepositoDeSuministros(this.juego.turnoDeJugador(), casilla);
		} catch (RecursosInsuficientesError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CasillaOcupadaError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.panelJuego.actualizar();
	}
}