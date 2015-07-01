package algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocraft.modelo.juego.Juego;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.JugadorIncorrectoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.DistanciaFueraDeRangoError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.NoPuedeAtacarMultiplesVecesError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.PerteneceAlMismoJugadorError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;
import algo3.algocraft.vista.PanelJuego;
import algo3.algocraft.vista.VentanaError;

public class AccionBotonAtacar implements ActionListener {

	private PanelJuego panelJuego;
	private Juego juego;

	public AccionBotonAtacar(PanelJuego panelJuego, Juego juego) {
		this.panelJuego = panelJuego;
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent click) {

		try {
			UnidadSoldado atacante = (UnidadSoldado) this.panelJuego
					.getUnidadIzquierdo();
			Unidad atacado = this.panelJuego.getUnidadDerecho();
			atacante.atacarEnemigo(atacado, this.juego.turnoDeJugador());
		} catch (PerteneceAlMismoJugadorError e) {
			String textoError = "<html>La unidad que quiere atacar pertenece al mismo jugador <html>";
			new VentanaError(textoError);
		} catch (NoPuedeAtacarMultiplesVecesError e) {
			String textoError = "<html>La unidad no puede atacar multiples veces <html>";
			new VentanaError(textoError);
		} catch (JugadorIncorrectoError e) {
			String textoError = "<html>La unidad pertenece a otro jugador <html>";
			new VentanaError(textoError);
		} catch (DistanciaFueraDeRangoError e) {
			String textoError = "<html>La unidad esta fuera de rango <html>";
			new VentanaError(textoError);
		} catch (Exception e) {
			String textoError = "<html>Unidad sin seleccionar <html>";
			new VentanaError(textoError);
		}

		this.panelJuego.actualizar();
		this.panelJuego.setSinInformacionAdicional();
		this.panelJuego.getPanelBotones().visibilidadCasillasEspeciales(false);
	}
}
