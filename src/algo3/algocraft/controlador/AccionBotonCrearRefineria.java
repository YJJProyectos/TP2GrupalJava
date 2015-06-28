package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.mapa.Coordenada;
import algo3.algocraft.modelo.recursos.RecolectorInvalidoError;
import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Refineria;
import algo3.algocraft.vista.VentanaInicio;

public class AccionBotonCrearRefineria implements ActionListener {

	// private VentanaInicio vista;
	private Juego juego;

	public AccionBotonCrearRefineria(VentanaInicio vista, Juego juego) {
		// this.vista = vista;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		// vista.addMouseListener(new MouseTocarCasilla(vista));
		// Casilla casilla = vista.obtenerCasillaClickeada();
		Casilla casilla = new Casilla(new Coordenada(1, 1));
		try {
			Recurso recurso = casilla.getRecurso();
			new Refineria(recurso, this.juego.turnoDeJugador());
		} catch (RecursosInsuficientesError errorRecursosInsuficientes) {

		} catch (RecolectorInvalidoError errorRecolectorInvalido) {
		} catch (CasillaOcupadaError errorCasillaOcupada) {
		}
	}
}
