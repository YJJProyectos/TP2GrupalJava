package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.vista.PanelJuego;

public class AccionBotonCrearRefineria implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonCrearRefineria(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		Casilla casilla = this.panelJuego.getCasillaActual();

		try {
			Recurso recurso = casilla.getRecurso();
			new Refineria(recurso, this.juego.turnoDeJugador());
		} catch (RecursosInsuficientesError errorRecursosInsuficientes) {

		} catch (RecolectorInvalidoError errorRecolectorInvalido) {
		} catch (CasillaOcupadaError errorCasillaOcupada) {
		}
	}
}
