package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.juego.PoblacionLimiteAlcanzadaError;
import algo3.algocraft.modelo.juego.RecursosInsuficientesError;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.unidadesEdificios.FabricaDestruidaError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PuertoEstelar;
import algo3.algocraft.modelo.unidades.unidadesEdificios.PuertoEstelarNoConstruidoError;
import algo3.algocraft.modelo.unidades.unidadesEdificios.YaHayUnidadEnEntrenamiento;
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

		try {
			Casilla casilla = this.panelJuego.getCasillaActual();
			PuertoEstelar puerto = (PuertoEstelar) casilla
					.getOcupanteTerrestre();
			puerto.entrenarEspectro(juego.turnoDeJugador());
		} catch (JugadorIncorrectoError e) {
			String textoError = "<html>La unidad pertenece a otro jugador <html>";
			new VentanaError(textoError);
		} catch (RecursosInsuficientesError e) {
			String textoError = "<html>Recursos insuficientes <html>";
			new VentanaError(textoError);
		} catch (PoblacionLimiteAlcanzadaError e) {
			String textoError = "<html>Poblacion limite alcanzada <html>";
			new VentanaError(textoError);
		} catch (PuertoEstelarNoConstruidoError e) {
			String textoError = "<html>Puerto Estelar no construido <html>";
			new VentanaError(textoError);
		} catch (FabricaDestruidaError e) {
			String textoError = "<html>Fabrica asociada destruida <html>";
			new VentanaError(textoError);
		} catch (YaHayUnidadEnEntrenamiento e) {
			String textoError = "<html>Ya hay unidad en entrenamiento <html>";
			new VentanaError(textoError);
		} catch (Exception e) {
			String textoError = "<html>No se selecciono una casilla con un Puerto Estelar <html>";
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
	}
}
