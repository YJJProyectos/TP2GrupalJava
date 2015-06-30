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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecursosInsuficientesError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BarracaNoConstruidaError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CasillaOcupadaError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.panelJuego.actualizar();
	}
}
